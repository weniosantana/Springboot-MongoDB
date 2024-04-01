package com.springmongo.springbootmongodb.domain;

import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private String author;
	
	
	public PostDTO() {
	}

	public PostDTO(Post obj) {
		super();
		this.id = obj.getId();
		this.date = obj.getDate();
		this.title = obj.getTitle();
		this.body = obj.getBody();
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
