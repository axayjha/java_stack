package com.infy.ekart.model;

import java.io.Serializable;

public class AuthToken implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	public AuthToken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
