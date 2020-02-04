package com.ht.core.service;

import java.util.List;

import com.ht.core.beans.UserDto;
import com.ht.core.model.User;

public interface UserService {

	void register(UserDto user);
	
	UserDto findById(long id);
	
	void updateUser (UserDto userDto);
	
	void deleteUser(long id);
}
