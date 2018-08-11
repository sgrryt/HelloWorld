package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Book extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();

		HttpSession session2=request.getSession();
		int bookID=Integer.parseInt(request.getParameter("bookId"));
		System.out.println("this is bookID" +bookID);
		
		if(session2!=null){ 
			
			 session2.setAttribute("BookID", bookID);
			request.getRequestDispatcher("Book.jsp").forward(request, response);
		}

		else {
			out.print("Please login first"); 
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		out.close();

	}

}
