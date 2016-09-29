package com.arif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column
	private String studentName;
	
	@Column
	private String studentSurname;
	
	@Column
	private int yearLevel;
	
	
	public Student() {
		
	}
	
	
	public Student(int studentId, String studentName, String studentSurname, int yearLevel) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.yearLevel = yearLevel;
	}

	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

}
