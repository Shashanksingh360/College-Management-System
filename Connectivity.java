import java.sql.*;

import javax.swing.JOptionPane;


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
		    String password=null,Role_id=null,Admin="Admin",Accountant="Accountant",Student="Student",Faculty="Faculty";
		    
		try{
			PreparedStatement st= con.prepareStatement("select password,Role_id from users where username=?");
			st.setString(1, lusername);
			ResultSet rs=st.executeQuery();   
			
			while(rs.next())
			{
			password=rs.getString(1);
			Role_id=rs.getString(2);
			}
			if(lpassword.equals(password))
			{
				if(Role_id.equals(Admin))
				{
					try {
						new Admin(lusername);
						Main.f.setVisible(false);
					} catch (ClassNotFoundException e) {
					}
				}
				else if(Role_id.equals(Accountant))
				{
					try {
						new Accountant(lusername);
						Main.f.setVisible(false);
					} catch (ClassNotFoundException e) {
					}
				}
				else if(Role_id.equals(Student))
				{
					new Student(lusername);
					Main.f.setVisible(false);
				}
				else if(Role_id.equals(Faculty))
				{
					new Faculty(lusername);
					Main.f.setVisible(false);
				}
				//Userpage uo=new Userpage();
				//Logintest.f.setVisible(false);
				//uo.user();
				}
			else{
				JOptionPane.showMessageDialog(Main.nlogin, "Wrong Userame or password");
				
			}
		}
		catch(SQLException e){
		}
	}
	
	public void registration(String rfname,String rlname, String rusername, String rpassword ,String rrole, String rgender)
	{
		rusername=rusername.toLowerCase();
		
		try {
			PreparedStatement st=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			st.setString(1, rfname);
			st.setString(2, rlname);
			st.setString(3, rusername);
			st.setString(4, rpassword);
			st.setString(5, rrole);
			st.setString(6, rgender);
			st.setString(7, "Not Approved");
			st.executeUpdate();
			
		}
		catch (SQLException e) {
		}
		
	}
	
	
}