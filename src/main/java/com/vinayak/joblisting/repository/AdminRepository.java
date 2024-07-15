package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinayak.joblisting.model.AdminLogin;

public interface AdminRepository extends MongoRepository<AdminLogin , String> {
	AdminLogin findByUsernameAndPassword(String username , String password);
	
}
