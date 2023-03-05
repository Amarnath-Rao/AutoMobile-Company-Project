package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarRegistration extends JFrame {

  private JPanel contentPane;
  private JTextField UserName;
  private JTextField Car_id;
  private JTextField model;
  private JTextField type;
  private JTextField brand;
  private JTextField Seater,Price,Age;

  /*
   * Launch the application.
   */
  public static void main(String[] args) {
    String jdbcURL = "jdbc:postgresql://localhost:5432/houseboat";
    String username = "postgres";
    String password = "Rkp@1801";
    
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
          CarRegistration frame = new CarRegistration();
          frame.setResizable(false);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /*
   * Create the frame.
   */
  public CarRegistration() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 790);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setBackground(new Color(137, 209, 194));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Car Registration");
    lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 30));
    lblNewLabel.setBounds(210, 120, 350, 40);
    lblNewLabel.setForeground(new Color(248, 151, 29));
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Username");
    lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1.setBounds(125, 217, 129, 40);
    lblNewLabel_1.setForeground(new Color(248, 151, 29));
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_1_1 = new JLabel("Car ID");
    lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_1.setBounds(125, 267, 129, 40);
    lblNewLabel_1_1.setForeground(new Color(248, 151, 29));

    contentPane.add(lblNewLabel_1_1);
    
    JLabel typeLabel = new JLabel("Type");
    typeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
    typeLabel.setBounds(125, 317, 129, 40);
    typeLabel.setForeground(new Color(248, 151, 29));
    contentPane.add(typeLabel);
    
    JLabel lblNewLabel_1_2 = new JLabel("Model");
    lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_2.setBounds(125, 367, 129, 40);
    lblNewLabel_1_2.setForeground(new Color(248, 151, 29));

    contentPane.add(lblNewLabel_1_2);
    
    JLabel ModelLabel = new JLabel("Model");
    ModelLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
    ModelLabel.setBounds(125, 417, 129, 40);
    ModelLabel.setForeground(new Color(248, 151, 29));
    contentPane.add(ModelLabel);
    
    JLabel lblNewLabel_1_3 = new JLabel("Price");
    lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_3.setBounds(125, 467, 129, 40);
    lblNewLabel_1_3.setForeground(new Color(248, 151, 29));
    contentPane.add(lblNewLabel_1_3);
    
    UserName = new JTextField();
    UserName.setBounds(280, 217, 288, 34);
    contentPane.add(UserName);
    UserName.setBorder(null);
    UserName.setColumns(10);
    
    Car_id = new JTextField();
    Car_id.setColumns(10);
    Car_id.setBounds(280, 267, 288, 34);
    Car_id.setBorder(null);
    contentPane.add(Car_id);
    
    type = new JTextField();
    type.setColumns(10);
    type.setBorder(null);
    type.setBounds(280, 317, 288, 34);
    contentPane.add(type);
    
    model = new JTextField();
    model.setColumns(10);
    model.setBorder(null);
    model.setBounds(280, 367, 288, 34);
    contentPane.add(model);
    
    Price = new JTextField();
    Price.setColumns(10);
    Price.setBounds(280, 467, 288, 34);
    Price.setBorder(null);
    contentPane.add(Price);
    
    brand = new JTextField();
    brand.setColumns(10);
    brand.setBounds(280, 417, 288, 34);
    brand.setBorder(null);
    contentPane.add(brand);

    
    JLabel lblNewLabel_1_3_2 = new JLabel("seats\r\n");
    lblNewLabel_1_3_2.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblNewLabel_1_3_2.setBounds(125, 517, 129, 40);
    lblNewLabel_1_3_2.setForeground(new Color(248, 151, 29));
    contentPane.add(lblNewLabel_1_3_2);
    
    
    JLabel vehicleAge = new JLabel("Vehicle Age");
    vehicleAge.setFont(new Font("Verdana", Font.PLAIN, 18));
    vehicleAge.setBounds(125, 567, 129, 40);
    vehicleAge.setForeground(new Color(248, 151, 29));
    contentPane.add(vehicleAge);
    
    Seater = new JTextField();
    Seater.setColumns(10);
    Seater.setBounds(280, 517, 288, 34);
    Seater.setBorder(null);
    contentPane.add(Seater);
    
    Age = new JTextField();
    Age.setColumns(10);
    Age.setBounds(280, 567, 288, 34);
    Age.setBorder(null);
    contentPane.add(Age);

    JButton reg_boat = new JButton("Register Car");
    reg_boat.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		try {
    			
    			Class.forName("org.postgresql.Driver");
    			
    			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","Rkp@1801");
    			String sql1 = "insert into boat_registration(max_capacity,rooms,fare,model,boat_id,username) values(?,?,?,?,?,?)";
    		PreparedStatement pst=connection.prepareStatement(sql1);
    		
    		pst.setString(1, UserName.getText());
    		pst.setString(2, Seater.getText());
    		pst.setString(3, Price.getText());
    		pst.setString(4, model.getText());
    		pst.setString(5, type.getText());
    		pst.setString(6, Car_id.getText());
    		pst.setString(7, brand.getText());
    		
    		

    		int rs1 = pst.executeUpdate();
    		JOptionPane.showMessageDialog(null,"values updated");
    		DealerPage ownerspage = new DealerPage();
			ownerspage.setVisible(true);
			dispose();
    		//return rs1;
    		//rs1.close();
    		pst.close();
    		connection.close();
    		
    		}
    		
    		catch(Exception e1)
    		{
    			JOptionPane.showMessageDialog(null, e1);
    			System.out.println("unknown error");
    		}
    	}
    });
    reg_boat.setFont(new Font("Verdana", Font.PLAIN, 19));
    reg_boat.setBounds(350, 640, 218, 40);
    reg_boat.setBorder(null);
    reg_boat.setForeground(new Color(255,255,255));
    reg_boat.setBackground(new Color(248, 151, 29));
    JButton returnbtn = new JButton(" Return");
    returnbtn.setFont(new Font("Verdana", Font.PLAIN, 19));
    returnbtn.setBorder(null);
    returnbtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    DealerPage dpg = new DealerPage();
    dpg.setVisible(true);
    dispose();
    }
    });
    returnbtn.setBounds(150, 640, 100, 40);
    returnbtn.setForeground(new Color(255,255,255));
    returnbtn.setBackground(new Color(248, 151, 29));
    contentPane.add(returnbtn);
    contentPane.add(reg_boat);
    
  }
}
