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

	public boolean approveBlog(Blog blog);

	public boolean rejectBlog(Blog blog);

	public List<Blog> listBlog(String userName);

	public boolean incrementLike(Blog blog);

	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public BlogComment getBlogComment(int commentId);

	public List<BlogComment> listBlogComments(int blogid);

}
