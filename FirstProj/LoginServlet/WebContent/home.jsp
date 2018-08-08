<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
p.padding {
	padding-left: 8cm;
}

p.padding2 {
	padding-right: 20%;
}
</style>
</head>

<body bgcolor="fadf7f">
	<h1>Employees List</h1>
	<p class="padding">
		<a href='Logout'>Logout</a>
	</p>
	<table border='1' width='100%'>
		<tr>
			<th>LastName</th>
			<th>firstName</th>
		</tr>
		<%
			List<Emp> list = EmpDao.getAllEmployees();
			for (Emp e : list) {
				out.print("<tr><td>" + e.getFirstname() + "</td><td>" + e.getLastname() + "</td></tr>");
				
		%>
		<tr>
			<td>
				<%
					}//out.print("</table>");
				%>
			
	</table>

</body>
</html>

<%@ page import="com.servlet.*"%>
<%@ page import="java.util.List"%>
