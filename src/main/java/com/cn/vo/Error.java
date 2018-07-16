package com.cn.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

	@JsonProperty("field")
	private String field;

	@JsonProperty("message")
	private String message;

	public Error(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public Error(String message) {
		this(null, message);
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}
