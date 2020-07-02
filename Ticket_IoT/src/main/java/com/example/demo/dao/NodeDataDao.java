package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Node;
import com.example.demo.model.NodeData;
import com.example.demo.model.User;

import antlr.collections.List;

public interface NodeDataDao extends CrudRepository<NodeData, Integer>  {

	
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO nodedata(accelerometer, gyroscope, city, node_id) values (?1, ?2, ?3, ?4) ", nativeQuery = true)
	void saveData(String splitAccel, String splitGyro, String splitLoc, String splitNode);
	
	

}
