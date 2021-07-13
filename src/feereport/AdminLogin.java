package feereport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 535, 382);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		panel.setBackground(new Color(205, 92, 92));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				AdminLogin.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("  ADMIN LOGIN");
		lblNewLabel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		lblNewLabel_2.setBounds(152, 22, 230, 47);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(186, 79, 136, 114);
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Admin-icon.png"));
		lblNewLabel_3.setIcon(img5);
		panel.add(lblNewLabel_3);
		
		
		txtusername = new JTextField();
		txtusername.setBounds(235, 204, 213, 36);
		panel.add(txtusername);
		txtusername.setToolTipText("Enter Username");
		txtusername.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		txtusername.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(235, 251, 213, 37);
		panel.add(txtpassword);
		txtpassword.setToolTipText("Enter Password");
		txtpassword.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		txtpassword.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(60, 251, 145, 37);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Login Pic 2.png"));
		lblNewLabel_1.setIcon(img1);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(60, 203, 145, 37);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img =new ImageIcon(this.getClass().getResource("/Login Pic 1.png"));
		lblNewLabel.setIcon(img);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(60, 324, 145, 47);
		
		btnNewButton.setToolTipText("Click here to Login");
		btnNewButton.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img3);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Username = txtusername.getText();
				String Pass = txtpassword.getText();
				
				if(Username.equals("admin") && Pass.equals("admin123")) 
				{
					dispose();
					AdminSection a = new AdminSection();
					a.setVisible(true);
					txtusername.setText("");
					txtpassword.setText("");	
				}
				else
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!",JOptionPane.ERROR_MESSAGE);
					txtusername.setText("");
					txtpassword.setText("");
					txtusername.requestFocus();
				}	
			}			
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBounds(303, 325, 145, 45);
		
		btnNewButton_1.setToolTipText("Click here to Exit");
		btnNewButton_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_1.setIcon(img4);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Lobby l=new Lobby();
			AdminLogin.this.setVisible(false);
			l.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton_1);
		JCheckBox c = new JCheckBox("SHOW PASSWORD");
		c.setBounds(236, 295, 146, 23);
		
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.isSelected())
				{
				 txtpassword.setEchoChar((char)0);	
				}
				else
				{
				 txtpassword.setEchoChar('*');
				}
			}
		});
		c.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		c.setOpaque(false);
		c.setForeground(Color.BLACK);
		c.setBackground(Color.WHITE);
		panel.add(c);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(482, 11, 31, 42);
		ImageIcon img2=new ImageIcon(this.getClass().getResource("/cancel.png"));
		lblNewLabel_5.setIcon(img2);
		lblNewLabel_5.setToolTipText("Close");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
				public void mousePressed(MouseEvent e) {
					xx=e.getX();
					xy=e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		lblNewLabel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				AdminLogin.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_5.setBorder(null);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_5);
	}
}
