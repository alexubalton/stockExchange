package com.stock;

public class InvalidCodeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCodeException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
