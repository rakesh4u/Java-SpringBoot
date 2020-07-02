package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "node")
public class Node {

	@Id
	@GeneratedValue
	private int id;
	public Node(int id, String node_id, String op_mode, String op_protocol, String act_stat, String updateddate) {
		super();
		this.id = id;
		this.node_id = node_id;
		this.op_mode = op_mode;
		this.op_protocol = op_protocol;
		this.act_stat = act_stat;
		this.updateddate = updateddate;
	}
	@NotNull
	private String node_id;
	@NotNull
	private String op_mode;
	@NotNull
	private String op_protocol;
	@NotNull
	private String act_stat;
	@NotNull
	private String updateddate; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOp_mode() {
		return op_mode;
	}
	public void setOp_mode(String op_mode) {
		this.op_mode = op_mode;
	}
	public String getOp_protocol() {
		return op_protocol;
	}
	public void setOp_protocol(String op_protocol) {
		this.op_protocol = op_protocol;
	}
	public String getAct_stat() {
		return act_stat;
	}
	public void setAct_stat(String act_stat) {
		this.act_stat = act_stat;
	}

	public Node() {
		super();
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}
	
}
