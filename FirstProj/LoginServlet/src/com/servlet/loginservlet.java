package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=req.getParameter("user").trim();
		String p=req.getParameter("pass").trim();

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		String username=null;
		String password=null;


		try {

			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 

			//Connection String
			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databasename=demo;integratedSecurity=true;";
			con = DriverManager.getConnection(connectionUrl); 

			stmt=con.createStatement();

			String SQL3="select username, password from Users where username="+"'"+u+"'";
			//out.println(SQL3);
			out.println();
			rs=stmt.executeQuery(SQL3);


			while(rs.next()) {
				username=rs.getString(1).trim();
				password=rs.getString(2).trim();
				System.out.println(username);
				System.out.println(password);
			}

			if(username == null && password == null )
			{
				out.println("<center>\n<font color=\"red\">Invalid Username Or Password... </font></center>");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
			else {
				if(username.equals(u) && password.equals(p)) {

					RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
					HttpSession hs=req.getSession();
					hs.setAttribute("uname", username);	
					rd.forward(req, resp);

				}else {
					//out.println("Authenication Failed");
					out.println("<center>\n<font color=\"red\">Invalid Username Or Password... </font></center>");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.include(req, resp);
					
				}

			}

			out.println("<br>\n</br>");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		out.close();

	}
}
