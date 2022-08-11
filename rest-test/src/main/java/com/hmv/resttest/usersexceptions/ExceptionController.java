package com.hmv.resttest.usersexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hmv.resttest.users.UserException;

@RestController
@RestControllerAdvice
public class ExceptionController  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
	
		return  new ResponseEntity(
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false))
				, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<Object> handleUserException(Exception ex, WebRequest request){
		
	
		return  new ResponseEntity(
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false))
				, HttpStatus.NOT_FOUND);
		
	}
	
}
