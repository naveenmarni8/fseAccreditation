package com.shopping.users.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.users.exception.CustomException;
import com.shopping.users.model.UsersModel;
import com.shopping.users.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersService
{
@Autowired
private UsersRepository usersRepository;
public UsersModel addUserService(UsersModel usersModel)
{
	if(usersRepository.findByEmail(usersModel.getEmail()).isEmpty())
	{
	return usersRepository.save(usersModel);
	}
	
	return null;
}
public String findUserService(String email) throws CustomException
{
	UsersModel res=usersRepository.findByEmail(email).isEmpty()?null:usersRepository.findByEmail(email).get(0);
	
	log.info("size: "+res);
	if(res!=null)
	{
		return res.getPassword();
	}
	throw new CustomException("Email Id is not found!");
}

public UsersModel getByEmail(String email) throws CustomException
{
	UsersModel res=usersRepository.findByEmail(email).isEmpty()?null:usersRepository.findByEmail(email).get(0);
	if(res!=null)
	{
		return res;
	}
	throw new CustomException("Username is not found!");
}

}
