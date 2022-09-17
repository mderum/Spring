package com.hmv.resttest.JpaUsers;

import static  org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class jpaSecurity {

	
	@Bean
	public  SecurityFilterChain filterChain( HttpSecurity hs) throws Exception {
		
		hs.authorizeHttpRequests( auth ->auth.anyRequest().authenticated());
		
		hs.httpBasic(withDefaults());
		hs.csrf().disable();
		return hs.build();
		
	}
	
}
