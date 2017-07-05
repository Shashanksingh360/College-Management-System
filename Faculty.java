import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
		//To get screen size start
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.getHeight();
		screenSize.getWidth();
		int screenHeight = screenSize.height;
		screenHeight=screenHeight-50;
		int screenWidth = screenSize.width;
		//To get screen size end

		JFrame userFrame=new JFrame("Faculty");
		userFrame.setLayout(null);
		userFrame.setBounds(0,0,1366,718);
		JLabel lblHeading=new JLabel("College Management System");
		lblHeading.setFont(new Font("ARIAL", Font.BOLD,40));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(0, 10, 1366, 70);
		userFrame.add(lblHeading);
		
		/*int usersx=(50+screenWidth-120)/2-(50+screenWidth-120)/4-(50+screenWidth-120)/4+20;//20;//(50+screenWidth-120)/2-(50+screenWidth-120)/4-(50+screenWidth-120)/4+20; //Start X
		int usersy=(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20;//465;//(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20; //Start Y
		int userex=(50+screenWidth-180)/2-60;//835;//(50+screenWidth-180)/2-60; //End X
		int userey=(130+screenHeight-300)/2+(130+screenHeight-300)/3-33;//110;//(130+screenHeight-300)/2+(130+screenHeight-300)/3-33; //End Y*/
		
	
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
		
		
		
		
			
/*	JLabel wellabel=new JLabel("Welcome");
		wellabel.setFont(new Font("ARIAL", Font.ITALIC,20));
		//wellabel.setHorizontalAlignment(SwingConstants.LEFT);
		wellabel.setBounds(25,150,50,200);
		wellabel.setForeground(Color.YELLOW);
		backuser.add(wellabel);     */	
		
		
//Panel for Details -->		
//		JPanel details=new JPanel();
//		details.setLayout(null);
//		details.setBounds(230, 10, 1110,568);
//		details.setBackground(Color.yellow);
//		backuser.add(details);
//		details.setVisible(true);
//		
		
		
		
		
//adding buttons in userpanel
			
			JButton btn1=new JButton("Personal Details");
			btn1.setBounds(20, 80, 140, 20);
			btnPanel.add(btn1);
			
			

			JButton btn2=new JButton("Add Marks");
			btn2.setBounds(40, 120, 100, 20);
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
		JLabel fname=new JLabel("FName:");
		fname.setFont(new Font("ARIAL", Font.BOLD,20));
		fname.setHorizontalAlignment(SwingConstants.LEFT);
		fname.setBounds(80, 10, screenWidth, 20);
		Showdetails.add(fname);
		
		JTextField TxtFname=new JTextField();
		TxtFname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtFname.setBounds(260,10,300,30);
		Showdetails.add(TxtFname);
		TxtFname.setEditable(false);
		
		
		//Label for Last name-->

		JLabel lname=new JLabel("LName:");
		lname.setFont(new Font("ARIAL", Font.BOLD,20));
		lname.setHorizontalAlignment(SwingConstants.LEFT);
		lname.setBounds(80, 60, screenWidth, 20);
		Showdetails.add(lname);
		
		JTextField TxtLname=new JTextField();
		TxtLname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtLname.setBounds(260,60,300,30);
		Showdetails.add(TxtLname);
		TxtLname.setEditable(false);
		
		
		
		//Label for User name-->

		JLabel uname=new JLabel("UserName:");
		uname.setFont(new Font("ARIAL", Font.BOLD,20));
		uname.setHorizontalAlignment(SwingConstants.LEFT);
		uname.setBounds(80,110, screenWidth, 20);
		Showdetails.add(uname);
		
		
		JTextField TxtUname=new JTextField();
		TxtUname.setHorizontalAlignment(SwingConstants.CENTER);
		TxtUname.setBounds(260,110,300,30);
		Showdetails.add(TxtUname);
		TxtUname.setEditable(false);
			
		//Label for Gender-->
		JLabel glabel=new JLabel("Gender:");
		glabel.setFont(new Font("ARIAL", Font.BOLD,20));
		glabel.setHorizontalAlignment(SwingConstants.LEFT);
		glabel.setBounds(80, 210, screenWidth, 20);
		Showdetails.add(glabel);
		
		
		JTextField TxtGender=new JTextField();
		TxtGender.setHorizontalAlignment(SwingConstants.CENTER);
		TxtGender.setBounds(260,210,300,30);
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
		Susername.setBounds(80, 10, screenWidth, 25);
		Suserpanel.add(Susername);
		
		//TextfField for Student UserName-->
		
		JTextField TxtUserName=new JTextField();
		TxtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		TxtUserName.setBounds(260,10,300,25);
		Suserpanel.add(TxtUserName);
		
		//Button for submit---> 
		
		JButton btn3=new JButton("Submit");
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setBounds(250,100,100,30);
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
		Subject1.setBounds(80, 10, screenWidth, 20);
		AddMarks.add(Subject1);
		
		JTextField TxtS1=new JTextField();
		TxtS1.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS1.setBounds(260,10,300, 30);
		AddMarks.add(TxtS1);
		
		
		
		//Label for Subject2-->

		JLabel Subject2=new JLabel("Subject2");
		Subject2.setFont(new Font("ARIAL", Font.BOLD,20));
		Subject2.setHorizontalAlignment(SwingConstants.LEFT);
		Subject2.setBounds(80, 50, screenWidth, 20);
		AddMarks.add(Subject2);
		
		JTextField TxtS2=new JTextField();
		TxtS2.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS2.setBounds(260,50,300,30);
		AddMarks.add(TxtS2);
		
		
		
		//Label for  Subject3-->

		JLabel Subject3=new JLabel("Subject3");
		Subject3.setFont(new Font("ARIAL", Font.BOLD,20));
		Subject3.setHorizontalAlignment(SwingConstants.LEFT);
		Subject3.setBounds(80, 90, screenWidth, 20);
		AddMarks.add(Subject3);
		
		
		JTextField TxtS3=new JTextField();
		TxtS3.setHorizontalAlignment(SwingConstants.CENTER);
		TxtS3.setBounds(260,90,300,30);
		AddMarks.add(TxtS3);
		
		//Label for Aggregate-->
		
		JLabel Aggregate=new JLabel("Aggregate");
		Aggregate.setFont(new Font("ARIAL", Font.BOLD,20));
		Aggregate.setHorizontalAlignment(SwingConstants.LEFT);
		Aggregate.setBounds(80, 130, screenWidth, 20);
		AddMarks.add(Aggregate);
			
		
		JTextField TxtAggr=new JTextField();
		TxtAggr.setHorizontalAlignment(SwingConstants.CENTER);
		TxtAggr.setBounds(260,130,300,30);
		AddMarks.add(TxtAggr);
		TxtAggr.setEditable(false);
		
		JButton btnAddMarks=new JButton("Submit");
		btnAddMarks.setBounds(120, 180, 100, 30);
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
		//details.setVisible(false);
		AddMarks.setVisible(false);
		Showdetails.setVisible(false);
		
	}
		});
		

		
		
	// "Enter Student UserName" Submit button action starts-->	
		
	btn3.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{
		
	    //details.setVisible(false);	
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

//	public static void main(String[] args){
//		new Faculty("S962333singh");
//	}
	
	

}

