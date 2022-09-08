package com.hmv.resttest.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<Users> userlist = new ArrayList<>();

	static {

		userlist.add(new Users("erum", 1, new Date()));
		userlist.add(new Users("umam", 2, new Date()));
	}
	int count = 2;

	public List<Users> findAll() {

		return userlist;
	}

	public Users findOne(int id) {

		for (Users u : userlist) {

			if (u.getId() == id)
				return u;
		}
		return null;
	}
	
	
	
	public Users deleteOne(int id) {

		for (Iterator<Users> iterator = userlist.iterator(); iterator.hasNext();) {
			Users u = iterator.next();
			
			if (u.getId() == id)
				{iterator.remove();
				return u;}
		}
		return null;
	}
	
	

	public Users saveUsers(Users u) {
		if (u.getId() == null) {

			count++;
			u.setId(count);
		}
		userlist.add(u);
		return u;
	}

	public static List<Users> getUserlist() {
		return userlist;
	}

	public static void setUserlist(List<Users> userlist) {
		UserDaoService.userlist = userlist;
	}
}
