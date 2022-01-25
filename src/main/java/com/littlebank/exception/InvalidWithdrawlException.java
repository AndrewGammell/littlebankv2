package com.littlebank.exception;

public class InvalidWithdrawlException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidWithdrawlException (String errorMessage) {
		super(errorMessage);
	}
	
	
}
