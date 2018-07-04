package com.absa.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = null;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
