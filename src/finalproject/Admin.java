package finalproject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends JFrame {
	private JPanel contentPane;
    public Admin() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 775, 440);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(137, 209, 194));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton addboat = new JButton("View Cars");
        addboat.setFont(new Font("Verdana", Font.PLAIN, 18));
        addboat.setBounds(130, 100, 163, 46);
        addboat.setBackground(new Color(248, 151, 29));
        addboat.setBorder(null);
        addboat.setForeground(new Color(255,255,255));
        contentPane.add(addboat);
        
        JButton btnDelete = new JButton("Customer Details");
        btnDelete.setFont(new Font("Verdana", Font.PLAIN, 18));
        btnDelete.setBounds(450, 100, 163, 46);
        btnDelete.setBackground(new Color(248, 151, 29));
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBorder(null);
        contentPane.add(btnDelete);
        
        JButton viewOrders = new JButton("View Orders");
        viewOrders.setFont(new Font("Verdana", Font.PLAIN, 18));
        viewOrders.setBounds(450, 260, 163, 46);
        viewOrders.setBackground(new Color(248, 151, 29));
        viewOrders.setForeground(new Color(255, 255, 255));
        viewOrders.setBorder(null);
        contentPane.add(viewOrders);
        
        JLabel lblNewLabel = new JLabel("Admin Page");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 26));
        lblNewLabel.setForeground(new Color(248, 151, 29));
        lblNewLabel.setBounds(281, 25, 224, 30);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Dealer Details");
        btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        btnNewButton.setBounds(130, 260, 163, 46);
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
    	          Admin frame = new Admin();
    	          frame.setVisible(true);
    	        } catch (Exception e) {
    	          e.printStackTrace();
    	        }
    	      }
    	    });    
   }
}
