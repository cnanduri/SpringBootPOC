package com.cn.svc;

import com.cn.exception.SvcException;
import com.cn.vo.User;

public interface UserSvc {

	User getUser(String userId) throws SvcException;

}
