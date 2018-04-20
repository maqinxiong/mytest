package com.itheima.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.domin.User;

public class MyBatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void createSqlSessionFacatory()throws Exception{
		//读取配置文件
		InputStream i = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建sqlSessionFactoryBuilder
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(i);
		
	}
	
	@Test
	public void findById() throws Exception{
		//创建sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//查询单个记录
		User user = session.selectOne("findById",1);
		
		System.out.println(user);
		
		session.close();
	}
	
	@Test
	public void findByUsername() throws Exception{
		//创建sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//查询单个记录
		List<User> list = session.selectList("findByUsername","张");
		
		System.out.println(list);
		session.close();
	}
	
	@Test
	public void inser() throws Exception{
		//创建sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//添加
		User user = new User();
		user.setUsername("熊三");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("大唐");
		session.insert("inser",user);
		
		session.commit();
	}
	
	@Test
	public void deleteById() throws Exception{
		//创建sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		session.delete("deleteById",26);
		
		session.commit();
	}
	
	
	@Test
	public void updateById() throws Exception{
		//创建sqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(16);
		user.setUsername("孙悟空");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("花果山");
		
		session.update("update",user);
		
		session.commit();
	}
	
}
