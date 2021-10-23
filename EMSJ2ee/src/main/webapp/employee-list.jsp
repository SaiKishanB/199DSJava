<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	${NOTIFICATION}
	<table border="1">
		<tr>
			<th>Emp Number</th>
			<th>Emp Name</th>
			<th>Department</th>
			<th colspan="2">Action</th>
		</tr>	
		<c:forEach var="emp" items="${allemp}">
		<tr>
			<td><c:out value="${emp.empno}"></c:out></td>
			<td><c:out value="${emp.ename}"></c:out></td>
			<td><c:out value="${emp.dept}"></c:out></td>
			<td><a href="">EDIT</a></td>
			<td><a href="${pageContext.request.contextPath}/EC?action=DELETE&eid=${emp.empno}">DELETE</a></td>
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>