package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import com.itheima.domin.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;
	
	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		userDao = new UserDaoImpl(sqlSessionFactory);
	}

	@Test
	public void testFindById() {
		User user =  userDao.findById(1);
		System.out.println(user);
	}

	@Test
	public void testFindByUserName() {
		List<User> list =  userDao.findByUserName("张");
		System.out.println(list);
	}

}
