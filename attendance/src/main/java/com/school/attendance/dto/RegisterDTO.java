package com.school.attendance.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class RegisterDTO {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDTO.class);
	
	@Id
	@GeneratedValue( generator = "regId", strategy = GenerationType.SEQUENCE )
	private Integer userId;
	private String emailId;
	private String mobileNo;
	private String password;
	private Boolean isActive;
	
	public RegisterDTO() {
		LOGGER.debug(this.getClass().getSimpleName()+" : object created");
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "RegisterDTO [userId=" + userId + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}

}
