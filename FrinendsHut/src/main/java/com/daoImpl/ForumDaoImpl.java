package com.daoImpl;

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
import com.dao.ForumDao;
import com.model.Blog;
import com.model.Forum;

@Repository("ForumDao")
public class ForumDaoImpl implements ForumDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Forum> getForums() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Forum> query = session.createQuery("FROM Forum");
		List<Forum> forumList = query.list();
		session.getTransaction().commit();
		return forumList;
	}

	public Forum getForum(int forumId)
	{
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Forum forum = session.get(Forum.class, forumId);
		session.getTransaction().commit();
		return forum;
	}

	public boolean insertForum(Forum forum) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.save(forum);
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

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.saveOrUpdate(forum);
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

	public boolean DeleteForum(Forum forum) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.delete(forum);
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

}
