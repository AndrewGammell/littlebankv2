package com.littlebank.exception;

import java.util.NoSuchElementException;

public class InvalidLoginException extends NoSuchElementException {

	private static final long serialVersionUID = 1L;
	
	public InvalidLoginException(String errorMessage) {
		super(errorMessage);
	}

}
