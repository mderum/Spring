package com.hmv.resttest.Users;

import java.time.LocalDate;

public class ErrorDetailks {

	
	 public ErrorDetailks(String message, String details, LocalDate timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
	private String message;
	 private 	String details;
	private 	LocalDate timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ErrorDetailks [message=" + message + ", details=" + details + ", timestamp=" + timestamp + "]";
	}
}
