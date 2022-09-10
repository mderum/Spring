package com.hmv.resttest.Users;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();

	static {

		userList.add(new User("Erum", 1, LocalDate.now()));
		userList.add(new User("John", 2, LocalDate.now()));

	}
	private  static int count =2;

	public void insertUser(User u) {

		u.setId(++count);
		userList.add(u);
	}

	public List<User> findAll() {

		return userList;
	}

	public User findById(int id) {

		return userList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

	}
	
	public void removeById(int id) {
		
		userList.removeIf(u-> u.getId()==id);
		
	}
	

}
