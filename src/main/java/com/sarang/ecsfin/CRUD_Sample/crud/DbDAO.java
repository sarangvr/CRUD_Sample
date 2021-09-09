package com.sarang.ecsfin.CRUD_Sample.crud;

import java.util.ArrayList; 
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbDAO {
	
	private static DbDAO instance;
	 
	private static MongoDatabase db = ConnectToDB.getDb();
	private static MongoCollection<Student> collection = db.getCollection("student", Student.class);
	private Document query;
	
	
	private DbDAO() {
	}
	
	public static DbDAO getInstance()  {
		if (instance == null)
			instance = new DbDAO();
		
		return instance;
	}
	
	public List<Student> listAll() {
		ArrayList<Student> studentList = collection.find().into(new ArrayList<Student>());
		return new ArrayList<Student>(studentList);
		
	}
	
	public int add(Student student) {
		int newId = (int) collection.count() + 1;
		student.setId(newId);
		
		collection.insertOne(student);
		
		return newId;
	}
	
	public Student get(int id) {
		query = new Document("_id", id);		
		Student student = collection.find(query).first();
		return student;
	}
	
	public Student update(Student student) {
		query = new Document("_id", student.getId());
		Student studentData = collection.findOneAndReplace(query, student);
		return studentData;
	}
	
	public Student delete(int id) {
		query = new Document("_id", id);
		Student student = collection.findOneAndDelete(query);
		System.out.println(student.toString());
		return student;
	}
	
	public int insert(String studentName,int yearOfJoin) {
		int newId = (int) collection.count() + 1;
		Student student = new Student(newId, studentName, yearOfJoin);
		System.out.println(student.toString());
		collection.insertOne(student);
		
		return newId;
	}

	
	

}
