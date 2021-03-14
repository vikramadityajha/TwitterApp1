package com.tweetapp;

public class Tweet {

	private Integer tweetId;
	private String messages;
	private String email;
	private String createAt;
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public Tweet(Integer tweetId, String messages, String email, String createAt) {
		super();
		this.tweetId = tweetId;
		this.messages = messages;
		this.email = email;
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", messages=" + messages + ", email=" + email + ", createAt=" + createAt
				+ "]";
	}
	public Tweet() {
		super();
	}

	
}
