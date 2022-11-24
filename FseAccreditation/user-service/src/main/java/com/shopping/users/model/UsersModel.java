package com.shopping.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="ShoppingUsers")
public class UsersModel {
	private String loginId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	

}
