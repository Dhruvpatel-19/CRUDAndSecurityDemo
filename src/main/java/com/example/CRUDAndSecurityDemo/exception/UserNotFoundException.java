package com.example.CRUDAndSecurityDemo.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2481892480256445929L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
