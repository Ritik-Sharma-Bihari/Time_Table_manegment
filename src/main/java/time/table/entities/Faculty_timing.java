package time.table.entities;

//this is for admin------------------

public class Faculty_timing {
	
	
	private int faculty_id;
	private int subject_id;
	private String course_id;
	private String course_name;
	private String year;
	private String session;
	private String day;
	private String start_time;
	private String end_time;
	private String operation;
	
	
	/*
	 * first constructor
	 */
	public Faculty_timing()
	{
		
	}
	
	/*
	 * second constructor
	 * it is invoked by faculty_alloacate_tming.java
	 * 
	 * to store the data into database means to transfer the data to Faculty_Dao object.
	 */
	public Faculty_timing(int faculty_id,int subject_id,String course_id,String course_name,String year, String session,String day,String start_time,String end_time,String operation)
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
		this.operation=operation;
		
		
		
	}
	/*
	 * third constructor
	 * for display the data
	 */
	public Faculty_timing(int faculty_id,int subject_id,String course_id,String course_name,String year, String session,String day,String start_time,String end_time)
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
	}

	/*
	 * getter and setter
	 */
	/*
	 * setter
	 */
	    public void set_Faculty_Id(int faculty_id) {
	        this.faculty_id= faculty_id;
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
	    public void set_Start_time(String start_time) {
	        this.start_time = start_time;
	    }
	    public void set_End_time(String end_time) {
	        this.end_time = end_time;
	    }

			

		public void setOperation(String operation) {
			// TODO Auto-generated method stub
		   this.operation=operation;
		}
	

		/*
		 * getter
		 */
		
		public String getOperation() {
			// TODO Auto-generated method stub
			return operation;
		}
		
		public int getFaculty_Id() {
			// TODO Auto-generated method stub
			return faculty_id;
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
		 public String getStart_time() {
				// TODO Auto-generated method stub
				return start_time;
			}
		 public String getDay() {
				// TODO Auto-generated method stub
				return day;
			}
		 public String getEnd_time() {
				// TODO Auto-generated method stub
				return end_time;
			}

}
