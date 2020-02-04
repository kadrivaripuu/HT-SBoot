package com.ht.core.dao.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ht.core.model.User;


@Component
public class UserRowMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet res, int rowNum) throws SQLException {
		User user = new User();
		user.setId(res.getLong("id"));
		user.setFname(res.getString("fname"));
		user.setLname(res.getString("lname"));
		user.setUsername(res.getString("username"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setRole(res.getString("role"));
		return user;
	}
}
