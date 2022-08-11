package com.hmv.resttest.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

		return service.findOne(id);

	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody Users u) {
		
		Users user= service.saveUsers(u);
		
	}

}
