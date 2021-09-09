<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

  <head>
      <title>Student Management</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>

  <body>

      <header>
          <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
               <div>
                   <a href="<%=request.getContextPath()%>/student" class="navbar-brand"> Student management App </a>
					
               </div>

               <ul class="navbar-nav">
                   <li><a href="<%=request.getContextPath()%>/student" class="nav-link">Student</a></li>
              </ul>
          </nav>
      </header>
      <br>

      <div class="row">
          <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

          <div class="container">
              <h3 class="text-center">Student</h3>
              <hr>
              <div class="container text-left">

                  <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Student</a>
               </div>
               <br>
               <table class="table table-bordered">
                   <thead>
                       <tr>
                           <th>Student ID</th>
                           <th>Student Name</th>
                           <th>Year Of Join</th>
                       </tr>
                   </thead>
                   <tbody>
                       <!--   for (Todo todo: todos) {  -->
                      <c:forEach var="student" items="${studentList}">

                          <tr>
                              <td>
                                  <c:out value="${student.id}" />
                              </td>
                              <td>
                                  <c:out value="${student.studentName}" />
                              </td>
                              <td>
                                  <c:out value="${student.yearOfJoin}" />
                              </td>
                              <td><a href="edit?id=<c:out value='${student.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
                          </tr>
                      </c:forEach>
                      <!-- } -->
                  </tbody>

              </table>
          </div>
      </div>
  </body>
</html>