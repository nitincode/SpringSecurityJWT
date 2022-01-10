package com.nitinIT.models;

import java.io.Serializable;


public class AuthenticationResponse implements Serializable {

   
	private String jwtToken;
     private User user;
	
     
     

	public AuthenticationResponse(String jwtToken, User user) {
		super();
		this.jwtToken = jwtToken;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	

}
