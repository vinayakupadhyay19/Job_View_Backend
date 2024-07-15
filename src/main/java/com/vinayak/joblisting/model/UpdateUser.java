package com.vinayak.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LoginTable")
public class UpdateUser {
	String Id;
    String username;
    String password;
    
   
    
	public String getUsername() {
		return this.username;
	}
	public String getId() {
		return this.Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UpdateUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [UserName=" + username + ", Password=" + password + "]";
	}
    
    
}
