package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinayak.joblisting.model.AdminRegistration;

public interface AdminRegistrationRepository extends MongoRepository<AdminRegistration , String>{

	AdminRegistration findByUsername(String username);
	
}
