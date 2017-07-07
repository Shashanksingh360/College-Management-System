import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

class Faculty{
	
	Connection con;
	String sUsername;
	
	Faculty(String lusername){


		JFrame userFrame=new JFrame("Faculty");
		userFrame.setLayout(null);
		userFrame.setBounds(0,0,1366,718);
		JLabel lblHeading=new JLabel("College Management System");
		lblHeading.setFont(new Font("ARIAL", Font.BOLD,40));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(0, 10, 1366, 70);
		userFrame.add(lblHeading);
		
		
	
		JPanel backuser=new JPanel();
		backuser.setLayout(null);
		backuser.setBounds(0,80,1366,588);
		backuser.setBackground(Color.black);
		userFrame.add(backuser);
		
		
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(20, 10, 200,568);
		btnPanel.setBackground(Color.gray);
		backuser.add(btnPanel);
	
		
		
		//label for welcome

		
//adding buttons in userpanel
			
			JButton btn1=new JButton("Personal Details");
			btn1.setBounds(20, 80, 140, 20);
			btnPanel.add(btn1);
			
			

			JButton btn2=new JButton("Add Marks");
			btn2.setBounds(20, 120, 140, 20);
			btnPanel.add(btn2);
			
			
//Adding buttons ends here.		
		
		
		
//Panel for "Show_details"--->	
		JPanel Showdetails=new JPanel();
		Showdetails.setLayout(null);
		Showdetails.setBounds(230, 10, 1110,568);
		Showdetails.setBackground(Color.red);
		backuser.add(Showdetails);
		
		
		
		
		
	//Details Content 	
		
		//Label for First name-->
		JLabel fname=new JLabel("First Name:");
		fname.setFont(new Font("ARIAL", Font.BOLD,20));
		fname.setHorizontalAlignment(SwingConstants.LEFT);
		fname.setBounds(190, 80, 190, 20);
		Showdetails.add(fname);
		
		JTextField TxtFname=new JTextField();
		TxtFname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtFname.setBounds(310,80,340,30);
		Showdetails.add(TxtFname);
		TxtFname.setEditable(false);
		
		
		//Label for Last name-->

		JLabel lname=new JLabel("Last Name:");
		lname.setFont(new Font("ARIAL", Font.BOLD,20));
		lname.setHorizontalAlignment(SwingConstants.LEFT);
		lname.setBounds(190,130, 190, 20);
		Showdetails.add(lname);
		
		JTextField TxtLname=new JTextField();
		TxtLname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtLname.setBounds(310,130,340,30);
		Showdetails.add(TxtLname);
		TxtLname.setEditable(false);
		
		
		
		//Label for User name-->

		JLabel uname=new JLabel("UserName:");
		uname.setFont(new Font("ARIAL", Font.BOLD,20));
		uname.setHorizontalAlignment(SwingConstants.LEFT);
		uname.setBounds(190,180,190, 20);
		Showdetails.add(uname);
		
		
		JTextField TxtUname=new JTextField();
		TxtUname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtUname.setBounds(310,180,340,30);
		Showdetails.add(TxtUname);
		TxtUname.setEditable(false);
			
		//Label for Gender-->
		JLabel glabel=new JLabel("Gender:");
		glabel.setFont(new Font("ARIAL", Font.BOLD,20));
		glabel.setHorizontalAlignment(SwingConstants.LEFT);
		glabel.setBounds(190, 230,190, 20);
		Showdetails.add(glabel);
		
		
		JTextField TxtGender=new JTextField();
		TxtGender.setHorizontalAlignment(SwingConstants.CENTER);
		TxtGender.setBounds(310,230,340,30);
		Showdetails.add(TxtGender);
		TxtGender.setEditable(false);
		

		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
			PreparedStatement st1= con.prepareStatement("select * from users where username=?");
			st1.setString(1, lusername);
			ResultSet rs1=st1.executeQuery();   
			while(rs1.next())
			{
			TxtFname.setText(rs1.getString(1));
			TxtLname.setText(rs1.getString(2));
			TxtUname.setText(rs1.getString(3));
			TxtGender.setText(rs1.getString(6));
			}				
		}
		catch(SQLException e){
		}
		catch (ClassNotFoundException e1) {
		}
		
		
//Panel for "Show_details" ends here.	
		
		
			
	
				
//Panel for Entering Student Username--->
		
		
		
		JPanel Suserpanel=new JPanel();
		Suserpanel.setLayout(null);
		Suserpanel.setBounds(230, 10, 1110,568);
		Suserpanel.setBackground(Color.blue);
		backuser.add(Suserpanel);
		Suserpanel.setVisible(false);
		
		
		//label for Student UserName--->

		JLabel Susername=new JLabel("Enter UserName:");
		Susername.setFont(new Font("ARIAL", Font.BOLD,20));
		Susername.setHorizontalAlignment(SwingConstants.LEFT);
		Susername.setBounds(190, 80, 190, 20);
		Suserpanel.add(Susername);
		
		//TextfField for Student UserName-->
		
		JTextField TxtUserName=new JTextField();
		TxtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		TxtUserName.setBounds(350,80,340,30);
		Suserpanel.add(TxtUserName);
		
		//Button for submit---> 
		
		JButton btn3=new JButton("Submit");
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(350,130,100,30);
		Suserpanel.add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sUsername=TxtUserName.getText().toLowerCase();	
			}
		});
		

//Panel ends for Entering Student UserName.
		
	
		
		
// panel for "ADD Marks"--->
		
		JPanel AddMarks=new JPanel();
		AddMarks.setLayout(null);
		AddMarks.setBounds(230, 10, 1110,568);
		AddMarks.setBackground(Color.white);
		backuser.add(AddMarks);
		AddMarks.setVisible(false);
		
	
		//Label for subject1-->
		
		
		JLabel Subject1=new JLabel("Subject1");
		Subject1.setFont(new Font("ARIAL", Font.BOLD,20));
		Subject1.setHorizontalAlignment(SwingConstants.LEFT);
		Subject1.setBounds(190, 80, 190, 20);
		AddMarks.add(Subject1);
		
		JTextField TxtS1=new JTextField();
		TxtS1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS1.setBounds(300,80,340, 30);
		AddMarks.add(TxtS1);
		
		
		
		//Label for Subject2-->

		JLabel Subject2=new JLabel("Subject2");
		Subject2.setFont(new Font("ARIAL", Font.BOLD,20));
		Subject2.setHorizontalAlignment(SwingConstants.LEFT);
		Subject2.setBounds(190, 120, 190, 20);
		AddMarks.add(Subject2);
		
		JTextField TxtS2=new JTextField();
		TxtS2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS2.setBounds(300,120,340,30);
		AddMarks.add(TxtS2);
		
		
		
		//Label for  Subject3-->

		JLabel Subject3=new JLabel("Subject3");
		Subject3.setFont(new Font("ARIAL", Font.BOLD,20));
		Subject3.setHorizontalAlignment(SwingConstants.LEFT);
		Subject3.setBounds(190, 160, 190, 20);
		AddMarks.add(Subject3);
		
		
		JTextField TxtS3=new JTextField();
		TxtS3.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS3.setBounds(300,160,340,30);
		AddMarks.add(TxtS3);
		
		//Label for Aggregate-->
		
		JLabel Aggregate=new JLabel("Aggregate");
		Aggregate.setFont(new Font("ARIAL", Font.BOLD,20));
		Aggregate.setHorizontalAlignment(SwingConstants.LEFT);
		Aggregate.setBounds(190, 200, 190, 20);
		AddMarks.add(Aggregate);
			
		
		JTextField TxtAggr=new JTextField();
		TxtAggr.setHorizontalAlignment(SwingConstants.CENTER);
		TxtAggr.setBounds(300,200,340,30);
		AddMarks.add(TxtAggr);
		TxtAggr.setEditable(false);
		
		JButton btnAddMarks=new JButton("Submit");
		btnAddMarks.setBounds(300, 240, 100, 30);
		AddMarks.add(btnAddMarks);
	   
//Panel for entering marks ends here.		
		
		userFrame.setVisible(true);
		
		
//Button action starts here
		
	     //	"Personal Details" button action Starts---->
		
		btn1.addActionListener(new ActionListener()
		   {
	          public void actionPerformed(ActionEvent e)
	       {
		
	
		/*     Connectivity co=new Connectivity();
		     co.connection(); */
	         Showdetails.setVisible(true);
	         
	         //details.setVisible(false);
	         
	         Suserpanel.setVisible(false);
	         
	         AddMarks.setVisible(false);
	        //	co.fdetails(lusername);
		}
		});
		
		//"Personal details" button action ends
		
		
		
		
		//"Add marks" button action starts--->
		
		btn2.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{
		
		
		Suserpanel.setVisible(true);
		AddMarks.setVisible(false);
		Showdetails.setVisible(false);
		
	}
		});
		

		
		
	// "Enter Student UserName" Submit button action starts-->	
		
	btn3.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{
	
		AddMarks.setVisible(true);
		Showdetails.setVisible(false);
		Suserpanel.setVisible(false);
	}
		});
		
	
	btnAddMarks.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String sub1,sub2,sub3,aggregate;
			sub1=TxtS1.getText();
			sub2=TxtS2.getText();
			sub3=TxtS3.getText();
			aggregate= Integer.toString(((Integer.parseInt(sub1)+Integer.parseInt(sub2)+Integer.parseInt(sub3))/3));
			TxtAggr.setText(aggregate);
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
				PreparedStatement ps=con.prepareStatement("update marks set Subject1=?, Subject2=?, Subject3=?, Aggregate=? where username=?");
				ps.setString(1, sub1);
			    ps.setString(2, sub2);
			    ps.setString(3, sub3);
			    ps.setString(4, aggregate);
			    ps.setString(5, sUsername);
			    System.out.println(sub1+" "+sub2+" "+sub3+" "+aggregate+" "+sUsername);
			    ps.executeUpdate();
			    
			    
			}
			catch(SQLException e1){
			}
			catch (ClassNotFoundException e1) {
			}
			
		}
	});
		
		
//Button actions ends here.

			
		
	}


	
	

}

