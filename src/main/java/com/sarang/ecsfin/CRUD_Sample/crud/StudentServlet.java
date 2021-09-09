package com.sarang.ecsfin.CRUD_Sample.crud;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static DbDAO dao;

	public void init() {
		dao = DbDAO.getInstance();
	}

	public StudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside doGet");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
				listAllStudents(request, response);
				break;
			}
		} catch (Exception exception) {
			throw new ServletException(exception);
		}
	}

	private void listAllStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> studentList = dao.listAll();
		request.setAttribute("studentList", studentList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");

		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = dao.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);

		System.out.println(id);

		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In showNewForm");
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("studentName"));
		System.out.println(request.getParameter("yearOfJoin"));
		int id = Integer.parseInt(request.getParameter("id"));

		String studentName = request.getParameter("studentName");
		int yearOfJoin = Integer.parseInt(request.getParameter("yearOfJoin"));
		System.out.println("float");

		Student student = new Student(id, studentName, yearOfJoin);
		System.out.println(student.toString());
		dao.update(student);

		response.sendRedirect("student");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(id);
		response.sendRedirect("menu");

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

//			int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("test");
		String studentName = (String) request.getParameter("studentName");
		int yearOfJoin = Integer.parseInt(request.getParameter("yearOfJoin"));

//			System.out.println("Inside insertStudent");
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("studentName"));
//			System.out.println(request.getParameter("yearOfJoin"));
		System.out.println("test");
		System.out.println(studentName + yearOfJoin);
		dao.insert(studentName, yearOfJoin);

//			System.out.println("Outside catch");
		response.sendRedirect("student");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
