<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

 <%@page import="time.table.entities.Message_class" %>
    <%@page import="time.table.dao.Login_Dao" %>
    <%@page import="time.table.entities.User" %>
    <%@page import="time.table.helper.ConnectionProvider" %> 
    
    
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
          
           <%  
          
           User userr=new User();
           Login_Dao dao=new Login_Dao(ConnectionProvider.getConnection());
           
          List<User> list=Login_Dao.getAllRecords(userr);  
          request.setAttribute("list",list); 
          
          
          
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

<!-- header part -->



<!-- end of header part -->


 <!--  <table  border=  "1" class="table table-bordered">  -->
<table border="1" >
        

<tr>
                        <td><%= userr.getFaculty_Id() %></td>
                        <td><%= userr.getSubject_Id() %></td>
                        <td><%= userr.getCourse_Id() %></td>
                        <td><%=userr.getCourse_Name()  %></td>                    
                      <td><%= userr.getSession() %></td> 
                        <td><%= userr.getYear() %></td>
                        <td><%= userr.getStart_time() %></td>
                        <td><%= %>
                        <%= %>
                    </tr>

</table>

<!--  

  <thead>
    <tr>
      <th scope="col">DAY/HOURSE</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">break</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">break</th>
      <th scope="col">start_time-end_time</th>
      <th scope="col">start_time-end_time</th>
    </tr>
  </thead>
  <tbody>
  <tr>
      <th scope="row"></th>
      <td colspan="">
      <table>
      <tr>
      <th>subject-id</th>
      <th>  </th>
      <th>section</th>
      
      </tr>
      </table>
      
      </td>
      <td colspan="">
      
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      
      
      
      </td>
      <td colspan="">....</td>
      
      
      <td colspan="">
      
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      
      </td>
      <td colspan="">
      
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      
      
      </td>
      <td colspan="">
      
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      
      
      </td>
      <td colspan="">....</td>
      <td colspan="">
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      
      
      </td>
      <td colspan="">
      
      <table>
      <tr>
      <th>subject-id</th>
      <th>course_id</th>
      <th>section</th>
      
      </tr>
      </table>
      </td>
    </tr>
    <tr>
      <th scope="row">MONDAY</th>
      <td colspan="">
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>break</td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      break
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
    </tr>
    
    <tr>
      <th scope="row">TUESDAY</th>
      <td colspan="">
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>break</td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      break
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
    
    </tr>
    <tr>
      <th scope="row">WEDNESDAY</th>
      <td colspan="">
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      
      <td colspan="">
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>break</td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      break
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
    </tr>
    
    <tr>
      <th scope="row">THURSDAY</th>
      <td colspan="">
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td colspan="">
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      
      <td>break</td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      break
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
    </tr>
    <tr>
      <th scope="row">FRIDAY</th>
       
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      
      
      
      <td>break</td>
      
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
      <td>
      
      <table>
      <tr>
      <th>**</th>
      <th>**</th>
      <th>**</th>
      
      </tr>
      </table>
      
      </td>
    </tr>
    <tr>
      <th scope="row">SATURDAY</th>
      <td>...</td>
      <td>...</td>
     <td>break</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
  </tbody>
  
  
</table>

-->
<!-- body end part -->

<!-- footer part -->

</body>
</html>