package com.ht.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ht.core.model.User;


@Repository
public interface UserDao extends JpaRepository<User,Long> {

	List<User> findByUsername(String username);
	
	List<User> findByUsernameAndRole(String username, String role);

	@Transactional
	void deleteByUsername(String username);
	
//	@Query("from user u where u.fname=:fname")
//	List<User> findByFname(@Param("fname") String fname);

}
