package com.dao;

import java.util.List;

import com.model.Job;

public interface JobDao {
	

	public List<Job> getJobss();
	public Job getJob(int jobId);
	public boolean insertJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(Job job);
	public boolean applyJob(Job job);
	//public List<ApplyJob> getAllAppliedJobDetails();
	// public List<ApplyJob> getAllAppliedJobDetails();

}
