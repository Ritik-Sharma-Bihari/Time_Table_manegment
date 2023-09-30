package time.table.dao;
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import time.table.entities.User;  
public class Faculty_timeTable_Dao {
	
	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Ritiksharma620@");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}
	
	// to get all recorde data from database of admin_faculty_time_allocate
	
	public static List<User> getAllRecords(){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day FROM admin_faculty_time_allocate");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User u=new User();  
	            u.set_Faculty_Id(rs.getInt("faculty_ID"));
	            u.set_Subject_Id(rs.getInt("subject_ID"));
	            u.set_Course_Id(rs.getString("course_ID"));
	            u.set_Course_Name(rs.getString("course_name"));
	            u.set_Year(rs.getString("year"));
	            u.set_Session(rs.getString("section"));
	            u.set_Day(rs.getString("day"));
	           // u.set_Start_time(rs.getTime(0));
	          //  u.set_Day(rs.getString("day"));
	            
	            
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	
	
	/*
	 * to get the id and name the data from database of admin_facultycreate
	 * 
	 */
	public static List<User> getIdName_admin_facultycreate(){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT id,name FROM admin_facultycreate");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User u=new User();  
	            u.set_Faculty_Id(rs.getInt("id"));
	            u.set_Faculty_Name(rs.getString("name"));
	           
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	
	
	// to get data from timing table for a particular faculty all data.
	public static List<User> getAllRecords_of_A_faculty(int id){  
	    List<User> list=new ArrayList<User>(); 
	    // to print the id in console
	      System.out.println( "this is faculty_timeTable_Dao " +id);
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day FROM admin_faculty_time_allocate where faculty_ID="+id);  
	        ResultSet rs=ps.executeQuery(); 
	        //
	        System.out.println("this is faculty_time0");
	        while(rs.next()){  
	            User u=new User();  
	            // to console
	            System.out.println("this is faculty_time");
	            
	            u.set_Faculty_Id(rs.getInt("faculty_ID"));
	            u.set_Subject_Id(rs.getInt("subject_ID"));
	            u.set_Course_Id(rs.getString("course_ID"));
	            u.set_Course_Name(rs.getString("course_name"));
	            u.set_Year(rs.getString("year"));
	            u.set_Session(rs.getString("section"));
	            u.set_Day(rs.getString("day"));
	            //
	            System.out.println("this is faculty_time1");
	          //  u.set_Start_time(rs.getTime(""));
	          //  u.set_Day(rs.getString("day"));
	            
	            
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	/*
	 * to get the record from database admin_faculty_time_allocate by id
	 */
	public static User getRecordById(int id){  
	    User u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day FROM admin_faculty_time_allocate where faculty_ID=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new User();  
	            u.set_Faculty_Id(rs.getInt("faculty_ID"));
	            u.set_Subject_Id(rs.getInt("subject_ID"));
	            u.set_Course_Id(rs.getString("course_ID"));
	            u.set_Course_Name(rs.getString("course_name"));
	            u.set_Year(rs.getString("year"));
	            u.set_Session(rs.getString("section"));
	            u.set_Day(rs.getString("day")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
	

}
