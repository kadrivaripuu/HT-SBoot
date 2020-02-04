package com.ht.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ht.core.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

	List<User> findByUsername(String username);
	
	List<User> findByUsernameAndRole(String username, String role);

}
