package com.sarang.ecsfin.CRUD_Sample.crud;

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
import javax.ws.rs.core.Response;

@Path("student")
public class StudentResource {
	private StudentDAO dao = StudentDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> list() {
		return dao.listAll();
	}
	
	@GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Student student = dao.get(id);
		if (student != null) {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student add(Student student) {
		int newStudentId = dao.add(student);
		return dao.get(newStudentId);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") int id, Student student) {
		student.setId(id);
		if (dao.updateStudent(student)) {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response delete(@PathParam("id") int id) {
		if (dao.removeStudent(id)) {
			return Response.ok(id, MediaType.TEXT_PLAIN).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	

}
