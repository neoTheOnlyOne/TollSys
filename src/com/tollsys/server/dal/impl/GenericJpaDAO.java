/**
 * 
 */
package com.tollsys.server.dal.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tollsys.common.exception.TollSysAppException;
import com.tollsys.common.util.CommonConstants;
import com.tollsys.common.util.CommonUtils;
import com.tollsys.common.util.ErrorConstants;
import com.tollsys.server.dal.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * @author SN
 *
 */
public class GenericJpaDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private static Logger logger = LogManager.getLogger(GenericJpaDAO.class);

	protected Class<T> persistentClass;
	protected String entityName;
	protected EntityManager em;

	/**
	 * Instantiates a new generic jpa dao.
	 */
	@SuppressWarnings("unchecked")
	public GenericJpaDAO() {
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		Entity entityAnn = (Entity) persistentClass.getAnnotation(Entity.class);

		if (entityAnn != null && !entityAnn.name().equals("")) {
			entityName = entityAnn.name();
		} else {
			entityName = persistentClass.getSimpleName();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itsys.server.dal.GenericDAO#findById(java.io.Serializable)
	 */
	@Override
	public T findById(ID Id) throws Exception {
		T entity = null;
		try {
			entity = em.find(persistentClass, Id);
		} catch (PersistenceException e) {
			System.out.println("PersistenceException : " + e);
		}
		return entity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <U> List<U> findByProperty(String prop) throws TollSysAppException {
		List<U> resultList = null;
		int count = 1;
		try {
			Query query = em.createNamedQuery(prop);

			resultList = (List<U>) query.getResultList();
		} catch (PersistenceException pex) {
			CommonUtils.doPrintln("PersistenceException : " + pex);
		}
		return resultList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <U> List<U> findByPropertyFiltered(String prop, Object val) throws TollSysAppException {
		List<U> resultList = null;
		int count = 1;
		try {
			Query query = em.createNamedQuery(prop);
			if (val != null) {
				String searchParameter = null;
				if (val instanceof Map) {
					Set set = ((Map) val).entrySet();
					Iterator iterator = set.iterator();
					while (iterator.hasNext()) {
						Map.Entry mapEntry = (Map.Entry) iterator.next();
						if (mapEntry.getValue() instanceof String) {
							searchParameter = ((String) mapEntry.getValue()).concat("%");
							query.setParameter(count, searchParameter);
						} else {
							query.setParameter(count, mapEntry.getValue());
						}
						count++;
					}
				} else {
					if (val instanceof String) {
						searchParameter = ((String) val).concat("%");
						query.setParameter(1, searchParameter);
					} else {
						query.setParameter(1, val);
					}
				}
			}

			resultList = (List<U>) query.getResultList();
		} catch (PersistenceException pex) {
			System.out.println("PersistenceException : " + pex);
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws TollSysAppException {
		List<T> resultList = null;

		try {
			Query query = null;

			query = em.createQuery("SELECT e FROM " + entityName + " e");

			resultList = (List<T>) query.getResultList();

		} catch (PersistenceException e) {
			System.out.println("PersistenceException" + e);
		}
		return resultList;
	}

	@Override
	public <U> U findSingleByProperty(String prop, Object val) throws TollSysAppException {

		if (logger.isDebugEnabled()) {
			logger.debug("prop=" + prop + ", val=" + val);
		}

		U entity = null;
		int count = 1;
		try {
			Query query = em.createNamedQuery(prop);

			if (val != null) {
				String searchParameter = null;
				if (val instanceof Map) {
					Set set = ((Map) val).entrySet();
					Iterator iterator = set.iterator();
					while (iterator.hasNext()) {
						Map.Entry mapEntry = (Map.Entry) iterator.next();
						if (mapEntry.getValue() instanceof String) {
							searchParameter = ((String) mapEntry.getValue()).concat("%");
							query.setParameter(count, searchParameter);
						} else {
							query.setParameter(count, mapEntry.getValue());
						}
						count++;
					}
				} else {
					if (val instanceof String) {
						searchParameter = ((String) val).concat("%");
						query.setParameter(1, searchParameter);
					} else {
						query.setParameter(1, val);
					}
				}
			}
			entity = (U) query.getSingleResult();

			if (entity == null) {
				throw new TollSysAppException(ErrorConstants.CANNOT_FIND + CommonConstants.SPACE + entityName);
			}

		} catch (NoResultException e) {
			logger.error(entityName + ErrorConstants.ENTITY_NOT_EXISTS, e);
			throw new TollSysAppException(entityName + ErrorConstants.ENTITY_NOT_EXISTS, e);
		} catch (NonUniqueResultException e) {
			logger.error(entityName + ErrorConstants.ENTITY_NOTUNIQUE, e);
			throw new TollSysAppException(entityName + ErrorConstants.ENTITY_NOTUNIQUE, e);
		} catch (PersistenceException e) {
			logger.error(ErrorConstants.CANNOT_FIND + CommonConstants.SPACE + entityName, e);
			throw new TollSysAppException(ErrorConstants.CANNOT_FIND + CommonConstants.SPACE + entityName, e);
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
			throw new TollSysAppException(ErrorConstants.COMMON_EXCEPTION_MESSAGE + e.getMessage(), e);
		}
		return entity;
	}

	@Override
	public Long countByProperty(String prop, Object val) throws TollSysAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T insert(T entity) throws TollSysAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T entity) throws TollSysAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ID Id) throws TollSysAppException {
		// TODO Auto-generated method stub

	}
}
