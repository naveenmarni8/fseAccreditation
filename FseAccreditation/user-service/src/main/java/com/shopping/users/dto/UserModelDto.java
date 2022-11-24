package com.shopping.users.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModelDto {
	
	@NotNull(message="login Id is required")
	private String loginId;
	@NotNull(message="Email is required")
	@Email(message="Email is not valid")
	private String email;
	@NotNull(message="First Name is required")
	private String firstName;
	@NotNull(message="Last Name is required")
	private String lastName;
	@NotNull(message="Password is required")
	private String password;
	@NotNull(message="Confirm Password is required")
	private String confirmPassword;
	@NotNull(message="Role is required")
	private String role;

}
