package com.tech.training.employeeApp;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String ex) {
		super(ex);
	}
}
