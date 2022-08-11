package com.hmv.resttest.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCont {

	@GetMapping(path="/hw")
	public String hello() {
		
		return "<H4>Im Spring <h4>";
	}
	
	
	@GetMapping(path="/hbean")
	public HelloBean helloBean() {
		
		return new HelloBean(" im a object");
		
	}
	
	@GetMapping(path="/hvar/{name}")
	public HelloBean helloVar( @PathVariable String name) {
		
		return new HelloBean(" im a object " + name);
		
	}
}
