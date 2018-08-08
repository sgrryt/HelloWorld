package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Forgotpass extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get user mailid/userid and new password
		String u=req.getParameter("updateuser");
		String p=req.getParameter("updatepass");

		//make connection to DB
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		out.println("<body bgcolor='grey>'");
		out.println("this is username1="+u+"" );
		out.println("this is password1="+p+"</body>");

		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;		

		// connect db with userid and update password

		//if user match, update msg with Login page
		//else invalid details with Register page
		try {
			String username="";
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			//Connection String
			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databasename=demo;integratedSecurity=true;";
			con = DriverManager.getConnection(connectionUrl);
			stmt=con.createStatement();
			String SQL3="select username from Users where username='"+ u+"'";
			out.println();
			rs=stmt.executeQuery(SQL3);

			while(rs.next()) {
				username=rs.getString(1);				
			}

			if(username.equals(u)) {				
				String SQL = "update Users set password =? where username =?";
				PreparedStatement pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, p);
				pstmt.setString(2, u);
				int j = pstmt.executeUpdate();
				out.println("\n Password updated succesfully.. ");				
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				HttpSession hs=req.getSession();
				hs.setAttribute("uname",	username);
				rd.include(req, resp);
				rs.close();
			}else {				
				out.println("\n"+u+": User does not exist..");
				HttpSession session=req.getSession();				
				RequestDispatcher rd=req.getRequestDispatcher("forgotPW.jsp");
				rd.include(req, resp);
			}
			out.println("<br>\n</br>");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		out.close();
	}

}
