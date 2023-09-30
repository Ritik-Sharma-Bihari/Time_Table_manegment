package time.table.create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Table_create_faculty_admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String url="jdbc:mysql://localhost:3306/college";
			String user="root";
			String password="Ritiksharma620@";
		//	String sql_query="CREATE TABLE admin_facultycreate (id INTEGER NOT NULL,name VARCHAR(30), date_join date)";
			String sql_query2="insert into admin_facultycreate values(?,?,?,?,?,?)";

		/*	
			Connection con=DriverManager.getConnection(url, user, password);
			Statement sc=con.createStatement();		
			sc.executeUpdate(sql_query);
			System.out.println("table created with date");   */
		
			/*
		 * to create the date type filed in the mysql is simple 
		 * but to insert date type data into mysql in some difficult
		 * and to display the date data in also simple
		 * 
		 * to insert the date data type we need to follow following steps..
		 * 
		 * step-1 convert the given string into util date format.
		 * 
		 * ex-- System.out.println("enter date of join");
			    String dob=ss.next();
			    
		 *  to convert string into util date format..
		 *   PreparedStatement ps=con.prepareStatement(sql_query2);
		 *       SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	     	     java.util.Date udate=sdf.parse(dob);
		 *  
		 * 	step--2 to convert util date to sql date 
		 * 
		 * ex--  long l=udate.getTime();
		         java.sql.Date sdate=new java.sql.Date(l);
		         
		         //set the date
		         //ps.setDate(index_number, java.sql.Date);
		          
		          ps.setDate(index_number, sdate);
		        ps.executeUpdate();
		 */
			
	
			Connection con=DriverManager.getConnection(url, user, password);	
		PreparedStatement ps=con.prepareStatement(sql_query2);
			Scanner ss=new Scanner(System.in);
			System.out.println("enter id");
			int id=ss.nextInt();
			
			System.out.println("enter name");
			String name=ss.next();
			
			System.out.println("enter email");
			String email=ss.next();
			
			System.out.println("enter password");
			String password1=ss.next();
			
			System.out.println("enter gender");
			String gender=ss.next();
			
			System.out.println("enter date of join");
			String dob=ss.next();
	
			
			/* to convert string into util date formate
			 * 
			 */
     	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date udate=sdf.parse(dob);
		
		// to convert util date to sql date 
		
		long l=udate.getTime();
		java.sql.Date sdate=new java.sql.Date(l);
		
		//set the date
		//ps.setDate(3, java.sql.Date);
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4,password1);
		
		ps.setString(5, gender);
		
		ps.setDate(6, sdate);
		ps.executeUpdate();
		
		System.out.println("date inserted");
			
		}
		catch(Exception e)
		{
			System.out.println("exection on date :"+e);
		}


	}




}
