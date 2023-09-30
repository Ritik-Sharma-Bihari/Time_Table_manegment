package time.table.Servlet;
// this is for admin--------------
// it is going to recive request from faculty_allocate_time.jsp

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import time.table.dao.Faculty_Dao;
import time.table.dao.Faculty_Timing_Dao;
import time.table.entities.Admin_Faculty;
import time.table.entities.Faculty_timing;
import time.table.entities.Message_class;
import time.table.helper.ConnectionProvider;

/**
 * Servlet implementation class faculty_allocate_tming
 */
@WebServlet("/faculty_allocate_tming")
public class faculty_allocate_tming extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	
        response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
try {
			
			// fetch all data 
        	// filter work
            String check=request.getParameter("check");
            
            if(check == null)
            {
            	out.println("box not checked");
            }
            else {

				String operation=request.getParameter("admin_faculty_operation_timing");
		    	/*
		    	 * convert string to int type
		    	 */
		    	int faculty_id=Integer.parseInt(request.getParameter("faculty_id_timing"));
		    	int subject_id=Integer.parseInt(request.getParameter("subject_id_timing"));
		    	String course_id=request.getParameter("course_id_timing");
		    	String course_name=request.getParameter("course_name");
		    	String year=request.getParameter("course_year");
		    	String session=request.getParameter("section");
		    	String day=request.getParameter("admin_faculty_operation_day");
		    	String start_time=request.getParameter("faculty_start_timing");
		    	String end_time=request.getParameter("faculty_end_timing");
		    	
            	
            	
            	/*to pass above parameter to User class so that 
            	 *they can be again share to UserDao then database 
            	 * 
            	 * we are creating the object of User class and setting(passing) this all 
            	 * parameter to corresponding for that we have to import com.tech.blog.entities.User;
            	 */
            	
            	
            	Faculty_timing time=new Faculty_timing(faculty_id,subject_id,course_id,course_name,year,session,day,start_time,end_time,operation);
            	
            	/*
            	 * it goes to initialize all this values into User class variable respectively.
            	 * after initialize values to parameters we need to store it into database , so
            	 */
            	
            	/* create userDao object because to interact with data
            	 * base we are writing the code in UserDao class
            	 * so in-order to create the UserDao object we must have to give the Connection type 
            	 * object so,
            	 * 
            	 */
            	
            
            	Faculty_Timing_Dao dao=new Faculty_Timing_Dao(ConnectionProvider.getConnection());
            	
            	if(dao.saveFaculty_timing(time))
            	{
            		/*
                	 * so after success full data insert into database the value of doa object will true(1).
                	 */
                 		
            		/* login success
                	 * so after success full data insert into database the value of doa object will true(1).
                	 * 
                	 * now storing the u object into session object 
                	 */
            	//	save..
            		
            		Message_class m=new Message_class("record updated","success","alert-success");
            		/*
            		 * if httpsession has already exit then it don't goes to 
            		 * create again session object
            		 * it will work on that one
            		 */
            		
            		HttpSession s=request.getSession();
            		s.setAttribute("msg", m);
            		response.sendRedirect("faculty_allocate_time.jsp");
            		
            		
            		
            		
            		
            		
            	}
            	else {
            		//out.println("error");
            		
            		Message_class sms=new Message_class("something went wrong","error", "alert-danger");
    				/*
    				 *  we are going to create the Httpsession object to store this sms and forware to login page
    				 *  so that we can display data on login data will not go to next page.
    				 */
    				HttpSession s=request.getSession();
    				s.setAttribute("msg", sms);
    				// here we are setting the value of Message object to session
    				response.sendRedirect("faculty_allocate_time.jsp");
            		
            		
            		
            	}
            	
            }
	}catch(Exception e)

{
	System.out.println(e);	
}
	}

}
