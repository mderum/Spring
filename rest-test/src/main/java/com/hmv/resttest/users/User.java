package com.hmv.resttest.Users;

import java.time.OffsetDateTime;

public class User {

	
	String name;
	
	public User(String name, int id, OffsetDateTime date) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
	}
	int id ;
	OffsetDateTime date;
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
	public OffsetDateTime getDate() {
		return date;
	}
	public void setDate(OffsetDateTime date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", date=" + date + "]";
	}
	
}
