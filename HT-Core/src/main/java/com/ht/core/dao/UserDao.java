package com.ht.core.dao;

import com.ht.core.model.User;


public interface UserDao {

	void save(User user);
	
	User findUserById(long id);
	
	void updateUser(User user);
	
	void deleteUser(long id);
	
}
