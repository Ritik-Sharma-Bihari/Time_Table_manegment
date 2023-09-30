package time.table.entities;
// this is for admin------------------
public class Admin_Course {
	private String id;
	private String year;
	private String name;
	private String operation;
	private String faculty_name;
	private String course_section;
	
	/*
	 * first constructor
	 */
	public Admin_Course()
	{
		
	}
	
	/*
	 * second constructor
	 */
	public Admin_Course(String id,String name,String year,String course_section,String operation)
	{
		this.id=id;
		this.year=year;
		this.name=name;
		this.operation=operation;
		
		this.course_section=course_section;
		
	}
	/*
	 * third constructor
	 */
	public Admin_Course(String id,String name,String faculty_name,String s)
	{
		this.id=id;		
	//	this.year=year;
		this.name=name;
		this.faculty_name=faculty_name;
	}

	/*
	 * getter and setter
	 */
	
	    public void setId(String id) {
	        this.id= id;
	    }
	    	    
	    
	    public void setYear(String year) {
	        this.year = year;
	    }
	    	  
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setSection(String course_section) {
	        this.course_section = course_section;
	    }
	    
	  
			

		public void setOperation(String operation) {
			// TODO Auto-generated method stub
		   this.operation=operation;
		}
		
		
		public String getSection() {
			// TODO Auto-generated method stub
			return course_section;
		}
	

		public String getOperation() {
			// TODO Auto-generated method stub
			return operation;
		}
		public String getId() {
			// TODO Auto-generated method stub
			return id;
		}
		 public String getYear() {
				// TODO Auto-generated method stub
				return year;
			} 
		 public String getName() {
				// TODO Auto-generated method stub
				return name;
			}


		

}
