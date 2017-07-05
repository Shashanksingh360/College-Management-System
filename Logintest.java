import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Logintest{

	static JFrame f;
	JPanel home,courses,login,information,contact,footer;
	static JPanel nlogin;
	
	String lusername,lpassword,rfname,rlname,rpassword,rrole,rgender,rusername;
	
	
	//content for Slideshow
		JLabel pic;
		Timer tm;
		int x=0;
		
		String[] list={
				
				"C:/Users/SHASHANK SINGH/Desktop/CMS1.jpg",
				"C:/Users/SHASHANK SINGH/Desktop/CMS2.jpg"
		};
		
	 //Slideshow content end
	
	public static void main(String[] args) {
		
		new Logintest();

	}
	
	

	Logintest()
	{
		
		//To get screen size start
//				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//				screenSize.getHeight();
//				screenSize.getWidth();
//				int screenHeight = screenSize.height;
//				screenHeight=910;//screenHeight-50;
//				int screenWidth = screenSize.width;
		//To get screen size end
				
		f=new JFrame("College Management System");
		JLabel lblHeading=new JLabel("College Management System");
		lblHeading.setFont(new Font("ARIAL", Font.BOLD,40));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(0, 10, 1366, 70);
		f.add(lblHeading);
		
		//Buttons Design start
		
		//int btnWidth=397;//(screenWidth-120)/4;
		
		JButton b1=new JButton("Home");
		b1.setFont(new Font("ARIAL", Font.BOLD, 20));
		b1.setBounds(50, 80, 312, 40);
		
		JButton b2=new JButton("Login/Register");
		b2.setFont(new Font("ARIAL", Font.BOLD, 20));
		b2.setBounds(362, 80, 312, 40);
		
		JButton b3=new JButton("Courses");
		b3.setFont(new Font("ARIAL", Font.BOLD, 20));
		b3.setBounds(674, 80, 312, 40);
		
		JButton b4=new JButton("Contact us");
		b4.setFont(new Font("ARIAL", Font.BOLD, 20));
		b4.setBounds(986, 80, 312, 40);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		//Buttons Design end
		
		//Home panel design Start
		home=new JPanel();
		home.setBounds(50, 130, 1246, 468);
		home.setBackground(Color.BLUE);
		home.setLayout(null);
		// slideshow code start
		
				pic=new JLabel();
				pic.setBounds(0, 0, 1246, 468);
				SETImageSize(1);
				
				tm=new Timer(2000,new ActionListener(){
					
					
					public void actionPerformed(ActionEvent e){
						
						SETImageSize(x);
						x+=1;
						if(x>=list.length)
							x=0;
					}
					
				});		
				home.add(pic);
				tm.start();
				f.setLocationRelativeTo(null);
			    pic.setVisible(true);
				
		//slideshow code end
			    
		//Home panel design end
		
		//Courses panel design start
		
			    courses=new JPanel();
				courses.setBounds(50, 130, 1246, 468);
				courses.setVisible(false);
				//courses.setBackground(Color.cyan);
				courses.setLayout(null);   
				
				ImageIcon imgCourses = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/Courses.jpg");
				JLabel lblCourses = new JLabel("", imgCourses, JLabel.CENTER);
				courses.add(lblCourses);
				lblCourses.setBackground(Color.BLACK);
			    lblCourses.setBounds(10, 10, 1226, 448);
		//Courses panel design end 
		
		
		//Login panel design start
		login=new JPanel();
		login.setBounds(50, 130, 1246, 468);
		login.setVisible(false);
		login.setBackground(Color.DARK_GRAY);
		nlogin=new JPanel();
		JButton btnlogin=new JButton("Login");
		btnlogin.setBounds(130, 250, 80, 30);
		int nloginsx=20;//(50+screenWidth-120)/2-(50+screenWidth-120)/4-(50+screenWidth-120)/4+20;//20;//(50+screenWidth-120)/2-(50+screenWidth-120)/4-(50+screenWidth-120)/4+20; //Start X
		int nloginsy=20;//(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20;//465;//(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20; //Start Y
		int nloginex=600;//(50+screenWidth-180)/2-60;//835;//(50+screenWidth-180)/2-60; //End X
		int nloginey=428;//(130+screenHeight-300)/2+(130+screenHeight-300)/3-33;//110;//(130+screenHeight-300)/2+(130+screenHeight-300)/3-33; //End Y
		nlogin.setBounds(nloginsx, nloginsy, nloginex, nloginey);
		nlogin.setBackground(Color.WHITE);
		JLabel lblUserName=new JLabel("Username");
		lblUserName.setBounds(10, 100, 190, 20);
		lblUserName.setFont(new Font("ARIAL", Font.BOLD,20));
		JLabel lblPassword=new JLabel("Password");
		lblPassword.setBounds(10, 170, 190, 20);
		lblPassword.setFont(new Font("ARIAL", Font.BOLD,20));
		JTextField txtUserName=new JTextField();
		txtUserName.setBounds(120, 100, 200, 27);
		JPasswordField txtPassword=new JPasswordField();
		txtPassword.setBounds(120, 170, 200, 27);
		
		
		//Code for Adding Image on nlogin panel
				ImageIcon image = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms5.jpg");
				JLabel label = new JLabel("", image, JLabel.LEFT);
				nlogin.add(label);
			    label.setBounds(330, 80, 210, 200);
		
		JPanel register=new JPanel();
		int rsx=630;//(50+screenWidth-180)/2-60+40;//125;//(50+screenWidth-180)/2-60+40;
		int rsy=20;//(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20;//20;//(130+screenHeight-300)/2-(130+screenHeight-300)/4-(130+screenHeight-300)/4+20;
		int rex=595;//(50+screenWidth-180)/2-60+30+nloginex-nloginsx-770;//910;//(50+screenWidth-180)/2-60+30+nloginex-nloginsx-770;
		int rey=428;//(130+screenHeight-300)/2+(130+screenHeight-300)/3-33;//683;//(130+screenHeight-300)/2+(130+screenHeight-300)/3-33;
		register.setBounds(rsx,rsy, rex, rey);
		register.setBackground(Color.WHITE);
		JLabel lblFirstName,lblLastName,lblGender,lblRole,lblrpassword;
		lblFirstName=new JLabel("First Name");
		lblLastName=new JLabel("Last Name");
		lblrpassword=new JLabel("Password");
		lblGender=new JLabel("Gender");
		lblRole=new JLabel("Role");
		JTextField txtFname,txtLname;
		JPasswordField txtrpassword;
		txtFname=new JTextField();
		txtLname=new JTextField();
		txtrpassword=new JPasswordField();
		String[] role={"<--Select-->","Admin","Accountant","Faculty","Student"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox rcombo=new JComboBox(role);
		
		JRadioButton genderMale,genderFemale;
		ButtonGroup bg;
		genderMale=new JRadioButton("Male");
		genderMale.setActionCommand("Male");
		genderFemale=new JRadioButton("Female");
		genderFemale.setActionCommand("Female");
		bg=new ButtonGroup();    
		bg.add(genderMale);bg.add(genderFemale); 
		JButton btnRegister=new JButton("Register");
		
		lblFirstName.setBounds(210, 40, 190, 20);
		lblFirstName.setFont(new Font("ARIAL", Font.BOLD,20));
		txtFname.setBounds(320, 40, 200, 30);
		lblLastName.setBounds(210, 90, 190, 20);
		lblLastName.setFont(new Font("ARIAL", Font.BOLD,20));
		txtLname.setBounds(320, 90, 200, 30);
		lblrpassword.setBounds(210, 140, 190, 20);
		lblrpassword.setFont(new Font("ARIAL", Font.BOLD,20));
		txtrpassword.setBounds(320, 140, 200, 30);
		lblGender.setBounds(210, 190, 190, 20);
		lblGender.setFont(new Font("ARIAL", Font.BOLD,20));
		genderMale.setBounds(320, 190, 100, 20);
		genderMale.setFont(new Font("ARIAL", Font.BOLD,20));
		genderFemale.setBounds(420, 190, 100, 20);
		genderFemale.setFont(new Font("ARIAL", Font.BOLD,20));
		lblRole.setBounds(210, 240, 190, 20);
		lblRole.setFont(new Font("ARIAL", Font.BOLD,20));
		rcombo.setBounds(320, 240, 120, 20);
		rcombo.setFont(new Font("ARIAL", Font.BOLD,15));
		btnRegister.setBounds(380, 290, 100, 30);
		
		//Adding Image for registeration panel--->
		
				ImageIcon image2 = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms6.jpg");
				JLabel label2 = new JLabel("", image2, JLabel.LEFT);
				register.add(label2);
			    label2.setBounds(10, 80, 210, 200);
		
		
		nlogin.add(lblUserName);
		nlogin.add(txtUserName);
		nlogin.add(lblPassword);
		nlogin.add(txtPassword);
		nlogin.add(btnlogin);
		register.add(lblFirstName);
		register.add(txtFname);
		register.add(lblLastName);
		register.add(txtLname);
		register.add(lblrpassword);
		register.add(txtrpassword);
		register.add(lblGender);
		register.add(genderMale);
		register.add(genderFemale);
		register.add(lblRole);
		register.add(rcombo);
		register.add(btnRegister);
		nlogin.setLayout(null);
		register.setLayout(null);
		login.add(nlogin);
		login.add(register);
		login.setLayout(null);
		//Login panel design end
		
		/*//Information panel design start
				information=new JPanel();
				information.setBounds(50, 130, screenWidth-120, screenHeight-300);
				information.setVisible(false);
				information.setBackground(Color.MAGENTA);
				JLabel lblinfo=new JLabel("Info us will be here");
				lblinfo.setBounds(50, -50, 400, 250);
				information.add(lblinfo);
				information.setLayout(null);
		//Information panel design end*/
				
		//Contact panel design start
				contact=new JPanel();
				contact.setBounds(50, 130, 1246, 468);
				contact.setVisible(false);
				contact.setBackground(Color.WHITE);
				contact.setLayout(null);
				
				ImageIcon image3 = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms8.jpg");
				JLabel label3 = new JLabel("", image3, JLabel.LEFT);
				contact.add(label3);
			    label3.setBounds(50, 50, 220, 225);
				
			    
				ImageIcon image4 = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms9.jpg");
				JLabel label4 = new JLabel("", image4, JLabel.LEFT);
				contact.add(label4);
			    label4.setBounds(350, 50, 220, 225);
			    
			    
				ImageIcon image5 = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms10.jpg");
				JLabel label5 = new JLabel("", image5, JLabel.LEFT);
				contact.add(label5);
			    label5.setBounds(650, 40, 220, 225);
			    
			    
				ImageIcon image6 = new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms11.png");
				JLabel label6= new JLabel("", image6, JLabel.LEFT);
				contact.add(label6);
			    label6.setBounds(950, 50, 220, 225);
		//Contact panel design end
		
		//Footer panel design start
		footer=new JPanel();
		footer.setBounds(50 ,603, 1246, 60);
		footer.setLayout(null);
		
		ImageIcon image7= new ImageIcon("C:/Users/SHASHANK SINGH/Desktop/Java Training/Project/cms12.jpg");
		JLabel label7 = new JLabel("", image7, JLabel.LEFT);
		footer.add(label7);
	    label7.setBounds(0 ,0, 1350, 60);
		//Footer panel design end
		
		
		
		
		f.add(home);
		f.add(courses);
		f.add(login);
		f.add(footer);
		//f.add(information);
		f.add(contact);
		f.setBounds(0, 10, 1366, 718);
		f.setLayout(null);
		f.setVisible(true);
		
		//Button action starts here
		b1.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e){
				home.setVisible(true);
				courses.setVisible(false);
				login.setVisible(false);
				//information.setVisible(false);
				contact.setVisible(false);
			}
				});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				courses.setVisible(false);
				login.setVisible(true);
				//information.setVisible(false);
				contact.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				courses.setVisible(true);
				login.setVisible(false);
				//information.setVisible(true);
				contact.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				home.setVisible(false);
				courses.setVisible(false);
				login.setVisible(false);
				//information.setVisible(false);
				contact.setVisible(true);
			}
		});
			
		
			//Login Button action start
		
				btnlogin.addActionListener(new ActionListener()
						{
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e)
					{
						
						lusername=txtUserName.getText().toLowerCase();
						lpassword=txtPassword.getText();
						Connectivity co=new Connectivity();
						co.connection();
						co.loginVerification(lusername, lpassword);
						
						
					}
						});
		
			//Login Button action end
				
			//Register button action start
				btnRegister.addActionListener(new ActionListener(){
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e)
						{	
							rfname=txtFname.getText();
							rlname=txtLname.getText();
							rpassword=txtrpassword.getText();
							rgender=bg.getSelection().getActionCommand();
							rrole=(String)rcombo.getItemAt(rcombo.getSelectedIndex());
							rusername=rfname.substring(0, 1);
							Random random=new Random();
							String r=new String();
							r=Integer.toString(Math.abs(random.nextInt()));
							r=r.substring(0, 6);
							rusername=rusername + r + rlname ;
							rusername=rusername.toLowerCase();							
							Connectivity co=new Connectivity();
							co.connection();
							
							co.registration(rfname, rlname, rusername, rpassword, rrole, rgender);
							JOptionPane.showMessageDialog(register, "Registered successfully, Your username is "+ rusername);
						}
					});
			
			//Register button action end
		
		//Button action ends here
		
		
	}
	
	//Slideshow action start
	
		public  void SETImageSize(int i){
			ImageIcon icon=new ImageIcon(list[i]);
			Image img=icon.getImage();
			Image newImg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
			 ImageIcon newImc = new ImageIcon(newImg);
			 pic.setIcon(newImc);
			
		}
		
		//Slideshow action end
}

