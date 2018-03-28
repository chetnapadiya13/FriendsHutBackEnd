package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.configer.HibernateConfig;
import com.dao.JobDao;
import com.model.Blog;
import com.model.Job;


@Repository("JobDao")
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Job> getJobss() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Job> query = session.createQuery("FROM Job");
		List<Job> jobList = query.list();
		session.getTransaction().commit();
		return jobList;
	}
	@Transactional
	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Job job = session.get(Job.class, jobId);
		session.getTransaction().commit();
		return job;
	
	}
	@Transactional
	public boolean insertJob(Job job) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.save(job);
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
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.saveOrUpdate(job);
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
	public boolean deleteJob(Job job) {
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.delete(job);
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
	public boolean applyJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

}
