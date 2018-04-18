<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Course</title>
</head>
<body>

<h1>Create a new Course</h1>

    
	<form:form method="post" action="/courses/new" modelAttribute="course">
		
		<form:label path="name">Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label><br>
		
		<form:label path="instructor">Instructor:
			<form:errors path="instructor"></form:errors>
			<form:input path="instructor"></form:input>
		</form:label><br>
		
		<form:label path="maxPeople">Limit:
			<form:errors path="maxPeople"></form:errors>
			<form:input type="number" path="maxPeople"></form:input>
		</form:label><br>

		<input type ="submit" value="Create Event"><br>
	</form:form><br>
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	
	
</body>
</html>