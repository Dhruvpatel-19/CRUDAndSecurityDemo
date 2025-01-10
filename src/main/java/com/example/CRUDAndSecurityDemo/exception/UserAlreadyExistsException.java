package com.example.CRUDAndSecurityDemo.exception;

public class UserAlreadyExistsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8600631978803511017L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
