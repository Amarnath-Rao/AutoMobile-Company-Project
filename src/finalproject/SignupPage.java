package finalproject;
import java.awt.*;
import javax.swing.JCheckBox;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import finalproject.SignupPage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

public class SignupPage extends JFrame {
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField phonenumberTextField,age,pincodeTextField,streetTextField,cityTextField,stateTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JPasswordField passwordTextField;
	private JTextField emailTextField;
	private JRadioButton Male,Female;
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    	public void run() {
    	try {
    	SignupPage frame = new SignupPage();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	
    	} catch (Exception e) {
    	e.printStackTrace();
    	}
    	}
    	});
        // Create a new JFrame
    }
   public SignupPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1248, 767);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(137, 209, 194));
        JLabel signupLabel = new JLabel("Signup");
        signupLabel.setBounds(475, 42, 193, 43);
        signupLabel.setFont(new Font("Verdana", Font.BOLD, 39));
        signupLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(signupLabel);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        usernameLabel.setBounds(96, 119, 160, 33);
        usernameLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(usernameLabel);
        
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        firstNameLabel.setBounds(96, 208, 122, 33);
        firstNameLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(firstNameLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        lastNameLabel.setBounds(610, 208, 122, 33);
        lastNameLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(lastNameLabel);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        passwordLabel.setBounds(610, 119, 225, 33);
        passwordLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(passwordLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        emailLabel.setBounds(610, 300, 108, 33);
        emailLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(emailLabel);
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Verdana", Font.PLAIN, 21));
        pincode.setBounds(96, 400, 133, 21);
        pincode.setForeground(new Color(248, 151, 29));
        contentPane.add(pincode);
        
        JLabel street = new JLabel("Street");
        street.setFont(new Font("Verdana", Font.PLAIN, 21));
        street.setBounds(96, 500, 133, 21);
        street.setForeground(new Color(248, 151, 29));
        contentPane.add(street);
        
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("Verdana", Font.PLAIN, 21));
        state.setBounds(96, 600, 133, 21);
        state.setForeground(new Color(248, 151, 29));
        contentPane.add(state);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("Verdana", Font.PLAIN, 21));
        city.setBounds(610, 500, 108, 33);
        city.setForeground(new Color(248, 151, 29));
        contentPane.add(city);
        
        JLabel AgeLabel = new JLabel("Age");
        AgeLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        AgeLabel.setBounds(610, 400, 108, 33);
        AgeLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(AgeLabel);
        
        JLabel phoneLabel = new JLabel("Phone No");
        phoneLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        phoneLabel.setBounds(96,300, 127, 33);
        phoneLabel.setForeground(new Color(248, 151, 29));
        contentPane.add(phoneLabel); 
        
        
        
        usernameTextField = new JTextField();
        usernameTextField.setBounds(261, 119, 223, 33);
        usernameTextField.setColumns(10);
        usernameTextField.setBorder(null);
        contentPane.add(usernameTextField);


        phonenumberTextField = new JTextField();
        phonenumberTextField.setColumns(10);
        phonenumberTextField.setBounds(261, 300, 223, 33);
        phonenumberTextField.setBorder(null);
        contentPane.add(phonenumberTextField);

        JRadioButton customerbtn = new JRadioButton("Customer");
        customerbtn.setFont(new Font("Verdana", Font.BOLD, 16));
        buttonGroup.add(customerbtn);
        customerbtn.setForeground(new Color(248, 151, 29));
        customerbtn.setBackground(new Color(137, 209, 194));
        customerbtn.setBounds(660, 600, 133, 21);
        contentPane.add(customerbtn);

        JRadioButton ownerbtn = new JRadioButton("Owner");
        ownerbtn.setFont(new Font("Verdana", Font.BOLD, 16));
        buttonGroup.add(ownerbtn);
        ownerbtn.setForeground(new Color(248, 151, 29));
        ownerbtn.setBounds(660, 650, 103, 21);
        ownerbtn.setBackground(new Color(137, 209, 194));
        contentPane.add(ownerbtn);
        ownerbtn.setText("Owner");
        customerbtn.setText("Customer");

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(261, 208, 223, 33);
        contentPane.add(firstNameTextField);
        firstNameTextField.setColumns(10);
        firstNameTextField.setBorder(null);

        lastNameTextField = new JTextField();
        lastNameTextField.setColumns(10);
        lastNameTextField.setBounds(777, 208, 223, 33);
        lastNameTextField.setBorder(null);
        contentPane.add(lastNameTextField);

        JButton returnbtn = new JButton(" Return");
        returnbtn.setFont(new Font("Verdana", Font.BOLD, 18));
        returnbtn.setBorder(null);
        returnbtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        LoginPage logpg = new LoginPage();
        logpg.setVisible(true);
        dispose();
        }
        });
        returnbtn.setBounds(100, 60, 95, 33);
        returnbtn.setBackground(new Color(248, 151, 29));
        contentPane.add(returnbtn);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(777, 119, 225, 33);
        passwordTextField.setBorder(null);
        contentPane.add(passwordTextField);
        

        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(777, 300, 223, 33);
        emailTextField.setBorder(null);
        contentPane.add(emailTextField);
        
        age = new JTextField();
        age.setColumns(10);
        age.setBounds(777, 400, 223, 33);
        age.setBorder(null);
        contentPane.add(age);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setColumns(10);
        pincodeTextField.setBounds(261, 400, 223, 33);
        pincodeTextField.setBorder(null);
        contentPane.add(pincodeTextField);
        
        streetTextField = new JTextField();
        streetTextField.setColumns(10);
        streetTextField.setBounds(261, 500, 223, 33);
        streetTextField.setBorder(null);
        contentPane.add(streetTextField);
        
        cityTextField = new JTextField();
        cityTextField.setColumns(10);
        cityTextField.setBounds(777, 500, 223, 33);
        cityTextField.setBorder(null);
        contentPane.add(cityTextField);
        
        stateTextField = new JTextField();
        stateTextField.setColumns(10);
        stateTextField.setBounds(261, 600, 223, 33);
        stateTextField.setBorder(null);
        contentPane.add(stateTextField);

        Male = new JRadioButton("Male");
        Male.setText("M");
        Male.setForeground(new Color(248, 151, 29));
        Female = new JRadioButton("Female");
        Female.setForeground(new Color(248, 151, 29));
        Female.setText("F");
        Male.setBounds(800,600,100,20);
        Male.setBorder(null);
        Male.setFont(new Font("Verdana",Font.PLAIN,18));
        Male.setBackground(new Color(137, 209, 194));
        Female.setBounds(800,650,100,20);
        Female.setBorder(null);
        Female.setFont(new Font("Verdana",Font.PLAIN,18));
        Female.setBackground(new Color(137, 209, 194));
        contentPane.add(Male);
        contentPane.add(Female);
        ButtonGroup b = new ButtonGroup();
        b.add(Male);
        b.add(Female);
       
        JButton createbtn = new JButton("SIGN UP");
        createbtn.setForeground(Color.BLACK);
        createbtn.setBackground(new Color(248, 151, 29));
        createbtn.setFont(new Font("Verdana", Font.BOLD, 18));
        createbtn.addActionListener(new ActionListener() {
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
        	
        	String Firstname = firstNameTextField.getText();
   		 	String Lastname = lastNameTextField.getText();
   		 	String CAge = age.getText();
   		 	String Cstreet = street.getText();
   		 	String Ccity = city.getText();
   		 	String Cstate = state.getText();
   		 	String email = emailTextField.getText();
   		 	String PHNO = phonenumberTextField.getText();
            String CID= usernameTextField.getText();
            String passwd = passwordTextField.getText(); 
            String pinc = pincodeTextField.getText();
            String gender="";
            String change="";
            if (Male.isSelected()) {
            	  
                gender = "M";
            }

            else if (Female.isSelected()) {

                gender = "F";
            }
            if (customerbtn.isSelected()) {
          	  
                change="customer";
            }

            else if (ownerbtn.isSelected()) {

                change = "owner";
            }
            
            try {
            
            	if(Firstname.length() == 0 || Lastname.length() == 0  || CAge.length() == 0 ||  email.length()==0
            	  ||  Cstreet.length() == 0		|| Ccity.length() == 0  || Cstate.length() == 0 || PHNO.length() == 0  || CID.length() == 0 
            			 || passwd.length() == 0 || gender.length()==0 ) {
                	
                    JOptionPane.showMessageDialog(createbtn,"Fill in all the Details");
                }
            	
            	else if(Integer.parseInt(CAge) < 1) {
                		
                        JOptionPane.showMessageDialog(createbtn,"Please Enter valid age");  
                    
            	}
            	else if(PHNO.length()!=10) {
            		
                    JOptionPane.showMessageDialog(createbtn,"Enter valid Phone Number"); 
        		
        	}
            else if(passwd.length()<6) {
            		
                    JOptionPane.showMessageDialog(createbtn,"Password should have minimum of 6 characters");
            	}
            else {
                	try {
            			Class.forName("org.postgresql.Driver");
                		 String jdbcURL = "jdbc:postgresql://localhost:5432/automobileCompany";
             	       	  String jdbcusername = "postgres";
               		     String jdbcpassword = "subbu0456";
               		     Connection connection = DriverManager.getConnection(jdbcURL, jdbcusername,jdbcpassword);
                  	     System.out.print("Connected");
                  	      ResultSet rs ;
                  	     if(change.equals("customer")) {
                  	    	PreparedStatement st = connection
                                    .prepareStatement("Select c_id from customer where c_id =?;");
                                     st.setString(1,CID);
                                    rs = st.executeQuery();
                  	     }
                  	     else {
                  	    	PreparedStatement st = connection
                                    .prepareStatement("Select d_id from dealer where d_id =?;");
                                     st.setString(1,CID);
                                    rs = st.executeQuery();
                  	     }
                   
                	if (rs.next()) {
                		
                        JOptionPane.showMessageDialog(createbtn, "Username already exists");
                        dispose();
                        SignupPage sp = new SignupPage();
                        sp.setVisible(true);
                        connection.close();
                    } 
                    else {
                    	try {
                    		Class.forName("org.postgresql.Driver");
                   		    String URL = "jdbc:postgresql://localhost:5432/automobileCompany";
                	       	  String dbcusername = "postgres";
                  		     String dbcpassword = "subbu0456";
                  		     connection = DriverManager.getConnection(URL, dbcusername,dbcpassword);
                     	     System.out.print("Connected");
                 			java.sql.Statement statement = connection.createStatement();
                			String sql1 = 
                			"insert into customer " +
                			"values ( '"+CID+"', '"+ Firstname +"','"
                			+ Lastname +"', '"+ gender+"', '"+email+"',"+CAge+", '"+Cstreet+"','"
                			+Ccity +"', '"+ Cstate +"', "
                			+pinc+", "+PHNO+",'"+passwd+"');"; 
                			String sql2="insert into dealer " +
                        			"values ( '"+CID+"', '"+ Firstname +"','"
                        			+ Lastname +"', '"+ gender+"', '"+email+"',"+CAge+", '"+Cstreet+"','"
                        			+Ccity +"', '"+ Cstate +"', "
                        			+pinc+", "+PHNO+",'"+passwd+"');"; 
                			if(change.equals("customer")) {
                			statement.executeUpdate(sql1);
                			}
                			else {
                				statement.executeUpdate(sql2);
                			}
                			
                			JOptionPane.showMessageDialog(createbtn, "successfully created account");
                			dispose();
                			LoginPage lp = new LoginPage();
                			lp.setVisible(true);
                		
                		}
                		catch(Exception ee) {
                			ee.printStackTrace();
                			System.err.println(ee.getClass().getName()+": "+ee.getMessage());
                			System.exit(0);
                		}
                			
                } 
                    connection.close();
                		}
                		catch (SQLException sqlException) {
                            sqlException.printStackTrace();
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
    
            	
        createbtn.setBounds(1000, 60, 133, 33);
        contentPane.add(createbtn);
    }
}
