package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter outL=resp.getWriter();
		HttpSession session=req.getSession();
		session.invalidate();
//		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
//		rd.include(req, resp);
		resp.sendRedirect("login.jsp");
		outL.println("You have succussfully Logged Out..");
		outL.close();
		
	}

}
