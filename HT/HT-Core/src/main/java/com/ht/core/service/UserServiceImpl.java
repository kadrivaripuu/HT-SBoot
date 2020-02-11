package com.ht.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.ht.core.beans.UserDto;
import com.ht.core.dao.UserDao;
import com.ht.core.model.User;
import com.ht.core.utils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	public void register(UserDto userDto) {
		// let's imagine (8 lines of code) many checks before save...
		User userAsModel = BeanUtils.dto2Model(userDto);
		userDao.save(userAsModel);
	}

	public UserDto findById(long id) {
		User user = userDao.findById(id).get();
		UserDto userAsDto = BeanUtils.model2Dto(user);
		return userAsDto;
	}

	public List<User> findAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		for (int i = 0; i < userDao.findAll().size(); i++) {
			allUsers.add(userDao.findAll().get(i));
		}
		return allUsers;
	}

	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

	/*
	 * 
	 * @Override public void updateUser(UserDto newUserDto) throws
	 * IllegalStateException {
	 * 
	 * if (newUserDto.getId() == null) { throw new
	 * IllegalStateException("User not found!"); }
	 * 
	 * User user = BeanUtils.dto2Model(userDto); userDao.updateUser(user);
	 * 
	 * 
	 * // throw new UnsupportedOperationException("Not implemented"); }
	 * 
	 */
}
