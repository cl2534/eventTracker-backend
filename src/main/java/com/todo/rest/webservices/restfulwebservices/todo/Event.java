package com.todo.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Event {
	private long id;
	private String username;
	private String description;
	private Date targetDate;

	
	protected Event() {
		
	}
	
	
	public Event(long id, String username, String description, Date targetDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getDescription() {
		return description;
	}
	public Date getTargetDate() {
		return targetDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
