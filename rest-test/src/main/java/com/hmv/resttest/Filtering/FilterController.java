package com.hmv.resttest.Filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	
	
	
	@GetMapping("/filterA")
	public MappingJacksonValue getFilterA() {
		
		
		
		TestBean testBean = new TestBean("a","b","c");
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(testBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("tBean", filter );
		jacksonValue.setFilters(filters );
		return jacksonValue;
	}
	
	
	
	@GetMapping("/filterB")
	public List<TestBean> getFilterB() {
		
		return Arrays.asList(new TestBean("a","b","c") , new TestBean("e","f","g")) ;
	}
}
