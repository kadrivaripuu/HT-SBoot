package com.ht.core.utils;

import com.ht.core.beans.UserDto;
import com.ht.core.model.User;

public class BeanUtils {

	public static User dto2Model(UserDto dto){
		User user = new User();
		user.setId(dto.getId());
		user.setFname(dto.getFname());
		user.setLname(dto.getLname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		user.setRole(dto.getRole());
		return user;
	}

	public static UserDto model2Dto(User model){
		UserDto dto = new UserDto();
		dto.setId(model.getId());
		dto.setFname(model.getFname());
		dto.setLname(model.getLname());
		dto.setUsername(model.getUsername());
		dto.setPassword(model.getPassword());
		dto.setEmail(model.getEmail());
		dto.setRole(model.getRole());
		return dto;
	}

}
