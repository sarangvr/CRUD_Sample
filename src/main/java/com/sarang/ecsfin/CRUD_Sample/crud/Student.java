package com.sarang.ecsfin.CRUD_Sample.crud;

import java.util.Objects;

public class Student {
	private int id;
	private String studentName;
	private int yearOfJoin;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getYearOfJoin() {
		return yearOfJoin;
	}
	public void setYearOfJoin(int yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}
	
	public Student() {
	}
	
	public Student(int id) {
		this.id = id;
	}
	
	public Student(int id, String studentName, int yearOfJoin) {
		this.id = id;
		this.studentName = studentName;
		this.yearOfJoin = yearOfJoin;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, studentName, yearOfJoin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(studentName, other.studentName) && yearOfJoin == other.yearOfJoin;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", yearOfJoin=" + yearOfJoin + "]";
	}

}
