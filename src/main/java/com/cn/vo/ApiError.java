package com.cn.vo;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

	@JsonProperty("status")
	private int status;

	@JsonProperty("reasonPhrase")
	private String reasonPhrase;

	@JsonProperty("developerMessage")
	private String developerMessage;

	@JsonProperty("errors")
	private List<Error> errors;

	public ApiError(HttpStatus status, String developerMessage, List<Error> errors) {
		this.status = status.value();
		this.reasonPhrase = status.getReasonPhrase();
		this.developerMessage = developerMessage;
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public List<Error> getErrors() {
		return errors;
	}

}
