import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

class Student  {
	
	Connection con;
	JTextField txtFname,txtLname,txtUname,txtGender,txtMarks,txtMarks1,txtMarks2,txtAggre,txtTotal,txtPaid,txtDues;
	
	Student(String lusername){


		JFrame userFrame=new JFrame("Student");
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
		btnPanel.setBounds(20,10,200,568);
		btnPanel.setBackground(Color.gray);
		backuser.add(btnPanel);

		
		//button actions
		
		JButton stu_btn1=new JButton("Student Details");
		stu_btn1.setBounds(20, 80, 140, 20);
		btnPanel.add(stu_btn1);
		

		JButton stu_btn2=new JButton("Academic Details");
		stu_btn2.setBounds(20, 120, 140, 20);
		btnPanel.add(stu_btn2);
		
		JButton stu_btn3=new JButton("Fees Details");
		stu_btn3.setBounds(20, 160, 140, 20);
		btnPanel.add(stu_btn3);
		
		JButton btnLogout=new JButton("Logout");
		btnLogout.setBounds(20, 240, 140, 20);	
		btnPanel.add(btnLogout);
		
		//   Student Details---->
		
		
		JPanel Student_panel=new JPanel();
		Student_panel.setBounds(230, 10, 1110,568);
		Student_panel.setBackground(Color.YELLOW);
		
		
		JLabel stdFname=new JLabel("FIRST NAME");
		stdFname.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdFname.setBounds(190,80,190,20);
		txtFname=new JTextField();
		txtFname.setBounds(310,80,340,30);
		
		
		
		JLabel stdLname=new JLabel("LAST NAME");
		stdLname.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdLname.setBounds(190,130, 190, 20);
		txtLname=new JTextField();
		txtLname.setBounds(310,130,340,30);
		
		
		JLabel stdUname=new JLabel("USERNAME");
		stdUname.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdUname.setBounds(190, 180, 190, 20);
		txtUname=new JTextField();
		txtUname.setBounds(310,180,340,30);
		
		
		JLabel stdGender=new JLabel("GENDER");
		stdGender.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdGender.setBounds(190, 230, 190, 20);
		txtGender=new JTextField();
		txtGender.setBounds(310,230,340,30);	
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
			PreparedStatement st1= con.prepareStatement("select * from users where username=?");
			st1.setString(1, lusername);
			ResultSet rs1=st1.executeQuery();   
			while(rs1.next())
			{
			txtFname.setText(rs1.getString(1));
			txtLname.setText(rs1.getString(2));
			txtUname.setText(rs1.getString(3));
			txtGender.setText(rs1.getString(6));
			}				
		}
		catch(SQLException e){
		}
		catch (ClassNotFoundException e1) {
		} 
		
		Student_panel.add(txtLname);
		Student_panel.add(stdLname);
		Student_panel.add(txtGender);
		Student_panel.add(stdGender);
		Student_panel.add(txtUname);
		Student_panel.add(stdUname);
		Student_panel.add(txtFname);
		Student_panel.add(stdFname);
		Student_panel.setLayout(null);
		
		
		txtFname.setEditable(false);
		txtLname.setEditable(false);
		txtUname.setEditable(false);
		txtGender.setEditable(false);		
		
		//  Academic Details---->
		
		
		JPanel Academics_panel=new JPanel();
		Academics_panel.setBounds(230, 10, 1110,568);
		Academics_panel.setVisible(false);
		Academics_panel.setBackground(Color.pink);

		JLabel stdMarks=new JLabel("SUBJECT 1");
		stdMarks.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdMarks.setBounds(190, 80, 190, 20);
		txtMarks=new JTextField();
		txtMarks.setBounds(315,80,340,30);
		
		
		
		JLabel stdMarks1=new JLabel("SUBJECT 2");
		stdMarks1.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdMarks1.setBounds(190, 130, 190, 20);
		txtMarks1=new JTextField();
		txtMarks1.setBounds(315,130,340,30);
		
		
		JLabel stdMarks2=new JLabel("SUBJECT 3");
		stdMarks2.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdMarks2.setBounds(190, 180, 190, 20);
		txtMarks2=new JTextField();
		txtMarks2.setBounds(315,180,340,30);
		
		
		JLabel stdAggre=new JLabel("AGGREGATE");
		stdAggre.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdAggre.setBounds(190, 230, 190, 20);
		txtAggre=new JTextField();
		txtAggre.setBounds(315,230,340,30);
		
		Academics_panel.add(txtMarks);
		Academics_panel.add(stdMarks);
		Academics_panel.add(txtAggre);
		Academics_panel.add(stdAggre);
		Academics_panel.add(txtMarks1);
		Academics_panel.add(stdMarks1);
		Academics_panel.add(txtMarks2);
		Academics_panel.add(stdMarks2);
		Academics_panel.setLayout(null);
		
		
		txtMarks.setEditable(false);
		txtMarks1.setEditable(false);
		txtMarks2.setEditable(false);
		txtAggre.setEditable(false);
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
			
			PreparedStatement st2= con.prepareStatement("select * from marks where username=?");
			st2.setString(1, lusername);
			ResultSet rs2=st2.executeQuery();   
			while(rs2.next())
			{
			txtMarks.setText(rs2.getString(2));
			txtMarks1.setText(rs2.getString(3));
			txtMarks2.setText(rs2.getString(4));
			txtAggre.setText(rs2.getString(5));
			}
				
		}
		catch(SQLException e){
		}
		catch (ClassNotFoundException e1) {
		} 
		
		
		
		//   Fee Details---->
		
		
		JPanel Fees_panel=new JPanel();
		Fees_panel.setBounds(230, 10, 1110,568);
		Fees_panel.setVisible(false);
		Fees_panel.setBackground(Color.CYAN);
		
		
		JLabel stdTotal=new JLabel("TOTAL FEES");
		stdTotal.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdTotal.setBounds(190, 80, 190, 20);
		txtTotal=new JTextField();
		txtTotal.setBounds(315,80,340,30);
		
		
		
		JLabel stdPaid=new JLabel("FEES PAID");
		stdPaid.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdPaid.setBounds(190, 130, 190, 20);
		txtPaid=new JTextField();
		txtPaid.setBounds(315,130,340,30);
		
		
		JLabel stdDues=new JLabel("FEES DUE");
		stdDues.setFont(new Font("ARIAL", Font.BOLD, 20));
		stdDues.setBounds(190, 180, 190, 20);
		txtDues=new JTextField();
		txtDues.setBounds(315,180,340,30);
		
		
		Fees_panel.add(stdTotal);
		Fees_panel.add(txtTotal);
		Fees_panel.add(stdPaid);
		Fees_panel.add(txtPaid);
		Fees_panel.add(stdDues);
		Fees_panel.add(txtDues);
		Fees_panel.setLayout(null);
		
		
		txtTotal.setEditable(false);
		txtPaid.setEditable(false);
		txtDues.setEditable(false);
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?useSSL=false","root","shashank");
			
			PreparedStatement st3= con.prepareStatement("select * from fee where username=?");
			st3.setString(1, lusername);
			ResultSet rs3=st3.executeQuery();   
			while(rs3.next())
			{
			txtTotal.setText(rs3.getString(3));
			txtPaid.setText(rs3.getString(2));
			txtDues.setText(rs3.getString(4));
			}
				
		}
		catch(SQLException e){
		}
		catch (ClassNotFoundException e1) {
		} 
		
		
		
		backuser.add(Student_panel);
		backuser.add(Academics_panel);
		backuser.add(Fees_panel);
		
		userFrame.setVisible(true);
		
		
		stu_btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Student_panel.setVisible(true);
				Academics_panel.setVisible(false);
				Fees_panel.setVisible(false);
		}
		});
		
		
		stu_btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Student_panel.setVisible(false);
				Academics_panel.setVisible(true);
				Fees_panel.setVisible(false);
				
			}
		});
		
		
		
		stu_btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Student_panel.setVisible(false);
				Academics_panel.setVisible(false);
				Fees_panel.setVisible(true);
			}
		});
			
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.f.setVisible(true);
				userFrame.setVisible(false);
				
			}
		});
		
	}


	
	

}
