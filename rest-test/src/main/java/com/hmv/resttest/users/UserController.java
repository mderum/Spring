package com.hmv.resttest.users;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired
	private MessageSource message;

	@GetMapping("/users")
	public List<Users> getUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<Users> getUser(@PathVariable int id) {

		Users u = service.findOne(id);
		if (u == null) {
			throw new UserException("User not found with id : " + id);
		}
//		EntityModel<Users>  model = EntityModel.of(u); 

//		WebMvcLinkBuilder linUser =	linkTo(
//			 methodOn(this.getClass()).getUsers()
//			 
//			 
//			 );

		return EntityModel.of(u).add(linkTo(methodOn(this.getClass()).getUsers()

		).withRel(" all -users "));
//		return u;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		Users u = service.deleteOne(id);
		if (u == null) {
			throw new UserException("User not found to delete with id : " + id);
		}

	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Users u) {

		Users user = service.saveUsers(u);

		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri())
				.build();

	}

	@GetMapping("/inter")
	public String getMessage() {
		return message.getMessage("mlang", null, LocaleContextHolder.getLocale());

	}

}
