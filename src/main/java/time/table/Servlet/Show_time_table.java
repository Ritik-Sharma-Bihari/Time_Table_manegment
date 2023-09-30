package time.table.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import time.table.entities.User;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Servlet implementation class Show_time_table
 */
@WebServlet("/Show_time_table")
public class Show_time_table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		   String name = null;
		   PrintWriter out=response.getWriter();
		   
		    out.print("good boy");
		    
		    HttpSession session=request.getSession(false);
		    User user=(User)session.getAttribute("currentUser");
	          
	          if(user == null)
	          {
	        	  response.sendRedirect("login.jsp");
	          }
	          else
	          {
	        	  
	          }
	           name=user.getName();
	          int id=user.getId();
	          String password=user.getPassword();
	          
	              String jdbcUrl = "jdbc:mysql://localhost:3306/college";
	              String dbUsername = "root";
	              String dbPassword = "Ritiksharma620@";
	              Connection conn = null;
	              
	              

	              try {
	                  Class.forName("com.mysql.cj.jdbc.Driver");
	                  conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
	                //  String selectSQL = "SELECT faculty_ID, subject_ID,course_ID,course_name,year,section,day,start_time,end_time FROM admin_faculty_time_allocate";
	                String selectSQL = "SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day,start_time,end_time FROM admin_faculty_time_allocate where faculty_ID="+id;
	                  Statement statement = conn.createStatement();
	                  ResultSet resultSet = statement.executeQuery(selectSQL);

	                  while (resultSet.next()) {
	                      int faculty_id = resultSet.getInt("faculty_ID");
	                      int subject_id = resultSet.getInt("subject_ID");
	                      String course_id = resultSet.getString("course_ID");
	                      String course_name = resultSet.getString("course_name");
	                      String year = resultSet.getString("year");
	                      String section = resultSet.getString("section");
	                      String day = resultSet.getString("day");
	                      Time start_time = resultSet.getTime("start_time");
	                      Time end_time = resultSet.getTime("end_time");
	                      
	                     System.out.println("data types of start_time and end_time ="+(Object)start_time.getClass().getSimpleName());
	                      /*
	                       * here it will recive the time type data.. which is sql type
	                       */
	                    

	                      // Assume you have received a java.sql.Time object from the database
	                      Time sqlTime =  start_time;      /* your received java.sql.Time object */;

	                      int hours = sqlTime.getHours();
	                      @SuppressWarnings("deprecation")
						int minutes = sqlTime.getMinutes();
	                      @SuppressWarnings("deprecation")
						int seconds = sqlTime.getSeconds();
	                      
	                      LocalTime localTime = LocalTime.of( minutes, seconds);

	                      
	                      // Convert it to java.time.LocalTime
	                   //   LocalTime localTime = sqlTime.toLocalTime();

	                      System.out.println("data types of start_time and end_time ="+(Object)localTime.getClass().getSimpleName()); 
	                      
	                   //   System.out.println("value of start_time and end_time ="+localTime); 
	                      /*
	                       * it will recive the java time
	                       */
	                      
	                      
	                      out.println("<html>");
	                      out.println("<body>");
	                      out.println("<table border='1'>");
	                      out.println("<tr>");
	                      out.println("<td>"+id);
	                      out.println("</td>");
	                      out.println("<td>"+subject_id);
	                      out.println("</td>");
	                      out.println("<td>"+course_id);
	                      out.println("</td>");
	                      out.println("<td>"+course_name);
	                      out.println("</td>");
	                      out.println("<td>"+year);
	                      out.println("</td>");
	                      out.println("<td>"+section);
	                      out.println("</td>");
	                      out.println("<td>"+day);
	                      out.println("</td>");
	                   
	                      out.println("<td>"+start_time);
	                      out.println("</td>");
	                      
	                      out.println("<td>"+end_time);
	                      out.println("</td>");
	                      
	                      
	                      out.println("</tr>");
	                      out.println("</table>");
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      
	                      out.println("<html>");
	                      out.println("<body>");
	                     
	                     
	          
	                  }
	              } catch (Exception e) {
	                  e.printStackTrace();
	              } finally {
	                  if (conn != null) {
	                      try {
	                          conn.close();
	                      } catch (SQLException e) {
	                          e.printStackTrace();
	                      }
	                  }
	              }
	          


		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
