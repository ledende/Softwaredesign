package documentManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private JTextField dobTF;

	/**
	 * Create the frame.
	 */
	public SignUp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				loginPage login=new loginPage();
				login.setVisible(true);
			}
		});
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.GRAY);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSignUp.setBounds(83, 372, 194, 30);
		contentPane.add(btnSignUp);
		btnSignUp.setFocusPainted(false);
		
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
		
		JLabel goback = new JLabel("<HTML>Previous</HTML>");
		goback.setHorizontalAlignment(SwingConstants.TRAILING);
		goback.setForeground(SystemColor.activeCaptionBorder);
		goback.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		goback.setBounds(267, 406, 53, 20);
		contentPane.add(goback);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginPage login=new loginPage();
				login.setVisible(true);
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
		
		JComboBox<String> designationCB = new JComboBox<String>();		
		designationCB.addItem("Select");
		designationCB.addItem("Student");
		designationCB.addItem("Faculty");
		designationCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				designationCB.removeItem("Select");
			}
		});
		designationCB.setForeground(Color.WHITE);
		designationCB.setBackground(Color.DARK_GRAY);
		designationCB.setBounds(61, 335, 241, 24);
		contentPane.add(designationCB);
	}
}
