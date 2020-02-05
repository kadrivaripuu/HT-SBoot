package com.ht.core.dao.intgr.test;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ht.core.config.HtCoreConfig;
import com.ht.core.dao.UserDao;
import com.ht.core.model.User;
import com.zaxxer.hikari.HikariDataSource;

public class UserDaoIntTest {

	private AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
	}

	
	@Test
	public void testSave() {
		UserDao userDao = context.getBean(UserDao.class);
		userDao.save(mockUser());
	}

	@Test
	public void testFind() {
		UserDao userDao = context.getBean(UserDao.class);

		String usernameToTest = "järgmineKasutaja";
		String roleToTest = "järgmineKasutaja";
		
		User user = mockUser();
		user.setUsername(usernameToTest);
		user.setRole(roleToTest);
		
		userDao.findByUsername(usernameToTest);
		userDao.findByUsernameAndRole(usernameToTest, roleToTest);
	}
	
//	@Test
//	public void testFindByQuery() {
//		UserDao userDao = context.getBean(UserDao.class);
//		
//		String fnameToTest = "NextOne";
//		User user = mockUser();
//		user.setFname(fnameToTest);
//		
//		userDao.findByFname(fnameToTest);
//	}

	@Test
	public void testDelete() {
		UserDao userDao = context.getBean(UserDao.class);

		String usernameToTest = "nextOneUser";
		
		User user = mockUser();
		user.setUsername(usernameToTest);
		userDao.save(user);

//		userDao.deleteById(userDao.findAll().get(0).getId());
		userDao.deleteByUsername(usernameToTest);
	}

	
	
	
	@After
	public void endTest() {
		HikariDataSource ds = (HikariDataSource) context.getBean(DataSource.class);
		ds.close();
		context.close();
	}

	private User mockUser() {

		User mockUser = new User();
		mockUser.setFname("Next");
		mockUser.setLname("User");
		mockUser.setUsername("nextUser");
		mockUser.setPassword("tere");
		mockUser.setEmail("next@user.com");
		mockUser.setRole("kasutaja");

		return mockUser;
	}

}
