package com.tollsys.server.dal.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.tollsys.common.util.NamedQueryConstants;

/**
 * The persistent class for the user_detail database table.
 * 
 */
@Entity
@Table(name = "user_detail")
@NamedQueries({ @NamedQuery(name = NamedQueryConstants.USER_FIND_ALL, query = "SELECT u FROM UserDetail u"),
	@NamedQuery(name = NamedQueryConstants.USER_FIND_BY_ID , query = "SELECT u.userName, u.password FROM UserDetail u WHERE u.userName LIKE ?1"),
	@NamedQuery(name = NamedQueryConstants.USER_FIND_ALL1, query = "SELECT u.userName, u.userId FROM UserDetail u")
})

public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String password;
	private String userEmailId;
	private String userName;
//	private Address address;

	public UserDetail() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(nullable = false, length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_email_id", length = 45)
	public String getUserEmailId() {
		return this.userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	@Column(nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

/*	// bi-directional many-to-one association to Address
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

}