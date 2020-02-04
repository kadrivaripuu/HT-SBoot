package com.ht.core.beans;

import lombok.Data;



@Data
public class UserDto {

	private long id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String email;
	private String role;
}

