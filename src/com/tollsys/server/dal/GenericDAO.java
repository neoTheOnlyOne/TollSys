/**
 * 
 */
package com.tollsys.server.dal;

import java.io.Serializable;
import java.util.List;

import com.tollsys.common.exception.TollSysAppException;

/**
 * @author  SN
 *
 */
public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public T findById(ID Id) throws Exception;
	
	public <U> List<U> findByProperty(String prop) throws TollSysAppException;
	
	public <U> List<U> findByPropertyFiltered(String prop, Object val) throws TollSysAppException;
	
	public <U> U findSingleByProperty(String prop, Object val) throws TollSysAppException;
	
	public Long countByProperty(String prop, Object val) throws TollSysAppException;
	
	public List<T> findAll() throws TollSysAppException;
	
	public T insert(T entity) throws TollSysAppException;
	
	public T update(T entity) throws TollSysAppException;
	
	public void delete(ID Id) throws TollSysAppException;
}
