package com.cn.exception;

public class SvcException extends Exception {

	private static final long serialVersionUID = 1L;

	public SvcException(String message) {
		super(message);
	}

	public SvcException(Exception ex) {
		super(ex);
	}
}
