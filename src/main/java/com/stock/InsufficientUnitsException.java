package com.stock;

public class InsufficientUnitsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientUnitsException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
