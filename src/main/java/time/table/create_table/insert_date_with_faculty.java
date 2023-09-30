package time.table.create_table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert_date_with_faculty
 */
@WebServlet("/insert_date_with_faculty")
public class insert_date_with_faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		
		
		
		
		try {
			String url="jdbc:mysql://localhost:3306/college";
			String user="root";
			String password="Ritiksharma620@";
		//	String sql_query="CREATE TABLE admin_facultycreate (id INTEGER NOT NULL,name VARCHAR(30), date_join date)";
			String sql_query2="insert into admin_facultycreate values(?,?,?,?,?,?)";
			
			
			int id=Integer.parseInt(request.getParameter("faculty_id"));
        	String name=request.getParameter("faculty_name");
        	String email=request.getParameter("faculty_email");
        	String password1=request.getParameter("faculty_password");
        	String gender=request.getParameter("gender");
        	String dob=request.getParameter("faculty_join_date");
			
			

			Connection con=DriverManager.getConnection(url, user, password);	
		PreparedStatement ps=con.prepareStatement(sql_query2);
		//	Scanner ss=new Scanner(System.in);
			
			
			/* to convert string into util date formate
			 * 
			 */
  /*   	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date udate=sdf.parse(dob);
		
		// to convert util date to sql date 
		
		long l=udate.getTime();
		java.sql.Date sdate=new java.sql.Date(l);
		
		//set the date
		//ps.setDate(3, java.sql.Date);                 */
        	
        	
        	
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4,password1);
		
		ps.setString(5, gender);
		
		// Creating a date for birthdate
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = dateFormat.parse(dob);
        ps.setDate(6, new java.sql.Date(birthdate.getTime()));
        
		ps.executeUpdate();
		
		System.out.println("date inserted");
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/display_data.jsp");
		
		rd.forward(request, response);
			
		}
		
		
		
		catch(Exception e)
		{
			System.out.println("exection on date :"+e);
			out.print(false);
		}
		


	}

	

}
