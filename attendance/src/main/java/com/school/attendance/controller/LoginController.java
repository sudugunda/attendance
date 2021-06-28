package com.school.attendance.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.attendance.dto.LoginDTO;
import com.school.attendance.dto.RegisterDTO;
import com.school.attendance.dto.UpdatePasswordDTO;
import com.school.attendance.service.RegistrationService;

@RestController
@RequestMapping( value = "/" )
public class LoginController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RegistrationService registrationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping(value = "/register")
	public ResponseEntity<RegisterDTO> register( @RequestBody RegisterDTO saveToDB ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : register method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+saveToDB);
			
			RegisterDTO dtoAfterSave = registrationService.registerUser(saveToDB);

			return new ResponseEntity<RegisterDTO>(dtoAfterSave, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<RegisterDTO> login( @RequestBody LoginDTO loginDTO ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : register method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+loginDTO);
			
			RegisterDTO dtoAfterSave = registrationService.checkIfUserExists(loginDTO);

			return new ResponseEntity<RegisterDTO>(dtoAfterSave, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping(value = "/updatePassword")
	public ResponseEntity<RegisterDTO> updatePassword( @RequestBody UpdatePasswordDTO updateDTO ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : updatePassword method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+updateDTO);
			
			RegisterDTO dtoAfterUpdate = registrationService.updatePassword(updateDTO);

			return new ResponseEntity<RegisterDTO>(dtoAfterUpdate, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<RegisterDTO> delete( @RequestBody String emailId ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : delete method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+emailId);
			
			RegisterDTO dtoAfterUpdate = registrationService.deleteUser(emailId);

			return new ResponseEntity<RegisterDTO>(dtoAfterUpdate, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
