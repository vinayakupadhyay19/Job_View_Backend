package com.vinayak.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vinayak.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	
	 
}
