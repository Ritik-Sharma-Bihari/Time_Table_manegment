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


    <title>Display Time Data</title>
</head>
<body>

<h1>Time table Data</h1>
 <table class="table table-bordered">
 
      
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
      
     
    
    
    
    
    
    
    
    
    
    
    </table>
    
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


       
    
</body>
</html>
