package course;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class AdminMarks {
	JFrame frameam = new JFrame("ADMIN MARKS :");
	 JTable tableam = new JTable();
	 JTextField userTextstd6 = new JTextField();
	 JButton buttonam=new JButton();
	 JPanel panel2 = new JPanel();
     JPanel panelam = new JPanel();
     JTextArea areadis;
 
     // table method for marks printing 
     void AdminMarksTable1() { 
 		try {
 			String fullname=userTextstd6.getText();
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
             PreparedStatement ps=conn.prepareStatement("SELECT * FROM entermarks");
             ResultSet result=ps.executeQuery();
             boolean bol = false;
             while(result.next()) {
             	
             
         if (fullname.equals(result.getString("fullname"))) {
         	bol = true;
         	break;
         	
         }
             }
         if(bol) {
         	String res = "SELECT * FROM entermarks WHERE fullname="+"'"+fullname+"'";
         	PreparedStatement pre = conn.prepareStatement(res);
         	ResultSet rs = pre.executeQuery();
             tableam.setModel(DbUtils.resultSetToTableModel(rs));
             JOptionPane.showMessageDialog(null," Result","RESULT",JOptionPane.PLAIN_MESSAGE);
         }
         else {
         	JOptionPane.showMessageDialog(null,"error","ERROR",JOptionPane.PLAIN_MESSAGE);	
         }
         }catch(Exception d) {
             JOptionPane.showMessageDialog(null,d);

         }
 	}
 		
	 
	void AdmMarks() {
	
		frameam.getContentPane().setBackground(new Color(0, 255, 255));
		
	    panelam.setBounds(880, 80, 630, 690);
	  
	
	    String[] column= {"studentnumber", "fullname", "email", "course", "level", "semester", "marks", "modulename","modulecode","remarks"};

	       
	       DefaultTableModel model = new DefaultTableModel();
	       model.setColumnIdentifiers(column);
	       //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
	       tableam = new JTable(model);
	       tableam = new JTable();
	       tableam.setModel(model); 
	       tableam.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	       tableam.setFillsViewportHeight(true);
	       JScrollPane s1 = new JScrollPane(tableam);
	       s1.setHorizontalScrollBarPolicy(
	       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       s1.setVerticalScrollBarPolicy(
	       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	       panelam.add(s1);
	       panelam.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));   
	       tableam.setPreferredScrollableViewportSize(new Dimension(550,600));
		  
		
	   	frameam.setTitle("Student");
		frameam.setSize(1600,1200); // size of whole page 
		frameam.setResizable(true);
	    frameam.getContentPane().setLayout(null);
	    frameam.setVisible(true);
        frameam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
		panel2.setBackground(new Color(0, 255, 0));
		
        
		//panel2.setText("STUDENT RESULT  : ");
		//panel2.setVerticalAlignment(JLabel.TOP);
		panel2.setBounds(100,80,750,700);
		//panel2.setFont(new Font("Serif",Font.BOLD,40));
		
		areadis = new JTextArea();
	    areadis.setEditable(false);
	    areadis.setFont(new Font(Font.MONOSPACED, Font.PLAIN,25));
	    JScrollPane scrollPane_1 = new JScrollPane(areadis);
	    scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane_1.setPreferredSize(new Dimension(650, 650));
	    panel2.add(scrollPane_1);
	    
		
    	// for Back button
        
        JButton buttonstd1 = new JButton("Back");
        buttonstd1.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonstd1.setBounds(50,30,100,30);
    
        frameam.getContentPane().add(buttonstd1);
        buttonstd1.addActionListener(new ActionListener() {
        	
            @Override
        public void actionPerformed(ActionEvent e) { 
            	
            	Administration  ad = new Administration();
        		
    			ad.Adminiad();
    			ad.Tablead();
    		
            	
                frameam.dispose(); 
    			

    			 }

        });
	
    // Course Result :
	  // Course Choose
    JLabel Userlabelstd9 =new JLabel("Student Name:");
    Userlabelstd9.setFont(new Font("Verdana", Font.PLAIN, 25));
    Userlabelstd9.setBounds(350,30,250,30); // X and Y with heights
	frameam.getContentPane().add(Userlabelstd9);
	
	
	 
    JButton buttonres = new JButton("RESULT:");
    buttonres.setFont(new Font("Verdana", Font.PLAIN, 16));
    buttonres.setBounds(800,30,150,30);
    frameam.getContentPane().add(buttonres);
  
	buttonres.addActionListener(e->AdminMarksTable1());
	
    
	userTextstd6.setBounds(550,30,200,30);
    frameam.getContentPane().add(userTextstd6);
	
// for printing 	 
    JButton buttonpre = new JButton("PRINT :");
    buttonpre.setFont(new Font("Verdana", Font.PLAIN, 16));
    buttonpre.setBounds(1000,30,150,30);
    frameam.getContentPane().add(buttonpre);
    buttonpre.addActionListener(e->Detailarea() );
    
    
	// set color inside the border 
	//panel2.setOpaque(true); // we can only set color only if it is opaque
	//panel2.setBackground(new Color(244,212,124)); 
	panelam.setOpaque(true); // we can only set color only if it is opaque
	panelam.setBackground(new Color(0, 255, 0));
	
	frameam.getContentPane().add(panelam);
	frameam.getContentPane().add(panel2);

	// for border 
	panel2.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
	panelam.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));

	ImageIcon Heraldstd = new ImageIcon("img.jpg"); // adding the image at the top 
	frameam.setIconImage(Heraldstd.getImage());

	
	}
	public void Detailarea() {
		areadis.setText(areadis.getText()+"======================================================================================================\n");
		areadis.setText(areadis.getText()+"\t"+" Result of Student \n");
		areadis.setText(areadis.getText()+"======================================================================================================\n");
        DefaultTableModel model = (DefaultTableModel) tableam.getModel();
        for(int i=0; i<tableam.getRowCount(); i++) {
            String studentnumber=tableam.getValueAt(i,0).toString();
            String fullname=tableam.getValueAt(i,1).toString();
            String course=tableam.getValueAt(i,2).toString();
            String level=tableam.getValueAt(i,3).toString();
            String semester=tableam.getValueAt(i,4).toString();
            String marks=tableam.getValueAt(i,5).toString();
            String modulename=tableam.getValueAt(i,6).toString();
            String modulecode=tableam.getValueAt(i,7).toString();
            String remark=tableam.getValueAt(i,8).toString();
            areadis.setText(areadis.getText()+"studentnumber:"+studentnumber+"\n"+"fullname:"+fullname+"\n"+"course:"+course+"\n"+"level:"+level+"\n"+"semester:"+semester+"\n"+"marks:"+marks+"\n"+"modulename:"+modulename+"\n"+"modulecode:"+modulecode+"\n"+"remark:"+remark+"\n");
        }
        areadis.setText(areadis.getText()+"\n");

        areadis.setText(areadis.getText()+"===================================================================================================\n");
	}
	public static void main(String[] args) {
		AdminMarks ad = new AdminMarks();
		ad.AdmMarks();
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
