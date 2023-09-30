<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

 <%@page import="time.table.entities.Message_class" %>
    
    <%@page import="time.table.entities.User" %> 
   
   
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
<html>
<head>


    <title>Display Time Data</title>
</head>
<body>
    <h1>Time Data</h1>
    <table border="1" >
        <tr>
            <th> Name</th>
            <th> Time</th>
        </tr>
        <%
        
        String name=user.getName();
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
              String selectSQL = "SELECT subject_ID,course_ID,course_name,year,section,day,start_time,end_time FROM admin_faculty_time_allocate where faculty_ID="+id;
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSQL);

                while (resultSet.next()) {
                  //  int faculty_id = resultSet.getInt("faculty_ID");
                    int subject_id = resultSet.getInt("subject_ID");
                    String course_id = resultSet.getString("course_ID");
                    String course_name = resultSet.getString("course_name");
                    String year = resultSet.getString("year");
                    String section = resultSet.getString("section");
                    String day = resultSet.getString("day");
                    Time start_time = resultSet.getTime("start_time");
                    Time end_time = resultSet.getTime("end_time");
                    
                    
                   
                   
                   
                    
        %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= subject_id %></td>
                        <td><%= course_id %></td>
                        <td><%= course_name %></td>                    
                      <td><%= day %></td> 
                        <td><%= section %></td>
                        <td><%= year %></td>
                        <td><%=start_time %>
                        <%=end_time %>
                    </tr>
        <%
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
        %>
    </table>
    
   
                
        
</body>
</html>
