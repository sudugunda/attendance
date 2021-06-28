package com.school.attendance.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDTO.class);
	
	private String userName;
	private String password;
	
	public LoginDTO() {
		LOGGER.debug(this.getClass().getSimpleName()+" : object created");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}

}
