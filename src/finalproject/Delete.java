package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Delete extends JFrame {
	private JPanel contentPane;

    public Delete(String username) {
        setTitle("Delete");
        setSize(700, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(137, 209, 194));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel vehicleIdLabel = new JLabel("vehicle id:");
        vehicleIdLabel.setBackground(new Color(0, 0, 205));
        vehicleIdLabel.setForeground(new Color(248, 151, 29));
        vehicleIdLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        vehicleIdLabel.setBounds(160, 100, 186, 50);
        JTextField vehicleIdField = new JTextField(20);
        vehicleIdField.setBackground(new Color(255, 255, 255));
        vehicleIdField.setBorder(null);
        vehicleIdField.setForeground(new Color(248, 151, 29));
        vehicleIdField.setBounds(340, 100, 186, 50);
        vehicleIdField.setFont(new Font("Verdana", Font.BOLD, 18));

        contentPane.add(vehicleIdLabel);
        contentPane.add(vehicleIdField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBackground(new Color(0, 0, 205));
        usernameLabel.setForeground(new Color(248, 151, 29));
        usernameLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        usernameLabel.setBounds(160, 200, 186, 50);

        JTextField usernameField = new JTextField(20);
        usernameField.setBackground(new Color(255, 255, 255));
        usernameField.setBorder(null);
        usernameField.setForeground(new Color(248, 151, 29));
        usernameField.setBounds(340, 200, 186, 50);
        usernameField.setFont(new Font("Verdana", Font.BOLD, 18));
        
        contentPane.add(usernameLabel);
        contentPane.add(usernameField);
       
        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String User_name = usernameField.getText();
            	String vehicle_id = vehicleIdField.getText();
            	try {
            		if(User_name.length()==0 || vehicle_id.length()==0) {
            			 JOptionPane.showMessageDialog(deleteButton,"Fill in all the Details");
            		}
            		else {
            			Class.forName("org.postgresql.Driver");
               		    String jdbcURL = "jdbc:postgresql://localhost:5432/automobileCompany";
            	       	String jdbcusername = "postgres";
              		    String jdbcpassword = "subbu0456";
              		    Connection connection = DriverManager.getConnection(jdbcURL, jdbcusername,jdbcpassword);
                 	    System.out.print("Connected");
                 	    ResultSet rs ;
                 	   PreparedStatement st = connection
                               .prepareStatement("Select d_id from dealer where d_id =?;");
                                st.setString(1,User_name);
                               rs = st.executeQuery();
                       if(rs.next()) {
                    	   st = connection
                                   .prepareStatement("Select vehicle_id from vehicle where vehicle_id =?;");
                                    st.setString(1,vehicle_id);
                                   rs = st.executeQuery();
                          if(rs.next()) {
                        	  try {
                          		Class.forName("org.postgresql.Driver");
                         		    String URL = "jdbc:postgresql://localhost:5432/automobileCompany";
                      	       	  String dbcusername = "postgres";
                        		     String dbcpassword = "subbu0456";
                        		     connection = DriverManager.getConnection(URL, dbcusername,dbcpassword);
                           	     System.out.print("Connected");
                       			java.sql.Statement statement = connection.createStatement();
                      			String sql1 = "delete from vehicle where vehicle_id='"+vehicle_id+"';"; 
                      			statement.executeUpdate(sql1);
                      			
                      		 JOptionPane.showMessageDialog(deleteButton, "successfully deleted vehicle");
                          	  dispose();
                          	  DealerPage dp = new DealerPage(username);
                          	  dp.setVisible(true);                      		
                      		}
                      		catch(Exception ee) {
                      			ee.printStackTrace();
                      			System.err.println(ee.getClass().getName()+": "+ee.getMessage());
                      			System.exit(0);
                      		}
               
                  			  
                          }
                          else {
                        	  JOptionPane.showMessageDialog(deleteButton,"Vehicle Id is incorrect");
                          }
                       }
                       else {
                     	  JOptionPane.showMessageDialog(deleteButton,"User Id is incorrect");
                       }
                 	    
            		}
            	}
            	catch(Exception ee) {
        			ee.printStackTrace();
        			System.out.println(ee.getClass().getName()+": "+ee.getMessage());
        			System.exit(0);
        		}   
            }
        });
        deleteButton.setBounds(261, 350, 163, 46);
        deleteButton.setBackground(new Color(248, 151, 29));
        deleteButton.setBorder(null);
        deleteButton.setForeground(new Color(255,255,255));
        contentPane.add(deleteButton);   
        JButton returnbtn = new JButton(" Return");
        returnbtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        returnbtn.setBorder(null);
        returnbtn.setForeground(Color.white);
        returnbtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        DealerPage dp = new DealerPage(username);
        dp.setVisible(true);
        dispose();
        }
        });
        contentPane.add(returnbtn);
        returnbtn.setBounds(60, 350, 100, 46);
        returnbtn.setBackground(new Color(248, 151, 29));
        contentPane.add(returnbtn);
   }
}
