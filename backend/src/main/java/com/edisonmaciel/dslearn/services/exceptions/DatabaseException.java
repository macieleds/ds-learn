package com.edisonmaciel.dslearn.services.exceptions;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DatabaseException(final String msg) {
		super(msg);
	}
}
