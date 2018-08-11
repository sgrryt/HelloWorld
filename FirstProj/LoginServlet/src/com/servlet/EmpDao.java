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
			PreparedStatement ps=con.prepareStatement("select * from Books");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Emp e=new Emp();  
				e.setBookId(rs.getString(1));  
				e.setBoook_Name(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setPrice(rs.getString(4));
				list.add(e);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}
	
	public static Emp getEmployee(int bid){  
		Emp emp=new Emp();  

		try{  			
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from Books where Book_Id ="+bid);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Emp e1=new Emp();  
				e1.setBookId(rs.getString(1));  
				e1.setBoook_Name(rs.getString(2));
				e1.setAuthor(rs.getString(3));
				e1.setPrice(rs.getString(4));
				emp=e1;
			}  
			con.close();
			
		}catch(Exception e){e.printStackTrace();}  
		finally {
			
		}
		
		return emp;  
	}
	

}
