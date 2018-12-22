package database;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FoundForm extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField location;
	private JTextField date;
	private JTextField q1;
	private JTextField q2;
	private JTextField q3;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JLabel lblName;
	private JLabel lblLocation;
	private JLabel lblDate;
	private JLabel lblQuestion;
	private JLabel lblQuestion_1;
	private JLabel lblQuestion_2;
	private JLabel lblAnswer;
	private JLabel lblAnswer_1;
	private JLabel lblAnswer_2;
	private String image ; 
	private String collect_answers = "";
	private String collect_questions = "";
	Controller control = new Controller();
	Item item = new Item();
	private JButton btnLogout;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundForm frame = new FoundForm();
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
	public FoundForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel photo = new JLabel("");
		photo.setBounds(631, 34, 113, 115);
		contentPane.add(photo);
		
		name = new JTextField();
		name.setBounds(153, 163, 356, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(153, 194, 356, 20);
		contentPane.add(location);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(153, 225, 356, 20);
		contentPane.add(date);
		
		q1 = new JTextField();
		q1.setColumns(10);
		q1.setBounds(153, 256, 356, 20);
		contentPane.add(q1);
		
		q2 = new JTextField();
		q2.setColumns(10);
		q2.setBounds(153, 287, 356, 20);
		contentPane.add(q2);
		
		q3 = new JTextField();
		q3.setColumns(10);
		q3.setBounds(153, 318, 356, 20);
		contentPane.add(q3);
		
		JButton btnNewButton = new JButton("done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String>Q = new ArrayList<String>();
				collect_answers = ans1.getText() + "/" + ans2.getText() + "/" + ans3.getText() ;
				Q.add(q1.getText());
				Q.add(q2.getText());
				Q.add(q3.getText());
				
				item.setDescription(name.getText());	
				item.setLocation(location.getText());
				item.setDescription(name.getText());
				item.setAnswers(collect_answers);
				item.setDate(date.getText());
				item.setImage(image);
				item.setListofquestions(Q);
				
				
				try {
					control.Posting(item);
				} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(153, 427, 356, 23);
		contentPane.add(btnNewButton);
		
		ans1 = new JTextField();
		ans1.setBounds(69, 377, 113, 20);
		contentPane.add(ans1);
		ans1.setColumns(10);
		
		ans2 = new JTextField();
		ans2.setBounds(279, 377, 113, 20);
		contentPane.add(ans2);
		ans2.setColumns(10);
		
		ans3 = new JTextField();
		ans3.setColumns(10);
		ans3.setBounds(483, 377, 113, 20);
		contentPane.add(ans3);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 165, 133, 17);
		contentPane.add(lblName);
		
		lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 196, 133, 17);
		contentPane.add(lblLocation);
		
		lblDate = new JLabel("date");
		lblDate.setBounds(10, 227, 133, 17);
		contentPane.add(lblDate);
		
		lblQuestion = new JLabel("Question1");
		lblQuestion.setBounds(10, 258, 133, 17);
		contentPane.add(lblQuestion);
		
		lblQuestion_1 = new JLabel("Question2");
		lblQuestion_1.setBounds(10, 289, 133, 17);
		contentPane.add(lblQuestion_1);
		
		lblQuestion_2 = new JLabel("Question3");
		lblQuestion_2.setBounds(10, 320, 133, 17);
		contentPane.add(lblQuestion_2);
		
		lblAnswer = new JLabel("Answer1");
		lblAnswer.setBounds(10, 379, 63, 17);
		contentPane.add(lblAnswer);
		
		lblAnswer_1 = new JLabel("Answer2");
		lblAnswer_1.setBounds(206, 379, 63, 17);
		contentPane.add(lblAnswer_1);
		
		lblAnswer_2 = new JLabel("Answer3");
		lblAnswer_2.setBounds(416, 379, 55, 17);
		contentPane.add(lblAnswer_2);
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				 
		        // For Directory
		        fileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		 
		        // For File
		        //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 
		        fileChooser.setAcceptAllFileFilterUsed(false);
		 
		        int rVal = fileChooser.showOpenDialog(null);
		        if (rVal == JFileChooser.APPROVE_OPTION) {
		        	photo.setIcon(new ImageIcon(fileChooser.getSelectedFile().toString()));
		        	image = fileChooser.getSelectedFile().toString();
		        	
		          
		        }
		        
				
			}
		});
		btnBrowse.setBounds(641, 162, 89, 23);
		contentPane.add(btnBrowse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Joe\\Desktop\\test_dp\\losty.jpg"));
		lblNewLabel.setBounds(-188, -106, 784, 327);
		contentPane.add(lblNewLabel);
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\Joe\\Desktop\\test_dp\\exit.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				
			}
		});
		btnLogout.setBounds(760, 0, 24, 23);
		contentPane.add(btnLogout);

		
		
		
		}
	
	
	
}


