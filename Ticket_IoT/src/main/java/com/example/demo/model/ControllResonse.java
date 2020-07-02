package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "contol_response")
public class ControllResonse {
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String user_id;
	@NotNull
	private String node_id;
	@NotNull
	private String resonse_value;
	private String updateddate;
	public String getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}
	public ControllResonse() {
		super();
	}
	public ControllResonse(int id, @NotNull String user_id, @NotNull String node_id, @NotNull String resonse_value, String updateddate) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.node_id = node_id;
		this.resonse_value = resonse_value;
		this.updateddate = updateddate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getResonse_value() {
		return resonse_value;
	}
	public void setResonse_value(String resonse_value) {
		this.resonse_value = resonse_value;
	}

}
