package com.dao;

import java.util.List;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.*;

public interface ForumDao {
	

	public List<Forum> getForums();
	public Forum getForum(int forumId);
	public boolean insertForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean DeleteForum(Forum forum);

}
