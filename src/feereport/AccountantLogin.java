package feereport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountantLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpass;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountantLogin frame = new AccountantLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountantLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		panel.setBackground(new Color(205, 92, 92));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				AccountantLogin.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(79, 200, 119, 33);
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img =new ImageIcon(this.getClass().getResource("/Login Pic 1.png"));
		panel.setLayout(null);
		lblNewLabel.setIcon(img);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(79, 244, 132, 33);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Login Pic 2.png"));
		lblNewLabel_1.setIcon(img1);
		panel.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setBounds(244, 200, 181, 33);
		txtusername.setToolTipText("Enter Username");
		txtusername.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtusername.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(77, 324, 119, 42);
		btnNewButton.setToolTipText("Click here to LOGIN.");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String username = txtusername.getText();
				String password = txtpass.getText();
				
				boolean status =AccountantLogin.validate(username, password);
				if(status) 
				{
					dispose();
					Main m = new Main();
					m.setVisible(true);	
					txtusername.setText("");
					txtpass.setText("");
				}
				
			
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username");
					txtusername.setText("");
					txtpass.setText("");
					txtusername.requestFocus();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBounds(279, 324, 119, 42);
		btnNewButton_1.setToolTipText("Click here to EXIT.");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_1.setIcon(img3);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Lobby l = new Lobby();
				AccountantLogin.this.setVisible(false);
				l.setVisible(true);
				
			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACCOUNTANT LOGIN");
		lblNewLabel_2.setBounds(77, 11, 321, 42);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(lblNewLabel_2);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(244, 244, 181, 33);
		txtpass.setToolTipText("Enter Password");
		txtpass.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtpass.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		panel.add(txtpass);
		
		JLabel label = new JLabel("");
		label.setBounds(449, 11, 40, 42);
		label.setToolTipText("Close");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/cancel.png"));
		label.setIcon(img4);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBorder(null);
		panel.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("n");
		lblNewLabel_3.setBounds(182, 61, 125, 128);
		ImageIcon im =new ImageIcon(this.getClass().getResource("/accounting.png"));
		lblNewLabel_3.setIcon(im);
		panel.add(lblNewLabel_3);
		
		JCheckBox c = new JCheckBox("Show Password");
		c.setBounds(244, 284, 170, 23);
		c.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		c.setOpaque(false);
		c.setForeground(Color.BLACK);
		c.setBackground(Color.WHITE);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.isSelected())
				{
				 txtpass.setEchoChar((char)0);	
				}
				else
				{
				 txtpass.setEchoChar('*');
				}
			}
		});
		panel.add(c);
		setUndecorated(true);
	
	
	}
	
	
public static boolean validate(String username,String password){
		
		boolean status=false;
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
			PreparedStatement ps=con.prepareStatement("select * from ACCOUNTANTDETAILS where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		
		
		
	}
}
