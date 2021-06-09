package com.infy.ekart.model;

public class Customer {
	private String emailId;
	private String password;
	
	
	
	public Customer(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public Customer() {
		
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
