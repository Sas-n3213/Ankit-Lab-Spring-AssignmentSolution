<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp" />



	<center>
		<h3>Students List</h3>
		<table border="1" cellspacing="5" cellpadding="10">
			<thead>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Course</th>
				<th>Country</th>
				<th>Action</th>
			</thead>
			<jstlc:forEach var="student" items="${Students}">
				<tr>
					<td>${student.studentId}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.course}</td>
					<td>${student.country}</td>
					<td>
						<button>
							<a href="${pageContext.request.contextPath}/student/edit?studentId=${student.studentId}"
								style="text-decoration: none">Edit</a>
						</button> |
						<button>
							<a href="${pageContext.request.contextPath}/student/delete?studentId=${student.studentId}"
								style="text-decoration: none">Delete</a>
						</button>
					</td>
				</tr>
			</jstlc:forEach>
		</table>
	</center>

</body>
</html>