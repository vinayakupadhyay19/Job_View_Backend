package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinayak.joblisting.model.UpdateUser;

public interface UpdateUserRepositoy extends MongoRepository<UpdateUser , String> {

	UpdateUser findByUsername(String uname);

}
