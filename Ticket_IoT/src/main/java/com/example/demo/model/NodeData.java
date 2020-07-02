package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "nodedata")
public class NodeData {
	
	@Id
	@GeneratedValue
	private int id;
	private String node_id;
	private String accelerometer;
	private String gyroscope;
	private String city;
	private String latitude;
	private String longitude;
	private String updateddate;
	public String getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}
	public NodeData() {
		super();
	}
	public NodeData(int id, String node_id, String accelerometer, String gyroscope, String city, String latitude,
			String longitude, String updateddate) {
		super();
		this.id = id;
		this.node_id = node_id;
		this.accelerometer = accelerometer;
		this.gyroscope = gyroscope;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.updateddate = updateddate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getAccelerometer() {
		return accelerometer;
	}
	public void setAccelerometer(String accelerometer) {
		this.accelerometer = accelerometer;
	}
	public String getGyroscope() {
		return gyroscope;
	}
	public void setGyroscope(String gyroscope) {
		this.gyroscope = gyroscope;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
