package com.tollsys.server.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tollsys.common.exception.TollSysAppException;
import com.tollsys.common.util.CommonConstants;
import com.tollsys.common.util.CommonUtils;
import com.tollsys.common.util.NamedQueryConstants;
import com.tollsys.server.dal.DAOFactory;
import com.tollsys.server.services.UserService;
import com.tollsys.server.services.delegate.impl.UserServiceDelegateImpl;
import com.tollsys.server.services.to.UserTO;

public class TestTask {

	final static Logger logger = LogManager.getLogger(TestTask.class);

	public static void main(String[] args) {
		String config = System.getProperty("log4j.properties");

		logger.trace("Entering App");
		TestTask task = new TestTask();
		task.checkValidUser();
		task.testGetUserDetails();

		logger.trace("Exiting App");
	}

	private void checkValidUser() {
		UserService userService = new UserServiceDelegateImpl();
		try {
			Boolean isLoginValid = userService.checkValidUser("mukesh", "kumar");
			if (isLoginValid)
				System.out.println("Success");
			else
				System.out.println("Wrong username or password");
		} catch (TollSysAppException ex) {
			System.out.println("Exception while validating user: " + ex);
			ex.printStackTrace();
		}
	}

	public void testGetUserDetails() {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory(CommonConstants.PERSISTENCE_CONTEXT_NAME);
		EntityManager em = emf.createEntityManager();
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.JPA, em);

		// Session session = em.unwrap(org.hibernate.Session.class);
		UserService userService = new UserServiceDelegateImpl();

		try {
			String query = "SELECT u.userName, u.userId FROM UserDetail u";
			List<Object[]> resultList = daoFactory.getUserDetailDAO()
					.findByProperty(NamedQueryConstants.USER_FIND_ALL1);
			CommonUtils.doPrintln("List of Users with array of Collection: ");
			for (Object[] object : resultList) {
				// Map user = (Map)object;
				System.out.println("user.getUserId: " + object[0]);
				System.out.println("user.getUserName: " + object[1]);
			}

		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		
		try {
			List<UserTO> users = userService.findAllUsers();
			CommonUtils.doPrintln("executing JPQL to fetch all users: ");
			for(UserTO user : users) {
				CommonUtils.doPrintln("" + user.getUserName());
				CommonUtils.doPrintln("" + user.getUserEmailId());
				CommonUtils.doPrintln("" + user.getUserId());
				CommonUtils.doPrintln("" + user.getAddress());
			}
			
		} catch (TollSysAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
