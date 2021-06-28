package com.school.attendance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDTO implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDTO.class);
	
	@Id
	@GeneratedValue( generator = "userId", strategy = GenerationType.SEQUENCE )
	private Integer userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dob;
	private int year;
	private int rollNo;
	private String city;
	private Long pincode;
	
	public UserDTO() {
		LOGGER.debug(this.getClass().getSimpleName()+" : object cretaed");
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", dob=" + dob + ", year=" + year + ", rollNo=" + rollNo + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

}
