package com.ht.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ht.core.beans.UserDto;
import com.ht.core.dao.UserDao;
import com.ht.core.model.User;
import com.ht.core.utils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void register(UserDto userDto) {		
		//let's imagine (8 lines of code) many checks before save...
		User userAsModel = BeanUtils.dto2Model(userDto);
		userDao.save(userAsModel);		
	}

	@Override	
	public UserDto findById(long id) {
		User user = userDao.findUserById(id);
		UserDto userAsDto = BeanUtils.model2Dto(user);
		return userAsDto;
	}
	
	@Override
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}
	
	

	
	@Override
	public void updateUser(UserDto userDto) {

		User user = BeanUtils.dto2Model(userDto);
		userDao.updateUser(user);

		
//		throw new UnsupportedOperationException("Not implemented");
	}


}
