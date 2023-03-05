package finalproject;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import javaproject.Admin;
import javaproject.customerdetails;
import javaproject.ownerpg;

//import javaproject.loginpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LoginPage extends JFrame {
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JLabel usernameLabel,passwordLabel;
	private JPasswordField passwordTextField;
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    public LoginPage() {
        setBounds(100, 100, 631, 537);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(137, 209, 194));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        JLabel heading = new JLabel("Automobile Company");
		heading.setBackground(new Color(255, 228, 196));
        heading.setForeground(new Color(248, 151, 29));
        heading.setFont(new Font("Verdana", Font.BOLD, 24));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(150, 80, 346, 66);
        contentPane.add(heading);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBackground(new Color(0, 0, 205));
		usernameLabel.setForeground(new Color(248, 151, 29));
		usernameLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		usernameLabel.setBounds(150, 200, 186, 50);
        usernameTextField = new JTextField(20);
        usernameTextField.setForeground(new Color(0, 0, 0));
		usernameTextField.setBackground(new Color(236, 238, 241));
        usernameTextField.setBounds(295, 210, 225, 36);
		usernameTextField.setColumns(10);
		usernameTextField.setBorder(null);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(248, 151, 29));
		passwordLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		passwordLabel.setBounds(150, 260, 186, 50);
        passwordTextField = new JPasswordField(20);
        passwordTextField.setForeground(new Color(0, 0, 0));
		passwordTextField.setBackground(new Color(236, 238, 241));
		passwordTextField.setBounds(295, 268, 225, 36);
		passwordTextField.setBorder(null);

        contentPane.add(usernameLabel);
        contentPane.add(usernameTextField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordTextField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(248, 151, 29));
        loginButton.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
       		  String jdbcURL = "jdbc:postgresql://localhost:5432/automobileCompany";
  	       	  String jdbcusername = "postgres";
    		  String jdbcpassword = "subbu0456";
                String userName = usernameTextField.getText();
                String password = passwordTextField.getText();
                try {
                	Connection connection = DriverManager.getConnection(jdbcURL, jdbcusername,jdbcpassword);
                	System.out.print("Connected");
                	int flag=0;
                    PreparedStatement st = 
                   (PreparedStatement) connection.prepareStatement("Select c_id,password from Customer where c_id=? and password =?");
                    
                    

                    st.setString(1, userName);
                    st.setString(2, password);
                    
                    ResultSet rs = st.executeQuery();
                    
                    if (rs.next()) {
                        customerpage c = new customerpage();
                        dispose();
                        c.setVisible(true);
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                    } else {
                    	st=(PreparedStatement) connection.prepareStatement("Select d_id,password from dealer where d_id=? and password =?");
                    	st.setString(1, userName);
                        st.setString(2, password);
                        rs = st.executeQuery();
                        if (rs.next()) {
                            DealerPage c = new DealerPage();
                            dispose();
                            c.setVisible(true);
                            JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                        } 
                        else {
                        	st=(PreparedStatement) connection.prepareStatement("Select a_id,password from admin where a_id=? and password =?");
                        	st.setString(1, userName);
                            st.setString(2, password);
                            rs = st.executeQuery();
                            if (rs.next()) {
                                Admin c = new Admin();
                                dispose();
                                c.setVisible(true);
                                JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                            } 
                            else {
                            	LoginPage l = new LoginPage();
                           	    dispose();
                                l.setVisible(true);
                                JOptionPane.showMessageDialog(loginButton, "Wrong Username 'OR' Password");
                            }
                        }
                    }
                    
                    
                }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            
            }
        });
        loginButton.setFont(new Font("Verdana", Font.PLAIN, 17));
		loginButton.setBounds(200, 338, 128, 30);
		loginButton.setBorder(null);
		contentPane.add(loginButton);
		JButton signupButton = new JButton("Signup");
		signupButton.setBackground(new Color(248, 151, 29));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupPage accpage = new SignupPage();
				accpage.setVisible(true);
				dispose();
				
			}
		});
		signupButton.setFont(new Font("Verdana", Font.PLAIN, 17));
		signupButton.setBounds(350, 338, 128, 30);
		signupButton.setBorder(null);

		contentPane.add(signupButton);
		
    }

}
