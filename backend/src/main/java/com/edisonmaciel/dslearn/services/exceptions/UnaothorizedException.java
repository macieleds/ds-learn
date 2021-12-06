package com.edisonmaciel.dslearn.services.exceptions;

public class UnaothorizedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UnaothorizedException(final String msg) {
		super(msg);
	}
}
