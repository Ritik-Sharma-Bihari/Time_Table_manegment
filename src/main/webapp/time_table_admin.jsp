<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="java.util.HashMap, java.util.Map" %>
<%@page import="time.table.entities.Message_class" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <%@page import="time.table.entities.User" %> 
    <%@page import="time.table.dao.Faculty_timeTable_Dao" %> 
   

 <%
          User user=(User)session.getAttribute("currentUser");
          
          if(user == null)
          {
        	  response.sendRedirect("login.jsp");
          }
          else
          {
        	  
          }
          
      
       
          
          %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</head>
<body>
    <h2>Faculty Schedule</h2>

    <% 
   
        String jdbcUrl = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Ritiksharma620@";
        int facultyId = user.getId();
        int count=0;
     // Replace with the faculty ID you want to retrieve data for.

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
        	String query = "SELECT day, start_time, end_time, course_name, subject_ID ,course_ID,year,section " +
                    "FROM admin_faculty_time_allocate " +
                    "WHERE faculty_ID = ? " +
                    "ORDER BY day, start_time";

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
                        String course_id = resultSet.getString("course_ID");
                        String year = resultSet.getString("year");
                        String section = resultSet.getString("section");

                        // Check if we already have a schedule entry for this day.
                        if (!scheduleMap.containsKey(day)) {
                            scheduleMap.put(day, "");
                        }

                        // Append course information to the schedule entry for this day.
                         String scheduleEntry = "<tr> <td> </td>  <td>" + startTime + "</td><td>" + endTime + "</td><td>"
                               + courseName + "</td><td>" + course_id + "</td> <td>" + subjectId + "</td>  <td>" 
                        		 + year + "</td> <td>" + section + "</td>  </tr>";
                      // scheduleMap.put(day, scheduleMap.get(day) + scheduleEntry);
                        		count=count+1;
                        scheduleMap.put(day, scheduleMap.get(day) + scheduleEntry);
                        
                    }

                    // Generate HTML table.
                    %>
                    
                    <table border="1">
                        <tr>
                            <th>TIMING</th>
                            <th>Start Time</th>
                            <th>End Time</th>
                            <th>Course Name</th>
                            <th>Course ID</th>
                            <th>Subject ID</th>
                            <th>year</th>
                            <th>Section</th>
                        </tr>
                        <%
                            for (String day : scheduleMap.keySet()) {
                        %>
                           <tr>
                           <td>DAY:</td>
                            <td class="text-center" colspan="<%=count %>"><%= day %></td>
                            </tr>
                            
                                    
                            <%= scheduleMap.get(day)%> 
                            
                           
                        
                        <%
                            }
                        %>
                    </table>
                    <%
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
