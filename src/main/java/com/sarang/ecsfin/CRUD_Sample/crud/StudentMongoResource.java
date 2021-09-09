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

@Path("mongo/student")
public class StudentMongoResource {

	private DbDAO dao = DbDAO.getInstance();

//	@GET
//	@Path("echo/{message}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String testMsg(@PathParam("message") String message) {
//		return message;
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(Student student) {
		int studentId = dao.add(student);
		return Integer.toString(studentId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> list() {
		return dao.listAll();		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Student student = dao.get(id);
		if (student != null) {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Student student) {
		student.setId(id);
		Student student1 = dao.update(student);
		if (student1 == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
		}
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		Student student = dao.delete(id);
//		if (dao.delete(id))
//			return Response.ok().build();
//		else
//			return Response.status(Response.Status.NOT_FOUND).build();
		if (student == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		else
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
	}

}
