package com.sarang.ecsfin.CRUD_Sample.service;

import com.sarang.ecsfin.CRUD_Sample.database.DatabaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.sarang.ecsfin.CRUD_Sample.model.Student;

public class StudentService {
	
	static Map<Long, Student> studentList=DatabaseClass.getStudentList();
	
	public StudentService() {
		studentList.put(1L, new Student((long) 100,"John Wick",2012));
		studentList.put(2L, new Student((long) 101,"Stephen Spilberg",2012));
		studentList.put(3L, new Student((long) 102,"Martin Scorse",2020));
		studentList.put(4L, new Student((long) 103,"Quintin Tarantino",2020));
	}
	
	public List<Student> getAllStudents(){
		return new ArrayList<Student>(studentList.values());
	}
	
	

	public Student addStudent(Student student) {
		student.setId((long) (studentList.size() + 1));
		studentList.put(student.getId(),student);
		return student;
	}
	
	public Student updateStudent(Student student) {
		if(student.getId() <=0) {
			return null;
		}
		studentList.put(student.getId(), student);
		return student;
	}
	
	

	public Student removeStudent(long id) {
		return studentList.remove(id);
	}

}
