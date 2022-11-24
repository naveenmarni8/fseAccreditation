package com.shopping.users.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.users.JwtTokenProvider;
import com.shopping.users.UsernamePwdAuthenticationProvider;
import com.shopping.users.model.AuthenticationRequest;
import com.shopping.users.model.UsersModel;
import com.shopping.users.service.UsersService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class UsersControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsersService usersService;
	
	@MockBean
	private PasswordEncoder passwordEncoder;
	
	@MockBean
	private UsernamePwdAuthenticationProvider usernamePwdAuthenticationProvider;
	
	@MockBean
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private UsersModel usersModel;
	
	private AuthenticationRequest authRequest;
	@BeforeEach
	public void init()
	{
		usersModel=UsersModel.builder()
				   .email("user.in@gmail.com")
				   .firstName("User")
		           .lastName("Indian")
		           .loginId("USER")
		           .password("1234")
		           .role("USER")
		           .build();
		
		authRequest=AuthenticationRequest.builder()
				    .username("user.in@gmail.com")
				    .password("1234")
				    .build();
		           
	}
	@Test
	@WithMockUser
	void test_createUser() throws JsonProcessingException, Exception
	{
		when(passwordEncoder.encode(usersModel.getPassword())).thenReturn(usersModel.getPassword());
		when(usersService.addUserService(usersModel)).thenReturn(usersModel);
		ResultActions response=mockMvc.perform(post("/api/v1.0/shopping/register")
				                      .contentType(MediaType.APPLICATION_JSON)
				                      .content(objectMapper.writeValueAsString(usersModel))
				                      .with(csrf()));
		response.andDo(print())
		        .andExpect(status().isOk());
		        
	}
	
	@Test
	@WithMockUser
	void test_loginUser() throws Exception
	{
		when(tokenProvider.generateToken(any())).thenReturn("SecretJwtToken");
		ResultActions response=mockMvc.perform(post("/api/v1.0/shopping/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authRequest))
                .with(csrf()));
		response.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser
	void test_forgotPassword() throws Exception
	{
		when(usersService.findUserService(usersModel.getEmail())).thenReturn(usersModel.getPassword());
		ResultActions response=mockMvc.perform(get("/api/v1.0/shopping//{email}/forgot",usersModel.getEmail()));
		
		response.andDo(print())
		        .andExpect(status().isOk());
	}
}
