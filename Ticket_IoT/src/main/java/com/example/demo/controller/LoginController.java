package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.NodeDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Node;
import com.example.demo.model.User;
//import com.fasterxml.jackson.core.JsonParser;
import org.springframework.boot.json.JsonParser;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NodeDao nodeDao;
	
	//*****Loads login page (JSP) on the first screen (root, "/")**********************
	
	@GetMapping("/")
	public String login() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/login";
	}
	//***Ends Load Login page***********************************************************
	
	
	
	//************Loads register page (JSP)*********************************************
	
	@GetMapping("/register")
	public String register() {
		return "pages/register";
	}
	
	//*******Ends register page loading**************************************************
	
	
	//******Method for save from the register field entered values************************
	
	@PostMapping("/setRegister")
//	@ResponseBody
	public String saveRegister(User user) {
		userDao.save(user);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/login";
		
	}
	
	//**********Save Method ends here******************************************************

}
