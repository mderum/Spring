package com.hmv.resttest.Users;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	@Size(min=2, message=" Min 2 char needed in name")
	String name;
	
	public User(String name, int id,  LocalDate date) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
	}
	int id ;
	
	@Past(message=" dob should be in past not future")
	LocalDate date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", date=" + date + "]";
	}
	
}
