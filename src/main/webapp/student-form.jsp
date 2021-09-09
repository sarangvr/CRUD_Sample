<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Student Management App</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/student" class="navbar-brand"> Student Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/student" class="nav-link">Student</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${student != null}">
                        
                  <form action="update" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                   <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${student != null}">
                                    Edit Student Details
                                </c:if>
                                <c:if test="${student == null}">
                                    Add New Student
                                </c:if>
                            </h2>
                        </caption>
                        <fieldset class="form-group">
                            <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                       	</fieldset>

                        
                        
                        <fieldset class="form-group">
                            <label>Student Name</label> <input type="text" value="<c:out value='${student.studentName}' />" class="form-control" name="studentName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Year OF Join</label> <input type="text" value="<c:out value='${student.yearOfJoin}' />" class="form-control" name="yearOfJoin" required="required">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>