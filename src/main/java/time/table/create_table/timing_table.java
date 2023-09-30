package time.table.create_table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class timing_table
 */
@WebServlet("/timing_table")
public class timing_table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
        response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		
		
		
		
		try {
			String url="jdbc:mysql://localhost:3306/project_time_table";
			String user="root";
			String password="Ritiksharma620@";
		//	String sql_query="CREATE TABLE admin_facultycreate (id INTEGER NOT NULL,name VARCHAR(30), date_join date)";
			String sql_query2="insert into admin_faculty_allocate(faculty_ID, subject_ID,course_ID,course_name,year,section,start_time,end_time) values(?,?,?,?,?,?,?,?)";
			
			
			String operation=request.getParameter("admin_faculty_operation_timing");
	    	/*
	    	 * convert string to int type
	    	 */
	    	int faculty_id=Integer.parseInt(request.getParameter("faculty_id_timing"));
	    	String subject_id=request.getParameter("subject_id_timing");
	    	String course_id=request.getParameter("course_id_timing");
	    	String course_name=request.getParameter("course_name");
	    	String year=request.getParameter("course_year");
	    	String session=request.getParameter("section");
	    	String start_time=request.getParameter("faculty_start_timing");
	    	String end_time=request.getParameter("faculty_end_timing");
	    	
	    	
	    //	System.out.println("data types of start_time and end_time ="+(Object)start_time.getClass().getSimpleName());	
			

			Connection con=DriverManager.getConnection(url, user, password);	
		PreparedStatement ps=con.prepareStatement(sql_query2);
		
        	
		ps.setInt(1, faculty_id);
		ps.setString(2, subject_id);
		ps.setString(3, course_id);
		ps.setString(4,course_name);
		
		ps.setString(5, year);
        ps.setString(6,session);
		
		ps.setString(7, start_time);
		ps.setString(8, end_time);
		
		// Creating a date for birthdate
	/*	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = dateFormat.parse(dob);
        ps.setDate(6, new java.sql.Date(birthdate.getTime()));
        
        
        */
		
		ps.executeUpdate();
		
		System.out.println("date inserted");
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/display_Simple_time.jsp");
		
		rd.forward(request, response);
			
		}
		
		
		
		catch(Exception e)
		{
			System.out.println("exection on date :"+e);
			out.print(false);
		}
		
		
	}

}
