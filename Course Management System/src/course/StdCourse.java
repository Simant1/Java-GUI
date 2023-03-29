package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StdCourse {
	
	JFrame frame=new JFrame();
	JButton button=new JButton();
	JButton[] bcs=new JButton[5];
	JLabel label=new JLabel();
	JLabel lableOne=new JLabel();
	JPanel panel=new JPanel();
// course method	
	void allCourse(){
		
		conn();
		frame.setLayout(null);

		panel.setBounds(100,50,600,600);
		panel.setBackground(new Color(0,255,255));
		frame.setSize(800,800);
		frame.setTitle("Courses");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0,255,255));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(panel);
		
		  // button for back
        JButton buttonscb = new JButton("Back");
        buttonscb.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonscb.setBounds(550,50,100,30);
        frame.add(buttonscb);
        buttonscb.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
            	Student  std =new Student(); 
            	std.student();
            	
            	std.setVisible(true);
            	frame.setVisible(false);
            	
	     		
            }


        });

	
		
	ImageIcon image=new ImageIcon("logo.png");// create an image icon
	frame.setIconImage(image.getImage()); // change icon of frame
}
// connection to add course from database and display in jframe
void Module(String str) {
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql:///connection","root","");
		Statement myStatement=conn.createStatement();
		ResultSet myData=myStatement.executeQuery("select * from "+str);
		String all="";
		while(myData.next()) {
			if(myData.getString("LEVEL").equals("")) {
			all+=(myData.getString("Module_Code")+":"+myData.getString("Module_Name")+"<br>");
		}else {
			all+=(myData.getString("LEVEL")+"<br>"+myData.getString("Module_Code")+":"+myData.getString("Module_Name")+"<br>");
		}
			
			
		}
		
	
			panel.removeAll();
			panel.setVisible(false);
			lableOne.setText("<html>"+all+"</html>");
			panel.add(lableOne);
			panel.setVisible(true);
			panel.setBounds(100,50,600,600);
			
		
		
	}
	catch(Exception e) {
		System.out.println("Error \n"+e);
	}
	
}

// Connection for Course :
void conn() {
	try {
		Connection connection=DriverManager.getConnection("jdbc:mysql:///connection","root","");
		Statement myStatement=connection.createStatement();
		ResultSet myData=myStatement.executeQuery("select * from course");

		ArrayList<String> yes= new ArrayList<String>();
		while(myData.next()) {
			yes.add(myData.getString("course_name"));	
			
		}
		int x=0;
		for(x=0;x<yes.size();x++) {
			bcs[x]=new JButton();
			bcs[x].setText(yes.get(x));
			bcs[x].setFont(new Font("MV Boli",Font.BOLD,20));
			String name=yes.get(x);
			bcs[x].addActionListener(e->Module(name));
			panel.add(bcs[x]);
			
		}
		
	}catch(Exception e) {
		System.out.println("Error \n"+e);
	}
}


		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
		    
			
		
			StdCourse cs = new StdCourse();
			cs.allCourse();
			
		}
	}

	