package com.school.attendance.controller;

import java.util.Objects;

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
	private RegistrationService registrationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping(value = "/register")
	public ResponseEntity<RegisterDTO> register( @RequestBody RegisterDTO saveToDB ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : register method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+saveToDB.toString());
			
			RegisterDTO dtoAfterSave = registrationService.registerUser(saveToDB);
			
			if(Objects.nonNull(dtoAfterSave)) {
				return new ResponseEntity<RegisterDTO>(dtoAfterSave, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
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
			
			RegisterDTO dtoAfterFetch = registrationService.getUser(loginDTO);
			
			if(Objects.nonNull(dtoAfterFetch)) {
				return new ResponseEntity<RegisterDTO>(dtoAfterFetch, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
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

			if(Objects.nonNull(dtoAfterUpdate)) {
				return new ResponseEntity<RegisterDTO>(dtoAfterUpdate, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}//Hello
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<RegisterDTO> delete( @RequestBody String emailId ){
		
		try {
			LOGGER.debug(this.getClass().getSimpleName()+" : delete method called");
			LOGGER.debug(getClass().getSimpleName()+" : "+emailId);
			
			RegisterDTO dtoAfterDelete = registrationService.deleteUser(emailId);

			if(Objects.nonNull(dtoAfterDelete)) {
				return new ResponseEntity<RegisterDTO>(dtoAfterDelete, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
