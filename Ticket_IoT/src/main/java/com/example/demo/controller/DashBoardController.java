package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Spliterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.NodeDao;
import com.example.demo.model.Node;
import com.example.demo.model.User;
import org.springframework.boot.json.JsonParser;

@Controller
@RequestMapping("/dash")
public class DashBoardController {
	
	public static String cookieUsername = "!Login_Again";
	public static String cookieType = "00";
	
	@Autowired
	private NodeDao nodeDao;
	
	
	//**Validating user and go to the Dashboard***************************
	
	@PostMapping("/dashboard")
	public String checkLogin(User user, ModelMap model, HttpServletResponse response) {

		String userName = user.getUsername();
		String password = user.getPassword();
		Cookie userCookie = new Cookie("username", userName);
		response.addCookie(userCookie);
		cookieUsername = userName;
		int res = validate(userName, password, response);
		if(res != 0) {
			String page = toDash(model);
			return page;		
		}
		else {
			return "pages/login";
		}
		
		
	}
	
	@RequestMapping("/dashs")
	@ResponseBody
	public String readCookie(HttpServletRequest request) {
        //get all cookies
        Cookie[] cookies = request.getCookies();
        //iterate each cookie
        for (Cookie cookie : cookies) {
            //display only the cookie with the name 'website'
            if (cookie.getName().equals("username")) {
                System.out.println("Current cookie value : " + cookie.getValue());
//                cookieUsername = cookie.getValue();
            }
            if (cookie.getName().equals("type")) {
                System.out.println("Current cookie type value : " + cookie.getValue());
//                cookieType = cookie.getValue();
            }
        }
        return null;
    }
	
	@RequestMapping("/todash")
	private String toDash(ModelMap model) {	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nodes = getAllNodes();
		String controlnodes = getAllControlNodes();
		System.out.println(nodes);
		
		
		model.addAttribute("username", cookieUsername);
		model.addAttribute("type", cookieType);
		model.addAttribute("nodes", nodes);
		model.addAttribute("controlnodes", controlnodes);
		return "pages/dashboard";
		
	}

	//**Ends validation here*************************************************
	
	
	//**Method used for Validating user**************************************
	
	@RequestMapping("/validate")
	@ResponseBody
	private int validate(String username, String password, HttpServletResponse response) {
		
		String res =  nodeDao.getValuesFromUser(username, password);
		System.out.println(res);
		String[] splt = res.split(",");
		String usrtype = splt[3];
		Cookie typeCookie = new Cookie("type", usrtype);
		response.addCookie(typeCookie);
		cookieType = usrtype;
		if(res == null) {
			return 0;
		}
		return 1;
		
	}
	
	//**Method ends here******************************************************
	
	
	
	//** Method for getting all Control nodes nodes(Not Used Now)***************************
	
		
	@RequestMapping("/all")
	@ResponseBody
	private String getAllNodes() {
	
		int id = 0;
		
		String nodes = "";
		String node_id = "";
		String act_stat = "";
		String op_protocol = "";
		String op_mode = "";
		String classes = "";
		String cls = "";
		
		ArrayList<Node> json = (ArrayList<Node>) nodeDao.findAll();
		for(int i = 0; i < json.size(); i++) {
			
			String url="http://localhost:8080/dash/jsonstring?i="+i;
			RestTemplate restTemplate = new RestTemplate();
			String resp = restTemplate.getForObject(url, String.class);

			JsonParser springParser = JsonParserFactory.getJsonParser();
			Map<String, Object> map = springParser.parseMap(resp);

			String mapArray[] = new String[map.size()];
//			System.out.println("Items found: " + mapArray.length);

			int j = 0;
			for (Map.Entry<String, Object> entry : map.entrySet() ) {
				
				if(entry.getKey() == "id" && entry.getValue() != "") {
					id = (int) entry.getValue();
//					System.out.println("The current id is : "+ id +  "," + j);
				}
					
				if(entry.getKey() == "node_id" && entry.getValue() != "") {
					node_id = (String) entry.getValue();
					cls = "clss"+node_id;
//					System.out.println("The node id id is : "+ node_id +  "," + j);
				}
				if(entry.getKey() == "op_protocol" && entry.getValue() != "") {
					op_protocol = (String) entry.getValue();
//					System.out.println("The protocol id is : "+ op_protocol +  "," + j);
				}
				if(entry.getKey() == "op_mode" && entry.getValue() != "") {
					op_mode = (String) entry.getValue();
//					System.out.println("The mode id is : "+ op_mode +  "," + j	);
				}
				if(entry.getKey() == "act_stat" && entry.getValue() != "") {
					act_stat = (String) entry.getValue();
					if(act_stat.equals("Yes")) {
						classes = "green-dot";
					}
					else if(act_stat.equals("No")) {
						classes = "orange-dot";
					}
					
				}
				//id > 0 && !node_id.equals("") && !op_protocol.equals("") && !op_mode.equals("") && !act_stat.equals("")
					if(j == 4) {
						System.out.println("The current id is : "+ id +  "," + j);
						System.out.println("The node id id is : "+ node_id);
						System.out.println("The protocol id is : "+ op_protocol);
						System.out.println("The mode id is : "+ op_mode	);
					nodes = nodes + "<div class = 'cls"+node_id+"'><h6><b>"+node_id+"</b>&nbsp;<span class='"+classes+"'></span></h6><p>Operational Mode: "+op_mode+"<br>Operational protocol: "+op_protocol+"<br>Action: "+act_stat+"</p><div class = 'adm'><a class = 'btn fa fa-trash-o pull-right' style = 'color:red; font-size:24px;margin:0px' value = '"+id+"' id = 'delete"+id+"' onclick = 'deletes("+id+")'></a><br></div><hr></div>";
					}
					j++;
			}
			
		}
		
		return nodes;
		
		
	}
	
	
	@RequestMapping("/allcontrol")
	@ResponseBody
	private String getAllControlNodes() {
		
		String nodes = "";
		String node_id = "";
		String act_stat = "";
		String op_protocol = "";
		String op_mode = "";
		String classes = "";
		
		ArrayList<Node> json = (ArrayList<Node>) nodeDao.findAllcontrol();
		System.out.println("SIZE: "+ json.size());
		for(int i = 0; i < json.size(); i++) {
			
			String url="http://localhost:8080/dash/jsoncontrolstring?i="+i;
			RestTemplate restTemplate = new RestTemplate();
			String resp = restTemplate.getForObject(url, String.class);

			JsonParser springParser = JsonParserFactory.getJsonParser();
			Map<String, Object> map = springParser.parseMap(resp);

			String mapArray[] = new String[map.size()];
//			System.out.println("Items found: " + mapArray.length);

			int j = 0;
			for (Map.Entry<String, Object> entry : map.entrySet()) {
//					System.out.println(entry.getKey() + " = " + entry.getValue());
				if(entry.getKey() == "node_id") {
					node_id = (String) entry.getValue();
				}
				else if(entry.getKey() == "op_mode") {
					op_mode = (String) entry.getValue();
				}
				else if(entry.getKey() == "act_stat") {
					act_stat = (String) entry.getValue();
					if(act_stat.equals("Yes")) {
						classes = "green-dot";
					}
					else if(act_stat.equals("No")) {
						classes = "orange-dot";
					}

				}
					if(j == 4) {
						nodes = nodes + "<div class = 'cls"+node_id+"'><h6><b>"+node_id+"</b>&nbsp;<span class='"+classes+"'></span></h6><p>Operational Mode: "+op_mode+"<br>Action: "+act_stat+"</p><hr></div>";
					}
					j++;
			}
			
		}
		
		return nodes;
		
		
	}
	
	@RequestMapping("/jsoncontrolstring")
	@ResponseBody
	private Node jsoncontrolstring(@RequestParam(name="i",required=false)int i) {
		
		ArrayList<Node> json = (ArrayList<Node>) nodeDao.findAllcontrol();
		return json.get(i);
		
		
	}
	
	
	@RequestMapping("/jsonstring")
	@ResponseBody
	private Node jsonstring(@RequestParam(name="i",required=false)int i) {
		
		ArrayList<Node> json = (ArrayList<Node>) nodeDao.findAll();
		return json.get(i);
		
		
	}
	
	
	
	//**Method Ends here*******************************************************
	
	
	//**Load Dashboard********************************************************
	
	@GetMapping("/dashes")
	public String dashes(User user) {
		return "pages/dashboard";
		
	}
	
	//**Ends loading Dashboard*************************************************
	
}
