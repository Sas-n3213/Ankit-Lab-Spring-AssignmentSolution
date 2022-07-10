package com.studentmanagement;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.studentmanagement.dao.RoleRepository;
import com.studentmanagement.dao.UserRepository;
import com.studentmanagement.entity.Role;
import com.studentmanagement.entity.User;

@SpringBootApplication
public class SpringBootDesignApplication implements CommandLineRunner  {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDesignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}