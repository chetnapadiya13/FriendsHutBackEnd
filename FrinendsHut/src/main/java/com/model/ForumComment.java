package com.model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class ForumComment{
	@Id 
	@Column(name = "ForumCommentId")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "forum_comment_ID_SEQ")
	private int ForumCommentId;
	private int fcLike;
	
	
	
	public int getFcLike() {
		return fcLike;
	}

	public void setFcLike(int fcLike) {
		this.fcLike = fcLike;
	}

	@Column(name="forumComment")
	private String forumComment;
	
	//relational mapping required 
	@Column(name="userName")
	private String userName;
	
	//manytomany relation mapping required
	@Column(name="forumid")
	private int forumId;

	public int getForumCommentId() {
		return ForumCommentId;
	}

	public void setForumCommentId(int forumCommentId) {
		ForumCommentId = forumCommentId;
	}

	public String getForumComment() {
		return forumComment;
	}

	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	
}
