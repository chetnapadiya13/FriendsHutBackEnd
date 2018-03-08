package com.dao;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.*;

public interface BlogDao {
	
		public List<Blog> getBlogs();
		public Blog getBlog(int blogId);
		public boolean insertBlog(Blog blog);
		public boolean updateBlog(Blog blog);
		public boolean deleteBlog(Blog blog);
		
		
		
}
