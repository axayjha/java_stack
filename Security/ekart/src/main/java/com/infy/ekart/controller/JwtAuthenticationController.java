package com.infy.ekart.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.config.JwtTokenUtil;
import com.infy.ekart.model.AuthToken;
import com.infy.ekart.model.Customer;
import com.infy.ekart.service.JwtUserDetailsService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<AuthToken> createAuthenticationToken(@RequestBody Customer customer) throws Exception {
		System.err.println(customer.getEmailId() + "   " + customer.getPassword());
		authenticate(customer.getEmailId(), customer.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(customer.getEmailId());
		System.err.println(userDetails.getUsername() + "   " + userDetails.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthToken(token));
	}
	
	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
