package com.dao;

import java.util.List;

import com.model.BlogComment;

public interface BlogCommentDao {
	
	public boolean addBlogComment(BlogComment blogComment);
    public boolean deleteBlogComment(BlogComment blogComment);
    public BlogComment getBlogComment(int commentId);
    public List<BlogComment> listBlogComments(int blogid);
}
