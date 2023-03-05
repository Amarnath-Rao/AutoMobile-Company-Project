package finalproject;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.time.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class bookback{
	
	static JFrame f;
	Box b;
	JTable j ;
	Connection c;
	Statement s;
	String username;
	
	bookback(String username){
		this.username=username;
		
		f = new JFrame("Second Hand Cars");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.getContentPane().setBackground(new Color(137, 209, 194));
		f.setLayout(new BorderLayout(15,15));
		//Heading
		b = Box.createVerticalBox();
		JLabel title = new JLabel("BUY CARS");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setForeground(new Color(248, 151, 29)); 
		title.setAlignmentX( Box.CENTER_ALIGNMENT);
		title.setAlignmentY(80);
		
		b.add(title); // adding label to box
		f.add(b);
		
		
		setConnection();
		display();
		
		f.setVisible(true);
	}

	
	
	public void setConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/automobileCompany","postgres","subbu0456");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
	
	public void display() {
		try {
			
			String[] cName = 
				{"SI NO","VEHICLE ID","BRAND","MODEL","TYPE","GEAR","FEUL","AGE","SEATS","PRICE"}; 
			s = c.createStatement();
			
			ResultSet rs = s.executeQuery("select count(vehicle_id) from vehicle");
			rs.next();
			int count = rs.getInt(1);
			
			String [][] data = new String[count+1][15];
			
			ResultSet r = s.executeQuery
			("select vehicle_id, brandname,modelname,typename,colour,gear_type,fuel,seat,age,price  from vehicle;");
			data[0][0] = "SI NO";
			data[0][1] = "VEHICLE ID"; 
			data[0][2] = "BRAND";
			data[0][3] = "MODEL";
			data[0][4] = "TYPE";	
			data[0][5] = "COLOUR";
			data[0][6] = "GEAR TYPE";
			data[0][7] = "FUEL";
			data[0][8] = "SEATS";
			data[0][9] = "PRICE";
			data[0][10] = "AGE";
			int i = 1;
			
			while(r.next()) {
					
				String c_id = r.getString("vehicle_id");
				String brand = r.getString("brandname");
				String type = r.getString("typename");
				String model = r.getString("modelname");
				String colour = r.getString("colour");
				String gear = r.getString("gear_type");
				String fuel = r.getString("fuel");
				int seat = r.getInt("seat");
				float price = r.getFloat("price");
				int age = r.getInt("age");

				String sprice = Float. toString(price);
				String sage =Integer.toString(age);
				String sseat = Integer.toString(seat);
				String ii = Integer.toString(i);
				
				data[i][0] = ii; 
				data[i][1] = c_id; 
				data[i][2] = brand;
				data[i][3] = type;
				data[i][4] = model;
				data[i][5] = colour;	
				data[i][6] = gear;
				data[i][7] = fuel;
				data[i][8] = sage;				
				data[i][9] = sseat;
				data[i][10] = sprice;
				i++;
				
			}
			
			j = new JTable(data, cName); 
	        j.setBounds(30, 40, 20, 40); 
	        j.setRowHeight(j.getRowHeight() + 20);
	        
	       
	        
	        b.add(Box.createRigidArea(new Dimension(50,70)));
	        
	        
	        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	        j.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	        j.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
	        j.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
	        j.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
	        j.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
	        j.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
	       JTableHeader jh = j.getTableHeader();
	       j.addMouseListener(new MouseAdapter() {
	    	    public void mouseClicked(MouseEvent e) {
	    	        // Get the row that was clicked
	    	        int row = j.rowAtPoint(e.getPoint());
	    	        String c_id = username;
	    	        String v_id = (String)j.getValueAt(row, 1);
	    	        
	    	        try {
                		Class.forName("org.postgresql.Driver");
               		    String URL = "jdbc:postgresql://localhost:5432/automobileCompany";
            	       	  String dbcusername = "postgres";
              		     String dbcpassword = "subbu0456";
              		     Connection connection = DriverManager.getConnection(URL, dbcusername,dbcpassword);
                 	     System.out.print("Connected");
             			java.sql.Statement statement = connection.createStatement();
             			String sqll = "select count(order_id) from bookorder;";
            			ResultSet rss = statement.executeQuery(sqll);
            			rss.next();
            			int count = rss.getInt(1);
            			
            
            			
            			String sql = "select order_id from bookorder;";
            			
            			ResultSet r = statement.executeQuery(sql);
            			
            			int i=1;
            			
            			while(r.next() && i < count) {
            				i++;
            			}
            			String cid = r.getString(1);
            			System.out.println(cid);
            			
            			int a = 0;
            			
            			for(int k=1;k<cid.length();k++) {
            				a = a*10 + Character.getNumericValue(cid.charAt(k));
            			}
            			a++;
            			String sql1 = 
            			"insert into vehicle " +
            			"values ( 'O"+ a +"','"+c_id+"','"+v_id+"');";
            			statement.executeUpdate(sql1);
            			f.dispose();
                			customerpage lp = new customerpage(username);
            			lp.setVisible(true);
            		
            		}
            		catch(Exception ee) {
            			ee.printStackTrace();
            			System.err.println(ee.getClass().getName()+": "+ee.getMessage());
            			System.exit(0);
            		}
            		
	    	    }
	    	});
	       jh.setBackground(Color.black);
	       jh.setForeground(Color.white);
	       jh.setFont(new Font("Verdana", Font.PLAIN, 18));
	       jh.setPreferredSize(
	    		     new Dimension(400,j.getRowHeight()+20));
	       j.setShowGrid(false);
	       j.setForeground(Color.white);
	       j.setBackground(new Color(248, 151, 29));
	       j.setFont(new Font("Verdana", Font.PLAIN, 18));	 
	       JButton returnbtn = new JButton(" Return");
	        returnbtn.setFont(new Font("Verdana", Font.BOLD, 18));
	        returnbtn.setBorder(null);
	        returnbtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        DealerPage dp= new DealerPage(username);
	        dp.setVisible(true);
	        f.dispose();;
	        }
	        });
	        returnbtn.setBounds(0, 60, 95, 33);
	        returnbtn.setBackground(new Color(248, 151, 29));
	        JPanel jp = new JPanel();
	        jp.add(returnbtn);
	        jp.setBackground(new Color(137, 209, 194));
	        f.add(jp,BorderLayout.NORTH);
	        b.add(j); 
	        rs.close();
	        r.close();
			s.close();
			c.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
}

