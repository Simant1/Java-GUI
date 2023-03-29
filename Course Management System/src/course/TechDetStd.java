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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class TechDetStd {
	JFrame frameat3 = new JFrame("Add Teacher");
	JLabel labelat = new JLabel();
	JPanel panelat = new JPanel();
	JPanel panelat1 = new JPanel();
	JTable tableat = new JTable();
	 
	
	void teachertable() {
		try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT teachername,course,modulename,modulecode,level,semester FROM addteacher");
            ResultSet result=ps.executeQuery();
            tableat.setModel(DbUtils.resultSetToTableModel(result));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }
	}
			
	
	void TeacherDet() {

	
	   // panelat.setLayout(null);
		frameat3.getContentPane().setBackground(new Color(0,255,255));

		frameat3.setTitle("Add Teacher");
		frameat3.setSize(900,800); // size of whole page 
		frameat3.setResizable(false);
		frameat3.setLayout(null);
		frameat3.setVisible(true);
	    frameat3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panelat.setBounds(50,80,750,650);
	    
	    JLabel Userlabelstd =new JLabel("Teacher  Details :");
	     Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 40));
	     Userlabelstd.setBounds(150,20,500,40); // X and Y with heights
	     panelat.add(Userlabelstd);
 
	     frameat3.add(panelat);
	     frameat3.setVisible(true);
	     panelat1=new JPanel();
		 panelat1.setBounds(150,160,550,450);
	      String[] column= {"teachername","course","modulename","modulecode","level","semester"};

	       
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
	       panelat.add(s1);
	       panelat1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));   
	       tableat.setPreferredScrollableViewportSize(new Dimension(550,450));
		
	    
	   
     
        panelat.setOpaque(true); // we can only set color only if it is opaque
		panelat.setBackground(new Color(244,212,124));
		frameat3.add(panelat1);
    	// for border 
		panelat.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
        // to make all visible and should be kept at button only 
        frameat3.setVisible(true);//Make Frame Visible 
	    panelat.setVisible(true);
		
// back button
 		
	    // button for back for instructor
     JButton buttonstd1 = new JButton("Backstd");
     buttonstd1.setFont(new Font("Verdana", Font.PLAIN, 16));
     buttonstd1.setBounds(50,20,100,40);
     frameat3.add(buttonstd1);
     buttonstd1.addActionListener(new ActionListener() {
         @Override
     public void actionPerformed(ActionEvent e) { 
        	 Student  std =new Student(); 
     		std.student();
     		frameat3.setVisible(false);
     		
     		std.setVisible(true);
            
    	

 			}

     });
		
		
	}

	public static void main(String[] args) {
		TechDetStd  std = new TechDetStd ();
		std.TeacherDet();
		std.teachertable();

	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
