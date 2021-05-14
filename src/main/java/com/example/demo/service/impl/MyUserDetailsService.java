package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.restcontroller.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.restcontroller.model.Admin;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	Admin admin = userRepository.findByUsername(username);
		if (admin == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(),
				new ArrayList<>());
    }
    
    public Admin save(User user) {
    	
    	Admin admin = new Admin();
    	
    	admin.setUsername(user.getUsername());
    	admin.setPassword(user.getPassword());
    	
		return userRepository.save(admin);
    	
    }
}
