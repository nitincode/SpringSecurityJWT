package com.nitinIT.rest;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nitinIT.models.AuthenticationRequest;
import com.nitinIT.models.AuthenticationResponse;
import com.nitinIT.models.Role;
import com.nitinIT.models.User;
import com.nitinIT.repository.RoleRepository;
import com.nitinIT.repository.UserRepository;
import com.nitinIT.security.MyUserDetailsService;
import com.nitinIT.util.JwtUtil;

@RestController
public class HelloRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	UserRepository  userRepo;

	
	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}
	


	@PostMapping("/authenticate")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getUserPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		 UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		   String jwt = jwtTokenUtil.generateToken(userDetails);
		   
		   System.out.println("toke"+jwt);
		
		User user = userRepo.findByUserName(authenticationRequest.getUserName());

		//return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
		return new AuthenticationResponse(jwt,user);
	}
	
	@RequestMapping("/protected")
	public String commonPage () {
		return "displying the commong page contents";
	}
	
	@RequestMapping("/user")
	public String userPage () {
		return "displying the user page contents";
	}
	
	@RequestMapping("/admin")
	public String adminPage () {
		return "displying the admin page contents";
	}
	
}
