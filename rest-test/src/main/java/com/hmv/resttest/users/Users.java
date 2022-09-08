package com.hmv.resttest.users;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Users {

	public Users(String name, Integer id, Date dob) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
	}
	
	@Size(min=3 , message=" atleast 2 char required in name")
	private String name;
	private Integer id;
	private Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", id=" + id + ", dob=" + dob + "]";
	}
}
