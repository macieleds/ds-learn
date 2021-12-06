package com.edisonmaciel.dslearn.services.exceptions;

public class ForbiddenException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ForbiddenException(final String msg) {
		super(msg);
	}
}
