package com.truong.grpc.service.security;

import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcSecurityConfig {

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
    @Bean
    public GrpcAuthenticationReader grpcAuthenticationReader() {
    	return new CustomGrpcAuthenticationReader(customUserDetailsService);
    }
}
