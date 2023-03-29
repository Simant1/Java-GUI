package course;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Administration {
	private JTextField userTextad = new JTextField();
	private JTextField userTextad2 = new JTextField();
	private JTextField userTextad3 = new JTextField();
	private JTextField userTextad4 = new JTextField();
	private JTextField userTextad5 = new JTextField();
	private JTextField userTextad6 = new JTextField();
	
	private JTable tablead = new JTable();
	private JButton buttonad=new JButton();
	private JComboBox combad = new JComboBox();
	private JComboBox combad1 = new JComboBox();
	private JComboBox combad2 = new JComboBox();
	private JFrame framead2 = new JFrame("Administration");
	private JPanel panelad = new JPanel();
	private JPanel panelad1 = new JPanel();
	private JButton buttonad2 = new JButton("REPORT/RESULT");
	private JButton buttonad3 = new JButton("MANAGE TEACHER");
    private JButton buttonadb = new JButton("Back");
	private JButton buttonstd = new JButton("MANAGE COURSE:");
	private JButton buttonins8 = new JButton("STUDENT DETAILS");
	private JButton buttonad7 = new JButton("CLEAR COURSE");
    private JButton buttonad6 = new JButton("DELETE COURSE");
	private JButton buttonad5 = new JButton("UPDATE COURSE");
	private JButton buttonadad4 = new JButton("ADD COURSE");
	JLabel Userlabelad6 =new JLabel("Select the Semester to add Course :");
	JLabel Userlabelad5 =new JLabel("Select the level to add Course :");
	JLabel Userlabelad4 =new JLabel("Select the Course to add :");
	JLabel Userlabelad3 =new JLabel("Enter the Module Code to add :");
	JLabel Userlabelad2 =new JLabel("Enter the Module Name  to add :");
	JLabel Userlabelad =new JLabel("Course & Module administrator");
	
	
	
	
	// Connection for table 
	void Tablead() {
		try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM extracourse");
            ResultSet result=ps.executeQuery();
            tablead.setModel(DbUtils.resultSetToTableModel(result));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }
	}
	// Method for Admin :
	void Adminiad() {
	
		 framead2.getContentPane().add(panelad); 
	     panelad.setLayout(null);
		 
		 framead2.getContentPane().setBackground(new Color(0,255,255));
		
	
		
		// Students Details
		framead2.setTitle("Administration");
		framead2.setSize(1600,1200); // size of whole page 
		framead2.setResizable(true);
		framead2.setVisible(true);
		framead2.getContentPane().setLayout(null);
	    framead2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panelad.setBounds(20,20,750,750);
    
		 
		 
		 
       // Result and sheet 
       
       buttonad2.setBackground(Color.green);
       buttonad2.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonad2.setBounds(20,130,200,40);
       panelad.add(buttonad2);
	   buttonad2.addActionListener(new ActionListener() 
		{
       public void actionPerformed(ActionEvent e) {
    	AdminMarks ad = new AdminMarks();
   		ad.AdmMarks();
   		
   		ad.setVisible(true);
   		framead2.setVisible(false);
        }

        });
       
       
	   // teacher button 
      
       buttonad3.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonad3.setBackground(Color.green);
       buttonad3.setBounds(250,130,200,40);
       panelad.add(buttonad3);
	   buttonad3.addActionListener(new ActionListener() 
		{
       public void actionPerformed(ActionEvent e) {
       AddTeacher tech = new AddTeacher();
       tech.teacher();
	   tech.teachertable();
       tech.setVisible(true);
  	  framead2.setVisible(false);	
        }

        });

       
       Userlabelad.setFont(new Font("Verdana", Font.PLAIN, 30));
       Userlabelad.setBounds(120,30,500,40); // X and Y with heights
       panelad.add(Userlabelad);
   
       // for module to add 
  
       Userlabelad2.setFont(new Font("Verdana", Font.PLAIN, 16));
       Userlabelad2.setBounds(300,270,350,40); // X and Y with heights
       panelad.add(Userlabelad2);
       
       userTextad2.setBounds(300,310,250, 30);
       panelad.add(userTextad2);
       
       //module code 
  
       Userlabelad3.setFont(new Font("Verdana", Font.PLAIN, 16));
       Userlabelad3.setBounds(300,350,370,40); // X and Y with heights
       panelad.add(Userlabelad3);
       
       userTextad3.setBounds(300,390,250, 30);
       panelad.add(userTextad3);
       
       
       //module course 

       Userlabelad4.setFont(new Font("Verdana", Font.PLAIN, 16));
       Userlabelad4.setBounds(300,430,250, 30); // X and Y with heights
       panelad.add(Userlabelad4);
       // for course 
       String[] levelad2= {};
       combad = new JComboBox(levelad2);
       combad.setBounds(300,470,250, 30);
       panelad.add(combad);
     // Connection for manage course  
       try {
         Connection  connect = DriverManager.getConnection("jdbc:mysql://:3306/connection","root","");
         Statement   state = connect.createStatement();
          ResultSet   res = state.executeQuery("select * from managecourse");
          while(res.next()){
              
              combad.addItem(res.getString("coursename"));
              
              }
      } catch(SQLException asqw) {
          Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, asqw);

      }
       
  
       
    
       
       //COURSE  LEVEL 

       Userlabelad5.setFont(new Font("Verdana", Font.PLAIN, 16));
       Userlabelad5.setBounds(300,510,300, 30); // X and Y with heights
       panelad.add(Userlabelad5);
       
       
       // for LEVEL 
       String[] levelad3= {"LEVEL : 4","LEVEL : 5","LEVEL : 6"};
       combad1 = new JComboBox(levelad3);
       combad1.setBounds(300,550,250, 30);
       panelad.add(combad1);
       combad1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ew) { 
               System.out.println(combad1.getSelectedItem());

             }

         });
       
       //SEMESTER  LEVEL 
       
       Userlabelad6.setFont(new Font("Verdana", Font.PLAIN, 16));
       Userlabelad6.setBounds(300,590,300, 30); // X and Y with heights
       panelad.add(Userlabelad6);
       
       
       // for SEMESTER LEVEL 
       String[] levelad4= {"SEME: 1","SEME: 2"};
       combad2 = new JComboBox(levelad4);
       combad2.setBounds(300,630,250, 30);
       panelad.add(combad2);
       combad2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ew) { 
               System.out.println(combad2.getSelectedItem());

             }

         });

       // Main Buttons to add:
       
       // ADD BUTTON
       
  
       buttonadad4.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonadad4.setBounds(65,310,180,30);
      
       panelad.add(buttonadad4);
	   buttonadad4.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent e) {
//  Connection for Add button:      
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connad=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
              
                PreparedStatement ps=connad.prepareStatement("insert into extracourse(coursename,modulename,modulecode,addlevel,addsemester)values(?,?,?,?,?)");
             

                String levelad2;
                levelad2=combad.getSelectedItem().toString();
                ps.setString(1, levelad2);

               
                ps.setString(2, userTextad2.getText());
                ps.setString(3, userTextad3.getText());

                String levelad3;
                levelad3=combad1.getSelectedItem().toString();
                ps.setString(4, levelad3);
                
                String levelad4;
                levelad4=combad2.getSelectedItem().toString();
                ps.setString(5, levelad4);
                
                
                
                int x=ps.executeUpdate();
                if (x>0) {
                    System.out.println("Sucessfully isert");
                }
                else {
                    System.out.println("Not");
                }
              }catch(Exception ee) {
                  System.out.println(ee);
              }
              Tablead();

              }
              
          });
	   
	      
      
	   panelad1=new JPanel();
	   panelad1.setBounds(850,20,650,750);
       String[] columnad= {"coursename","modulename","modulecode","addlevel","addsemester"};

 // Creating the table for displaying the data       
       DefaultTableModel modelad = new DefaultTableModel();
       modelad.setColumnIdentifiers(columnad);
       //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
       tablead = new JTable(modelad);
       tablead = new JTable();
       tablead.setModel(modelad); 
       tablead.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
       tablead.setFillsViewportHeight(true);
       JScrollPane s1ad = new JScrollPane(tablead);
       s1ad.setHorizontalScrollBarPolicy(
       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       s1ad.setVerticalScrollBarPolicy(
       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
       panelad1.add(s1ad);
       panelad1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));
       tablead.setPreferredScrollableViewportSize(new Dimension(600,600));
       
       
       // EDIT BUTTON
     
       buttonad5.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonad5.setBounds(65,360,180,30);
       
       panelad.add(buttonad5);
       buttonad5.addActionListener(new ActionListener() 
       {
       public void actionPerformed(ActionEvent e) {
       	
 // Connection for update button:   	   
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection connad1=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");   
               PreparedStatement ps=connad1.prepareStatement(" UPDATE extracourse SET coursename=?,modulename=?,modulecode=?,addlevel=?,addsemester=? WHERE modulecode=?" );
               

               String levelad2;
               levelad2=combad.getSelectedItem().toString();
               ps.setString(1, levelad2);

              
               ps.setString(2, userTextad2.getText());
               ps.setString(3, userTextad3.getText());

               String levelad3;
               levelad3=combad1.getSelectedItem().toString();
               ps.setString(4, levelad3);
               
               String levelad4;
               levelad4=combad2.getSelectedItem().toString();
               ps.setString(5, levelad4);
               
               ps.setString(6, userTextad3.getText());
               
               int x=ps.executeUpdate();
               if (x>0) {
                   System.out.println("Update  Successfully");
               }
               else {
                   System.out.println("Not");
               }
             }catch(Exception ed) {
                 System.out.println(ed);
             }
             Tablead();

             }

         });
       
       
       //DELETE BUTTON
      
       buttonad6.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonad6.setBounds(65,410,180,30);
       
       panelad.add(buttonad6);
       buttonad6.addActionListener(new ActionListener() 
       {
       public void actionPerformed(ActionEvent e) {
    	   String delete=userTextad.getText();
           combad.removeItem(delete);
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection connad3=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
               PreparedStatement ps=connad3.prepareStatement("DELETE FROM extracourse where modulename=?");
               
  
               ps.setString(1, userTextad2.getText());
               
               
               int x=ps.executeUpdate();
               if (x>0) {
                   System.out.println("Delete Sucessfully");
               }
               else {
                   System.out.println("Not");
               }
             }catch(Exception ee) {
                 System.out.println(ee);
             }
             Tablead();

             }

         });

       
       
       
       //CLEAR BUTTON

       buttonad7.setFont(new Font("Verdana", Font.PLAIN, 16));
       buttonad7.setBounds(65,460,180,30);
      
       panelad.add(buttonad7);
       buttonad7.addActionListener(new ActionListener() {
           @Override
       public void actionPerformed(ActionEvent eer) { 
        	   userTextad.setText("");
        	   userTextad2.setText("");
               userTextad3.setText("");
           }

       });

      
       
       //Student details
	 
	    buttonins8.setFont(new Font("Verdana", Font.PLAIN, 16));
	    buttonins8.setBackground(Color.green);
	    buttonins8.setBounds(490,130,200,40);
	    panelad.add(buttonins8);
		buttonins8.addActionListener(new ActionListener() 
			{
	    public void actionPerformed(ActionEvent e) {
	    	 StudentDetail window = new  StudentDetail();
	         window.studentinformation();
	         framead2.setVisible(false);	
	        }

	        });
       
		
		// COURSE MANAGEMENT
   //Student details
	   
	    buttonstd.setFont(new Font("Verdana", Font.PLAIN, 16));
	    buttonstd.setBounds(250,210,200,40);
	    buttonstd.setBackground(Color.green);
	    panelad.add(buttonstd);
		buttonstd.addActionListener(new ActionListener() 
			{
	    public void actionPerformed(ActionEvent e) {
	   	 AdminCourse ad = new  AdminCourse();
		 ad.admincourse();
		framead2.setVisible(false);
 		ad.setVisible(true);
	        }

	        });
		
		
		
		
       // BACK BUTTON
  
        buttonadb.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonadb.setBounds(630,60,120,30);
        framead2.getContentPane().add(buttonadb);
        buttonadb.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
            	CMS cms = new CMS();
            	cms.Logincms();
    		framead2.setVisible(false);
    		cms.setVisible(true);
    			
         
    			

    			}

        });
        // 244,212,124
        
        
        
		// set color inside the border 
		panelad.setOpaque(true); // we can only set color only if it is opaque
		panelad1.setOpaque(true);
		panelad.setBackground(new Color(0, 255, 0));//244,212,124
		panelad1.setBackground(new Color(0, 255, 0));
		framead2.getContentPane().add(panelad);
		framead2.getContentPane().add(panelad1);
    	// for border 
		panelad.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
		panelad1.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
        // to make all visible and should be kept at button only 
        framead2.setVisible(true);//Make Frame Visible 
       
   
    	
	}
	
	public static void main(String[] args) {
		Administration  ad = new Administration();
		
			ad.Adminiad();
			ad.Tablead();
		
		
	

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


}
