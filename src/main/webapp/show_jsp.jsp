<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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
          <%
          HttpSession s=request.getSession(false); 
          int n=(Integer)session.getAttribute("listt");
          

            
        //  List<User> list=Faculty_timeTable_Dao.getAllRecords(); 
          List<User> list=Faculty_timeTable_Dao.getAllRecords_of_A_faculty(n); 
          request.setAttribute("list",list);  
          
           
          %>
 
          
<html>
<head>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


<style>

.card-container{



}



</style>
</head>
<body>

<div class="main-container">

<div class="card-container text-center ">
<h1>Time table Data</h1>
 <table class="table table-bordered">
 <thead>
   
    <tr>
      <th scope="row">DAY/HOURSE/course</th>
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
      </thead>
      
      <tr>
      <td scope="col">  </td>
      <td scope="col">
      
      
      8.15-9.20
      
      </td>
      <td scope="col">9.20-10.00</td>
      <td scope="col">break</td>
      <td scope="col">10.20-11.10</td>
      <td scope="col">11.10-12.10</td>
      <td scope="col">12.00-13.15</td>
      <td scope="col">break</td>
      <td scope="col">14.20-15.15</td>
      <td scope="col">15.15-16.00</td>
      </tr>
      
       <c:forEach items="${list}" var="u"> 
       
       
       <%
       
       
       %>
       
      <tr>
      <th scope="row"> ${u.getDay()} </th>
      <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
      <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
      
      <td>break</td>
      
     <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
      
     <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
     <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
      
      <td>
      break
      </td>
      
      
     <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
      
     <td colspan="">      
      <table>
      <tr>
      <!-- this is for subject id -->
      <th> ${u.getSubject_Id()}  </th>
      <!--  this is for course id -->
      <th>${u.getCourse_Id()}</th>
      <!--  this is for section -->
      <th>${u.getSession() }</th>     
      </tr>
      </table>     
      </td>
      
    </tr>
    
      
       </c:forEach>
       </table>
      
      
      
      
      

</div>

</div>

      
      
      
      
      
      
   <!--   
      
     <c:forEach items="${list}" var="u"> 
        
            <tr>
            <td>    ${u.getFaculty_Id()}      </td>
             <td>    ${u.getSubject_Id()}      </td>
            <td>    ${u.getCourse_Id()}      </td>
            <td>    ${u.getCourse_Name()}      </td>
            <td>    ${u.getYear()}      </td>
            <td>    ${u.getDay()}           </td>
            <td>    ${u.getSession() }      </td>
           
              
              </tr>                
       </c:forEach>   
      
      -->  
      
     
      
     
    
    
    
    
    
    
    
    
    
    
    <!--  
    
    <table border="1">
        <tr>
            <th> Name</th>
            <th> Time</th>
        </tr>
        <c:forEach items="${list}" var="u"> 
        
            <tr>
            <td>    ${u.getFaculty_Id()}      </td>
             <td>    ${u.getSubject_Id()}      </td>
            <td>    ${u.getCourse_Id()}      </td>
            <td>    ${u.getCourse_Name()}      </td>
            <td>    ${u.getYear()}      </td>
            <td>    ${u.getDay()}           </td>
            <td>    ${u.getSession() }      </td>
           
              
              </tr>                
       </c:forEach>
    </table>

-->
       
    
</body>
</html>
