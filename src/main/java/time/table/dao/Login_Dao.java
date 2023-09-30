package time.table.dao;

//this is for admin , faculty, hod------------------

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import time.table.entities.User;

//import com.tech.blog.entities.User;

public class Login_Dao {
	
	/*
	int id;
	private String password=null;
	 private String table_type=null;
	
	*/
	private static Connection con;
	public Login_Dao(Connection con)
	{
		this.con=con;
		
		/* so without the connection object can't access this class so if we 
		 * want to access this class we must have to give the argument to it 
		 * which argument must be Connection type return..
		 * 
		 */
	}
	
	
	/*get user by email and password for login verification 
	 * or
	 * to retrive data from database
	 *  
	 */
	
	


	

/*
 * this is basically used to verifing the given user_id and password
 * that whither that data is available or not it particular table
 * and
 * this is going to return all the values from database to User class object from that table
 */
	
	 
	public User getUserByTableNameIDAndPassword(String type,int id,String password)
	{
		User user=null;
		String table_type=null;
		
		
		try {
			
			if(type.equals("admin"))
			{
				table_type="admin_login";
				System.out.println("admin table exit");		
				
			}
			else if(type.equals("faculty"))
			{
				table_type="faculty_login";
				System.out.println("faculty table exit");
						
			}
			else if(type.equals("hod"))
			{
				table_type="admin_login";
				System.out.println("hod table exit");			
			}
			else if(type.equals("student"))
			{
				table_type="student_login";
				System.out.println("student table exit");				
			}
			else {
				
				
				System.out.println("table name error");
			}
			
			System.out.println("hello1");
			String query="select id,name,password from "+table_type+" where id=? and password=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			
			ResultSet set=pstmt.executeQuery();
			
			System.out.println("hello2");// to execute the query
			if(set.next())
			{
				System.out.println("hello3");
			//	System.out.println( "this is provius id before creating new object="+user.getId());
				user=new User();
				/*
				 * to check that whither privius object will the 
				 * value of not after creating new object
				 * so
				 */
				
			
				
				// retrive data from database
				// data from db
				user.setId(set.getInt("id"));
				String name=set.getString("name");	
				System.out.println("hello5");
				
				// forwade the store data into User class method SetName()
				// set to user object
				/*
				 * here we are calling the setName() method of User class 
				 * to set the value so that we can campare with other values 
				 * for authentication
				 */
				System.out.println("hello6");
				user.setName(name);
				// to get the id data from db and set to User object
				System.out.println("hello7");
				user.setPassword(set.getString("password"));
				System.out.println("hello8");
			}			
			
		}catch(Exception e)
		{
			System.out.println("error happed in catch statement!!");
			
		}
			
		return user;
	}
	
	
	
	
	
	public User selectuser(int id)
	{
		User user=null;
		// establish connection
		
		try {
			
			PreparedStatement ps=con.prepareStatement("SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day FROM admin_faculty_time_allocate where faculty_ID="+id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	         //   User u=new User();  
	            	            
	            // user.setId(rs.getInt("id"));
	            user.set_Faculty_Id(rs.getInt("faculty_ID"));
	            user.set_Subject_Id(rs.getInt("subject_ID"));
	            user.set_Course_Id(rs.getString("course_ID"));
	            user.set_Course_Name(rs.getString("course_name"));
	            user.set_Year(rs.getString("year"));
	            user.set_Session(rs.getString("section"));
	            user.set_Day(rs.getString("day"));
	            
	        }
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// to retrive the all data	
	public static List<User> getAllRecords(User user){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        //Connection con=getConnection();  
	    	
	    	  
	           int id=user.getId();
	         
	           
	        PreparedStatement ps=con.prepareStatement("SELECT faculty_ID,subject_ID,course_ID,course_name,year,section,day FROM admin_faculty_time_allocate where faculty_ID="+id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	         //   User u=new User();  
	            	            
	          //  user.setId(set.getInt("id"));
	            user.set_Faculty_Id(rs.getInt("faculty_ID"));
	            user.set_Subject_Id(rs.getInt("subject_ID"));
	            user.set_Course_Id(rs.getString("course_ID"));
	            user.set_Course_Name(rs.getString("course_name"));
	            user.set_Year(rs.getString("year"));
	            user.set_Session(rs.getString("section"));
	            user.set_Day(rs.getString("day"));
	           // user.set_Start_time(rs.getTime(""));
	    
                list.add(user);
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  

	
}
