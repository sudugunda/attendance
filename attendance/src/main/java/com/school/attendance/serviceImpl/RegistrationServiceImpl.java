package com.school.attendance.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.attendance.dao.RegistrationDAO;
import com.school.attendance.dto.LoginDTO;
import com.school.attendance.dto.RegisterDTO;
import com.school.attendance.dto.UpdatePasswordDTO;
import com.school.attendance.service.RegistrationService;
import com.school.attendance.service.ValidationService;

public class RegistrationServiceImpl implements RegistrationService{

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	@Autowired
	private RegistrationDAO registrationDAO;
	
	@Autowired
	private ValidationService validationService;
	
	@Override
	public RegisterDTO registerUser(RegisterDTO registerDto) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : registerUser method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+registerDto.toString());
			
			RegisterDTO dtoAfterSave = registrationDAO.save(registerDto);
			
			return dtoAfterSave;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RegisterDTO checkIfUserExists(LoginDTO loginDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : checkIfUserExists method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+loginDTO.toString());
			
			RegisterDTO dtoAfterSave = registrationDAO.findUserByEmail(loginDTO.getUserName());
			
			return dtoAfterSave;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public RegisterDTO updatePassword(UpdatePasswordDTO updateDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : updatePassword method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+updateDTO.toString());
			
			if(validationService.validateUpdatePasswordDTO(updateDTO)) {
				RegisterDTO dtoAfterFetch = registrationDAO.findUserByEmail(updateDTO.getEmailId());
				dtoAfterFetch.setPassword(updateDTO.getNewPassword());
				RegisterDTO dtoAfterSave = registrationDAO.save(dtoAfterFetch);
				return dtoAfterSave;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public RegisterDTO deleteUser(String emailId) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : deleteUser method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+emailId);
			
			RegisterDTO dtoAfterFetch = registrationDAO.findUserByEmail(emailId);
			RegisterDTO dtoAfterDelete = registrationDAO.save(dtoAfterFetch);
			
			return dtoAfterDelete;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
