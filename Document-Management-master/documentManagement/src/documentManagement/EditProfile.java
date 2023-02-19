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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class EditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JPasswordField passwordTF;
	private JTextField usernameTF;
	private JTextField dobTF;

	/**
	 * Create the frame.
	 */
	public EditProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(57, 52, 77, 24);
		contentPane.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setBackground(Color.DARK_GRAY);
		nameTF.setForeground(Color.WHITE);
		nameTF.setBounds(61, 80, 241, 24);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		nameTF.setBorder(null);
		nameTF.setCaretColor(Color.WHITE);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(56, 114, 77, 24);
		contentPane.add(lblUsername);
		
		usernameTF = new JTextField();
		usernameTF.setBackground(Color.DARK_GRAY);
		usernameTF.setForeground(Color.WHITE);
		usernameTF.setBounds(61, 142, 241, 24);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		usernameTF.setBorder(null);
		usernameTF.setCaretColor(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(56, 176, 77, 24);
		contentPane.add(lblPassword);
		
		passwordTF = new JPasswordField();
		passwordTF.setBackground(Color.DARK_GRAY);
		passwordTF.setForeground(Color.WHITE);
		passwordTF.setBounds(61, 204, 241, 24);
		passwordTF.setBorder(null);
		passwordTF.setCaretColor(Color.WHITE);
		contentPane.add(passwordTF);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnApply.setForeground(Color.WHITE);
		btnApply.setBackground(Color.GRAY);
		btnApply.setFocusPainted(false);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profile profilepage=new profile();
				profilepage.setVisible(true);
				dispose();
			}
		});
		btnApply.setBounds(68, 383, 107, 30);
		contentPane.add(btnApply);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setBounds(57, 300, 77, 24);
		contentPane.add(lblDesignation);
		
		dobTF = new JTextField();
		dobTF.setBackground(Color.DARK_GRAY);
		dobTF.setForeground(Color.WHITE);
		dobTF.setColumns(10);
		dobTF.setBorder(null);
		dobTF.setBounds(61, 264, 241, 24);
		dobTF.setCaretColor(Color.WHITE);
		contentPane.add(dobTF);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setBounds(56, 238, 87, 24);
		contentPane.add(lblDateOfBirth);
		
		JComboBox<String> designationCB = new JComboBox<String>();
		designationCB.setBackground(Color.DARK_GRAY);
		designationCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				designationCB.removeItem("Select");
			}
		});
		designationCB.setBounds(61, 326, 241, 24);
		contentPane.add(designationCB);
		designationCB.addItem("Select");
		designationCB.addItem("Student");
		designationCB.addItem("Faculty");
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(57, 106, 250, 6);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\logo.png"));
		label.setBounds(14, 10, 82, 30);
		contentPane.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(57, 168, 250, 6);
		contentPane.add(separator_1);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClose.setForeground(SystemColor.activeCaptionBorder);
		lblClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClose.setBounds(266, 24, 53, 20);
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
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(57, 230, 250, 6);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(57, 290, 250, 6);
		contentPane.add(separator_3);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dashboard dash= new Dashboard();
				dash.setVisible(true);
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setBounds(185, 383, 107, 30);
		btnCancel.setFocusPainted(false);
		contentPane.add(btnCancel);
	}
}
