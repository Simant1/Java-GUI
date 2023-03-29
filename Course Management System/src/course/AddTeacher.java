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

	public class AddTeacher {
		JTextField userTextat = new JTextField();
		JTextField userTextat1 = new JTextField();
		JTextField userTextat2 = new JTextField();
		JTextField userTextat3 = new JTextField();
		JTextField userTextat4 = new JTextField();
		JTextField userTextat5 = new JTextField();
		JTextField userTextat6 = new JTextField();
		JTable tableat = new JTable();

		JComboBox combat1 = new JComboBox();
		JComboBox combat2 = new JComboBox();
		
		// Connection for table 
		
		void teachertable() {
			try {
	            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
	            PreparedStatement ps=conn.prepareStatement("SELECT * FROM addteacher");
	            ResultSet result=ps.executeQuery();
	            tableat.setModel(DbUtils.resultSetToTableModel(result));


	        }catch(Exception d) {
	            JOptionPane.showMessageDialog(null,d);

	        }
		}
				
	// Methods for teacher 	
		void teacher() {
			JFrame frameat3 = new JFrame("Add Teacher");
			JLabel labelat = new JLabel();
			JPanel panelat = new JPanel();
			JPanel panelat1 = new JPanel();
			
			 
			
		    panelat.setLayout(null);
			frameat3.getContentPane().setBackground(new Color(0, 255, 255));

			frameat3.setTitle("Add Teacher");
			frameat3.setSize(1600,1200); // size of whole page 
			frameat3.setResizable(true);
			frameat3.getContentPane().setLayout(null);
			frameat3.setVisible(true);
		    frameat3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    panelat.setBounds(80,100,750,650);
		   

	        // ADD TEACHER 
		       JLabel Userlabelat =new JLabel("ADD TEACHER :");
		       Userlabelat.setFont(new Font("Verdana", Font.PLAIN, 30));
		       Userlabelat.setBounds(250,20,500,40); // X and Y with heights
		       panelat.add(Userlabelat);
		       
		       // for Teacher name
		       JLabel Userlabelat1 =new JLabel("TEACHER NAME :");
		       Userlabelat1.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat1.setBounds(110,80,350,40); // X and Y with heights
		       panelat.add(Userlabelat1);
		       userTextat.setBackground(new Color(255, 255, 255));
		       
		       userTextat.setBounds(80,130,250, 30);
		       panelat.add(userTextat);
		     
		       // COURSE NAME
		       
		       JLabel Userlabelat2 =new JLabel("COURSE  :");
		       Userlabelat2.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat2.setBounds(430,80,350,40); // X and Y with heights
		       panelat.add(Userlabelat2);
		       userTextat1.setBackground(new Color(255, 255, 255));
		       
		       userTextat1.setBounds(400,130,250, 30);
		       panelat.add(userTextat1);
		       
		       // MODULE NAME 
		       JLabel Userlabelat3 =new JLabel("MODULE NAME :");
		       Userlabelat3.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat3.setBounds(110,180,350,40); // X and Y with heights
		       panelat.add(Userlabelat3);
		       userTextat2.setBackground(new Color(255, 255, 255));
		       
		       userTextat2.setBounds(80,220,250, 30);
		       panelat.add(userTextat2);
		       
		       // MODULE CODE 
		       
		       JLabel Userlabelat4 =new JLabel("MODULE CODE :");
		       Userlabelat4.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat4.setBounds(430,180,350,40); // X and Y with heights
		       panelat.add(Userlabelat4);
		       
		       userTextat3.setBounds(400,220,250, 30);
		       panelat.add(userTextat3);
		       
		       
		       // LEVEL
		       
		       JLabel Userlabelat5 =new JLabel("LEVEL :");
		       Userlabelat5.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat5.setBounds(110,270,350,40);// X and Y with heights
		       panelat.add(Userlabelat5);
		    
		       // for LEVEL 
		       String[] levelat3= {"LEVEL : 4","LEVEL : 5","LEVEL : 6"};
		       combat1 = new JComboBox(levelat3);
		       combat1.setBackground(new Color(0, 255, 0));
		       combat1.setBounds(80,320,250, 30);
		       panelat.add(combat1);
		       combat1.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent ew) { 
		               System.out.println(combat1.getSelectedItem());

		             }

		         });
		       
		       // SEMESTER 
		       JLabel Userlabelat6 =new JLabel("SEMESTER :");
		       Userlabelat6.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat6.setBounds(430,280,350,40); // X and Y with heights
		       panelat.add(Userlabelat6);
		       
		       // for SEMESTER LEVEL 
		       String[] levelat4= {"SEM : 1s","SEM : 2"};
		       combat2 = new JComboBox(levelat4);
		       combat2.setBounds(400,330,250, 30);
		       panelat.add(combat2);
		       combat2.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent ew) { 
		               System.out.println(combat1.getSelectedItem());

		             }

		         });
		       
		       // for Teacher name
		       JLabel Userlabelat7 =new JLabel("TEACHER ID :");
		       Userlabelat7.setFont(new Font("Verdana", Font.PLAIN, 16));
		       Userlabelat7.setBounds(80,410,250, 30); // X and Y with heights
		       panelat.add(Userlabelat7);
		       
		       userTextat6.setBounds(200,410,250, 30);
		       panelat.add(userTextat6);
		       
		       
		     // ALL BUTTONS 
		       
		       // ADD BUTTON
		       JButton buttonat4 = new JButton("ADD ");
		       buttonat4.setFont(new Font("Verdana", Font.PLAIN, 16));
		       buttonat4.setBounds(80,500,170,30);
		       panelat.add(buttonat4);
		       buttonat4.addActionListener(new ActionListener() 
		        {
		        public void actionPerformed(ActionEvent e) {
		        	
	// Connection for adding the teacher from database to jframe table:	           
		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
		                PreparedStatement ps=conn.prepareStatement("insert into addteacher(teachername,course,modulename,modulecode,level,semester,teacherid)values(?,?,?,?,?,?,?)");
		                
		   
		                ps.setString(1, userTextat.getText());
		                ps.setString(2, userTextat1.getText());
		                ps.setString(3, userTextat2.getText());
		                ps.setString(4, userTextat3.getText());

		                String level3;
		                level3=combat1.getSelectedItem().toString();
		                ps.setString(5, level3);

		                String level4;
		                level4=combat2.getSelectedItem().toString();
		                ps.setString(6, level4);
		                
		                ps.setString(7, userTextat6.getText());
		                
		                
		                int x=ps.executeUpdate();
		                if (x>0) {
		                	JOptionPane.showMessageDialog(null,"Teacher Added  Sucessfully");
		                    System.out.println("Sucessfully isert");
		                }
		                else {
		                    System.out.println("Not");
		                }
		              }catch(Exception ee) {
		                  System.out.println(ee);
		              }
		            teachertable();

		              }

		          });
		       panelat1=new JPanel();
			   panelat1.setBounds(850,100,650,650);
		       String[] column= {"teachername","course","modulename","modulecode","level","semester","teacherid"};

	// creating JTable in Jframe :	       
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
		       panelat1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));   
		       tableat.setPreferredScrollableViewportSize(new Dimension(600,600));
		          
			
		    
		       
		       //DELETE BUTTON
		       JButton buttonat6 = new JButton("DELETE ");
		       buttonat6.setFont(new Font("Verdana", Font.PLAIN, 16));
		       buttonat6.setBounds(450,500,170,30);
		       panelat.add(buttonat6);
		       buttonat6.addActionListener(new ActionListener() 
		       {
		       public void actionPerformed(ActionEvent e) {
//Connection for delete code :		    	  
		           try {
		               Class.forName("com.mysql.cj.jdbc.Driver");
		               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
		               PreparedStatement ps=conn.prepareStatement("DELETE FROM addteacher where teacherid=?");
		               
		  
		               ps.setString(1, userTextat6.getText());
		               
		               
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
		           teachertable();

		             }

		         });

		       
		       
		    // button for back
	     JButton buttonatb = new JButton("Back");
	     buttonatb.setFont(new Font("Verdana", Font.PLAIN, 16));
	     buttonatb.setBounds(50,50,100,30);
	     frameat3.getContentPane().add(buttonatb);
	     buttonatb.addActionListener(new ActionListener() {
	         @Override
	     public void actionPerformed(ActionEvent e) { 
	     		Administration  ad = new Administration();
	     		ad.Adminiad();
				ad.Tablead();
	     		frameat3.setVisible(false);
	     		
	     		ad.setVisible(true);
	            
	    	

	 			}

	     });
		    
	        frameat3.getContentPane().add(labelat);
	        
			// set color inside the border 
			panelat1.setOpaque(true); // we can only set color only if it is opaque
			panelat1.setBackground(new Color(0, 255, 0));
			panelat.setOpaque(true); // we can only set color only if it is opaque
			panelat.setBackground(new Color(0, 255, 0));
			
			frameat3.getContentPane().add(panelat);
			frameat3.getContentPane().add(panelat1);
	    	// for border 
			panelat.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
			panelat1.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
	        // to make all visible and should be kept at button only 
	        frameat3.setVisible(true);//Make Frame Visible 
		    
			
		}
		public static void main(String[] args) {
			AddTeacher tech = new AddTeacher();
			tech.teacher();
			tech.teachertable();
				
		}
		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}

	}



		



