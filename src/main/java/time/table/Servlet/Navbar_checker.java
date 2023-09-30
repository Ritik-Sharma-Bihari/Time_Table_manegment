package time.table.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Navbar_checker
 */
@WebServlet("/Navbar_checker")
public class Navbar_checker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		String name=request.getParameter("user_navbar");
		
		if(name.equals("admin"))
		{
			out.print("hello admin");
			
		}
		else if(name.equals("hod"))
		{
			out.print("hello hod");
			
		}
		else if(name.equals("faculty"))
		{
			out.print("hello faculty");
		}
		else if(name.equals("student"))
		{
			out.print("hello student");
		}
		else {
			out.print(false);
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
			out.print(false);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
