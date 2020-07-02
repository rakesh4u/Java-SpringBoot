package com.example.demo.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ControllResonse;


public interface ResponseDao extends CrudRepository<ControllResonse, Integer> {

	
	
	@Query(value = "SELECT u.resonse_value FROM contol_response as u ORDER BY id DESC limit 1", nativeQuery = true)
	public String getLastInsertedValue();

}
