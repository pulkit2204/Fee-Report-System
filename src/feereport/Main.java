package feereport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTextField txtname;
	private JTextField txtcourse;
	private JTextField txtfee;
	private JTextField txtpaid;
	private JTextField txtdue;
	private JTextField txtaddress;
	private JTextField txtcontactno;
	private JTable table;
	private JTextField txtid;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		
		Connect();
		Main_Load();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 738, 493);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.WHITE));
		panel.setBackground(new Color(205, 92, 92));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Main.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("STUDENT DETAILS");
		lblNewLabel.setBounds(204, 19, 289, 34);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(686, 11, 24, 42);
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
		
		JLabel lblNewLabel_2 = new JLabel("NAME :");
		lblNewLabel_2.setBounds(18, 92, 98, 34);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_2.setIcon(img7);
		panel.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setBounds(126, 99, 161, 24);
		txtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					
					txtname.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Aphabets Only");
					
				}else {
					txtname.setEditable(true);
					
				}
			}
		});
		txtname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtname.setToolTipText("Enter STUDENT Name");
		panel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("COURSE :");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/Book Content.png"));
		lblNewLabel_3.setIcon(img8);
		lblNewLabel_3.setBounds(18, 125, 98, 38);
		panel.add(lblNewLabel_3);
		
		txtcourse = new JTextField();
		txtcourse.setBounds(126, 134, 160, 24);
		txtcourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					
					txtcourse.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Aphabets Only");
					
				}else {
					txtcourse.setEditable(true);
					
				}
			}
		});
		txtcourse.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtcourse.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtcourse.setToolTipText("Enter STUDENT COURSE");
		panel.add(txtcourse);
		txtcourse.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("FEE :");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img12 =new ImageIcon(this.getClass().getResource("/fee.png"));
		lblNewLabel_4.setIcon(img12);
		lblNewLabel_4.setBounds(18, 161, 98, 34);
		panel.add(lblNewLabel_4);
		
		txtfee = new JTextField();
		txtfee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtfee.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Numbers Only");
					
				}else {
					txtfee.setEditable(true);
				
				}
			}
		});
		txtfee.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtfee.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtfee.setToolTipText("Enter STUDENT FEE");
		txtfee.setBounds(126, 169, 161, 23);
		panel.add(txtfee);
		txtfee.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PAID :");
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img13 =new ImageIcon(this.getClass().getResource("/transfer.png"));
		lblNewLabel_5.setIcon(img13);
		lblNewLabel_5.setBounds(18, 196, 76, 34);
		panel.add(lblNewLabel_5);
		
		txtpaid = new JTextField();
		txtpaid.setBounds(126, 203, 161, 24);
		txtpaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtpaid.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Numbers Only");
					
				}else {
					txtpaid.setEditable(true);
				
				}
			}
		});
		txtpaid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtpaid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtpaid.setToolTipText("Enter STUDENT FEES PAID");
		panel.add(txtpaid);
		txtpaid.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DUE :");
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/fine.png"));
		lblNewLabel_6.setIcon(img11);
		lblNewLabel_6.setBounds(18, 227, 87, 42);
		panel.add(lblNewLabel_6);
		
		txtdue = new JTextField();
		txtdue.setBounds(126, 238, 161, 24);
		txtdue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtdue.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Numbers Only");
					
				}else {
					txtdue.setEditable(true);
				
				}
			}
		});
		txtdue.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtdue.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdue.setToolTipText("Enter STUDENT FEES DUE");
		panel.add(txtdue);
		txtdue.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("ADDRESS :");
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/Author Address.png"));
		lblNewLabel_7.setIcon(img9);
		lblNewLabel_7.setBounds(18, 266, 111, 34);
		panel.add(lblNewLabel_7);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(126, 273, 161, 24);
		txtaddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					
					txtaddress.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Aphabets Only");
					
				}else {
					txtaddress.setEditable(true);
					
				}
			}
		});
		txtaddress.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtaddress.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtaddress.setToolTipText("Enter STUDENT ADDRESS");
		panel.add(txtaddress);
		txtaddress.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("CONTACT NO :");
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/Author Call.png"));
		lblNewLabel_8.setIcon(img10);
		lblNewLabel_8.setBounds(10, 296, 161, 44);
		panel.add(lblNewLabel_8);
		
		txtcontactno = new JTextField();
		txtcontactno.setBounds(151, 308, 136, 24);
		txtcontactno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtcontactno.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Numbers Only");
					
				}else {
					txtcontactno.setEditable(true);
				
				}
			}
		});
		txtcontactno.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtcontactno.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtcontactno.setToolTipText("Enter STUDENT FEES PAID");
		panel.add(txtcontactno);
		txtcontactno.setColumns(10);
		
		table = new JTable();
		table.setBounds(362, 316, 324, -241);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.WHITE));
		scrollPane.setBounds(310, 64, 418, 312);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.orange);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.yellow);
		table.setFont(new Font("Arial Rounded MT Bold",Font.ITALIC,14));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String name = txtname.getText();
				String course=txtcourse.getText();
				String fee = txtfee.getText();
				String paid = txtpaid.getText();
				String due = txtdue.getText();
				String address = txtaddress.getText();
				String contactno = txtcontactno.getText();
				
				
				try {
					String query="select * from STUDENT where id='"+id+"'";
					pst = con.prepareStatement(query);
					rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtname.setText(""); 
						txtcourse.setText("");
						txtfee.setText("");
						txtpaid.setText(""); 
						txtdue.setText("");
						txtaddress.setText("");
						txtcontactno.setText("");
		            }
		            else {
					pst = con.prepareStatement("insert into STUDENT(id,name,course,fee,paid,due,address,contactno) values(?,?,?,?,?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,course);
					pst.setString(4,fee);
					pst.setString(5,paid);
					pst.setString(6,due);
					pst.setString(7,address);
					pst.setString(8,contactno);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Main.this,"STUDENT Added");
						
						txtid.setText("");
						txtname.setText(""); 
						txtcourse.setText("");
						txtfee.setText("");
						txtpaid.setText(""); 
						txtdue.setText("");
						txtaddress.setText("");
						txtcontactno.setText("");
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(Main.this,"Error");
					}}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(18, 387, 124, 42);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton.setIcon(img);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String name = txtname.getText();
				String course=txtcourse.getText();
				String fee = txtfee.getText();
				String paid = txtpaid.getText();
				String due = txtdue.getText();
				String address = txtaddress.getText();
				String contactno = txtcontactno.getText();
				try {
					pst = con.prepareStatement("update STUDENT set name=?, course=?, fee=?, paid=?, due=?, address=?, contactno=? WHERE id=?");
					  	
					pst.setString(1,name);
					pst.setString(2,course);
					pst.setString(3,fee);
					pst.setString(4,paid);
					pst.setString(5,due);
					pst.setString(6,address);
					pst.setString(7,contactno);
					pst.setString(8,id);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Main.this,"STUDENT Updated");
						txtid.setText("");
						txtname.setText(""); 
						txtcourse.setText("");
						txtfee.setText("");
						txtpaid.setText(""); 
						txtdue.setText("");
						txtaddress.setText("");
						txtcontactno.setText("");
						
					}
					else
					{
						JOptionPane.showMessageDialog(Main.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(175, 387, 120, 42);
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();

				try {
					pst = con.prepareStatement("delete from STUDENT where id=?");
		           
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Main.this,"STUDENT Deleted");
						txtid.setText("");
						txtname.setText(""); 
						txtcourse.setText("");
						txtfee.setText("");
						txtpaid.setText(""); 
						txtdue.setText("");
						txtaddress.setText("");
						txtcontactno.setText("");
							
					}
					else
					{
						JOptionPane.showMessageDialog(Main.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(21, 440, 121, 42);
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/trash.png"));
		btnNewButton_2.setIcon(img3);
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountantLogin l=new AccountantLogin();
				l.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(175, 440, 120, 42);
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/MainPic8.png"));
		btnNewButton_3.setIcon(img4);
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("VIEW TABLE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from STUDENT";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            	
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(432, 387, 171, 42);
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_4.setIcon(img5);
		btnNewButton_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("ID :");
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_9.setIcon(img6);
		lblNewLabel_9.setBounds(18, 62, 64, 24);
		panel.add(lblNewLabel_9);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(Main.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);
				
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setToolTipText("Enter STUDENT ID");
		txtid.setBounds(92, 65, 58, 24);
		panel.add(txtid);
		txtid.setColumns(10);
		
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.setBounds(156, 60, 131, 34);
		panel.add(btnNewButton_5);
		btnNewButton_5.setToolTipText("Click here to SEARCH.");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from STUDENT where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("name");
						txtname.setText(add1);
						String add2=rs.getString("course");
						txtcourse.setText(add2);
						String add3=rs.getString("fee");
						txtfee.setText(add3);
						String add4=rs.getString("paid");
						txtpaid.setText(add4);
						String add5=rs.getString("due");
						txtdue.setText(add5);
						String add6=rs.getString("address");
						txtaddress.setText(add6);
						String add7=rs.getString("contactno");
						txtcontactno.setText(add7);
						
						
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "STUDENT ID not Found");
					}					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		btnNewButton_5.setBackground(SystemColor.inactiveCaption);
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		ImageIcon img14 =new ImageIcon(this.getClass().getResource("/Zoom-icon.png"));
		btnNewButton_5.setIcon(img14);
		setUndecorated(true);
	}
	

	public void Connect()
	{
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void Main_Load() {
		int a;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from STUDENT");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
