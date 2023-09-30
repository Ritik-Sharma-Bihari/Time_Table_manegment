package time.table.entities;
//this is for admin hod and faculty ------------------
//import java.sql.Timestamp;

import java.sql.Time;

/*
 * this is for login authentication dao
 */

public class User {

	// to verify the authentication
	private int id;
	private String type;
	private String password;
	private String name;
	// to retrive the data from timing table.......
	private int faculty_id;
	private int subject_id;
	private String course_id;
	private String course_name;
	private String year;
	private String session;
	private String day;
	private Time start_time;
	private Time end_time;
	private String operation;

	
	private String profile;  // for storing the image
	
	
	
	// display the data
	public User( int id ,String name)
	{
		// 1 constructure
		
		this.id=id;
		this.name=name;	
		
	}
	public User()
	{
		// 2nd constuctre
	}
	
	
	// this is for data insert
	/*
	 * this constructer is created for login authority fixed cleard
	 */
	public User(String type , int id,String password)
	{
		// 3rd constructure
		this.type=type;
		this.id=id;
		this.password=password;
		/*
		 * so here what ever value we get from GUI that values will be stored here.
		 */
	}
	
	
	/*
	 * this is for retrive the data from timing table
	 * 
	 */
	
	public User(int faculty_id,int subject_id,String course_id,String course_name,String year, String session,String day,Time start_time,Time end_time)
	{
		this.faculty_id=faculty_id;
		this.subject_id=subject_id;
		this.course_id=course_id;
		this.course_name=course_name;
		this.year=year;
		this.session=session;
		this.start_time=start_time;
		this.day=day;
		this.end_time=end_time;
	//	this.operation=operation;
		
		
		
	}
	
	
	public User(int subject_id, String course_id, String course_name, String year, String session, String day,
			Time start_time, Time end_time) {
		super();
		this.subject_id = subject_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.year = year;
		this.session = session;
		this.day = day;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public User(int faculty_id, int subject_id, String course_id, String course_name, String year, String session,
			String day) {
		super();
		this.faculty_id = faculty_id;
		this.subject_id = subject_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.year = year;
		this.session = session;
		this.day = day;
	}
	public void set_Faculty_Id(int faculty_id) {
        this.faculty_id= faculty_id;
    }
	public void set_Faculty_Name(String name) {
        this.name= name;
    }
    
    public void set_Subject_Id(int subject_id) {
        this.subject_id= subject_id;
    }
     
    public void set_Course_Id(String course_id) {
        this.course_id = course_id;
    }
    
    public void set_Course_Name(String course_name) {
        this.course_name = course_name;
    }
    
    public void set_Year(String year) {
        this.year = year;
    }
    public void set_Session(String session) {
        this.session = session;
    }
    
    public void set_Day(String day) {
        this.day = day;
    }
    public void set_Start_time(Time time) {
        this.start_time = time;
    }
    public void set_End_time(Time end_time) {
        this.end_time = end_time;
    }

    //getter
    public int getFaculty_Id() {
		// TODO Auto-generated method stub
		return faculty_id;
	}
    
    public String getFaculty_Name() {
		// TODO Auto-generated method stub
		return name;
	}
	
    public int getSubject_Id() {
		// TODO Auto-generated method stub
		return subject_id;
	}
 public String getCourse_Id() {
		// TODO Auto-generated method stub
		return course_id;
	}
 public String getCourse_Name() {
		// TODO Auto-generated method stub
		return course_name;
	}
 public String getYear() {
		// TODO Auto-generated method stub
		return year;
	}
 public String getSession() {
		// TODO Auto-generated method stub
		return session;
	}
 public Time getStart_time() {
		// TODO Auto-generated method stub
		return start_time;
	}
 public String getDay() {
		// TODO Auto-generated method stub
		return day;
	}
 public Time getEnd_time() {
		// TODO Auto-generated method stub
		return end_time;
	}

	
	
	
	
	// getters and settters
	/*
	 * why we are using this setter and getter because what ever we are accessing 
	 * data from database which values will be store in respective variable by call this 
	 * method so that the comparison will be easy.
	 * 
	 * so when ever we will call this method then they goes to performs their operation
	 * but bassicallly we are going to call it by userDao for verification or for insert data.
	 */
	 public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	   

	   
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	  
	    
	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	
	
}
