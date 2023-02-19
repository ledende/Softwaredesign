package documentManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile frame = new profile();
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
	public profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel goback = new JLabel("<HTML>Previous</HTML>");
		goback.setHorizontalAlignment(SwingConstants.TRAILING);
		goback.setForeground(SystemColor.activeCaptionBorder);
		goback.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		goback.setBounds(343, 298, 64, 20);
		contentPane.add(goback);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				setVisible(false);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				goback.setText("<HTML><U><B>Previous</B></U></HTML>");
				goback.setForeground(SystemColor.activeCaption);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goback.setText("<HTML>Previous</HTML>");
				goback.setForeground(SystemColor.activeCaptionBorder);
			}
		});
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBackground(Color.GRAY);
		btnEditProfile.setForeground(Color.WHITE);
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditProfile.setFocusPainted(false);
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfile editprofilepage=new EditProfile();
				editprofilepage.setVisible(true);
				dispose();
			}
		});
		btnEditProfile.setBounds(164, 276, 126, 30);
		contentPane.add(btnEditProfile);
		
		JLabel label_1 = new JLabel("Designation");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(52, 233, 77, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Date of Birth");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(52, 188, 87, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(52, 145, 77, 24);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Username");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(52, 99, 77, 24);
		contentPane.add(label_4);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(52, 54, 77, 24);
		contentPane.add(lblName);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClose.setForeground(SystemColor.activeCaptionBorder);
		lblClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClose.setBounds(352, 23, 53, 20);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setText("<HTML><U><B>Close</B></U></HTML>");
				lblClose.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setText("<HTML>Close</HTML>");
				lblClose.setForeground(SystemColor.activeCaptionBorder);
			}
		});
		contentPane.add(lblClose);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\logo.png"));
		label.setBounds(15, 9, 87, 32);
		contentPane.add(label);
	}
}
