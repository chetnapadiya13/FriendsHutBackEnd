package com.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class BlogComment {
	
	
	@Id 
	@Column(name = "BlogCommentId")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "blog_comment_ID_SEQ")
	private int BlogCommentId;
	
	@Column(name="blogComment")
	private String blogComment;
	
	//relational mapping required 
	@Column(name="userName")
	private String userName;
	
	//manytomany relation mapping required
	@Column(name="blogid")
	private int blogId;

	public int getBlogCommentId() {
		return BlogCommentId;
	}

	public void setBlogCommentId(int blogCommentId) {
		BlogCommentId = blogCommentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}	

}
