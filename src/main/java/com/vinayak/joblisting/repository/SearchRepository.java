 package com.vinayak.joblisting.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vinayak.joblisting.model.Post;


public interface SearchRepository {

	List<Post> findByText(String text);
	
}
