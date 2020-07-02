package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.NodeDataDao;
import com.example.demo.dao.ResponseDao;
import com.example.demo.model.ControllResonse;
import com.example.demo.model.NodeData;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired 
	private NodeDataDao nodeDataDao;
	
	@Autowired 
	private ResponseDao responseDao ;
	

	@PostMapping("/save")
	@ResponseBody
	public String save(NodeData nodeData) {
		
		nodeDataDao.save(nodeData);
		
		return "Saved";
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public Iterable<NodeData> getAll(NodeData nodeData) {
		Iterable<NodeData> data = nodeDataDao.findAll();
		
		
		
		return data;
		
	}
	
	@PostMapping("/saveresponse")
	@ResponseBody
	public String saveresponse(ControllResonse response) {

		responseDao.save(response);
		return "Saved";
		
	}
	
	@GetMapping("/getresponse")
	@ResponseBody
	public String getresponse() {

		return responseDao.getLastInsertedValue();
		
		
	}
}
