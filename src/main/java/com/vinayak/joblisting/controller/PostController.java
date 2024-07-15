package com.vinayak.joblisting.controller;


import com.vinayak.joblisting.model.AdminLogin;
import com.vinayak.joblisting.model.AdminRegistration;

import com.vinayak.joblisting.model.Post;
import com.vinayak.joblisting.model.UpdateUser;
import com.vinayak.joblisting.model.UserLogin;
import com.vinayak.joblisting.model.UserRegistration;
import com.vinayak.joblisting.repository.AdminRegistrationRepository;
import com.vinayak.joblisting.repository.AdminRepository;

import com.vinayak.joblisting.repository.PostRepository;
import com.vinayak.joblisting.repository.SearchRepository;
import com.vinayak.joblisting.repository.UpdateUserRepositoy;
import com.vinayak.joblisting.repository.UserRegistrationRepository;
import com.vinayak.joblisting.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController
{

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;
    
    @Autowired
    UserRegistrationRepository urepo;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    AdminRepository adminRepo;
    
    @Autowired
    AdminRegistrationRepository arRepo;
    
    @Autowired
    UpdateUserRepositoy updrepo;
    
    
    
    
    
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    
    
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }
    
    
    // posts/java
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }
    
    
   
    
    
    
    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
    	//System.out.println(post);
        return repo.save(post);
    }
    
    
    
    
    
    
    
    @PostMapping("/UserRegistration")
    @CrossOrigin
    public UserRegistration addLogin(@RequestBody UserRegistration ulogin) {
    	String username = ulogin.getUsername();
    	if(urepo.findByUsername(username) == null) {
    		return urepo.save(ulogin);
    	}else {
    		System.out.println("Already username exists.");
    	}
    	return null;
    }
    
    @PostMapping("/AdminRegistration")
    @CrossOrigin
    public AdminRegistration addAdmin(@RequestBody AdminRegistration alogin) {
    	String uname = alogin.getUsername();
    	if(arRepo.findByUsername(uname) == null) {
    		return arRepo.save(alogin);
    	}else {
    		System.out.println("Already username exists.");
    	}
    	return null;
    }
    
    
    @PostMapping("/UserLogin")
    @CrossOrigin
    public boolean login(@RequestBody UserLogin ur) {
    	String username = ur.getUsername();
    	String password = ur.getPassword();
    	
    	System.out.println(username+"  "+password);
    	UserLogin user = userRepository.findByUsernameAndPassword(username,password);
    	
    	
    	
    	System.out.println(user);
        
        return user != null;
    }
    
    
    
    @PostMapping("/AdminLogin")
    @CrossOrigin
    public boolean adminlogin(@RequestBody AdminLogin al) {
    	String uname = al.getUsername();
    	String pass = al.getPassword();
    	
    	System.out.println(uname+" "+pass);
    	
    	AdminLogin admin = adminRepo.findByUsernameAndPassword(uname, pass);
    	
    	System.out.println(admin);
    	
    	return admin!=null;
    }
    
    
    
    
    
    int f=0;
    @PutMapping("/update")
    @CrossOrigin
    public boolean updateUser(@RequestBody UpdateUser ud) {
    	String uname = ud.getUsername();
    	String newpass = ud.getPassword();
    	
    	UpdateUser upd = updrepo.findByUsername(uname);
    	if(upd != null && f==0) {
    		
			f=1;
			upd.setPassword(newpass);
			updrepo.save(upd);
			List<UpdateUser> arr = updrepo.findAll();
			//System.out.println(arr.size());
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i).getUsername().equalsIgnoreCase(uname)) {
					userRepository.deleteByUsernameAndPassword(uname,arr.get(i).getPassword());
					break;
				}
			}
    		
    		return true;
    	}
    	if(f == 1) System.out.println("It is changed do not hit again...");
    	else
    	System.out.println("Cant update.. Because No user found....");
    	return false;
    	
    }
    
    
    
    @DeleteMapping("/users/{username}")
    @CrossOrigin
    public boolean delete(@PathVariable String username) {
    	System.out.println(username);
    	UserLogin user = userRepository.findByUsername(username);
    	if(user != null) {
    		userRepository.deleteByUsername(username);
    		return true;
    	}else {
    		System.out.println("Not present....");
    	}
    	return false;
    }
    
    
    @DeleteMapping("/apply/{id}")
    @CrossOrigin
    public void apply(@PathVariable String id) {
    	 System.out.println(id);
    	 repo.deleteById(id);
    } 

}