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
	
	<p>
		<a href='Logout'>Logout</a>
	</p>
	<h1 align="center">Employees List</h1>
	<table border='1' width='100%' align="center">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Price (Rs)</th>
		</tr>
		<%
			List<Emp> list = EmpDao.getAllEmployees();
			for (Emp e : list) {
				out.print("<tr><td>" + e.getBookId() + "</td><td><a href=Book.jsp?bookId="+e.getBookId() +">"+e.getBoook_Name()+"</a></td><td>" + e.getAuthor() + "</td><td>" + e.getPrice() + "</td></tr>");
				
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
