package time.table.dao;
//this is for admin------------------

import java.sql.Connection;
import java.sql.PreparedStatement;
import time.table.entities.Admin_Course;


public class Course_Dao {
	
private Connection con;
	
	public Course_Dao(Connection con)
	{
		this.con=con;
		
		/* so without the connection object can't access this class so if we 
		 * want to access this class we must have to give the argument to it 
		 * which argument must be Connection type return..
		 * 
		 */
	}
	
	/* method to insert user to data base
	 * actually we are initialized all the user data into User class object so 
	 * to aacess those data into here we are going to pass object of user class.
	 * here we are importing the com.tech.blog.entities.User for creating the object of User class
	 *  or 
	 *  to insert data into database 
	 */
	
	public boolean saveCourse(Admin_Course course)
	{
		boolean f=false;
		/*
		 * BYdefault f=false beacuse it not insert data into database.
		 * so after execute the statement for insert data into database.
		 * we will make it true..
		 */
		
		
		
		
		try {
			// insert data into database...
			
			String operation=course.getOperation();
			
			if(operation.equals("create"))
			{
				String query="insert into course_admin(id,name,year,section) values(?,?,?,?)";
				
				PreparedStatement pstmt=con.prepareStatement(query);
				/*
				 * call the getName() method to store data into database which is stored into in this 
				 * method
				 */
				pstmt.setString(1, course.getId());
				pstmt.setString(2, course.getName());
				pstmt.setString(3, course.getYear());
				pstmt.setString(4, course.getSection());
		
				/*		pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getGender());
				pstmt.setString(5, user.getAbout());            */
				
				pstmt.executeUpdate();
				f=true;
				
			}
			else if(operation.equals("update"))
			{
				String query="UPDATE course_admin SET name =?,year=?,section=? WHERE id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				/*
				 * call the getName() method to store data into database which is stored into in this 
				 * method
				 */
				pstmt.setString(1, course.getName());
				pstmt.setString(2,course.getYear());
				pstmt.setString(3, course.getSection());
				pstmt.setString(4,course.getId() );
				
				pstmt.executeUpdate();
				
				f=true;
				
			}
			else {
				
				
				System.out.println("error happed");
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("this is Course Dao java");
		System.out.println(f);
		return f;
		
	}	
	
	
	

}
