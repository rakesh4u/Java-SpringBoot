package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Node;
import com.example.demo.model.User;

import antlr.collections.List;

public interface NodeDao extends CrudRepository<Node, Integer>  {
	
	
	
	@Query(value = "SELECT u.* FROM user as u WHERE u.username = ?1 AND u.password = ?2", nativeQuery = true)
	public String getValuesFromUser(String username, String password);
	

	@Query(value = "SELECT u.* FROM node as u where u.op_mode = 'Control Node'", nativeQuery = true)
	public ArrayList<Node> findAllcontrol();



	
}
