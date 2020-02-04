package com.ht.core.dao;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.ht.core.model.User;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoHibernateCMT implements UserDao {
	
	@PersistenceContext
    private Session session;

	@Override
	public void save(User user) {
		session.save(user);
	}

	@Override
	public User findUserById(long id) {
		return session.get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		session.update(user);
		
	}

	@Override
	public void deleteUser(long id) {
		User user = session.get(User.class,id);
		session.delete(user);
		
	}

}
