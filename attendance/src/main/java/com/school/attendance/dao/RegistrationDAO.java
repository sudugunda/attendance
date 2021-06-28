package com.school.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.attendance.dto.RegisterDTO;

public interface RegistrationDAO extends JpaRepository<RegisterDTO, Integer> {
	
	RegisterDTO findUserByEmail(String emailId);

}
