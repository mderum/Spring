package com.hmv.resttest.Users;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service=service;
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody  User u) {
		
		try {
		service.insertUser(u);
	
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri()).build();
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}


	}
	
	
	
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
	return	service.findAll();
		
	}
	
	
	@GetMapping("/users/{id}")
	public User getUser( @PathVariable int id)
	{
		User u = service.findById(id);
		if(u==null) {
			
			throw new UserNotFoundException(" User not present for given  id : " + id);
		}
		else {
			
			return u;
		}
			
	
		
	}

}
