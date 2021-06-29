package com.school.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.school.attendance.dao.RegistrationDAO")
@ComponentScan(basePackages = "com.school.attendance.AttendanceApplication")
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

}
