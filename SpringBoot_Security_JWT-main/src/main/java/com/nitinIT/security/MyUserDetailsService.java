package com.nitinIT.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nitinIT.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		com.nitinIT.models.User u=userrepo.findByUserName(s);
		 System.out.println("user data "+u.getUserName());
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		u.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase()));
		});
	
		return new User(u.getUserName(), u.getUserPassword(), authorities);
	}
}