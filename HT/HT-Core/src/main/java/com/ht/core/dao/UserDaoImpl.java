//package com.ht.core.dao;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.ht.core.beans.UserDto;
//import com.ht.core.dao.helpers.UserRowMapper;
//import com.ht.core.model.User;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Repository
//public class UserDaoImpl implements UserDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	private UserRowMapper userRowMapper;
//	
//	@Override
//	public void save(User newModelUser) {
//		
//		Object[] data =new Object[6];
//		data[0]=newModelUser.getFname();
//		data[1]=newModelUser.getLname();
//		data[2]=newModelUser.getUsername();
//		data[3]=newModelUser.getPassword();
//		data[4]=newModelUser.getEmail();
//		data[5]=newModelUser.getRole();
//		
//		jdbcTemplate.update("INSERT INTO `user` ( `fname`, `lname`, `username`, `password`, `email`, `role`) VALUES(?,?,?,?,?,?)", data);	
//		
//	}
//
//	
//	@Override
//	public User findUserById (long id) {
//		
//		String sql="SELECT * FROM USER WHERE ID=?";
//		Object[] inputForQuery =new Object[1];
//		inputForQuery[0]=new Long(id);
//		return jdbcTemplate.queryForObject(sql, inputForQuery, userRowMapper);	
//	
//	}
//
//	
//	@Override
//	public void deleteUser(long id) {
//		String sql="DELETE FROM USER WHERE ID=?";
//		Object[] inputForSql =new Object[1];
//		inputForSql[0]=new Long(id);
//		jdbcTemplate.update(sql, inputForSql);
//	}
//	
//	
//	@Override
//	public void updateUser(User user) {
//		
//		
//		String sql="UPDATE USER SET "
//				+ "fname=?, "
//				+ "lname=?, "
//				+ "username=?, "
//				+ "password=?, "
//				+ "email=?, "
//				+ "role=? "
//				+ "WHERE id=?";
//				
//		
//		
//		Object[] data =new Object[7];
//		data[0]=user.getFname();
//		data[1]=user.getLname();
//		data[2]=user.getUsername();
//		data[3]=user.getPassword();
//		data[4]=user.getEmail();
//		data[5]=user.getRole();
//		data[6]=user.getId();
//		
//		
//		
//		int changed =jdbcTemplate.update(sql, data);
//		System.out.println("Updated "+changed+" lines");
//		
//		//throw new UnsupportedOperationException("updateUser is not yet implemented");
//		/*
//		UPDATE Customers
//		SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//		WHERE CustomerID = 1;
//		
//		*/
//		
//		
//		
//		/*
//		Connection conn = null;
//		User user = null;
//		
//		try {
//			conn = datasource.getConnection();
//			Statement cmd = conn.createStatement();
//			String sql = "UPDATE `user` set `fname`, `lname`, `username`, `password`, `email`, `role` where `id=?` VALUES(" 
//					+ "'" + user.getFname() 	+ "', " 
//					+ "'" + user.getLname() 	+ "', "
//					+ "'" + user.getUsername() 	+ "', "
//					+ "'" + user.getPassword() 	+ "', "
//					+ "'" + user.getEmail() 	+ "', "
//					+ "'" + user.getRole() 		+ "') ";
//
//			
//			int rowsUpdated = cmd.executeUpdate(sql);
//			log.info("User {} updated in DB ", user.toString());
//		} catch (Exception e) {
//			System.err.println("Impossible to connect to Database");
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//					log.info("connection closed");
//				} catch (Exception e) {
//					 }
//			}
//		}
//		*/
//		
//	}
//	
//	
//	
//
//
//
//}
