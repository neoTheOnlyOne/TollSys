/**
 * 
 */
package com.tollsys.server.dal.impl;

import javax.persistence.EntityManager;

import com.tollsys.server.dal.UserDetailDAO;
import com.tollsys.server.dal.entities.UserDetail;

/**
 * @author  SN
 *
 */
public class UserDetailJpaDAO extends GenericJpaDAO<UserDetail, Long> implements UserDetailDAO {

	public UserDetailJpaDAO(EntityManager entityManager) {
		em = entityManager;
	}
}
