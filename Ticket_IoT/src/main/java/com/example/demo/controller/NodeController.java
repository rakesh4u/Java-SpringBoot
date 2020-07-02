package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.NodeDao;
import com.example.demo.model.Node;
import com.example.demo.model.User;

@Controller
@RequestMapping("/nodes")
public class NodeController {
	
	@Autowired
	private NodeDao nodeDao;
	
	//****Method for save node into the ****************************
	
	@PostMapping("/save")
	public String save(Node node) {
		nodeDao.save(node);
		
		
		
		return "redirect:/dash/todash";
		
	}
	//******Ends here(Node save**************************************
	
	@RequestMapping("/deletenode")
	public String deletenode(@RequestParam(name="i",required=false)int id) {
		nodeDao.deleteById(id);
		return "redirect:/dash/todash";
		
		
	}
	
	
	
	//Method for load node creation JSP file
	
	@GetMapping("/nodeAdd")
	public String nodeAdd(User user, ModelMap model) {
		
		String username = DashBoardController.cookieUsername;
		model.addAttribute("username", username);
		return "pages/createnode";
		
	}
	
	//***Ends jsp load node*******************************************
	
	
	
	//***** For Fetching All node datas(Not used now)*****************
	
		@RequestMapping("/aa")
		@ResponseBody
		private Iterable<Node> getAllData() {
			
			return nodeDao.findAll();
			
		}
		
	// *************Ending********************************************

}
