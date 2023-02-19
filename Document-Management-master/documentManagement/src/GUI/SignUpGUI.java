package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

@SuppressWarnings("serial")
public class SignUpGUI extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTF;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private JTextField lastNameTF;
	private JComboBox<String> typeCB;

	/**
	 * Create the frame.
	 */
	public SignUpGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LoginPageGUI login=new LoginPageGUI();
				login.setVisible(true);
			}
		});
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(57, 52, 77, 24);
		contentPane.add(lblNewLabel);
		
		firstNameTF = new JTextField();
		firstNameTF.setBackground(Color.DARK_GRAY);
		firstNameTF.setForeground(Color.WHITE);
		firstNameTF.setBounds(61, 84, 241, 24);
		contentPane.add(firstNameTF);
		firstNameTF.setColumns(10);
		firstNameTF.setBorder(null);
		firstNameTF.setCaretColor(Color.WHITE);
		
		JLabel lblUsername = new JLabel("Username / ID");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(56, 176, 102, 24);
		contentPane.add(lblUsername);
		
		usernameTF = new JTextField();
		usernameTF.setBackground(Color.DARK_GRAY);
		usernameTF.setForeground(Color.WHITE);
		usernameTF.setBounds(61, 204, 241, 24);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		usernameTF.setBorder(null);
		usernameTF.setCaretColor(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(56, 238, 77, 24);
		contentPane.add(lblPassword);
		
		passwordTF = new JPasswordField();
		passwordTF.setBackground(Color.DARK_GRAY);
		passwordTF.setForeground(Color.WHITE);
		passwordTF.setBounds(61, 264, 241, 24);
		passwordTF.setBorder(null);
		passwordTF.setCaretColor(Color.WHITE);
		contentPane.add(passwordTF);
		
		JComboBox<String> departmentCB = new JComboBox<String>();
		departmentCB.setForeground(Color.WHITE);
		departmentCB.setBackground(Color.DARK_GRAY);
		departmentCB.setBounds(58, 399, 111, 24);
		departmentCB.setVisible(false);
		contentPane.add(departmentCB);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment.setBounds(58, 362, 111, 24);
		lblDepartment.setVisible(false);
		contentPane.add(lblDepartment);
		
		JComboBox<String> yearCB = new JComboBox<String>();
		yearCB.setForeground(Color.WHITE);
		yearCB.setBackground(Color.DARK_GRAY);
		yearCB.setBounds(192, 399, 112, 24);
		yearCB.setVisible(false);
		contentPane.add(yearCB);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYear.setBounds(192, 362, 112, 24);
		lblYear.setVisible(false);
		contentPane.add(lblYear);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.GRAY);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String id=usernameTF.getText();
					if(Database.checkIDAlreadyExists(id)) {
						throw new Exception("ID "+id+" already exists");
					}
					else {
						String firstname=firstNameTF.getText();
						String lastname=lastNameTF.getText();
						if(!checkname(firstname)) {
							throw new Exception("First Name must contain alphabets only");
						}
						if(!checkname(lastname)) {
							throw new Exception("Last Name must contain alphabets only");
						}
						
						String psswd=new String(passwordTF.getPassword());
						if(psswd.equals("")) {
							throw new Exception("Enter a password");
						}
						String type=(String) typeCB.getSelectedItem();
						Profile newProfile=null;
						if(type.equals("Faculty")) {
							String department=(String) departmentCB.getSelectedItem();
							Faculty f=new Faculty(firstname,lastname,id,psswd,type,department);
							newProfile=f;
						}
						else if(type.equals("Student")){
							String branch=(String) departmentCB.getSelectedItem();
							String year=(String) yearCB.getSelectedItem();
							Student s=new Student(firstname,lastname,id,psswd,type,branch,year);
							newProfile=s;
						}
						else {
							throw new Exception("Select a type");
						}
						Database.addProfile(newProfile);
						DashboardGUI dashboard=new DashboardGUI();
						dashboard.setVisible(true);
						dispose();
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
					passwordTF.setText("");
				}
			}
		});
		btnSignUp.setBounds(82, 437, 194, 30);
		contentPane.add(btnSignUp);
		btnSignUp.setFocusPainted(false);
		
		JLabel lblDesignation = new JLabel("Type");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setBounds(57, 300, 87, 24);
		contentPane.add(lblDesignation);
		
		lastNameTF = new JTextField();
		lastNameTF.setBackground(Color.DARK_GRAY);
		lastNameTF.setForeground(Color.WHITE);
		lastNameTF.setColumns(10);
		lastNameTF.setBorder(null);
		lastNameTF.setBounds(61, 144, 241, 24);
		lastNameTF.setCaretColor(Color.WHITE);
		contentPane.add(lastNameTF);
		
		JLabel lblLastName = new JLabel("LastName");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(56, 114, 87, 24);
		contentPane.add(lblLastName);
		
		JLabel goback = new JLabel("<HTML>Previous</HTML>");
		goback.setHorizontalAlignment(SwingConstants.TRAILING);
		goback.setForeground(SystemColor.activeCaptionBorder);
		goback.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		goback.setBounds(242, 478, 77, 20);
		contentPane.add(goback);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPageGUI login=new LoginPageGUI();
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
		separator.setBounds(57, 110, 250, 6);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\eclipse-workspace\\documentManagement\\src\\logo.png"));
		label.setBounds(14, 10, 82, 30);
		contentPane.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(57, 170, 250, 6);
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
		
		typeCB = new JComboBox<String>();	
		typeCB.addItem("Select");
		typeCB.addItem("Student");
		typeCB.addItem("Faculty");
		typeCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String student="Student";
				String faculty="Faculty";
				if(student.equals((String)(typeCB.getSelectedItem()))) {
					lblDepartment.setVisible(true);
					lblDepartment.setText("Branch");
					departmentCB.setBounds(58, 399, 111, 24);
					departmentCB.setVisible(true);
					lblYear.setVisible(true);
					yearCB.setVisible(true);
					departmentCB.removeAllItems();
					yearCB.removeAllItems();
					departmentCB.addItem("CSE");
					departmentCB.addItem("CCE");
					departmentCB.addItem("ECE");
					departmentCB.addItem("Mechanical");
					yearCB.addItem("1st year");
					yearCB.addItem("2nd year");
					yearCB.addItem("3rd year");
					yearCB.addItem("4th year");
					
					if(typeCB.getItemAt(0).equals("Select"))
						typeCB.removeItem("Select");
				}
				else if(faculty.equals((String)(typeCB.getSelectedItem()))){
					departmentCB.setBounds(58, 399, 246, 24);
					lblDepartment.setVisible(true);
					lblDepartment.setText("Department");
					departmentCB.setVisible(true);
					lblYear.setVisible(false);
					yearCB.setVisible(false);
					departmentCB.removeAllItems();
					departmentCB.addItem("Computer");
					departmentCB.addItem("Electronics");
					departmentCB.addItem("Mechanical");
					departmentCB.addItem("HSS");
					departmentCB.addItem("Mathematics");
					
					if(typeCB.getItemAt(0).equals("Select"))
						typeCB.removeItem("Select");
				}
			}
		});
		
		typeCB.setForeground(Color.WHITE);
		typeCB.setBackground(Color.DARK_GRAY);
		typeCB.setBounds(58, 329, 246, 24);
		contentPane.add(typeCB);
		
		
	}
	boolean checkname(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            int t=(int)c;
            if(!((t>=97&&t<=122)||(t>=65&&t<=90)||t==32))
                return false;
        }
        return true;
    }
}
