<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
<script src="script.js"></script>
</head>
<body >
	<div class="grandParentContaniner">
		<div class="parentContainer">
			<h1 >- Book Details -</h1>
			<%			
			int bid= Integer.parseInt(request.getParameter("bookId"));
			Emp e1=EmpDao.getEmployee(bid);
			out.println("<h3>BookName : "+e1.getBoook_Name()+"</h3>");
			out.println("<h3>Author : "+e1.getAuthor()+"</h3>");
			out.println("<h3>Price : "+e1.getPrice()+"</h3>");
			
			%>			
			<a href="home.jsp">Back To Book Store</a><br>
			<a href='Logout'>Logout</a><br>
		</div>
	</div>
</body>
</html>

<%@ page import="com.servlet.*"%>
<%@ page import="java.util.List"%>