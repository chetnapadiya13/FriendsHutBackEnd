package com.test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.*;
import com.daoImpl.*;
import com.model.User;
import java.sql.Date; 
public class TestUser {

		static UserDao userDao;
		
		@Before
		public void setup()
		{
			userDao=new UserDaoImpl();
		}
		@After
		public void teardown()
		{
			userDao=null;
		}
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com");
			annotationConfigAppContext.refresh();
			
			userDao=(UserDao)annotationConfigAppContext.getBean("userDao");
		}
		@Ignore
		@Test
		public void testadduser()
		{
			User user=new User();
			user.setFirstName("chetana");
			user.setLastName("padiya");
			user.setEmail("c@cn.com");
			user.setPassword("123");
			user.setRole("ROLE_ADMIN");
			user.setSsoId("c@cn.com");
			user.setGender("female");
			String str="1989-10-13";  
			Date date=Date.valueOf(str);
			user.setDob(date);
			user.setAddress("mumbai");
			assertTrue("Problem in Adding user",userDao.addUser(user));
			
		}
	/*	@Ignore
		@Test
		public void testgetalluser()
		{
			List<User> listUser=userDao.getAllUsers();
			assertTrue("Problem in Adding user",);
			for(User user:listUser)
			{
				System.out.println("User Id:"+user.getId());
				System.out.println("User Email :"+user.getEmail());
				System.out.println("User Name :"+user.getFirstName());
				System.out.println("User password :"+user.getPassword());
				
				
			}
			
		}*/
	/*	@Ignore
		@Test
		public void testgetuser()
		{
			String email="c@cn.com";
			List<User> listuser=(List<User>) userDao.getUser(email);
			assertNotNull("Problem in Listing user",listuser);
			this.testgetalluser(listuser);
		}*/
		
		@Ignore
		@Test
		public void testupdateuser()
		{
			User user=new User();
			user.setFirstName("chetana");
			user.setLastName("padiya");
			user.setEmail("c@cn.com");
			user.setPassword("123");
			user.setRole("ROLE_ADMIN");
			user.setSsoId("c@cn.com");
			user.setGender("female");
			String str="1989-10-13";  
			Date date=Date.valueOf(str);
			user.setDob(date);
			user.setAddress("mumbai");
			assertTrue("Problem in updating user",userDao.updateUser(user));
			
		}
		@Ignore
		@Test
		public void testdeleteuser()
		{
			User user=new User();
			user.setFirstName("chetana");
			user.setLastName("padiya");
			user.setEmail("c@cn.com");
			user.setPassword("123");
			user.setRole("ROLE_ADMIN");
			user.setSsoId("c@cn.com");
			user.setGender("female");
			String str="1989-10-13";  
			Date date=Date.valueOf(str);
			user.setDob(date);
			user.setAddress("mumbai");
			
			assertTrue("Problem in deleting user",userDao.deleteUser(user));
			
		}
		

}