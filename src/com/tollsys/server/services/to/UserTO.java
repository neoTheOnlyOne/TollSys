package com.tollsys.server.services.to;

import com.tollsys.server.dal.entities.Address;

public class UserTO {

	private Long userId;
	private String password;
	private String userEmailId;
	private String userName;
	private Address address;

	/** default Constructor */
	public UserTO() {

	}

	/**
	 * @param userId
	 * @param password
	 * @param userEmailId
	 * @param userName
	 * @param address
	 */
	public UserTO(Long userId, String password, String userEmailId, String userName) {
		this.userId = userId;
		this.password = password;
		this.userEmailId = userEmailId;
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userEmailId
	 */
	public String getUserEmailId() {
		return userEmailId;
	}

	/**
	 * @param userEmailId
	 *            the userEmailId to set
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
