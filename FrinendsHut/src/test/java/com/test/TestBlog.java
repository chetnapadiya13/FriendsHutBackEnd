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
import com.dao.UserDao;
import com.daoImpl.BlogDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.model.Blog;
import com.model.User;
public class TestBlog {

	static BlogDao blogDao;
	
	@Before
	public void setup()
	{
		blogDao=new BlogDaoImpl();
	}
	@After
	public void teardown()
	{
		blogDao=null;
	}
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com");
		annotationConfigAppContext.refresh();
		
		blogDao=(BlogDao)annotationConfigAppContext.getBean("blogDao");
	}
	@Ignore
	@Test
	public void testaddblog()
	{
		Blog blog=new Blog();
		blog.setBlogName("foodfood");
		blog.setBlogContent("recipe panner tika");
		blog.setStatus("valid");
		blog.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		blog.setCreatedDate(date);
		
		assertTrue("Problem in Adding user",blogDao.insertBlog(blog));
		
	}
	@Ignore
	@Test
	public void updateblog()
	{
		Blog blog=new Blog();
		blog.setBlogName("foodfood");
		blog.setBlogContent("recipe panner tika");
		blog.setStatus("valid");
		blog.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		blog.setCreatedDate(date);
		
		assertTrue("Problem in Adding user",blogDao.updateBlog(blog));
		
	}
	
	@Ignore
	@Test
	public void deleteblog()
	{
		Blog blog=new Blog();
		blog.setBlogName("foodfood");
		blog.setBlogContent("recipe panner tika");
		blog.setStatus("valid");
		blog.setUserName("c@cn.com");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		blog.setCreatedDate(date);
		assertTrue("Problem in Adding user",blogDao.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void findblog()
	{
		Blog blog=new Blog();
		blog=blogDao.getBlog(1);
		if (blog==null)
		{
		assertTrue("Problem in Adding user",false);
		}
		else
		{
			assertTrue("Problem in Adding user",true);
		}
	}
	@Ignore
	@Test
	public void ListAllBlog()
	{
		List<Blog> blogList=blogDao.getBlogs();
		if (blogList==null)
		{
		assertTrue("Problem in Adding user",false);
		}
		else
		{
			assertTrue("Problem in Adding user",true);
		}
	}
	
	
}
