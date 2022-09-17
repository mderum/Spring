package com.hmv.resttest.JpaUsers;

import java.util.List;

import javax.validation.Valid;

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
	
	private UserRepo userRepo ;
	
	private PostRepo postRepo; 
	
	public JpaUserRes(UserRepo userRepo, PostRepo postRepo) {
		super();
		this.userRepo = userRepo;
		this.postRepo = postRepo;
	}



	
	


	
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
	
	
	@PostMapping("/jpa/user/{id}/post")
	public List<Posts> getOne( @PathVariable int id  ,@Valid @RequestBody Posts p){
		
		User u=  userRepo.findById(id).get();
		
		if(null != u) {
			
			p.setUser(u);
			postRepo.save(p);
		return u.getPosts();
		}
		else {
			
			
			return null;
		}
		
		
		
	}
	
	
	
}
