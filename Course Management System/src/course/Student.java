package course;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Student {
	private JTextField userTextstd = new JTextField();
	private JTextField userTextstd1 = new JTextField();
	private JTextField userTextstd2 = new JTextField(); 
	private JTextField userTextstd3 = new JTextField(); 
	private JTextField userTextstd4 = new JTextField();
	private JTextField userTextstd5 = new JTextField();
	private JTextField userTextstd6 = new JTextField();
	private JComboBox combstd, combstd1, combstd2;
    private JTable tableat = new JTable();
    private JFrame framestd = new JFrame("Students");
	private JButton buttonstd=new JButton();
    private JLabel labelstd = new JLabel();
    private JPanel panel = new JPanel();
    private DefaultTableModel model = new DefaultTableModel();
    private JLabel Userlabelstd6 =new JLabel("STUDENT NUMBER: ");
    private JLabel Userlabelstd5 =new JLabel("SEMSETER: ");
    private JLabel Userlabelstd4 =new JLabel("LEVEL: ");
    private JButton buttonres = new JButton("Result:");
    private JLabel Userlabelstd9 =new JLabel("Student Number:");
    private JLabel Userlabelstd3 =new JLabel("COURSE: ");
    private JLabel Userlabelstd2 =new JLabel("EMAIL: ");
    private JLabel Userlabelstd1 =new JLabel("PHONE NUMBER: ");
    private JLabel Userlabelstd =new JLabel("FULL NAME: ");
    private ImageIcon firststd = new ImageIcon("sec.jpg");
    private JButton buttonstd2 = new JButton("SAVE DATA");
    private JButton buttonstd4 = new JButton("COURSES:");
    private JButton buttonstd1 = new JButton("Back");
    private JButton buttontecdet = new JButton("Teacher Details");
	void studentTable() {   // creating student table to display the course 
		try {
			String studentnumber=userTextstd6.getText();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM entermarks");
            ResultSet result=ps.executeQuery();
            boolean bol = false;
            while(result.next()) {
            	
            
        if (studentnumber.equals(result.getString("studentnumber"))) {
        	bol = true;
        	break;
        	
        }
            }
        if(bol) {
        	String res = "SELECT * FROM entermarks WHERE studentnumber="+"'"+studentnumber+"'";
        	PreparedStatement pre = conn.prepareStatement(res);
        	ResultSet rs = pre.executeQuery();
            tableat.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(null," Result","RESULT",JOptionPane.PLAIN_MESSAGE);
        }
        else {
        	JOptionPane.showMessageDialog(null,"error","ERROR",JOptionPane.PLAIN_MESSAGE);	
        }
        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }
	}
	// creating students methods 	
	    void student() {
	  
		
		framestd.getContentPane().setBackground(new Color(0,255,255));
		// Students Details
		
	    panel.setBounds(880, 80, 630, 690);
	    
	    framestd.add(panel);
	    String[] column= {"studentnumber", "fullname", "email", "course", "level", "semester", "marks", "modulename"};

	       
	      
	       model.setColumnIdentifiers(column);
	       //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
	       tableat = new JTable(model);
	       tableat = new JTable();
	       tableat.setModel(model); 
	       tableat.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	       tableat.setFillsViewportHeight(true);
	       JScrollPane s1 = new JScrollPane(tableat);
	       s1.setHorizontalScrollBarPolicy(
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       s1.setVerticalScrollBarPolicy(
	       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	       panel.add(s1);
	       panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));   
	       tableat.setPreferredScrollableViewportSize(new Dimension(550,600));
		  
		framestd.setTitle("Student");
		framestd.setSize(1600,1200); // size of whole page 
		framestd.setResizable(true);
	    framestd.setLayout(null);
	    framestd.setVisible(true);
        framestd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
	

		// top
		labelstd.setText("Students Enquire Form : ");
		labelstd.setVerticalAlignment(JLabel.TOP);
		labelstd.setBounds(100,80,750,700);
		labelstd.setFont(new Font("Serif",Font.BOLD,40));
		
	
           
		// Teacher details
	       
	        buttontecdet.setFont(new Font("Verdana", Font.PLAIN, 16));
	        buttontecdet.setBounds(150, 500, 180, 30);
	        labelstd.add(buttontecdet);
			buttontecdet.addActionListener(new ActionListener() 
				{
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog(null,"shown Teacher Details: ");
		    	TechDetStd  std = new TechDetStd ();
				std.TeacherDet();
				std.teachertable();
				 std.setVisible(true);
		         framestd.setVisible(false);	

		        }

		        });
	     
		
	
		
        
    	// for Back button
        
    
        buttonstd1.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonstd1.setBounds(50,30,100,30);
    
        framestd.add(buttonstd1);
        buttonstd1.addActionListener(new ActionListener() {
        	
            @Override
        public void actionPerformed(ActionEvent e) { 
            	
            	CMS cms = new CMS();
            	cms.Logincms();
            	
            	
                framestd.dispose(); 
    			

    			 }

        });
      
      
        // Courses avialble 

        buttonstd4.setFont(new Font("Verdana", Font.PLAIN, 20));
        buttonstd4.setBounds(450,280,165,50);
        labelstd.add(buttonstd4);
        buttonstd4.addActionListener(new ActionListener() 
		{
       public void actionPerformed(ActionEvent e) {
    	   JOptionPane.showMessageDialog(null,"Courses Avialble:");
    	   StdCourse cs = new StdCourse();
		   cs.allCourse();
    	   framestd.dispose();
     	 
     	  	
        }

        });
      
     
        //SAVE DATA BUTTON
      
        buttonstd2.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonstd2.setBounds(450, 500, 140, 30);

        labelstd.add(buttonstd2);
        buttonstd2.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent e) {
        	// printing in mini box 
        	JOptionPane.showMessageDialog(null,"Data saved  Sucessfully");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connstd=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
                PreparedStatement psstd=connstd.prepareStatement("insert into studentdetail(fullname,phonenumber,email,course,level,semester,studentnumber)values(?,?,?,?,?,?,?)");
                
   
                psstd.setString(1, userTextstd.getText());
                psstd.setString(2, userTextstd1.getText());
                psstd.setString(3, userTextstd2.getText());

                String levelstd;
                levelstd=combstd.getSelectedItem().toString();
                psstd.setString(4, levelstd);

                String levelstd2;
                levelstd2=combstd1.getSelectedItem().toString();
                psstd.setString(5, levelstd2);
                
                String levelstd3;
                levelstd3=combstd2.getSelectedItem().toString();
                psstd.setString(6, levelstd3);
                
                psstd.setString(7, userTextstd5.getText());
                
                int x=psstd.executeUpdate();
                if (x>0) {
                    System.out.println("Sucessfully isert");
                }
                else {
                    System.out.println("Not");
                }
              }catch(Exception ee) {
                  System.out.println(ee);
              }
            

              }

          });
        
        

     
	    // Image of Student
    

	JLabel labelstd4 = new JLabel(firststd);
	labelstd4.setBounds(450,70,200,200);
	labelstd.add(labelstd4);

  
    
    // Name

    Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd.setBounds(50,120,150,30); // X and Y with heights
    labelstd.add(Userlabelstd);
   
    userTextstd.setBounds(200, 120, 190, 30);
    labelstd.add(userTextstd);
	
    // Phone number 
   

    Userlabelstd1.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd1.setBounds(50,180,150,30); // X and Y with heights
	labelstd.add(Userlabelstd1);
   
    userTextstd1.setBounds(200, 180, 190, 30);
    labelstd.add(userTextstd1);
    
    // FOR EMAIL

    Userlabelstd2.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd2.setBounds(50,230,150,30); // X and Y with heights
	labelstd.add(Userlabelstd2);
   
    userTextstd2.setBounds(200, 230, 190, 30);
    labelstd.add(userTextstd2);
    
    // Course Choose

    Userlabelstd3.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd3.setBounds(50,280,190,30); // X and Y with heights
	labelstd.add(Userlabelstd3);
	
	
	
    // Course Result :
	  // Course Choose

    Userlabelstd9.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd9.setBounds(40, 590,200,30); // X and Y with heights
	labelstd.add(Userlabelstd9);
	
	
	 

    buttonres.setFont(new Font("Verdana", Font.PLAIN, 16));
    buttonres.setBounds(350, 590, 140, 30);
    labelstd.add(buttonres);
	buttonres.addActionListener(e->studentTable());
	
    
	userTextstd6.setBounds(200, 590, 140, 30);
    labelstd.add(userTextstd6);
	
	
    String[] levelstd= {"BIT","BIBM"};
    combstd = new JComboBox(levelstd);
    combstd.setBounds(200, 280, 190, 30);
    labelstd.add(combstd);
    combstd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ew) { 
            System.out.println(combstd.getSelectedItem());

          }

      });
   
    // FOR MODULE

    Userlabelstd4.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd4.setBounds(50,330,190,30); // X and Y with heights
	labelstd.add(Userlabelstd4);
	
	
    String[] levelstd2= {"LEVEL: 4","LEVEL: 5","LEVEL:6"};
    combstd1 = new JComboBox(levelstd2);
    combstd1.setBounds(200, 330, 190, 30);
    labelstd.add(combstd1);
    combstd1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ew) { 
            System.out.println(combstd1.getSelectedItem());

          }

      });
    
    // FOR SEMSESTER

    Userlabelstd5.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd5.setBounds(50,380,190,30); // X and Y with heights
	labelstd.add(Userlabelstd5);
	
	
    String[] levelstd3= {"SEMESTER: 1","SEMESTER:2"};
    combstd2 = new JComboBox(levelstd3);
    combstd2.setBounds(200, 380, 190, 30);
    labelstd.add(combstd2);
    combstd2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ew) { 
            System.out.println(combstd.getSelectedItem());

          }

      });
    
// Student Number:

    Userlabelstd6.setFont(new Font("Verdana", Font.PLAIN, 16));
    Userlabelstd6.setBounds(30,430,210,30); // X and Y with heights
	labelstd.add(Userlabelstd6);

	  
    userTextstd5.setBounds(200, 430, 190, 30);
    labelstd.add(userTextstd5);    
	
	
		// set color inside the border 
		labelstd.setOpaque(true); // we can only set color only if it is opaque
		labelstd.setBackground(new Color(244,212,124));
		panel.setOpaque(true); // we can only set color only if it is opaque
		panel.setBackground(new Color(244,212,124));
		
        
		framestd.add(labelstd);
	
		// for border 
		labelstd.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,  Color.red));
		panel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,  Color.red));

		ImageIcon Heraldstd = new ImageIcon("img.jpg"); // adding the image at the top 
		framestd.setIconImage(Heraldstd.getImage());

 
	    }
	    
	    
	   	   
     
	public static void main(String arg[])
	{
		Student  std =new Student(); 
		std.student();
	
			
		
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}



	}
