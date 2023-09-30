<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <%@ page import="java.sql.*, java.util.*" %>
    <%@page import="time.table.entities.Message_class" %>
    <%@ page import="java.sql.*, java.util.* ,java.time.LocalTime" %>
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
          
          
        <!DOCTYPE html>
        <html>

        <head>
            <!-- this is css bootstrap -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
                crossorigin="anonymous" />
            <!-- this is font icon awensome -->
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link href="css/NewFile.css" rel="stylesheet" type="text/css">

            <!-- from here we are using the clip path for that following link -->
            <style type="text/css">
                .banaer_image {
                    width: 140px;
                    height: 70px;
                }

                #menuitem1,
                #menuitem2,
                #menuitem3,
                #menuitem4,
                #menuitem5,
                #menuitem6 {
                    font-family: "Roboto";
                }

                .all-container-card {

                    height: 100vh;
                    background-image: radial-gradient(#2196f3, #f44336);
                    background-size: cover;
                }



                
            </style>


        </head>



        <body>

            <div class="all-container-card">

                <div class="container ">

                    <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="#">
                <img class="banaer_image" src="https://www.effe.in/img/customer-logos/vignan.jpg" />
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav mr-auto">
           <!--     <a class="nav-link" id="menuitem1" href="course_admin.jsp">Course <span class="sr-only">(current)</span></a>
                    <a class="nav-link" id="menuitem2" href="syllabus_admin.jsp">Subject</a>
                    
                  
                    <a class="nav-link" id="menuitem4" href="show_jsp.jsp">Time-Table</a>
                    <a class="nav-link" id="menuitem4" href="Show_baba_show">Time-Table</a>
              -->
                    <a class="nav-link" id="menuitem4" href="time_table_admin.jsp">Time-Table</a>
                    <a class="nav-link" id="menuitem5" href="#">Update-Info </a>

                </div>
                
                <div class="navbar-nav ml-auto">
                    
                  <a class="nav-link" id="menuitem5" href="#">  <span class="fa fa-user-o"></span> <%= user.getName() %>  </a>
                  <a class="nav-link" id="menuitem5" href="#">  <span class="fa fa-user-o"></span> <%= user.getId() %>  </a>
                  
                    <a class="nav-link" id="menuitem5" href="LogOutServlet">LogOut </a>

                </div>
            </div>
        </nav>
                </div>
                
                
                
                
                
                
                
                <!-- body part  -->
           
           
           
           <body>
    <h1>Time Data</h1>
    <table border="1">
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
                String selectSQL = "SELECT subject_ID,course_ID,course_name,year,section,day,start_time,end_time FROM admin_faculty_time_allocate where faculty_ID ="+id;
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSQL);

                while (resultSet.next()) {
                 //   int faculty_id = resultSet.getInt("faculty_ID");
                    int subject_id = resultSet.getInt("subject_ID");
                    String course_id = resultSet.getString("course_ID");
                    String course_name = resultSet.getString("course_name");
                    String year = resultSet.getString("year");
                    String section = resultSet.getString("section");
                    String day = resultSet.getString("day");
                    Time start_time = resultSet.getTime("start_time");
                    Time end_time = resultSet.getTime("end_time");
                    
                    
                   
                   
                   
                    
        %>
        
        <%
        
        LocalTime javaTime = start_time.toLocalTime();
      
        %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= subject_id %></td>
                        <td><%= course_id %></td>
                        <td><%= course_name %></td>                    
                     
                        <td><%= section %></td>
                        <td><%= year %></td>
                         <td><%=day %></td>
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

        

            <!-- java script bootstrap libraries -->
            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
                crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
                integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
                crossorigin="anonymous"></script>
            <script src="js/myjs.js" type="text/javascript"></script>
            <!-- this is for sweet cdn link -->
            <script src="js/myjs.js" type="text/javascript"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

        </body>

        </html>