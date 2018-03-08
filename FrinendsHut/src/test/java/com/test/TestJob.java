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

import com.dao.ForumDao;
import com.dao.JobDao;
import com.daoImpl.ForumDaoImpl;
import com.daoImpl.JobDaoImpl;
import com.model.Blog;
import com.model.Forum;
import com.model.Job;
import com.model.User;


public class TestJob {
	
	static JobDao jobDao;
	public void setup()
	{
		jobDao=new JobDaoImpl();
	}
	@After
	public void teardown()
	{
		jobDao=null;
	}
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com");
		annotationConfigAppContext.refresh();
		
		jobDao=(JobDao)annotationConfigAppContext.getBean("jobDao");
	}
	
	@Ignore
	@Test
	public void testJobAdd()
	{
		Job job=new Job();
		User user=new User();
		user.setEmail("c@cn.com");
		job.setJobTitle("tech");
		job.setLocations("mumbai");
		job.setUser(user);
		job.setCurrentCTC(2.3);
		job.setExp("2 years");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		job.setPubdate(date);
		job.setBasicPay(8000);
		job.setJobDescription("it job");
		
		
		assertTrue("Problem in Adding user",jobDao.insertJob(job));
		
	}
	@Ignore
	@Test
	public void testJobUpdate()
	{
		Job job=new Job();
		User user=new User();
		user.setEmail("c@cn.com");
		job.setJobTitle("tech");
		job.setLocations("mumbai");
		job.setUser(user);
		job.setCurrentCTC(2.3);
		job.setExp("2 years");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		job.setPubdate(date);
		job.setBasicPay(8000);
		job.setJobDescription("it job");
		
		
		assertTrue("Problem in Adding user",jobDao.updateJob(job));
		
	}
	
	@Ignore
	@Test
	public void testJobdelete()
	{
		Job job=new Job();
		User user=new User();
		user.setEmail("c@cn.com");
		job.setJobTitle("tech");
		job.setLocations("mumbai");
		job.setUser(user);
		job.setCurrentCTC(2.3);
		job.setExp("2 years");
		String str="1989-10-13";  
		Date date=Date.valueOf(str);
		job.setPubdate(date);
		job.setBasicPay(8000);
		job.setJobDescription("it job");
		
		
		assertTrue("Problem in Adding user",jobDao.deleteJob(job));
		
	}
	@Ignore
	@Test
	public void findjob()
	{
		Job job=new Job();
		job=jobDao.getJob(1);
		if (job==null)
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
	public void ListAlljob()
	{
		List<Job> jobList=jobDao.getJobss();
		if (jobList==null)
		{
		assertTrue("Problem in Adding user",false);
		}
		else
		{
			assertTrue("Problem in Adding user",true);
		}
	}
	

}
