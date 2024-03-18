package com.springmongo.springbootmongodb.domain;

import java.util.Date;

public class CommentDTO {

	private String id;
	private String text;
	private Date date;
	
	public CommentDTO() {
	}

	
	
	public CommentDTO(Comment obj) {
		this.id = obj.getId();
		this.text = obj.getText();
		this.date = obj.getDate();
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
