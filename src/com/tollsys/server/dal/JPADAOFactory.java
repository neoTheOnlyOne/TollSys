/**
 * 
 */
package com.tollsys.server.dal;

import javax.persistence.EntityManager;

import com.tollsys.server.dal.impl.TaskJpaDAO;
import com.tollsys.server.dal.impl.UserDetailJpaDAO;

/**
 * @author  SN
 *
 */
public class JPADAOFactory extends DAOFactory {
	protected EntityManager entityManager;

	public JPADAOFactory(Object entityManager) {
		this.entityManager = (EntityManager) entityManager;
	}

	@Override
	public UserDetailDAO getUserDetailDAO() {
		return new UserDetailJpaDAO(entityManager);
	}

	@Override
	public TaskDAO getTaskDAO() {
		return new TaskJpaDAO(entityManager);
	}

	@Override
	public CityDAO getCityDAO() {
		return null;
	}

	@Override
	public StateDAO getStateDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDAO getCountryDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
