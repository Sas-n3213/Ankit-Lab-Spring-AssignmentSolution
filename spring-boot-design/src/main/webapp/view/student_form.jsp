<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<center>
	<form action="${pageContext.request.contextPath}/student/save" method="POST">
	
		<input type="hidden" name="studentId" value="${Student.studentId}"><br>
		<input type="text" name="firstName" value="${Student.firstName}"
			placeholder="First Name"><br><br>
			 <input type="text"	name="lastName" value="${Student.lastName}"
			placeholder="Last Name"><br><br>
			<input type="text" name="course" value="${Student.course}" placeholder="course"><br><br>
			<input type="text" name="country" value="${Student.country}" placeholder="country"><br><br>
		<input type="submit" value="save">

	</form>
	<br><br>
	
	<div style="float: left">
		<button><a href="${pageContext.request.contextPath}/student/list" style="text-decoration: none">Back to Students List</a></button>
	</div>

</center>
</body>
</html>