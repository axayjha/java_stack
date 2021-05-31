package com.akshay.raxjsdemo.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7867864786428734L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
