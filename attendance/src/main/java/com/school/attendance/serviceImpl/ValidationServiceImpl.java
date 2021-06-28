package com.school.attendance.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.school.attendance.dto.LoginDTO;
import com.school.attendance.dto.RegisterDTO;
import com.school.attendance.dto.UpdatePasswordDTO;
import com.school.attendance.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationServiceImpl.class);
	
	@Override
	public Boolean validateRegistrationFields(RegisterDTO validateDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : validateRegistrationFields method called");
		
			if(!StringUtils.isEmpty(validateDTO.getEmailId()) 
					&& !StringUtils.isEmpty(validateDTO.getPassword())
					&& !StringUtils.isEmpty(validateDTO.getMobileNo())) {
				LOGGER.debug(getClass().getSimpleName()+" : registerdto validated successfully");
				return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public Boolean validateLoginFields(LoginDTO validateDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : validateLoginFields method called");
			
			if( !StringUtils.isEmpty(validateDTO.getUserName()) 
					&& !StringUtils.isEmpty(validateDTO.getPassword())) {
				LOGGER.debug(getClass().getSimpleName()+" : login dto validated successfully");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public Boolean validateUpdatePasswordDTO(UpdatePasswordDTO validateDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : validateUpdatePasswordDTO method called");
			
			if( !StringUtils.isEmpty(validateDTO.getEmailId()) 
					&& !StringUtils.isEmpty(validateDTO.getOldPassword())
					&& !StringUtils.isEmpty(validateDTO.getNewPassword())
					&& !StringUtils.isEmpty(validateDTO.getConfirmPassword())) {
				LOGGER.debug(getClass().getSimpleName()+" : validateDTO validated successfully");

				return comparePassword(validateDTO.getNewPassword(), validateDTO.getConfirmPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Boolean comparePassword(String pass1, String pass2) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : comparePassword method called");
			if(pass1.equals(pass2)) {
				LOGGER.debug(getClass().getSimpleName()+" : password compared successfully");
				return true;
			}
			LOGGER.debug(getClass().getSimpleName()+" : password compare failed");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
