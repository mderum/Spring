package com.hmv.resttest.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {


	public UserException(String s) {
		
		super(s);
	}
	
	
}
