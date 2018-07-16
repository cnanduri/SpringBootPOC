package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.exception.SvcException;
import com.cn.svc.UserSvc;
import com.cn.vo.User;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/users/{userId}")
public class UserController extends BaseController {

	@Autowired
	private UserSvc userSvc;

	@GetMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<User> findUserDetails(@PathVariable("userId") String userId) throws SvcException {

		User user = userSvc.getUser(userId);

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
