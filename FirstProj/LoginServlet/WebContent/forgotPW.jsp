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
			<form action="ForgotPassword" method="post">
			<h2 class="form-signin" >Forgot Password</h2>
				Enter Username : <input type="text" name="updateuser"><br>
				Enter Password : <input type="password" name="updatepass"><br>
				<input type="submit" name="submit" value="Update"><br>
				<hr>
			</form>
			<a  href="register.jsp">Register</a><br> <a href="login.jsp">Login</a><br>
		</div>
	</div>
</body>
</html>