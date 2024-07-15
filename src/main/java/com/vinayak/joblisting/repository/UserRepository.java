package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

import com.vinayak.joblisting.model.UserLogin;



public interface UserRepository extends MongoRepository<UserLogin, String>{
	//@Query("{'username' : ?0, 'password' : ?1}")
	
	UserLogin findByUsernameAndPassword(String username , String password);

	UserLogin findByUsername(String uname);

	void deleteByUsername(String uname);

	void deleteByUsernameAndPassword(String uname, String password);
	
}
