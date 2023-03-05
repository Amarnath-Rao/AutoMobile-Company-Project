package finalproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import org.imgsclr.Scalar;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import finalproject.LoginPage;
import java.awt.*;

public class home implements ActionListener {
	private JFrame f;
	private JPanel navPanel,innerContent;
	private BufferedImage image;
	private JLabel imageLabel;
	private JButton homeButton,productsButton,aboutButton,contactButton,LogoutButton;
	home(){
		f = new JFrame("Automobile");
		f.setLayout(new BorderLayout());
	    f.getContentPane().setBackground(new Color(1, 4, 9));
		navPanel = new JPanel();
	    navPanel.setLayout(new BorderLayout());
	    imageLabel = new JLabel();
	    try {
            image = ImageIO.read(new File("/home/subbarao/audi.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	    innerContent = new JPanel();
	    f.add(innerContent, BorderLayout.CENTER);
	    innerContent.setPreferredSize(new Dimension(f.getWidth(), f.getHeight()-navPanel.getHeight()));
	    innerContent.setBackground(new Color(0,0,0));
	    innerContent.setLayout(new BorderLayout());
	    imageLabel = new JLabel(new ImageIcon(image));
	    innerContent.add(imageLabel);
        navPanel.setBorder(new LineBorder(new Color(22, 27, 34), 3, true));
	    homeButton = new JButton("Home");
        productsButton = new JButton("Cars");
        aboutButton = new JButton("Parts");
        contactButton = new JButton("Contact Us");
        LogoutButton = new JButton("Login");
        homeButton.setForeground(Color.WHITE);
        homeButton.setBorder(null);
        homeButton.setBackground(new Color(22, 27, 34));
        homeButton.setFont(new Font("Arial", Font.PLAIN,25));
        homeButton.setSize(new Dimension(100,50));
      	productsButton.setForeground(Color.WHITE);
        productsButton.setBorder(null);
        productsButton.setFont(new Font("Arial", Font.PLAIN,25));
        productsButton.setBackground(new Color(22, 27, 34));
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setBorder(null);
        aboutButton.setFont(new Font("Arial", Font.PLAIN,25));
        aboutButton.setBackground(new Color(22, 27, 34));
        contactButton.setForeground(Color.WHITE);
        contactButton.setBorder(null);
        contactButton.setFont(new Font("Arial", Font.PLAIN,25));
        contactButton.setBackground(new Color(22, 27, 34));
        LogoutButton.setForeground(Color.WHITE);
        LogoutButton.setBorder(null);
        LogoutButton.setBackground(new Color(22, 27, 34));
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage lp = new LoginPage();
                f.dispose();
                lp.setVisible(true);
            }
        });
        LogoutButton.setFont(new Font("Arial", Font.PLAIN,25));
        LogoutButton.setSize(new Dimension(100,50));
        navPanel.add(LogoutButton);
	    navPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,15));
        navPanel.setBackground(new Color(22, 27, 34));
        navPanel.setPreferredSize(new Dimension(1920,70));
//        innerContent.setBackground(new Color(117, 115, 115));
        f.add(navPanel, BorderLayout.NORTH);
        f.add(innerContent,BorderLayout.CENTER);
        f.setSize(1920,1080);
        f.setVisible(true);
        homeButton.addActionListener(this);
        productsButton.addActionListener(this);
        aboutButton.addActionListener(this);
        contactButton.addActionListener(this);
        LogoutButton.addActionListener(this);
	}
	public JPanel getnavPanel() {
		return navPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Home":{
			f.repaint();
			break;
		}
		case "Cars":{
			break;
		}
		case "Parts":{
			break;
		}
		case "Contact Us":{
			f.remove(innerContent);
			break;
		}
		case "Logout":{
		//	Runner r = new Runner();
			//JFrame frame=r.getFrame()
		}
	  }
	}
	public static void main(String[] args) {
		home h=new home();
	}
	
	
}
