package com.school.attendance.serviceImpl;

import java.util.Objects;

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
			
			if( validationService.validateRegistrationFields(registerDto) && checkIfUserExists(registerDto.getEmailId()) ) {
				registerDto.setIsActive(true);
				RegisterDTO dtoAfterSave = registrationDAO.save(registerDto);
				return dtoAfterSave;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Boolean checkIfUserExists(String emailId) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : checkIfUserExists method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+emailId);
			
			RegisterDTO dtoAfterFetch = registrationDAO.findUserByEmail(emailId);
			if(Objects.nonNull(dtoAfterFetch)) {
				LOGGER.debug(getClass().getSimpleName()+" : user exists");
				
				return checkIfUserIsActive(dtoAfterFetch)?true:false;
			}
			
			return Objects.nonNull(registrationDAO.findUserByEmail(emailId))?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean checkIfUserIsActive(RegisterDTO dto) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : checkIfUserIsActive method called");
			
			return dto.getIsActive()?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public RegisterDTO getUser(LoginDTO loginDTO) {
		
		try {
			LOGGER.debug(getClass().getSimpleName()+" : checkIfUserExists method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+loginDTO.toString());
			
			RegisterDTO dtoAfterSave = registrationDAO.findUserByEmail(loginDTO.getUserName());
			
			if( validationService.validateLoginFields(loginDTO) && checkIfUserExists(loginDTO.getUserName()) ) {
				RegisterDTO dtoAfterFetch = registrationDAO.findUserByEmail(loginDTO.getUserName());
				return dtoAfterSave;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
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
			
			if(checkIfUserExists(emailId)) {
				RegisterDTO dtoAfterFetch = registrationDAO.findUserByEmail(emailId);
				dtoAfterFetch.setIsActive(false);
				return registrationDAO.save(dtoAfterFetch);
				
			}
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
