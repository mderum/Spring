package com.hmv.resttest.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<Users> getUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable int id) {

		Users u= service.findOne(id);
		if(u==null) {
			throw new UserException("User not found with id : "+id);
		}
		

		return u;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody Users u) {
		
		Users user= service.saveUsers(u);
		
	return	ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(user.getId()).toUri()).build();
		
	}

}
