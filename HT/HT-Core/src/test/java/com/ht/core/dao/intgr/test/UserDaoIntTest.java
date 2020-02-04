package com.ht.core.dao.intgr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ht.core.config.HtCoreConfig;
import com.ht.core.dao.UserDao;
import com.ht.core.model.User;

public class UserDaoIntTest {

	@Test
	public void testSave() {

		ApplicationContext context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
		UserDao userDao = context.getBean(UserDao.class);

		// 1) Create UserDto
		User mockUser = new User();
		mockUser.setFname("Next");
		mockUser.setLname("User");
		mockUser.setUsername("nextUser");
		mockUser.setPassword("tere");
		mockUser.setEmail("next@user.com");
//		mockUser.setRole("kasutaja");

		userDao.save(mockUser);
		userDao.findByUsername("järgmineKasutaja");
		userDao.findByUsernameAndRole("järgmineKasutaja", "kasutaja");
	}


}
