<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is Hibernate Application</title>
<link rel="stylesheet" href="style.css" />
<script src="script.js"></script>
</head>
<body bgcolor="ff5733">
	<div class="grandParentContaniner">
		<div class="parentContainer">
			<form bgcolor="ff5733" action="Login" method="post">
				<h2 class="form-signin">Please sign in</h2>
				<label>Enter Username : </label> <input type="text" name="user"><br>
				<label>Enter Password :</label> <input type="password" name="pass"><br>
				<input type="submit" name="submit" value="Login"><br>
				<hr>
			</form>
			<a href="register.jsp">Register</a><br> <a href="forgotPW.jsp">Forgot
				Password</a><br>
		</div>
	</div>

</body>
</html>