package com.tollsys.server.dal.impl;

import javax.persistence.EntityManager;

import com.tollsys.server.dal.TaskDAO;
import com.tollsys.server.dal.entities.Task;

public class TaskJpaDAO extends GenericJpaDAO<Task, Long> implements TaskDAO {

	public TaskJpaDAO(EntityManager entityManager) {
		em = entityManager;
	}
}
