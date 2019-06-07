package com.news.model;

import java.util.List;

//用户实体类
public class User {
	private Integer UserID;
	private String  UserPassword;
	private String UserName;
	private String UserSex;
	private String UserPhone;
	private Integer IsOnline;
	private String IsReader;
	private List<News> allnews;
	


public List<News> getAllnews() {
		return allnews;
	}

	public void setAllnews(List<News> allnews) {
		this.allnews = allnews;
	}

	//创建方法
	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserSex() {
		return UserSex;
	}

	public void setUserSex(String userSex) {
		UserSex = userSex;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public Integer getIsOnline() {
		return IsOnline;
	}

	public void setIsOnline(Integer isOnline) {
		IsOnline = isOnline;
	}

	public String getIsReader() {
		return IsReader;
	}

	public void setIsReader(String isReader) {
		IsReader = isReader;
	}
	

}
