package database;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;
import javax.swing.ImageIcon;

public class ShowDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDetails frame = new ShowDetails();
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
	public ShowDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulations");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(0, 0, 434, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("check your E-Mail for contact info.");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 74, 434, 55);
		contentPane.add(lblNewLabel_1);
		
		JButton btnFoundOrSearch = new JButton("Post or Search again");
		btnFoundOrSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FoundSearch form = new FoundSearch();
				form.show();
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnFoundOrSearch.setBounds(139, 163, 170, 36);
		contentPane.add(btnFoundOrSearch);
		
		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\Joe\\Desktop\\test_dp\\exit.png"));
		btnLogout.setSelectedIcon(null);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnLogout.setBounds(414, 0, 20, 20);
		contentPane.add(btnLogout);
	}
}
