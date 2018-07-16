package com.cn.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class User {

	@ApiModelProperty("First Name of the user")
	@JsonProperty("firstName")
	private String firstName;

	@ApiModelProperty("Last Name of the user")
	@JsonProperty("lastName")
	private String lastName;

	@ApiModelProperty("Email of the user")
	@JsonProperty("email")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
