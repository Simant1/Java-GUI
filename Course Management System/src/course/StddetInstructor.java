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

class newdetail {
	 
 private String fullname;
 private String phonenumber;
 private String email;
 private String course;
 private String level;
 private String semester;
 private String studentnumber;
 
 public newdetail (String fullname,String phonenumber,String email,String course, String level,String semester,String studentnumber){
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

public class StddetInstructor {
	void StdInfo() {

	
		JFrame framestd = new JFrame();
    	 JPanel panelstd = new JPanel();
    	 
    	 framestd.setTitle("Student Details: ");
    	 framestd.setSize(900,900);
      
        framestd.setResizable(false);
		 framestd.setLayout(null);
		 
		 framestd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 framestd.getContentPane().setBackground(new Color(0,255,255));
		 panelstd.setBounds(20,50,750,650);
		  
       
        JTable tablestd = new JTable();
        tablestd.setPreferredScrollableViewportSize(new Dimension(670,510));
        
		

	     
 		
	    // button for back for instructor
     JButton buttonstd1 = new JButton("BackIns");
     buttonstd1.setFont(new Font("Verdana", Font.PLAIN, 16));
     buttonstd1.setBounds(50,10,100,40);
     framestd.add(buttonstd1);
     buttonstd1.addActionListener(new ActionListener() {
         @Override
     public void actionPerformed(ActionEvent e) { 
        	Instructor ins = new Instructor();
     		ins.Instructor1();
    		ins.InsConn();
    		
     		framestd.setVisible(false);
     		
     		ins.setVisible(true);
            
    	

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
     panelstd.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.CYAN));
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
     
  

	}

	 // create a Function to get the connection
	    static Connection getConnection(){
	        Connection constd = null;
	        
	        try {
	            constd = DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
	        } catch (SQLException ex) {
	            Logger.getLogger(newdetail.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return constd;
	    }
	    
	 // create a function to fill the an arraylist from database
	    static ArrayList<newdetail> getUsers(){
	        
	        ArrayList<newdetail> users = new ArrayList<newdetail>();
	        
	        Connection constd = getConnection();
	        
	        Statement st;
	        
	        ResultSet rs;
	        
	        newdetail u;
	        
	        try {
	            
	            st = constd.createStatement();
	            rs = st.executeQuery("SELECT * FROM studentdetail");
	            
	            while(rs.next()){
	                
	                u = new newdetail(
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
	            Logger.getLogger(newdetail.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return users;
	        
	    }
	  

  public static void main(String[] args){

	  StddetInstructor st = new StddetInstructor();
	  st.StdInfo();
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
