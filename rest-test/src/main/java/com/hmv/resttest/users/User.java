package com.hmv.resttest.Users;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hmv.resttest.JpaUsers.Posts;

@Entity(name = "user_details")
public class User {

	protected User() {
	}
	
	@Id
	@GeneratedValue
	private int id;

	@Past(message = " dob should be in past not future")
	private LocalDate date;
	@Size(min = 2, message = " Min 2 char needed in name")
	private String name;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Posts> posts;

	public User(String name, int id, LocalDate date) {
		super();
		this.name = name;
		this.id = id;

		this.date = date;
	}



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
		return "User [id=" + id + ", date=" + date + ", name=" + name + ", posts=" + posts + "]";
	}



	public List<Posts> getPosts() {
		return posts;
	}



	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

}
