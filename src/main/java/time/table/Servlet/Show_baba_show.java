package time.table.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import time.table.entities.User;
/**
 * Servlet implementation class Show_baba_show
 */
@WebServlet("/Show_baba_show")
public class Show_baba_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/college";
    private static final String username = "root";
    private static final String password = "Ritiksharma620@";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int facultyId = 199;
        System.out.println(facultyId);
       //  String password=user.getPassword();
	
	 response.setContentType("text/html");
       PrintWriter out = response.getWriter();

        // Replace with the faculty ID you want to retrieve data for.

       try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
           String query = "SELECT day, start_time, end_time, course_name, subject_ID " +
                          "FROM admin_faculty_time_allocate " +
                          "WHERE faculty_ID = ? " +
                          "ORDER BY day, start_time";
           
          // SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day,start_time,end_time FROM admin_faculty_time_allocate where faculty_ID="+id;

           try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
               preparedStatement.setInt(1, facultyId);
               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   Map<String, String> scheduleMap = new HashMap<>();

                   while (resultSet.next()) {
                       String day = resultSet.getString("day");
                       String startTime = resultSet.getString("start_time");
                       String endTime = resultSet.getString("end_time");
                       String courseName = resultSet.getString("course_name");
                       int subjectId = resultSet.getInt("subject_ID");

                       // Check if we already have a schedule entry for this day.
                       if (!scheduleMap.containsKey(day)) {
                           scheduleMap.put(day, "");
                       }

                       // Append course information to the schedule entry for this day.
                       String scheduleEntry = "<tr><td>" + startTime + "</td><td>" + endTime + "</td><td>"
                               + courseName + "</td><td>" + subjectId + "</td></tr>";
                       scheduleMap.put(day, scheduleMap.get(day) + scheduleEntry);
                   }

                   // Generate HTML response.
                   out.println("<html><head><title>Faculty Schedule</title></head><body>");
                   out.println("<h2>Faculty Schedule</h2>");
                   out.println("<table border='1'><tr><th>Day</th><th>Start Time</th><th>End Time</th><th>Course Name</th><th>Subject ID</th></tr>");

                   for (String day : scheduleMap.keySet()) {
                       out.println("<tr><td>" + day + "</td>" + scheduleMap.get(day) + "</tr>");
                   }

                   out.println("</table>");
                   out.println("</body></html>");
               }
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		

		 HttpSession session=request.getSession(false);
		    User user=(User)session.getAttribute("currentUser");
	          
	          if(user == null)
	          {
	        	  response.sendRedirect("login.jsp");
	          }
	          else
	          {
	        	  
	          }
	         String  name=user.getName();
	}

}
