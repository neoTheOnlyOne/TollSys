package com.tollsys.server.services;

import java.util.List;

import com.tollsys.common.exception.TollSysAppException;
import com.tollsys.server.services.to.UserTO;

public interface UserService {

	public boolean checkValidUser(String userName, String passwd) throws TollSysAppException;
	
	public List<UserTO> findAllUsers() throws TollSysAppException;
	
	
}
