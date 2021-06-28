package com.school.attendance.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePasswordDTO {
	
private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDTO.class);
	
	private String emailId;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	public UpdatePasswordDTO() {
		LOGGER.debug(this.getClass().getSimpleName()+" : object created");
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UpdatePasswordDTO [emailId=" + emailId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}

}
