package com.midashnt.taekwondo.app.dto;
import org.springframework.stereotype.Component;
@Component
public class User {
	public static final String COLUMN_NAME_USER_INDEX = "USER_INDEX";
	public static final String KEY_USER_INDEX = "userIndex";
	private int userIndex;
	public static final String COLUMN_NAME_USER_ID = "USER_ID";
	public static final String KEY_USER_ID = "userId";
	private String userId;
	public static final String COLUMN_NAME_USER_PASSWORD = "USER_PASSWORD";
	public static final String KEY_USER_PASSWORD = "userPassword";
	private String userPassword;
	public static final String COLUMN_NAME_USER_NAME = "USER_NAME";
	public static final String KEY_USER_NAME = "userName";
	private String userName;
	public static final String COLUMN_NAME_USER_AUTHORITY = "USER_AUTHORITY";
	public static final String KEY_USER_AUTHORITY = "userAuthority";
	private int userAuthority;
	public int getUserIndex () {
		return userIndex;
	}
	public void setUserIndex (int userIndex) {
		this.userIndex = userIndex;
	}
	public String getUserId () {
		return userId;
	}
	public void setUserId (String userId) {
		this.userId = userId;
	}
	public String getUserPassword () {
		return userPassword;
	}
	public void setUserPassword (String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName () {
		return userName;
	}
	public void setUserName (String userName) {
		this.userName = userName;
	}
	public int getUserAuthority () {
		return userAuthority;
	}
	public void setUserAuthority (int userAuthority) {
		this.userAuthority = userAuthority;
	}
}