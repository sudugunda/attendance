package com.school.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.attendance.dto.RegisterDTO;

@Repository
public interface RegistrationDAO extends JpaRepository<RegisterDTO, Integer> {
	
	RegisterDTO findUserByEmail(String emailId);

}
