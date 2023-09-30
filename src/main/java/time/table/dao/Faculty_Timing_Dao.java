package time.table.dao;
//this is for admin------------------

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Date;


import time.table.entities.Faculty_timing;

public class Faculty_Timing_Dao {
	
	
	
private Connection con;
	
	public Faculty_Timing_Dao(Connection con)
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
	
	public boolean saveFaculty_timing(Faculty_timing timing)
	{
		boolean f=false;
		/*
		 * BYdefault f=false beacuse it not insert data into database.
		 * so after execute the statement for insert data into database.
		 * we will make it true..
		 */	
		
		try {
			// insert data into database...
			
			String operation=timing.getOperation();
			
			if(operation.equals("create"))
			{
				String query="insert into admin_faculty_time_allocate(faculty_ID, subject_ID,course_ID,course_name,year,section,day,start_time,end_time) values(?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement pstmt=con.prepareStatement(query);
				/*
				 * call the getName() method to store data into database which is stored into in this 
				 * method
				 */
				pstmt.setInt(1, timing.getFaculty_Id());
				pstmt.setInt(2, timing.getSubject_Id());
				pstmt.setString(3, timing.getCourse_Id());
				pstmt.setString(4,timing.getCourse_Name());
				
				pstmt.setString(5, timing.getYear());
				pstmt.setString(6,timing.getSession());
				
				pstmt.setString(7, timing.getDay());
				/*
				 * so here this time goes to inform of string in mysql 
				 * not in form of mysql data
				 */
			pstmt.setString(8, timing.getStart_time());
			pstmt.setString(9, timing.getEnd_time());
				
				/*
				 * so above code is inform of String then we have to convert them into 
				 * java java time then w can directly insert it into database
				 * while if we don't convert it then also in mysql it will store in 
				 * bydeafult in time type
				 * but while retrive it may it will show some eroor 
				 */
				// this is for start_time
			
			/*  ---- this is not working --------
			 * 
				String timeString = timing.getStart_time(); // Replace with your string value
				java.sql.Time timeData = java.sql.Time.valueOf(timeString);	
				pstmt.setTime(8, timeData);
				
				
				// this is for start_time
				String timeString2 = timing.getEnd_time(); // Replace with your string value
				java.sql.Time timeData2 = java.sql.Time.valueOf(timeString2);	
				pstmt.setTime(9, timeData2);
				
				*/
				
				/*
				 * to check the the data type of getSatrt_time() data.
				 */
		
		       
		        pstmt.executeUpdate();
				f=true;
			//	System.out.println("data type of faculty time is="+ ((Object)timing.getStart_time()).getClass().getSimpleName());	
			}
			
			
			
		//	else if(operation.equals("update"))
		//	{
			//	System.out.println("update execute1");
				
			//	String query="UPDATE admin_facultycreate SET name =?,email=?,password=?,gender=?,join_date=? WHERE id=?";
			//	PreparedStatement pstmt=con.prepareStatement(query);
				/*
				 * call the getName() method to store data into database which is stored into in this 
				 * method
				 */
		/*		System.out.println("update execute2");
				pstmt.setString(1, faculty.getName());
				pstmt.setString(2, faculty.getEmail());
				pstmt.setString(3, faculty.getPassword());
				pstmt.setString(4, faculty.getGender());
		//		pstmt.setString(6, faculty.getDate_join());
				System.out.println("update execute3");
				// Creating a date for birthdate
				
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date birthdate = dateFormat.parse(faculty.getDate_join());
		        pstmt.setDate(5, new java.sql.Date(birthdate.getTime()));
		        System.out.println("update execute4");
		        pstmt.setInt(6, faculty.getId());
		        System.out.println("update execute5");
		        pstmt.executeUpdate();
		        System.out.println("update execute6");
			//	pstmt.executeUpdate();
				f=true;
				System.out.println("update execute7");
			}   */
				
				
			else {
				
				
				System.out.println("error happed");
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error happed raa");
		}
		System.out.println("this is Faculty_Timing_Dao java");
		System.out.println(f);
		return f;
		
		}
	
	
	
	/*
	 * to retrive data from database
	 *  
	 */
	
	
	

}


