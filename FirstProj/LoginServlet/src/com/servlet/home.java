package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class home extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();

		HttpSession session2=request.getSession();
		
		if(session2!=null){ 
			
			String n1=(String) session2.getAttribute("uname");
			out.println("session n2="+n1);
			out.print("<html><head bgcolor=\"ffd133\"><style>p.padding {    padding-left:8cm;}p.padding2 {    padding-right:20%;}</style></head><body>");
			out.print("<p>Welcome "+n1+"</p>");
 
			out.println("<p class=\"padding\"><a href='Logout'>Logout</a></p>");  
			out.println("<h1>Employees List</h1>");  

			List<Emp> list=EmpDao.getAllEmployees();  

			out.print("<table border='1' width='100%'");  
			out.print("<tr><th>Lastname</th><th>FirstName</th></tr>");  
			for(Emp e:list){  
				out.print("<tr><td>"+e.getFirstname()+"</td><td>"+e.getLastname()+"</td></tr>");  
			}  
			out.print("</table>"); 
		}

		else {
			out.print("Please login first"); 
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		out.close();

	}

}
