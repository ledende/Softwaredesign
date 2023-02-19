package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import model.Faculty;
import model.Profile;
import model.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ProfileGUI extends JFrame {

	
	private JPanel contentPane;
	JLabel departmentLBL,FirstNameLbl,UsernameLbl,LastNameLbl;
	private JLabel lblDepartment;
	private JLabel lblYear;
	private JLabel yearLBL;

	/**
	 * Create the frame.
	 */
	public ProfileGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
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
		goback.setBounds(352, 310, 64, 20);
		contentPane.add(goback);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DashboardGUI dashboard = new DashboardGUI();
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
		
		lblDepartment = new JLabel("Designation");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setBounds(52, 215, 105, 24);
		contentPane.add(lblDepartment);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(52, 115, 87, 24);
		contentPane.add(lblLastName);
		
		JLabel lblId = new JLabel("Username/ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(52, 165, 105, 24);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(52, 65, 87, 24);
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
		
		JLabel LogoLbl = new JLabel("");
		LogoLbl.setIcon(new ImageIcon("D:\\eclipse-workspace\\documentManagement\\src\\logo.png"));
		LogoLbl.setBounds(15, 9, 87, 30);
		contentPane.add(LogoLbl);
		
		FirstNameLbl = new JLabel("New label");
		FirstNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		FirstNameLbl.setForeground(Color.WHITE);
		FirstNameLbl.setBounds(196, 69, 211, 17);
		contentPane.add(FirstNameLbl);
		
		UsernameLbl = new JLabel("New label");
		UsernameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		UsernameLbl.setForeground(Color.WHITE);
		UsernameLbl.setBounds(196, 169, 146, 17);
		contentPane.add(UsernameLbl);
		
		LastNameLbl = new JLabel("New label");
		LastNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		LastNameLbl.setForeground(Color.WHITE);
		LastNameLbl.setBounds(196, 119, 146, 17);
		contentPane.add(LastNameLbl);
		
		departmentLBL = new JLabel("New label");
		departmentLBL.setFont(new Font("Dialog", Font.PLAIN, 12));
		departmentLBL.setForeground(Color.WHITE);
		departmentLBL.setBounds(196, 219, 146, 17);
		contentPane.add(departmentLBL);
		
		lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(54, 266, 77, 14);
		contentPane.add(lblYear);
		
		yearLBL = new JLabel("New label");
		yearLBL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		yearLBL.setForeground(Color.WHITE);
		yearLBL.setBounds(198, 266, 94, 14);
		contentPane.add(yearLBL);
		
		showDetails();
	}
	
	private void showDetails() {
		Profile currentProfile=Database.getCurrentProfile();
		FirstNameLbl.setText(currentProfile.getFirstName());
		LastNameLbl.setText(currentProfile.getLastName());
		UsernameLbl.setText(""+currentProfile.getID());
		if(currentProfile.getType().equals("Faculty")) {
			Faculty f=(Faculty) currentProfile;
			lblDepartment.setText("Department");
			departmentLBL.setText(f.getDept());
			lblYear.setVisible(false);
			yearLBL.setVisible(false);
		}
		else if(currentProfile.getType().equals("Student")) {
			Student s=(Student) currentProfile;
			lblDepartment.setText("Branch");
			lblYear.setVisible(true);
			yearLBL.setVisible(true);
			departmentLBL.setText(s.getBranch());
			yearLBL.setText(s.getYear());
		}
		//departmentLBL.setText(text);
	}
}
