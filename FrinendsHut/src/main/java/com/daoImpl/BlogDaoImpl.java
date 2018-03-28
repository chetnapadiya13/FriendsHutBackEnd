package com.daoImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.configer.HibernateConfig;
import com.dao.BlogDao;
import com.model.Blog;
import com.model.BlogComment;

@Repository("BlogDao")
public class BlogDaoImpl implements BlogDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Blog> query = session.createQuery("FROM Blog");
		List<Blog> blogList = query.list();
		session.getTransaction().commit();
		return blogList;
	}
	@Transactional
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Blog blog = session.get(Blog.class, blogId);
		session.getTransaction().commit();
		return blog;
	}
	@Transactional
	public boolean insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.save(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.saveOrUpdate(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.delete(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	public boolean approveBlog(Blog blog) {
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			blog.setStatus("Approved");
			session.beginTransaction();
		    session.saveOrUpdate(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	public boolean rejectBlog(Blog blog) {
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			blog.setStatus("Reject");
			session.beginTransaction();
		    session.saveOrUpdate(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	public List<Blog> listBlog(String userName) {
		 
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Blog> blogList = (List<Blog>) session.get(Blog.class, userName);
		session.getTransaction().commit();
		return blogList;
	}
	@Transactional
	public boolean incrementLike(Blog blog) {
	
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			int likes = blog.getBlikes();
			likes++;
			blog.setBlikes(likes);
			session.beginTransaction();
		    session.saveOrUpdate(blog);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
		
	}
	public boolean addBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}
	public BlogComment getBlogComment(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<BlogComment> listBlogComments(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}
}
















