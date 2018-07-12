package com.tollsys.client.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "login")
@SessionScoped
public class LoginModel {

	private String userName;
	private String password;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the loginId to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String checkValidUser() {
		//dbData(userName);
		if (userName.equalsIgnoreCase("user")) {
			if (password.equalsIgnoreCase("pass"))
				return "success";
			else
				return "failure";
		} else
			return "failure";
	}
}
