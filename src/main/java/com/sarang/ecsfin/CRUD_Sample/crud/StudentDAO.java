package com.sarang.ecsfin.CRUD_Sample.crud;

import java.util.ArrayList; 
import java.util.List;

public class StudentDAO {
	
	private static StudentDAO instance;
	private static List<Student> studentList = new ArrayList<>();
	
	static {
		studentList.add(new Student(100,"John Wick",2012));
		studentList.add(new Student(101,"Stephen Spilberg",2012));
	}
	
	private StudentDAO() {
	}
	
	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		
		return instance;
	}
	
	public List<Student> listAll() {
		return new ArrayList<Student>(studentList);
	}
	
	public int add(Student student) {
		int newId = studentList.size() + 1;
		student.setId(newId);
		studentList.add(student);
		
		return newId;
	}
	
	public Student get(int id) {
		Student studentToFind = new Student(id);
		int index = studentList.indexOf(studentToFind);
		if (index >= 0) {
			return studentList.get(index);
		}
		return null;
	}
	
	public boolean updateStudent(Student student) {
		int index = studentList.indexOf(student);
		if (index >= 0) {
			studentList.set(index, student);
			return true;
		}
		return false;
	}
	
	public boolean removeStudent(int id) {
		Student studentToFind = new Student(id);
		int index = studentList.indexOf(studentToFind);
		if (index >= 0) {
			studentList.remove(index);
			return true;
		}
		return false;
	}


}
