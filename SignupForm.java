package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignupForm extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField pass;
	private JTextField cpass;
	private JTextField email;
	public String  confirmpass ;
	User user = new User();
	Controller control = new Controller();
	
	
	
//	public String  Firstname ;
//	public String  Lastname ;
//	public String  Password ;
//	public String  confirmpass ;
//	public String  Email ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupForm frame = new SignupForm();
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
	public SignupForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUp");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(219, 11, 344, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("FirstName");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername.setBounds(44, 141, 105, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("LastName");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(44, 177, 125, 25);
		contentPane.add(lblPassword);
		
		fname = new JTextField();
		fname.setBounds(255, 144, 298, 25);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(255, 180, 298, 25);
		contentPane.add(lname);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(255, 216, 298, 25);
		contentPane.add(pass);
		
		cpass = new JPasswordField();
		cpass.setColumns(10);
		cpass.setBounds(255, 252, 298, 25);
		contentPane.add(cpass);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword_1.setBounds(44, 213, 125, 25);
		contentPane.add(lblPassword_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(44, 249, 179, 25);
		contentPane.add(lblConfirmPassword);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(255, 288, 298, 25);
		contentPane.add(email);
		
		JLabel lblEmal = new JLabel("Email");
		lblEmal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmal.setBounds(44, 285, 125, 25);
		contentPane.add(lblEmal);
		

		
		JPanel fn = new JPanel();
		fn.setBounds(576, 144, 131, 25);
		contentPane.add(fn);
		
		JLabel lblEmptyFirstname = new JLabel("Empty FirstName");
		lblEmptyFirstname.setForeground(Color.RED);
		fn.add(lblEmptyFirstname);
		
		JPanel ln = new JPanel();
		ln.setBounds(576, 180, 131, 25);
		contentPane.add(ln);
		
		JLabel lblEmptyLastname = new JLabel("Empty LastName");
		lblEmptyLastname.setForeground(Color.RED);
		ln.add(lblEmptyLastname);
		
		JPanel pw = new JPanel();
		pw.setBounds(576, 216, 131, 25);
		contentPane.add(pw);
		
		JLabel lblEmptyPassword = new JLabel("Empty Password");
		lblEmptyPassword.setForeground(Color.RED);
		pw.add(lblEmptyPassword);
		
		JPanel cp = new JPanel();
		cp.setBounds(576, 252, 131, 25);
		contentPane.add(cp);
		
		JLabel lblEntercomirmpass = new JLabel("Empty ComirmPass");
		lblEntercomirmpass.setForeground(Color.RED);
		cp.add(lblEntercomirmpass);
		
		JPanel em = new JPanel();
		em.setBounds(576, 288, 131, 25);
		contentPane.add(em);
		
		JLabel lblEmptyEmail = new JLabel("Empty Email");
		lblEmptyEmail.setForeground(Color.RED);
		em.add(lblEmptyEmail);
		
		JPanel validpass = new JPanel();
		validpass.setBounds(169, 324, 214, 25);
		contentPane.add(validpass);
		
		JLabel lblPleaseTryYour = new JLabel("Please Try your Password again");
		lblPleaseTryYour.setForeground(Color.RED);
		validpass.add(lblPleaseTryYour);
		
		fn.setVisible(false);
		ln.setVisible(false);
		em.setVisible(false);
		cp.setVisible(false);
		pw.setVisible(false);
		validpass.setVisible(false);
		
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setFirstName(fname.getText()); 
				user.setLastName(lname.getText());
				user.setPassword(pass.getText());
				confirmpass = cpass.getText();
				user.setEmail(email.getText());
				
				if(!confirmpass.equals(user.getPassword())) {
					validpass.setVisible(true);
				}
				if(user.getPassword().equals("")) {
					pw.setVisible(true);
				}
				
				if(user.getFirstName().equals("")) {
					fn.setVisible(true);
				}
				if(user.getLastName().equals("")) {
					ln.setVisible(true);
				}
				if(user.getEmail().equals("")) {
					em.setVisible(true);
				}
				if(confirmpass.equals("")) {
					cp.setVisible(true);
				}
				
				else {
					
					try {
						try {
							control.SignUp(user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
						} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						LoginForm login= new LoginForm();
						login.show();
						this.finalize();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(255, 354, 298, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Joe\\Desktop\\test_dp\\exit.png"));
		btnNewButton_1.setBounds(722, 0, 23, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Joe\\Desktop\\test_dp\\login.jpg"));
		lblNewLabel_2.setBounds(0, 0, 745, 398);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
