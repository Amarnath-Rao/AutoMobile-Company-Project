package finalproject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javaproject.boatregistration;
import javaproject.ownerpg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DealerPage extends JFrame {
	private JPanel contentPane;
    public DealerPage() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 775, 440);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(137, 209, 194));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton addboat = new JButton("Add Car");
        addboat.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        addboat.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  CarRegistration br = new CarRegistration();
        	  br.setVisible(true);
      		dispose();  
          }
        });
        
        addboat.setBounds(271, 100, 163, 46);
        addboat.setBackground(new Color(248, 151, 29));
        addboat.setBorder(null);
        addboat.setForeground(new Color(255,255,255));
        contentPane.add(addboat);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Verdana", Font.PLAIN, 18));
        btnDelete.setBounds(271, 200, 163, 46);
        btnDelete.setBackground(new Color(248, 151, 29));
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBorder(null);
        contentPane.add(btnDelete);
        
        JLabel lblNewLabel = new JLabel("Dealer Page");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 26));
        lblNewLabel.setForeground(new Color(248, 151, 29));
        lblNewLabel.setBounds(271, 25, 224, 30);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Car Details");
        /*
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
    				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
    				String query = "SELECT * FROM boat_registration";
    				  
    				  java.sql.Statement stm = connection.createStatement();
    				  ResultSet res = stm.executeQuery(query);
    				
    				  String columns[] = { "username", "boat_id", "model" };
    				  String data[][] = new String[8][3];
    				
    				  int i = 0;
    				  while (res.next()) {
    				    String id = res.getString("username");
    				    String nom = res.getString("boat_id");
    				    String model = res.getString("model");
    				    data[i][0] = id + "";
    				    data[i][1] = nom;
    				    data[i][2] = model;
    				    i++;
    				  }
    				
    				  DefaultTableModel model = new DefaultTableModel(data, columns);
    				  JTable table = new JTable(model);
    				  table.setShowGrid(true);
    				  table.setShowVerticalLines(true);
    				  JScrollPane pane = new JScrollPane(table);
    				  JFrame f = new JFrame("Populate JTable from Database");
    				  JPanel panel = new JPanel();
    				  panel.add(pane);
    				  f.getContentPane().add(panel);
    				  f.setSize(500, 250);
    				  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				  f.setVisible(true);
    			} catch (HeadlessException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
        });
        */
        btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        btnNewButton.setBounds(271, 300, 163, 46);
        btnNewButton.setBackground(new Color(248, 151, 29));
        btnNewButton.setForeground(new Color(255,255,255));
        btnNewButton.setBorder(null);
        contentPane.add(btnNewButton);
      }
    public static void main(String[] args) {
    	 String jdbcURL = "jdbc:postgresql://localhost:5432/houseboat";
    	    String username = "postgres";
    	    String password = "subbu0456";
    	    
    	    try {
    	      Connection connection = DriverManager.getConnection(jdbcURL, username, password);
    	      
    	      System.out.print("Connected");
    	          }
    	      catch(SQLException e) {
    	        System.out.println("Error in connection");
    	        e.printStackTrace();
    	      }
    	    EventQueue.invokeLater(new Runnable() {
    	      public void run() {
    	        try {
    	          DealerPage frame = new DealerPage();
    	          frame.setVisible(true);
    	        } catch (Exception e) {
    	          e.printStackTrace();
    	        }
    	      }
    	    });    
   }
}
