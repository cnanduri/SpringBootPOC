package com.cn.svc;

import org.springframework.stereotype.Service;

import com.cn.exception.SvcException;
import com.cn.vo.User;

@Service
public class UserSvcImpl implements UserSvc {

	@Override
	public User getUser(String userId) throws SvcException {
		
		User user = new User();
		
		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setEmail("firstName.lastName@gmail.com");
		
		return user;
	}

}
