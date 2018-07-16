package com.cn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.vo.User;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/samples")
public class UserController {

	@GetMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<User> findUserDetails() {

		User user = new User();

		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setEmail("firstName.lastName@gmail.com");

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
