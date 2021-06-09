package com.infy.ekart.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infy.ekart.model.Customer;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if ("tom@infy.com".equals(email)) {
			return new User("tom@infy.com", "test", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with emailId: " + email);
		}
	}
}
