package com.hmv.resttest.Users;

import java.util.ArrayList;
import java.util.List;

public class testmeth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String > sList = new ArrayList<>();
		
		sList.add("a");	sList.add("b");	sList.add("b");	sList.add("d");	sList.add("e");	
		
		
		sList.removeIf(s-> s.equals("b"));
		
		System.out.println(sList.toString());
		
	}

}
