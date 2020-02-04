package com.ht.core.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ht.core.beans.UserDto;
import com.ht.core.config.HtCoreConfig;
import com.ht.core.dao.UserDao;
import com.ht.core.model.User;
import com.ht.core.service.UserService;

public class ApplicationDemo {

	public static void main(String[] args) {

		demoDaoImplUpdateById(10);
//		demoDaoImplFindById();
//		demoDaoImplDeleteById();
		demoDaoImplCreate();

	}

	private static void demoDaoImplCreate() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
		UserDao userDao = context.getBean(UserDao.class);

		// 1) Create UserDto
		User mockUser = new User();
		mockUser.setFname("Järgmine");
		mockUser.setLname("Kasutaja");
		mockUser.setUsername("järgmineKasutaja");
		mockUser.setPassword("tere");
		mockUser.setEmail("järgmine@kasutaja.com");
//		mockUser.setRole("kasutaja");

		userDao.save(mockUser);

	}

	private static void demoDaoImplFindById() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
		User user = userDao.findUserById(1L);
		System.out.println();
		System.out.println("Found: " + user.toString());
	}

	private static void demoDaoImplDeleteById() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
		userDao.deleteUser(9L);

	}

	private static void demoDaoImplUpdateById(long id) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HtCoreConfig.class);
		UserDao userDao = context.getBean(UserDao.class);

		User mockUser = userDao.findUserById(id);
		mockUser.setId(2L);
		mockUser.setFname("Hei");
		mockUser.setLname("Hoi");
		mockUser.setUsername("Heihoi");
		mockUser.setPassword("tere");
		mockUser.setEmail("hei@hoi.com");
		mockUser.setRole("heihoi");

		userDao.updateUser(mockUser);

	}

}
