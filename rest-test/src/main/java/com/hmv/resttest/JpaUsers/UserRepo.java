package com.hmv.resttest.JpaUsers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmv.resttest.Users.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	
	
}
