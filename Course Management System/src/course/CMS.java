package course;            // Package name 

import java.awt.Color;     // Java Swing library
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CMS  {     
	 private JTextField userText = new JTextField(); 
	 private JPasswordField passwordText = new JPasswordField();
	@SuppressWarnings("rawtypes")
	 private JComboBox combcms = new JComboBox();//
	 private JPanel panelcms = new JPanel();
	 private JFrame framecms = new JFrame(); 
	 private JButton button1 = new JButton("Exit");
	 private JButton button4 = new JButton("ABOUT ME");
	 private JButton buttonlog = new JButton("Login");
	 private JLabel passwordLabel =new JLabel("Password:");
	 private JLabel Userlabel =new JLabel("Username:");
	 private JLabel Userlabel5 =new JLabel("Login:");
     private ImageIcon Herald = new ImageIcon("img.jpg"); // adding the image at the top 
	

 void Logincms() {                  // method for creating frame for login

		// Creating a frame
		
		framecms.setTitle("Course Management System");// Title of frame
		framecms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit our application
		framecms.setResizable(false);//size code
		framecms.setSize(730,630);//set the dimension for X and Y for  our frame
		
	
	     // login image box 
		ImageIcon img = new ImageIcon("login.png");
		JLabel labelcms = new JLabel(img);
		labelcms.setBounds(240,29,250,250);
		panelcms.add(labelcms);
		
	
		framecms.setIconImage(Herald.getImage()); //change image
		framecms.getContentPane().setBackground(new Color(0, 255, 0));// 0,255,255 Change color in background
        framecms.getContentPane().add(panelcms); 
        panelcms.setLayout(null);
		// label 
        

        Userlabel5.setFont(new Font("Verdana", Font.PLAIN, 18));
        Userlabel5.setBounds(170,300,100,35); // X and Y with heights
        panelcms.add(Userlabel5);
        
        
        // for LEVEL 
        String[] levelcms3= {"Student","Administration","Instructor"};
        combcms = new JComboBox(levelcms3);
        combcms.setBounds(290,300,165,35);
        panelcms.add(combcms);
        combcms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) { 
                System.out.println(combcms.getSelectedItem());

              }

          });
        
        
        // for User and user login box for printing name user

        Userlabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        Userlabel.setBounds(170,360,200,35); // X and Y with heights
        panelcms.add(Userlabel);
        
        // for user text fill of user 
        
        
        userText.setBounds(290, 360, 165, 35);
        panelcms.add(userText);
        
        // for password and password login box  
    
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setBounds(170, 410, 100, 35);
        panelcms.add(passwordLabel);
        
        // password text fill of password 
        
        passwordText.setBounds(290, 410, 165, 35);
        panelcms.add(passwordText);
        
        
        // for Buttons  for word login 

        buttonlog.setFont(new Font("Verdana", Font.PLAIN, 20));
        buttonlog.setBounds(100, 490, 100, 35);
       // buttonlog.setBackground(Color.ORANGE);
        panelcms.add(buttonlog);
        buttonlog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ee){
               
           // Connection for login different classes student, instructor and admin.
               try {
                   Connection con=null;
                   PreparedStatement pst=null;
                   ResultSet rs=null;
                   String query="SELECT * FROM `login` WHERE username=? and password=? and usertype=?";
                   con=DriverManager.getConnection("jdbc:mysql://localhost/connection","root","");
                   pst=con.prepareStatement(query);
                   pst.setString(1, userText.getText());
                   pst.setString(2, passwordText.getText());
                   pst.setString(3, String.valueOf(combcms.getSelectedItem()));
                   rs=pst.executeQuery();
                   if(rs.next()) {
                       JOptionPane.showMessageDialog(null,"Login Sucessfully");
                       
                   if(combcms.getSelectedIndex()==0) {
                       Student  std =new Student();
                      
               		   std.student();
                       
                       std.setVisible(true);
                       framecms.setVisible(false);
                      
                       }
                   else if(combcms.getSelectedIndex()==1) {
                	   
                        Administration  ad = new Administration();
                        ad.Adminiad();
            			ad.Tablead();
                       ad.setVisible(true);
                       framecms.setVisible(false);
                	   
                       }
                   else if(combcms.getSelectedIndex()==2) {
                	   Instructor ins = new Instructor();
                	   ins.Instructor1();
                	   ins.InsConn();
                       ins.setVisible(true);
                       framecms.setVisible(false);
                       }
                  
                   }
                   else {
                       JOptionPane.showMessageDialog(null,"Invalid username and password");
                   }
                   
  // Exception handling                  
               }catch(Exception ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
               }
               
                   
               
            }
        });
     
    
       
        
        
        
       /*
        
        // My Details
    
        button4.setFont(new Font("Verdana", Font.PLAIN, 20));
        button4.setBounds(490,300,175,45);
        //button4.setBackground(Color.ORANGE);
        panelcms.add(button4);
        button4.addActionListener(new ActionListener() 
		{
       public void actionPerformed(ActionEvent e) {
    	   profile pro = new profile();
    	   
		   pro.profdetail();
    	   pro.setVisible(true);
     		framecms.setVisible(false);	
        }

        });
        
  */
        // For exit  word exit 
  
        button1.setFont(new Font("Verdana", Font.PLAIN, 20));
        button1.setBounds(490, 490, 100, 35);
       // button1.setBackground(Color.ORANGE);
        panelcms.add(button1);
        // Method Overriding 
        button1.addActionListener((ActionListener) new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
              JOptionPane.showMessageDialog(null,"After this dialog box is closed your program is terminated");
              System.exit(0);

            }

        });
        
        
    	
		// for border 
		panelcms.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY)); 
        // to make all visible and should be kept at button only 
        framecms.setVisible(true);//Make Frame Visible 
        panelcms.setOpaque(true);
		
		panelcms.setBackground(new Color(0, 255, 0));
        
        

	}
	  
		   
		  public static void main(String args[]) {
			CMS cms = new CMS();
			cms.Logincms();
			
			
		}
		
		 public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
	   }

		



