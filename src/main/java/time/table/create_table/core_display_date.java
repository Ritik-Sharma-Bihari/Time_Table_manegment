package time.table.create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class core_display_date {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			String url="jdbc:mysql://localhost:3306/college";
			String user="root";
			String password="Ritiksharma620@";
			Connection con=DriverManager.getConnection(url, user, password);
			 String sql_query="select * from  admin_facultycreate";
			PreparedStatement ps=con.prepareStatement(sql_query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String password1=rs.getString(4);
				String gender=rs.getString(5);
			//	String date_join=rs.getString(2);
				
				
				java.sql.Date sdate=rs.getDate(6);
				System.out.println(id+" " +name+" "+email+" "+password1+" "+gender+" "+sdate);
				
				// to display the data type of date in console..
				System.out.println( "this data type of date--"+((Object)sdate).getClass().getSimpleName());
			}
			
			
			
		}catch(Exception e)
		{
			System.out.println("execption:"+e);
		}

	}


}
