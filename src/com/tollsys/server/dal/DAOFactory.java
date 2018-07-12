/**
 * 
 */
package com.tollsys.server.dal;

/**
 * @author  SN
 *
 */
public abstract class DAOFactory {

	public static final int JDBC = 1;
	public static final int JPA = 2;

	/**
	 * Gets the dAO factory.
	 * 
	 * @param whichFactory
	 *            the which factory
	 * @param payload
	 *            the payload
	 * 
	 * @return the dAO factory
	 */
	public final static DAOFactory getDAOFactory(int whichFactory, Object payload) {

		switch (whichFactory) {
		case JPA:
			return new JPADAOFactory(payload);
		default:
			return null;
		}
	}

	public abstract UserDetailDAO getUserDetailDAO();

	public abstract TaskDAO getTaskDAO();

	public abstract CityDAO getCityDAO();

	public abstract StateDAO getStateDAO();

	public abstract CountryDAO getCountryDAO();

}
