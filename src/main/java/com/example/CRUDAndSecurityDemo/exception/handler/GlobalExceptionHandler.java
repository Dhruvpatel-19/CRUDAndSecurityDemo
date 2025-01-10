package com.example.CRUDAndSecurityDemo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.CRUDAndSecurityDemo.exception.UserAlreadyExistsException;
import com.example.CRUDAndSecurityDemo.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler{
	
	//for specific UserAlreadyExistsException
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	//for specific UserNotFoundException
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//for any other unhandled exceptions
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
