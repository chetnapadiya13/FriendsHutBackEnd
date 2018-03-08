package com.app;
import com.model.*;
import com.dao.*;
import com.daoImpl.*;
public class App {
	public static void main(String args[])
	{
		BlogDao blogDao=new BlogDaoImpl();
		Blog blog=new Blog();
		blog.setBlogName("foodfood");
		blog.setBlogContent("recipe of panner tikka.....");
		blog.setStatus("valid");
		blog.setUserName("chetana");
		//blog.setCreatedDate("12-feb-18");
		blogDao.insertBlog(blog);
	}
}
