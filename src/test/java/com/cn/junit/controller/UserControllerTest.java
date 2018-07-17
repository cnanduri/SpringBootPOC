package com.cn.junit.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cn.controller.UserController;
import com.cn.exception.SvcException;
import com.cn.svc.UserSvc;
import com.cn.vo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserSvc userSvc;

	@Test(expected = SvcException.class)
	public void test_findUserDetails_throws_SvcExcp() throws SvcException {
		Mockito.when(userSvc.getUser(Mockito.anyString()))
				.thenThrow(new SvcException("Test Message"));

		userController.findUserDetails("Test");
	}

	@Test
	public void test_findUserDetails() throws SvcException {
		Mockito.when(userSvc.getUser(Mockito.anyString()))
				.thenReturn(new User());

		ResponseEntity<User> responseEntity = userController
				.findUserDetails("Test");

		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertThat(responseEntity.getBody(), instanceOf(User.class));

	}

}
