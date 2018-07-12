package com.tollsys.server.services.delegate.impl;

import java.util.List;

import com.tollsys.common.exception.TollSysAppException;
import com.tollsys.server.services.UserService;
import com.tollsys.server.services.delegate.UserServiceDelegate;
import com.tollsys.server.services.impl.UserServiceImpl;
import com.tollsys.server.services.to.UserTO;

public class UserServiceDelegateImpl implements UserServiceDelegate {

	private UserService userService;

	public UserServiceDelegateImpl() {
		userService = new UserServiceImpl();
	}

	@Override
	public boolean checkValidUser(String userName, String passwd) throws TollSysAppException {
		return userService.checkValidUser(userName, passwd);
	}

	@Override
	public List<UserTO> findAllUsers() throws TollSysAppException  {
		return userService.findAllUsers();
	}

}
