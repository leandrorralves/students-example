package com.students.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 10)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Team clone() {
		final Team clone = new Team();
		
		clone.name = name;
		
		return clone;
	}
}
