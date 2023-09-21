package com.truong.grpc.service.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from your data source and return a UserDetails object
        // You can use repositories, JDBC, or any other method to fetch user details
        // Create a UserDetails instance based on your user data
        // Example: return new User(username, password, authorities);
    	
    	return new User(username, username, null);
    }
}
