package com.stephanie.spring.exception;

public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6010872894574024501L;

	public InvalidInputException(String message) {
		super(message);
	}
}
