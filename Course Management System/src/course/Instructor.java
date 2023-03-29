package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class Instructor {
	ResultSet res;
    Connection connect;
    PreparedStatement pes;
    Statement state;
	
	@SuppressWarnings("rawtypes")
	private JComboBox combins1,combins2,combins3,combins4,combins5,combins6; 
	private JFrame frameins = new JFrame("Instructor");
	private JLabel labelins = new JLabel();
	private JPanel panelins = new JPanel();
    private JLabel Userlabelins =new JLabel("Instructor Details :");
    private ImageIcon firstins = new ImageIcon("teacher.jpg");
    private JLabel labelins4 = new JLabel(firstins);
    private JLabel Userlabelins1 =new JLabel("TECHER NAME :");
    private JLabel Userlabelins2 =new JLabel("COURSE :");
    private JLabel Userlabelins6 =new JLabel("SEMESTER:");
    private JLabel Userlabelins5 =new JLabel("LEVEL:");
    private JLabel Userlabelins4 =new JLabel("MODULE CODE:");
    private JLabel Userlabelins3 =new JLabel("MODULE NAME:");
    private JButton buttoninsb = new JButton("Back");
    private JButton buttonins8 = new JButton("Students Details");
    private JButton buttonins1 = new JButton("Enter Marks: ");
    
    
    
	void Instructor1() {      // method for creating frame for instructor 
		
		frameins.getContentPane().add(panelins); 
	    panelins.setLayout(null);
		frameins.getContentPane().setBackground(new Color(0, 255, 255));

		frameins.setTitle("Instructor");
		frameins.setSize(1600,1200); // size of whole page 
		frameins.setResizable(true);
		frameins.getContentPane().setLayout(null);
		frameins.setVisible(true);
	    frameins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panelins.setBounds(300,50,800,700);
		
	    // Instructor details 
	  
	       Userlabelins.setFont(new Font("Verdana", Font.PLAIN, 30));
	       Userlabelins.setBounds(230,20,500,40); // X and Y with heights
	       panelins.add(Userlabelins);
	       
	       // teacher image 
		
			
//			labelins4.setBounds(200,0,400,400);
//			labelins.add(labelins4);
//		    panelins.add(labelins4);
//		    
	        
	        // for  Teacher name
	      
	        Userlabelins1.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins1.setBounds(50,310,200,25); // X and Y with heights
	        panelins.add(Userlabelins1);
	        
		       // for TEACHER NAME 
		       String[] level= {};
		       combins1 = new JComboBox(level);
		       combins1.setBounds(200, 310, 165, 30);
		       panelins.add(combins1);
		       // Method Overriding 
		       combins1.addItemListener(new ItemListener() {
	                @Override
	                public void itemStateChanged(ItemEvent e) {
	                    String level=combins1.getSelectedItem().toString();
	                    String sql="Select * from addteacher where teachername='"+level+"'";
	     // Connection for instructor with its details:              
	                    try {

	                    	  PreparedStatement  pes=connect.prepareStatement(sql);
	                    	  ResultSet res=pes.executeQuery();
	                        while(res.next()) {
	                        	   combins2.setSelectedItem(res.getString("course"));
	                               combins3.setSelectedItem(res.getString("modulename"));
	                               combins4.setSelectedItem(res.getString("modulecode"));
	                               combins5.setSelectedItem(res.getString("level"));
	                               combins6.setSelectedItem(res.getString("semester"));
	                        }
	                    }catch(SQLException ed) {
	                        Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ed);
	                    }

	                      }
	                  });
	
		       combins1.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent ew) { 
		               System.out.println(combins1.getSelectedItem());

		             }

		         });  
	        //subject 
	        
	        // for  COURSE
	        
	        Userlabelins2.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins2.setBounds(50,380,200,25); // X and Y with heights
	        panelins.add(Userlabelins2);
	        
	        // for COURSE

	        String[] levelins2= {};
		    combins2 = new JComboBox(levelins2);
		    combins2.setBounds(200, 380, 165, 30);
		    panelins.add(combins2);
		       
	
	        // for MODULE NAME
	   
	        Userlabelins3.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins3.setBounds(50,450,200,25); // X and Y with heights
	        panelins.add(Userlabelins3);
	        

	        // for MODULE LEVEL 
		       String[] levelins3= {};
		       combins3 = new JComboBox(levelins3);
		       combins3.setBounds(200, 450, 165, 30);
		       panelins.add(combins3);
		       
	        
	        
	        // for  MODULE CODE
	
	        Userlabelins4.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins4.setBounds(390,310,200,25); // X and Y with heights
	        panelins.add(Userlabelins4);
	       
	        // for MODULE CODE 
		       String[] levelins4= {};
		       combins4 = new JComboBox(levelins4);
		       combins4.setBounds(550, 310, 165, 30);
		       panelins.add(combins4);
		       
		       
	        
	        // FOR LEVEL
	        
	        Userlabelins5.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins5.setBounds(390,380,200,25); // X and Y with heights
	        panelins.add(Userlabelins5);
	        
		       // for LEVEL 
		       String[] levelins5= {};
		       combins5 = new JComboBox(levelins5);
		       combins5.setBounds(550, 380, 165, 30);
		       panelins.add(combins5);
		       
		       
	       
	        
	        // FOR SEMESTER
	      
	        Userlabelins6.setFont(new Font("Verdana", Font.PLAIN, 16));
	        Userlabelins6.setBounds(390,450,200,25); // X and Y with heights
	        panelins.add(Userlabelins6);
	        
	        
	        
		       // for SEMESTER LEVEL 
		       String[] levelins6= {};
		       combins6 = new JComboBox(levelins6);
		       combins6.setBounds(550, 450, 165, 30);
		       panelins.add(combins6);
		       
	    
	        // enter marks button
	        
	      
	        buttonins1.setFont(new Font("Verdana", Font.PLAIN, 16));
	        buttonins1.setBounds(100, 610, 210, 40);  
	        panelins.add(buttonins1);
	        buttonins1.addActionListener(new ActionListener() 
			{
	       public void actionPerformed(ActionEvent e) {
	    	teacherMarks tm = new teacherMarks();
	   		tm.techMark();
	   		
	    	tm.setVisible(true);
	    	frameins.setVisible(false);
	    		
	       }

	        });
	 
	    
	       //Student details
		    
		  
		    buttonins8.setFont(new Font("Verdana", Font.PLAIN, 16));
		    buttonins8.setBounds(500,610,210,40);
		    panelins.add(buttonins8);
			buttonins8.addActionListener(new ActionListener() 
				{
		    public void actionPerformed(ActionEvent e) {
		    	  StddetInstructor st = new StddetInstructor();
		    	  st.StdInfo();
		    	  st.setVisible(true);
		         frameins.setVisible(false);	
		        }

		        });
		        
	     
	    // button for back
 
        buttoninsb.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttoninsb.setBounds(50,50,100,30);
        frameins.getContentPane().add(buttoninsb);
        buttoninsb.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
            	CMS cms = new CMS();
    			cms.Logincms();
    	        frameins.dispose(); 
    			}

        });
        frameins.getContentPane().add(labelins);
        
        
		// set color inside the border 
		panelins.setOpaque(true); // we can only set color only if it is opaque
		panelins.setBackground(new Color(0, 255, 0));
		frameins.getContentPane().add(panelins);
    	// for border 
		panelins.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
        // to make all visible and should be kept at button only 
        frameins.setVisible(true);//Make Frame Visible 
        
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void InsConn() {
        try {
             connect = DriverManager.getConnection("jdbc:mysql://:3306/connection","root","");
              state = connect.createStatement();
              res = state.executeQuery("select * from addteacher");
            while(res.next()){
                combins1.addItem(res.getString("teachername"));
                combins2.addItem(res.getString("course"));
                combins3.addItem(res.getString("modulename"));
                combins4.addItem(res.getString("modulecode"));
                combins5.addItem(res.getString("level"));
                combins6.addItem(res.getString("semester"));
                }
        } catch(SQLException asqw) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, asqw);
//The getLogger() method of a Logger class used find or create a logger.
//  If there is a logger exists with the passed name then the method will return
//that logger else method will create a new logger with that name and return it.
        }

    }
	

	public static void main(String[] args) {

		Instructor ins = new Instructor();
		ins.Instructor1();
		ins.InsConn();
		

	}
}

