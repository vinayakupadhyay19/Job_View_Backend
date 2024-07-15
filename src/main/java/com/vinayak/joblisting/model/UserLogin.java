package com.vinayak.joblisting.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LoginTable")
public class UserLogin {
	private String Id;
    private String username;
    private String password;
    
    public String getId() {
		return this.Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	

    public UserLogin() {
        // Default no-argument constructor
    }

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
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

    @Override
    public String toString() {
        return "UserLogin [username=" + username + ", password=" + password + "]";
    }
}
