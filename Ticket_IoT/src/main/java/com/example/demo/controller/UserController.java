package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User users) {
		userDao.save(users);
		return "User Saved SuccessFully of numbers";
		
	}
	
	

}
