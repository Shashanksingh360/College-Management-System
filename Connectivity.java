import java.awt.Font;
import java.sql.*;


class Connectivity{
	Connection con;
	Statement st;
	
	void connection()
	{
       try{     
    	   
		Class.forName("com.mysql.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
		}
		catch(SQLException e)
		{
		}
		catch(ClassNotFoundException e)
		{ 
		}
		
	}
	
	public void loginVerification(String lusername,String lpassword){
		    lusername=lusername.toLowerCase();
		    String password=null;
		try{
			PreparedStatement st= con.prepareStatement("select password from user where username=?");
			st.setString(1, lusername);
			ResultSet rs=st.executeQuery();   
			while(rs.next())
			{
			password=rs.getString(1);
			}
			if(lpassword.equals(password))
			{
				System.out.println("Successful");
				Userpage uo=new Userpage();
				Logintest.f.setVisible(false);
				uo.user();
				}
			else{
				System.out.println("Failed");
				
			}
		}
		catch(SQLException e){
		}
	}
	
	public void registration(String rfname,String rlname, String rusername, String rpassword ,String rrole, String rgender)
	{
		rusername=rusername.toLowerCase();
		
		try {
			PreparedStatement st=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			st.setString(1, rfname);
			st.setString(2, rlname);
			st.setString(3, rusername);
			st.setString(4, rpassword);
			st.setString(5, rrole);
			st.setString(6, rgender);
			st.setString(7, "Not Approved");
			//int i=st.executeUpdate();
			
		}
		catch (SQLException e) {
		}
		
	}
	
	public void approved()
	{
		try{
			PreparedStatement st= con.prepareStatement("select * from user where username=?");
			//st.setString(1, lusername);
			ResultSet rs=st.executeQuery();   
		}
		catch(SQLException e){
		}
		
	}
}
