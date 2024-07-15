package com.vinayak.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AdminLogin")
public class AdminRegistration {
	private String Id;
	private String username;
	private String password;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminRegistration(String id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
	}
	
	
}
