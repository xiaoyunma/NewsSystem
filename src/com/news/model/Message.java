package com.news.model;

import java.util.Date;

public class Message {

	private Integer MsgID;
	private Integer NewsID;
	private Integer UserID;
	private Date MsgTime;
	private String MsgContent;
	public Integer getMsgID() {
		return MsgID;
	}
	public void setMsgID(Integer msgID) {
		MsgID = msgID;
	}
	public Integer getNewsID() {
		return NewsID;
	}
	public void setNewsID(Integer newsID) {
		NewsID = newsID;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Date getMsgTime() {
		return MsgTime;
	}
	public void setMsgTime(Date msgTime) {
		MsgTime = msgTime;
	}
	public String getMsgContent() {
		return MsgContent;
	}
	public void setMsgContent(String msgContent) {
		MsgContent = msgContent;
	}
	
}
