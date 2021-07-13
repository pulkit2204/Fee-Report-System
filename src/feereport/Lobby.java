package feereport;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;



public class Lobby extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lobby frame = new Lobby();
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
	public Lobby() {
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 563, 389);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		panel.setBackground(new Color(205, 92, 92));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Lobby.this.setLocation(x-xx, y-xy);
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
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEE SYSTEM 1.0");
		lblNewLabel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		lblNewLabel.setBounds(166, 20, 231, 51);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(509, 11, 24, 42);
		ImageIcon img1=new ImageIcon(this.getClass().getResource("/cancel.png"));
		lblNewLabel_1.setIcon(img1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(70, 82, 137, 143);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/admin1.png"));
		lblNewLabel_2.setIcon(img);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/Teacher-icon.png"));
		lblNewLabel_3.setIcon(img2);
		lblNewLabel_3.setBounds(358, 84, 143, 141);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img3);
		btnNewButton.setToolTipText("Click to open ADMIN LOGIN.");
		btnNewButton.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255)));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(39, 249, 219, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a = new AdminLogin();
				Lobby.this.setVisible(false);
				a.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ACCOUNTANT LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountantLogin a = new AccountantLogin();
				Lobby.this.setVisible(false);
				a.setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("Click to open ACCOUNTANT LOGIN.");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton_1.setIcon(img4);
		btnNewButton_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255)));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(290, 249, 243, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_2.setIcon(img5);
		btnNewButton_2.setToolTipText("Click here to EXIT.");
		btnNewButton_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBounds(425, 319, 111, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnNewButton_2);
		
		
	}
}
