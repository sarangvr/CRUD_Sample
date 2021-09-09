package com.sarang.ecsfin.CRUD_Sample.database;

import java.util.HashMap;
import java.util.Map;

import com.sarang.ecsfin.CRUD_Sample.model.Student;


public class DatabaseClass {
	private static Map<Long, Student> studentList=new HashMap<>();
	
	public static Map<Long, Student> getStudentList() {
		return studentList;
	}

}
