package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BlogCommentDao;
import com.model.BlogComment;

@Repository("BlogCommentDao")
public class BlogCommentDaoImpl implements BlogCommentDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public BlogComment getBlogComment(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<BlogComment> listBlogComments(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}
}
