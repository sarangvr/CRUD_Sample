package com.sarang.ecsfin.CRUD_Sample.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Student {
	private Long id;
	private String studentName;
	private int yearOfJoin;
	
	public Student() {
		super();
	}
	
	public Student(Long id, String studentName, int yearOfJoin) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.yearOfJoin = yearOfJoin;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	
	
//	List<Student> student=new ArrayList<>();
	
	
	
}
