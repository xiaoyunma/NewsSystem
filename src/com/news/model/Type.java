package com.news.model;

import java.util.List;

public class Type {

	private int id;
	private String typename;
	private List<News> allnews;

	public List<News> getAllnews() {
		return allnews;
	}

	public void setAllnews(List<News> allnews) {
		this.allnews = allnews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
