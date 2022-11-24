package com.shopping.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shopping.users.filter.JwtTokenValidationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v1.0/shopping/login","/api/v1.0/shopping/register").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated().and()
		.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(new JwtTokenValidationFilter(), UsernamePasswordAuthenticationFilter.class)
		.httpBasic();
        


            
        return httpSecurity.build();
    }
	
	@Bean
	public PasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	 

}
