<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>welcome to Admin page  </title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<!-- this is font icon awensome --> 
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link href="css/NewFile.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" href="admin_page.css">



</head>
<body>

<div class="main-container-admin">


<!-- this is header part of body -->
<nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="#">
                <img class="banaer_image" src="https://www.effe.in/img/customer-logos/vignan.jpg" />
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav mr-auto">
                    <a class="nav-link" id="menuitem1" href="course_admin.jsp">Course <span class="sr-only">(current)</span></a>
                    <a class="nav-link" id="menuitem2" href="syllabus_admin.jsp">subject</a>
                    <a class="nav-link" id="menuitem3" href="Faculty_admin.jsp">Faculty</a>
                    <a class="nav-link" id="menuitem3" href="faculty_allocate_time.jsp">set_time_table</a>     
                    <a class="nav-link" id="menuitem4" href="time_table_admin.jsp">Time-Table</a>
                   

                </div>
                
                <div class="navbar-nav ml-auto">
                    
                  <a class="nav-link" id="menuitem5" href="#">  <span class="fa fa-user-o"></span> <%= user.getName() %>  </a>
                    <a class="nav-link" id="menuitem5" href="LogOutServlet">LogOut </a>

                </div>
            </div>
            
            
            
            
        </nav>
    
    
    
    
    

<!-- end of header part of body -->
<!-- middle part of body -->

<!-- body part  -->      
     <div class="body-container-admin">
		
		 <jsp:include page="login_success.jsp" />
	 </div> 
        
<!-- end of middle part of body -->
 </div>


<!-- footer of body -->

<!-- end of footer of body -->


<!-- javascript -->












</body>
</html>