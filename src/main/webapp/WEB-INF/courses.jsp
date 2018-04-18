<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome, ${currentUser.username }</h1><br>

<h3>Courses</h3>
		<table border="1">
	
		<tr>
			<th>Name</th>
			<th>Instructor</th>
			<th>Limit</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${courses}" var="course">
			<tr>
				<td>${course.name }</td>
				<td>${course.instructor }</td>
				<td>${course.maxPeople }</td>
				<td><a href="/courses/${course.id}/add">Add</a></td>
				
			</tr>
		</c:forEach>

	</table><br>
	<a href="/courses/new"><button type="button">Add a New Course</button></a><br><br>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>


</body>
</html>