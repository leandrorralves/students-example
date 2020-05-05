package com.students.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 100, nullable = false)
	private String name;

	@Id
	@Column(length = 40)
	private String email;

	@Column(name = "birth_date")
	private Date birthDate;

	@OneToOne
	@JoinColumn(name = "team", referencedColumnName = "name")
	private Team team;

	@Column(nullable = false)
	private double income;

	@Column(nullable = false)
	private double photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {

		this.birthDate = birthDate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getPhoto() {
		return photo;
	}

	public void setPhoto(double photo) {
		this.photo = photo;
	}

	public Student clone() {
		final Student clone = new Student();

		clone.name = name;
		clone.email = email;
		clone.birthDate = birthDate;
		clone.team = team;
		clone.income = income;
		clone.photo = photo;

		return clone;
	}
}
