package com.shopping.users.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.users.model.UsersModel;


@SpringBootTest
class UsersRepositoryTests {
@Autowired
private UsersRepository usersRepository;
private UsersModel usersModel;
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
	           
}

@Test
void test_SaveUser()
{
	assertEquals(usersModel,usersRepository.save(usersModel));
}
@Test
void test_findByEmail()
{
	assertTrue(usersRepository.findByEmail(usersModel.getEmail()).size()>0);
}
}
