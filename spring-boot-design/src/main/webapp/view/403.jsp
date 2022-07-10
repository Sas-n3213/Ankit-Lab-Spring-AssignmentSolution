<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>
	<h2>${msg}</h2>
	
	<br><br>
	
	<div style="float: left">
		<button><a href="${pageContext.request.contextPath}/student/list" style="text-decoration: none">Back to Students List</a></button>
	</div>
	
</body>
</html>