package com.school.attendance.service;

import org.springframework.stereotype.Service;

import com.school.attendance.dto.LoginDTO;
import com.school.attendance.dto.RegisterDTO;
import com.school.attendance.dto.UpdatePasswordDTO;

@Service
public interface RegistrationService {
	
//	RegisterDTO getRegisteredUser();
	
	RegisterDTO registerUser(RegisterDTO registerDto);

	RegisterDTO getUser(LoginDTO loginDTO);

	RegisterDTO updatePassword(UpdatePasswordDTO updateDTO);

	RegisterDTO deleteUser(String emailId);
	
//	RegisterDTO updateUser();
	
//	RegisterDTO deleteUser();

}
