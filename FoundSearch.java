package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoundSearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundSearch frame = new FoundSearch();
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
	public FoundSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchForItem = new JButton("Search For Item");
		btnSearchForItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LostForm lost = new LostForm();
				lost.show();
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearchForItem.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnSearchForItem.setBounds(85, 80, 211, 241);
		contentPane.add(btnSearchForItem);
		
		JButton btnFoundForItem = new JButton("Found For Item");
		btnFoundForItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoundForm found = new FoundForm();
				found.show();
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFoundForItem.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnFoundForItem.setBounds(433, 80, 220, 241);
		contentPane.add(btnFoundForItem);
	}

}
