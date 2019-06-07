package com.news.model;

import java.util.Date;

public class News {

	private Integer NewsID;
	private Integer UserID;
	private Integer TypeID;
	private String NewsContent;
	private Date NewsTime;
	private String NewsTitle;
	private String NewsImg;
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
	public Integer getTypeID() {
		return TypeID;
	}
	public void setTypeID(Integer typeID) {
		TypeID = typeID;
	}
	public String getNewsContent() {
		return NewsContent;
	}
	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}
	public Date getNewsTime() {
		return NewsTime;
	}
	public void setNewsTime(Date newsTime) {
		NewsTime = newsTime;
	}
	public String getNewsTitle() {
		return NewsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}
	public String getNewsImg() {
		return NewsImg;
	}
	public void setNewsImg(String newsImg) {
		NewsImg = newsImg;
	}
	

}
