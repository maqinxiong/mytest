package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.domin.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public User findById(int id) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		User user = sqlsession.selectOne("findById",1);
		sqlsession.close();
		return user;
	}

	@Override
	public List<User> findByUserName(String username) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		List<User> list = sqlsession.selectList("findByUsername","张");
		sqlsession.close();
		return list;
	}

}
