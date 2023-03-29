package course;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class EnterMarks {
	ResultSet res;
    Connection connect;
    PreparedStatement pes;
    Statement state;
	JTable tableat = new JTable();
	
	JTextField userTextat1 = new JTextField();
	JTextField userTextat2 = new JTextField();
	JTextField userTextat3 = new JTextField();
	JTextField userTextat4 = new JTextField();
	@SuppressWarnings("rawtypes")
	JComboBox combins1,combins2,combins3,combins4,combins5,combins6; 

	void studentTable() {
		try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM entermarks");
            ResultSet result=ps.executeQuery();
            tableat.setModel(DbUtils.resultSetToTableModel(result));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }
	}
			
	
	void Marks(String teachernumber) {
		JFrame frameins = new JFrame("Enter Marks: ");
		JLabel labelins = new JLabel();
		JPanel panelins = new JPanel();
		JPanel panelat1 = new JPanel();
		
		
		
		frameins.getContentPane().add(panelins); 
	    panelins.setLayout(null);
		frameins.getContentPane().setBackground(new Color(0, 255, 255));


       frameins.setResizable(false);
       frameins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frameins.setVisible(true);
       panelins.setVisible(true);
       
     
		
	    JLabel Userlabelstd =new JLabel("Enter Marks:");
	    Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 40));
	    Userlabelstd.setBounds(250,20,500,40); // X and Y with heights
	    panelins.add(Userlabelstd);

		frameins.setTitle("Enter Marks: ");
		frameins.setSize(1600,1200); // size of whole page 
		frameins.setResizable(true);
		frameins.getContentPane().setLayout(null);
		frameins.setVisible(true);
	    frameins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panelins.setBounds(50,80,800,700);
	    
	    
        // for  Teacher name
        JLabel Userlabelins1 =new JLabel("Student Number :");
        Userlabelins1.setFont(new Font("Verdana", Font.PLAIN, 16));
        Userlabelins1.setBounds(20,150,200,25); // X and Y with heights
        panelins.add(Userlabelins1);
        
	       // for Student Number 
	    String[] level= {};
	    combins1 = new JComboBox(level);
	    combins1.setBounds(180, 150, 200, 30);
	    panelins.add(combins1);
	    combins1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String level=combins1.getSelectedItem().toString();
                String sql="Select * from studentdetail where studentnumber='"+level+"'";
               
                try {

                	  PreparedStatement  pes=connect.prepareStatement(sql);
                	  ResultSet res=pes.executeQuery();
                    while(res.next()) {
                    	 combins2.setSelectedItem(res.getString("fullname"));
                         
                         combins4.setSelectedItem(res.getString("course"));
                         combins5.setSelectedItem(res.getString("level"));
                         combins6.setSelectedItem(res.getString("semester"));
                    }
                }catch(SQLException ed) {
                    Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ed);
                }

                  }
              });

      
	    
	    
	    
	    
	    // FullName
        // for  student name name
        JLabel Userlabelins2 =new JLabel("Full Name :");
        Userlabelins2.setFont(new Font("Verdana", Font.PLAIN, 16));
        Userlabelins2.setBounds(420,150,200,25); // X and Y with heights
        panelins.add(Userlabelins2);
        
	       // for Student Number 
	    String[] level2= {};
	    combins2 = new JComboBox(level2);
	    combins2.setBounds(550, 150, 200, 30);
	    panelins.add(combins2);
	    
  
        // for  Course Name
        JLabel Userlabelins4 =new JLabel("Course :");
        Userlabelins4.setFont(new Font("Verdana", Font.PLAIN, 16));
        Userlabelins4.setBounds(420,220,200,25); // X and Y with heights
        panelins.add(Userlabelins4);
        
	       // for course Name
	    String[] level4= {};
	    combins4 = new JComboBox(level4);
	    combins4.setBounds(550, 220, 200, 30);
	    panelins.add(combins4);
	    

        // for  Level
        JLabel Userlabelins5 =new JLabel("Level:");
        Userlabelins5.setFont(new Font("Verdana", Font.PLAIN, 16));
        Userlabelins5.setBounds(20,220,200,25); // X and Y with heights
        panelins.add(Userlabelins5);
        
	       // for level 
	    String[] level5= {};
	    combins5 = new JComboBox(level5);
	    combins5.setBounds(180, 220, 200, 30);
	    panelins.add(combins5);
	    
        // for  semester
        JLabel Userlabelins6 =new JLabel("Semester :");
        Userlabelins6.setFont(new Font("Verdana", Font.PLAIN, 16));
        Userlabelins6.setBounds(20,290,200,25); // X and Y with heights
        panelins.add(Userlabelins6);
        
	       // for course Name
	    String[] level6= {};
	    combins6 = new JComboBox(level6);
	    combins6.setBounds(180, 290, 200, 30);
	    panelins.add(combins6);

	    
	
	     // MODULE NAME 
	    JLabel Userlabelat7 =new JLabel("Module Name :");
	    Userlabelat7.setFont(new Font("Verdana", Font.PLAIN, 16));
	    Userlabelat7.setBounds(420,360,200,25); // X and Y with heights
	    panelins.add(Userlabelat7);
	       
	   userTextat1.setBounds(550, 360, 200, 30);
	   panelins.add(userTextat1);
	   try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
           PreparedStatement ps = con.prepareStatement("select modulename from addteacher where teacherid=?"); 
           ps.setString(1, teachernumber);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               userTextat1.setText(rs.getString("modulename"));

           }
           }
           catch(ClassNotFoundException | SQLException e)
           {
           System.out.println(e);
           }
	   
	   
	   
		
	     // MODULE CODE 
	    JLabel Userlabelat12 =new JLabel("Module Code:");
	    Userlabelat12.setFont(new Font("Verdana", Font.PLAIN, 16));
	    Userlabelat12.setBounds(420,290,200,25); // X and Y with heights 
	    panelins.add(Userlabelat12);
	       
	   userTextat4.setBounds(550, 290, 200, 30); 
	   panelins.add(userTextat4);
	   try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
           PreparedStatement ps = con.prepareStatement("select modulecode from addteacher where teacherid=?"); 
           ps.setString(1, teachernumber);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               userTextat4.setText(rs.getString("modulecode"));

           }
           }
           catch(ClassNotFoundException | SQLException e)
           {
           System.out.println(e);
           }
	   
	   
	   
	   // Enter Marks:
	    JLabel Userlabelat8 =new JLabel("Marks :");
	    Userlabelat8.setFont(new Font("Verdana", Font.PLAIN, 16));
	    Userlabelat8.setBounds(20,360,200,25); // X and Y with heights
	    panelins.add(Userlabelat8);
	       
	   userTextat2.setBounds(180, 360, 200, 30);
	   panelins.add(userTextat2);
	    
	   
	   // REMARKS
	   // Enter Marks:
	    JLabel Userlabelat9 =new JLabel("Remarks :");
	    Userlabelat9.setFont(new Font("Verdana", Font.PLAIN, 16));
	    Userlabelat9.setBounds(20,430,200,25); // X and Y with heights
	    panelins.add(Userlabelat9);
	       
	   userTextat3.setBounds(180, 430, 200, 30);//
	   panelins.add(userTextat3);
	   
	   
	   // Buttons used here
	   
	    
	    // ADD BUTTON
	    JButton buttonat4 = new JButton("Add Marks: ");
	    buttonat4.setFont(new Font("Verdana", Font.PLAIN, 16));
	    buttonat4.setBounds(80,570,170,30);
	    panelins.add(buttonat4);
	   
	    buttonat4.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent e) {
        	
           
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
                PreparedStatement ps=conn.prepareStatement("insert into entermarks(studentnumber,fullname,course,level,semester,marks,modulename,modulecode,remark)values(?,?,?,?,?,?,?,?,?)");
                
                String level;
                level=combins1.getSelectedItem().toString();
                ps.setString(1, level);
                
                String level2;
                level2=combins2.getSelectedItem().toString();
                ps.setString(2, level2);
                
             
                String level4;
                level4=combins4.getSelectedItem().toString();
                ps.setString(3, level4);
                
                String level5;
                level5=combins5.getSelectedItem().toString();
                ps.setString(4, level5);
                
                String level6;
                level6=combins6.getSelectedItem().toString();
                ps.setString(5, level6);
                
                ps.setString(6, userTextat2.getText());
                ps.setString(7, userTextat1.getText());
                ps.setString(8, userTextat4.getText());
                ps.setString(9, userTextat3.getText());
                
                int x=ps.executeUpdate();
                if (x>0) {
                	JOptionPane.showMessageDialog(null,"Marks Entered  Sucessfully");
                    System.out.println("Sucessfully isert");
                }
                else {
                    System.out.println("Not");
                }
              }catch(Exception ee) {
                  System.out.println(ee);
              }
            studentTable();

              }

          });
      
	  panelat1=new JPanel();
	  panelat1.setBounds(870,80,650,700);
       String[] column= {"studentnumber","fullname","course","level","semester","marks","modulename","modulecode","remark"};

       
       DefaultTableModel model = new DefaultTableModel();
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
       panelat1.add(s1);
       
       tableat.setPreferredScrollableViewportSize(new Dimension(600,650));
          
	    
	    // DELETE Button
	    JButton buttonat5 = new JButton("Delete Marks: ");
	    buttonat5.setFont(new Font("Verdana", Font.PLAIN, 16));
	    buttonat5.setBounds(500,570,170,30);
	    panelins.add(buttonat5);
	   
	    buttonat5.addActionListener(new ActionListener() 
	       {
	       public void actionPerformed(ActionEvent e) {
	    	  
	           try {
	               Class.forName("com.mysql.cj.jdbc.Driver");
	               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
	               PreparedStatement ps=conn.prepareStatement("DELETE FROM entermarks where studentnumber=?");
	               
	  
	               
	               String level;
	               level=combins1.getSelectedItem().toString();
	               ps.setString(1, level);
	               
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
	           studentTable();

	             }

	         });

	       
 		
	    // button for back for instructor
     JButton buttonem = new JButton("BackIns");
     buttonem.setFont(new Font("Verdana", Font.PLAIN, 16));
     buttonem.setBounds(50,20,100,40);
     frameins.getContentPane().add(buttonem);
     buttonem.addActionListener(new ActionListener() {
         @Override
     public void actionPerformed(ActionEvent e) { 
        	Instructor ins = new Instructor();
     		ins.Instructor1();
    		ins.InsConn();
    		
     		frameins.setVisible(false);
     		
     		ins.setVisible(true);
            
    	

 			}

     });
	   
	   
		// set color inside the border 
		panelins.setOpaque(true); // we can only set color only if it is opaque
		panelins.setBackground(new Color(0, 255, 0));
     
         panelat1.setOpaque(true); // we can only set color only if it is opaque
		 panelat1.setBackground(new Color(0, 255, 0));
		frameins.getContentPane().add(panelins);
		frameins.getContentPane().add(panelat1);
    	// for border 
		panelins.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
		panelat1.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));  
        // to make all visible and should be kept at button only 
        frameins.setVisible(true);//Make Frame Visible 
        
		
	}
	public void InsConn() {
        try {
             connect = DriverManager.getConnection("jdbc:mysql://:3306/connection","root","");
              state = connect.createStatement();
              res = state.executeQuery("select * from  studentdetail");
            while(res.next()){
                combins1.addItem(res.getString("studentnumber"));
                combins2.addItem(res.getString("fullname"));
               
                combins4.addItem(res.getString("course"));
                combins5.addItem(res.getString("level"));
                combins6.addItem(res.getString("semester"));
                }
        } catch(SQLException asqw) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, asqw);

        }

    }
	

	public static void main(String[] args) {
		EnterMarks en = new EnterMarks();
		en.Marks(null);
		en.InsConn();
		en.studentTable();
		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
