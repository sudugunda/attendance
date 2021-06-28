package com.school.attendance.service;

import org.springframework.stereotype.Service;

import com.school.attendance.dto.LoginDTO;
import com.school.attendance.dto.RegisterDTO;
import com.school.attendance.dto.UpdatePasswordDTO;

@Service
public interface ValidationService {
	
	Boolean validateRegistrationFields(RegisterDTO validateDTO);
	
	Boolean validateLoginFields(LoginDTO validateDTO);
	
	Boolean validateUpdatePasswordDTO(UpdatePasswordDTO validateDTO);

}
