package course;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// create a users class

class detailstd {
// making all the variables private inorder to acces them we need to use getter and setter methods
	
    private String fullname;
    private String phonenumber;
    private String email;
    private String course;
    private String level;
    private String semester;
    private String studentnumber;
    
 // Using the  Constructor   
    public detailstd (String fullname,String phonenumber,String email,String course, String level,String semester,String studentnumber){
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.course = course;
        this.level = level;
        this.semester = semester;
        this.studentnumber=studentnumber;
    }
    
    public String getfullname(){
        return this.fullname;
    }
    
    public String getphonenumber(){
        return this.phonenumber;
    }
    
    public String getemail(){
        return this.email;
    }
    
    public String getcourse(){
        return this.course;
    } 
    
    public String getlevel(){
        return this.level;
    } 
    
    public String getsemester(){
        return this.semester;
    } 
    
    public String getstudentnumber(){
        return this.studentnumber;
    }
  
}

public class StudentDetail{
 // Methods for student informations :   
     void studentinformation(){
    	 
    	 JFrame framestd = new JFrame();
     	 JPanel panelstd = new JPanel();
     	 
     	 framestd.setTitle("Student Details: ");
     	 framestd.setSize(1600,1200);
       
         framestd.setResizable(true);
		 framestd.setLayout(null);
		 
		 framestd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 framestd.getContentPane().setBackground(new Color(0,255,255));
		 panelstd.setBounds(20,60,750,650);
		  
        
         JTable tablestd = new JTable();
         tablestd.setPreferredScrollableViewportSize(new Dimension(670,510));
         
		

	     
	     // back for admin
	     
		    // button for back
	     JButton buttonstd2 = new JButton("BackAdm");
	     buttonstd2.setFont(new Font("Verdana", Font.PLAIN, 16));
	     buttonstd2.setBounds(550,20,120,40);
	     framestd.add(buttonstd2);
	     buttonstd2.addActionListener(new ActionListener() {
	         @Override
	     public void actionPerformed(ActionEvent e) { 
	        		Administration  ad = new Administration();
	        		
	    			ad.Adminiad();
	    			ad.Tablead();
	    		
	     		framestd.setVisible(false);
	     		
	     		ad.setVisible(true);
	            
	    	

	 			}

	     });

  
         DefaultTableModel modelstd = new DefaultTableModel();
         
         Object[] columnsNamestd = new Object[7];
         
         columnsNamestd[0] = "fullname";
         columnsNamestd[1] = "phonenumber";
         columnsNamestd[2] = "email";
         columnsNamestd[3] = "course";
         columnsNamestd[4] = "level";
         columnsNamestd[5] = "semester";
         columnsNamestd[6] = "studentnumber";
         
         
         modelstd.setColumnIdentifiers(columnsNamestd);
         
         Object[] rowDatastd = new Object[7];
         
         for(int i = 0; i < getUsers().size(); i++){
             
             rowDatastd[0] = getUsers().get(i).getfullname();
             rowDatastd[1] = getUsers().get(i).getphonenumber();
             rowDatastd[2] = getUsers().get(i).getemail();
             rowDatastd[3] = getUsers().get(i).getcourse();
             rowDatastd[4] = getUsers().get(i).getlevel();
             rowDatastd[5] = getUsers().get(i).getsemester();
             rowDatastd[6] = getUsers().get(i).getstudentnumber();
             
                
                modelstd.addRow(rowDatastd);
         }
         
         tablestd.setModel(modelstd);
         
         tablestd.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         tablestd.setFillsViewportHeight(true);
         JScrollPane s1std = new JScrollPane(tablestd);
         s1std.setHorizontalScrollBarPolicy(
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         s1std.setVerticalScrollBarPolicy(
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
         panelstd.add(s1std);
        
        framestd.setSize(800,750);
        framestd.setResizable(false);
        framestd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        framestd.setVisible(true);
        panelstd.setOpaque(true); // we can only set color only if it is opaque
		panelstd.setBackground(new Color(244,212,124));
       framestd.add(panelstd); 
        
        // STUDENT DETAILS
	       JLabel Userlabelstd =new JLabel("Student Admission Details :");
	       Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 40));
	       Userlabelstd.setBounds(250,20,500,40); // X and Y with heights
	       panelstd.add(Userlabelstd);
       
	       framestd.add(panelstd);
	       framestd.setVisible(true);
	       panelstd.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.CYAN));
    }
     

 // create a Function to get the connection
    static Connection getConnection(){
        Connection constd = null;
        
        try {
            constd = DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
        } catch (SQLException ex) {
            Logger.getLogger(detailstd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return constd;
    }
    
 // create a function to fill the an arraylist from database
    static ArrayList<detailstd> getUsers(){
        
        ArrayList<detailstd> users = new ArrayList<detailstd>();
        
        Connection constd = getConnection();
        
        Statement st;
        
        ResultSet rs;
        
        detailstd u;
        
        try {
            
            st = constd.createStatement();
            rs = st.executeQuery("SELECT * FROM studentdetail");
            
            while(rs.next()){
                
                u = new detailstd(
                        rs.getString("fullname"),
                        rs.getString("phonenumber"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getString("level"),
                        rs.getString("semester"),
                        rs.getString("studentnumber")
                );
                
                users.add(u);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(detailstd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
        
    }
  

    
    public static void main(String[] args){
        StudentDetail window = new  StudentDetail();
        window.studentinformation();
        
        
        
       
    }
}



