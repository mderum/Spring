package com.hmv.resttest.JpaUsers;

import java.util.List;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmv.resttest.Users.User;

@RestController
public class JpaUserRes {

	public JpaUserRes(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	private UserRepo userRepo ;
	
	@GetMapping("/jpa/user")
	public List<User> getAll(){
		
		return userRepo.findAll();
		
	}
	
	@GetMapping("/jpa/user/{id}")
	public User getOne( @PathVariable int id){
		
		return userRepo.findById(id).get();
		
	}
	
	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteOne(@PathVariable int id){
		
		 userRepo.deleteById(id);
		
	}
	
	
	
	@PostMapping("/jpa/user")
	public User saveOne(@RequestBody User u){
		
		return userRepo.save(u);
		
	}
	
	
	@GetMapping("/jpa/user/{id}/posts")
	public List<Posts> getPosts( @PathVariable int id){
		
		User u = userRepo.findById(id).get();
		
		return u.getPosts();
		
	}
	
	
}
