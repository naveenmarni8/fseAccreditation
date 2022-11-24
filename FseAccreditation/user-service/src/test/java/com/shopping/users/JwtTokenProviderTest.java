package com.shopping.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@SpringBootTest
class JwtTokenProviderTest {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Test
	void test_generateToken()
	{
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
				new UsernamePasswordAuthenticationToken("user","password");
		assertNotNull(jwtTokenProvider.generateToken(usernamePasswordAuthenticationToken));
	}
	
	@Test
	void test_populateAuthorities()
	{   List<SimpleGrantedAuthority> authList=new ArrayList<>();
	    //authList.addAll("USER");
		assertEquals("",jwtTokenProvider.populateAuthorities(authList));
	}

}
