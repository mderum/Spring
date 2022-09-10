package com.hmv.resttest.Users;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetailks> handleAllException(Exception e, WebRequest wr) throws Exception {
		System.out.println("----- " + wr.toString());
		return new ResponseEntity<ErrorDetailks>(
				new ErrorDetailks(e.getMessage(), wr.getDescription(false), LocalDate.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetailks> handleUserNFException(Exception e, WebRequest wr) throws Exception {
		System.out.println("----- " + wr.toString());
		return new ResponseEntity<ErrorDetailks>(
				new ErrorDetailks(e.getMessage(), wr.getDescription(false), LocalDate.now()),
				HttpStatus.NOT_FOUND);

	}
	

}
