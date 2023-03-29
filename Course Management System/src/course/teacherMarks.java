package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class teacherMarks {
	JTextField userTextat = new JTextField();
	JTextField userTextat1 = new JTextField();
	JTextField userTextat2 = new JTextField();
	JFrame frameat3 = new JFrame("Adding Marks By Teacher :");
	
	
	JLabel label = new JLabel();
	JTable tableat = new JTable();
	
   void teacherMraks() {
	      String teachernumber= userTextat.getText();
		try {
			
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT teacherid FROM addteacher where teacherid=?");
            ps.setString(1, teachernumber);
            ResultSet result=ps.executeQuery();
            boolean bol = false;
            while(result.next()) {
            	
            
        if (teachernumber.equals(result.getString("teacherid"))) {
        	bol = true;
        	break;
        	
        }
            }
        if(bol) {
        	String res = "SELECT * FROM addteacher WHERE teacherid="+"'"+teachernumber+"'";
        	PreparedStatement pre = conn.prepareStatement(res);
        	ResultSet rs = pre.executeQuery();
        	EnterMarks en = new EnterMarks();
    		en.Marks(teachernumber);
    		en.InsConn();
    		en.studentTable();
    		en.setVisible(true);
	        frameat3.setVisible(false);
    		
           // JOptionPane.showMessageDialog(null," Result","RESULT",JOptionPane.PLAIN_MESSAGE);
        }
        else {
        	JOptionPane.showMessageDialog(null,"Teacher ID Wrong","ERROR",JOptionPane.PLAIN_MESSAGE);	
        }
        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }
	}
		
	
	
void techMark() {
		frameat3.getContentPane().setBackground(new Color(0,255,255));

		frameat3.setTitle("Adding Marks By Teacher: ");
		frameat3.setSize(550,550); // size of whole page 
		frameat3.setResizable(false);
		frameat3.setLayout(null);
		frameat3.setVisible(true);
	    frameat3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	    
	    JLabel Userlabelstd =new JLabel("Teacher  Details :");
	    Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 40));
	    Userlabelstd.setBounds(50,20,500,40); // X and Y with heights
	    frameat3.add(Userlabelstd);
 
	  
	    frameat3.setVisible(true);
	    
	       // teacher image 
			    ImageIcon firstins = new ImageIcon("icon2.png");
				JLabel labelins4 = new JLabel(firstins);
				labelins4.setBounds(50,0,400,400);
				
			    frameat3.add(labelins4);
	    
		 // TEACHER NAME
	       // for Teacher name
	       JLabel Userlabelat1 =new JLabel("TEACHER ID :");
	       Userlabelat1.setFont(new Font("Verdana", Font.PLAIN, 16));
	       Userlabelat1.setBounds(60,360,200,40); // X and Y with heights
	       frameat3.add(Userlabelat1);
	       
	       userTextat.setBounds(220,360,200,30);
	       frameat3.add(userTextat);
/*
	       // for MODULE name
	       JLabel Userlabelat2 =new JLabel("MODULE NAME :");
	       Userlabelat2.setFont(new Font("Verdana", Font.PLAIN, 16));
	       Userlabelat2.setBounds(40,170,200,40); // X and Y with heights
	       frameat3.add(Userlabelat2);
	       
	       userTextat1.setBounds(200,180,200,30);
	       frameat3.add(userTextat1);
*/	       
	       
		    // button for back for instructor
	        JButton buttonem = new JButton("BackIns");
	        buttonem.setFont(new Font("Verdana", Font.PLAIN, 16));
	        buttonem.setBounds(340,450,100,40);
	        buttonem.setBackground(Color.ORANGE);
	        frameat3.add(buttonem);
	        buttonem.addActionListener(new ActionListener() {
	            @Override
	        public void actionPerformed(ActionEvent e) { 
	           	Instructor ins = new Instructor();
	        		ins.Instructor1();
	       		ins.InsConn();
	       		
	        		frameat3.setVisible(false);
	        		
	        		ins.setVisible(true);
	               
	       	

	    			}

	        });
	        
	        
		    // button for back for instructor
	        JButton button1 = new JButton("Marks");
	        button1.setFont(new Font("Verdana", Font.PLAIN, 16));
	        button1.setBounds(60,450,100,40);
	        button1.setBackground(Color.ORANGE);
	        frameat3.add(button1);
	        button1.addActionListener(e->
	        {

	        	
				if (userTextat.getText().isEmpty())
	        	{
				JOptionPane.showMessageDialog(null," Teacher ID  Missing.....");
	        	}
	        	else 
	        		teacherMraks();
	        		
	        	}
	        	);

			
	        
	/*        

		 
		     

	       // for MODULE name
	       JLabel Userlabelat3 =new JLabel("MODULE NAME :");
	       Userlabelat3.setFont(new Font("Verdana", Font.PLAIN, 16));
	       Userlabelat3.setBounds(40,220,200,40); // X and Y with heights
	       frameat3.add(Userlabelat3);
	       
	       userTextat2.setBounds(200,230,200,30);
	       frameat3.add(userTextat2);
	       
	   */    
	        frameat3.setVisible(true);//Make Frame Visible 
		
		    
	}

	public static void main(String[] args) {
		teacherMarks tm = new teacherMarks();
		tm.techMark();
		tm.teacherMraks();
		
    	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
