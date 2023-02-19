package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import database.Database;

import javax.swing.ImageIcon;
@SuppressWarnings("serial")
public class LoginPageGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordTF;
	private JTextField usernameTF;
	

	/**
	 * Create the frame.
	 */
	public LoginPageGUI() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 277);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignIn = new JLabel("<HTML>Sign Up</HTML>");
		lblSignIn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSignIn.setForeground(SystemColor.activeCaptionBorder);
		lblSignIn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSignIn.setBounds(188, 232, 53, 20);
		contentPane.add(lblSignIn);
		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUpGUI signup = new SignUpGUI();
				signup.setVisible(true);
				setVisible(false);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignIn.setText("<HTML><U><B>Sign Up</B></U></HTML>");
				lblSignIn.setForeground(SystemColor.activeCaption);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignIn.setText("<HTML>Sign Up</HTML>");
				lblSignIn.setForeground(SystemColor.activeCaptionBorder);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setBounds(50, 192, 171, 30);
		contentPane.add(btnLogin);
		btnLogin.setFocusPainted(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String id=usernameTF.getText();
					if(Database.checkIDAlreadyExists(id)) {
						char password[]=passwordTF.getPassword();
						String psswd=new String(password);
						if(Database.checkPassword(id, psswd)) {																																																																																																																																																																																																																																									
							DashboardGUI dashboard = new DashboardGUI();
							dashboard.setVisible(true);
							setVisible(false);
							dispose();
						}
						else {
							
							throw new Exception("Enter Correct Details");
						}
					}
					else {
						throw new Exception("No such user exists");
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
					passwordTF.setText("");
				}
			}
		});
		
		passwordTF = new JPasswordField();
		passwordTF.setForeground(Color.WHITE);
		passwordTF.setBackground(Color.DARK_GRAY);
		passwordTF.setBounds(46, 139, 171, 20);
		passwordTF.setBorder(null);
		passwordTF.setCaretColor(Color.WHITE);
		contentPane.add(passwordTF);
		
		usernameTF = new JTextField();
		usernameTF.setForeground(Color.WHITE);
		usernameTF.setBackground(Color.DARK_GRAY);
		usernameTF.setColumns(10);
		usernameTF.setBounds(46, 78, 171, 20);
		usernameTF.setBorder(null);
		usernameTF.setCaretColor(Color.WHITE);
		contentPane.add(usernameTF);
		
		JLabel lblUsernameid = new JLabel("Username/ID");
		lblUsernameid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsernameid.setForeground(Color.WHITE);
		lblUsernameid.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsernameid.setBackground(Color.WHITE);
		lblUsernameid.setBounds(43, 59, 88, 14);
		contentPane.add(lblUsernameid);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(43, 120, 88, 14);
		contentPane.add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.WHITE);
		separator.setBounds(41, 101, 178, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(44, 162, 178, 2);
		contentPane.add(separator_1);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClose.setForeground(SystemColor.activeCaptionBorder);
		lblClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClose.setBounds(188, 24, 53, 20);
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
		label.setIcon(new ImageIcon("D:\\eclipse-workspace\\documentManagement\\src\\logo.png"));
		label.setBounds(19, 13, 82, 30);
		contentPane.add(label);
	}
}
