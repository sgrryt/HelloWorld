package com.servlet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDao {

	public static Connection getConnection(){  
		Connection con=null;  
		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databasename=demo;integratedSecurity=true;";
			con = DriverManager.getConnection(connectionUrl);  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	}  

	public static ArrayList<Emp> getAllEmployees(){  
		ArrayList<Emp> list=new ArrayList<Emp>();  

		try{  			
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from Userinfo");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Emp e=new Emp();  
				e.setFirstname(rs.getString(1));  
				e.setLastname(rs.getString(2)); 
				list.add(e);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	} 	

}
