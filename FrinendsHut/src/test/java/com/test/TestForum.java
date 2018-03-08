package com.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.BlogDao;
import com.dao.ForumDao;
import com.daoImpl.BlogDaoImpl;
import com.daoImpl.ForumDaoImpl;
import com.model.Blog;
import com.model.Forum;

public class TestForum {
static ForumDao forumDao;
	
	@Before
	public void setup()
	{
		forumDao=new ForumDaoImpl();
	}
	@After
	public void teardown()
	{
		forumDao=null;
	}
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com");
		annotationConfigAppContext.refresh();
		
		forumDao=(ForumDao)annotationConfigAppContext.getBean("forumDao");
	}
	@Ignore
	@Test
	public void testaddforum()
	{
		Forum forum=new Forum();
		forum.setForumName("test");
		forum.setForumContent("testcontent");
		forum.setStatus("valid");
		forum.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		forum.setCreatedDate(date);
		
		assertTrue("Problem in Adding user",forumDao.insertForum(forum));
		
	}
	@Ignore
	@Test
	public void testupdateforum()
	{
		Forum forum=new Forum();
		forum.setForumName("test");
		forum.setForumContent("testcontent");
		forum.setStatus("valid");
		forum.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		forum.setCreatedDate(date);
		
		assertTrue("Problem in Adding user",forumDao.updateForum(forum));
		
	}
	@Ignore
	@Test
	public void testdeleteforum()
	{
		Forum forum=new Forum();
		forum.setForumName("test");
		forum.setForumContent("testcontent");
		forum.setStatus("valid");
		forum.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		forum.setCreatedDate(date);
		
		assertTrue("Problem in Adding user",forumDao.DeleteForum(forum));
		
	}
	@Ignore
	@Test
	public void findforum()
	{
		Forum forum=new Forum();
		forum=forumDao.getForum(1);
		if (forum==null)
		{
		assertTrue("Problem in Adding user",false);
		}
		else
		{
			assertTrue("Problem in Adding user",true);
		}
	}
	

}
