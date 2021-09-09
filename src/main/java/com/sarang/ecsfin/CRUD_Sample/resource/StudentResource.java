package com.sarang.ecsfin.CRUD_Sample.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sarang.ecsfin.CRUD_Sample.model.Student;
import com.sarang.ecsfin.CRUD_Sample.service.StudentService;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class StudentResource {
	StudentService studentService = new StudentService();
	
	@GET
	public List<Student> getStudentList(){
		return studentService.getAllStudents();
	}
	
	@POST
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
//		return "Post Works";
	}
	
	@PUT
	@Path("/{studentId}")
	public Student updateStudent(@PathParam("studentId")long id, Student student) {
		student.setId(id);
		return studentService.updateStudent(student);
	}
	
	@DELETE
	@Path("/{studentId}")
	public void deleteMessage(@PathParam("studentId")long id) {
		studentService.removeStudent(id);
	}
	

}
