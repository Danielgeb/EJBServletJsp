<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.data.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

	<h1 align='center'>Department " ${deptId} "</h1>
	<table border='1' align='center'>
		<th>ID</th>
		<th>NAME</th>
		<th>SALARY</th>
		<c:forEach var="e" items="${empList}">
			<tr>
				<td>${e.id} + "</td>
				<td>${e.name}</td>
				<td>${e.salary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
