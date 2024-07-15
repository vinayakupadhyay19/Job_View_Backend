package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinayak.joblisting.model.UserRegistration;

public interface UserRegistrationRepository extends MongoRepository <UserRegistration , String>{

	 UserRegistration findByUsername(String username);


}
