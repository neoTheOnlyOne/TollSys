package com.tollsys.server.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.tollsys.common.exception.TollSysAppException;
import com.tollsys.common.util.CommonConstants;
import com.tollsys.common.util.CommonUtils;
import com.tollsys.common.util.NamedQueryConstants;
import com.tollsys.server.dal.DAOFactory;
import com.tollsys.server.dal.entities.UserDetail;
import com.tollsys.server.services.UserService;
import com.tollsys.server.services.to.UserTO;

public class UserServiceImpl implements UserService {

	private DAOFactory daoFactory;

	private EntityManager em;

	// to be called from EJB/Spring.
	/**
	 * @param daoFactory
	 *            The DAOFactory object Note: to be used / called from EJB/Spring.
	 */
	public UserServiceImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public UserServiceImpl() {
		try {
			em = Persistence.createEntityManagerFactory(CommonConstants.PERSISTENCE_CONTEXT_NAME).createEntityManager();
		} catch (Exception ex) {
			System.out.println("Caught exception->-> : " + ex);
			return;
		}

		daoFactory = DAOFactory.getDAOFactory(DAOFactory.JPA, em);
	}

	@Override
	public boolean checkValidUser(String userId, String passwd) throws TollSysAppException {
		Object[] user = (Object[]) daoFactory.getUserDetailDAO()
				.findSingleByProperty(NamedQueryConstants.USER_FIND_BY_ID, userId);
		// if (passwd.equals(user.getPassword()))
		CommonUtils.doPrintln("user Name-> " + user[0]);
		CommonUtils.doPrintln("user Password-> " + user[1]);
		if (passwd.equals(user[1].toString())) {

			return true;
		}
		return false;
	}

	@Override
	public List<UserTO> findAllUsers() throws TollSysAppException {
		List<UserDetail> userDetailList = daoFactory.getUserDetailDAO()
				.findByProperty(NamedQueryConstants.USER_FIND_ALL);

		List<UserTO> userTOList = new ArrayList<UserTO>();

		for (UserDetail user : userDetailList) {
			UserTO userTO = new UserTO(user.getUserId(), user.getPassword(), user.getUserEmailId(), user.getUserName());
			userTOList.add(userTO);
		}
		return userTOList;
	}

}
