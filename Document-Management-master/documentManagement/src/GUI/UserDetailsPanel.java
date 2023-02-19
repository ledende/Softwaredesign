package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import database.Database;
import model.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UserDetailsPanel extends JPanel {
	private JTextField userFirstNameTF;
	private JTextField userLastNameTF;
	private JTextField userIDTF;
	private JTextField userTypeTF;
	private JTextField userDepartmentTF;
	private JPanel yearUserDetailsPanel;
	private JTextField userYearTF;
	private JLabel lblUserDepartment;
	private JPanel userListPanel;
	private JPanel detailsPanel;
	private JScrollPane scrollPane;
	private String currentID;

	/**
	 * Create the panel.
	 */
	public UserDetailsPanel(DashboardGUI parentUI) {
		setForeground(Color.BLACK);
		setBounds(0,0,364, 443);
		setLayout(null);
		setBorder(null);
		setBackground(Color.WHITE);
		
		detailsPanel = new JPanel();
		detailsPanel.setBackground(Color.WHITE);
		detailsPanel.setBounds(48, 11, 257, 421);
		add(detailsPanel);
		detailsPanel.setLayout(null);
		detailsPanel.setVisible(false);
		
		JLabel label_7 = new JLabel("First Name");
		label_7.setBounds(1, 0, 77, 24);
		detailsPanel.add(label_7);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userFirstNameTF = new JTextField();
		userFirstNameTF.setBounds(4, 26, 241, 24);
		detailsPanel.add(userFirstNameTF);
		userFirstNameTF.setEditable(false);
		userFirstNameTF.setForeground(Color.BLACK);
		userFirstNameTF.setColumns(10);
		userFirstNameTF.setCaretColor(Color.WHITE);
		userFirstNameTF.setBorder(null);
		userFirstNameTF.setBackground(Color.WHITE);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 52, 250, 6);
		detailsPanel.add(separator_6);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.WHITE);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setBounds(0, 63, 87, 24);
		detailsPanel.add(lblLastname);
		lblLastname.setForeground(Color.BLACK);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userLastNameTF = new JTextField();
		userLastNameTF.setBounds(5, 89, 241, 24);
		detailsPanel.add(userLastNameTF);
		userLastNameTF.setEditable(false);
		userLastNameTF.setForeground(Color.BLACK);
		userLastNameTF.setColumns(10);
		userLastNameTF.setCaretColor(Color.WHITE);
		userLastNameTF.setBorder(null);
		userLastNameTF.setBackground(Color.WHITE);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(1, 115, 250, 6);
		detailsPanel.add(separator_7);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.WHITE);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(0, 126, 102, 24);
		detailsPanel.add(lblId);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userIDTF = new JTextField();
		userIDTF.setBounds(5, 152, 241, 24);
		detailsPanel.add(userIDTF);
		userIDTF.setEditable(false);
		userIDTF.setForeground(Color.BLACK);
		userIDTF.setColumns(10);
		userIDTF.setCaretColor(Color.WHITE);
		userIDTF.setBorder(null);
		userIDTF.setBackground(Color.WHITE);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(1, 178, 250, 6);
		detailsPanel.add(separator_8);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.WHITE);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(0, 189, 102, 24);
		detailsPanel.add(lblType);
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userTypeTF = new JTextField();
		userTypeTF.setBounds(5, 215, 241, 24);
		detailsPanel.add(userTypeTF);
		userTypeTF.setEditable(false);
		userTypeTF.setForeground(Color.BLACK);
		userTypeTF.setColumns(10);
		userTypeTF.setCaretColor(Color.WHITE);
		userTypeTF.setBorder(null);
		userTypeTF.setBackground(Color.WHITE);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(1, 241, 250, 6);
		detailsPanel.add(separator_9);
		separator_9.setForeground(Color.BLACK);
		separator_9.setBackground(Color.WHITE);
		
		lblUserDepartment = new JLabel("Branch/Department");
		lblUserDepartment.setBounds(1, 252, 139, 24);
		detailsPanel.add(lblUserDepartment);
		lblUserDepartment.setForeground(Color.BLACK);
		lblUserDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userDepartmentTF = new JTextField();
		userDepartmentTF.setBounds(6, 278, 241, 24);
		detailsPanel.add(userDepartmentTF);
		userDepartmentTF.setEditable(false);
		userDepartmentTF.setForeground(Color.BLACK);
		userDepartmentTF.setColumns(10);
		userDepartmentTF.setCaretColor(Color.WHITE);
		userDepartmentTF.setBorder(null);
		userDepartmentTF.setBackground(Color.WHITE);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(2, 304, 250, 6);
		detailsPanel.add(separator_10);
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.WHITE);
		
		yearUserDetailsPanel = new JPanel();
		yearUserDetailsPanel.setBounds(0, 315, 251, 58);
		detailsPanel.add(yearUserDetailsPanel);
		yearUserDetailsPanel.setBackground(Color.WHITE);
		yearUserDetailsPanel.setLayout(null);
		yearUserDetailsPanel.setVisible(true);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(0, 0, 102, 24);
		yearUserDetailsPanel.add(lblYear);
		lblYear.setForeground(Color.BLACK);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		userYearTF = new JTextField();
		userYearTF.setBounds(5, 26, 241, 24);
		yearUserDetailsPanel.add(userYearTF);
		userYearTF.setEditable(false);
		userYearTF.setForeground(Color.BLACK);
		userYearTF.setColumns(10);
		userYearTF.setCaretColor(Color.WHITE);
		userYearTF.setBorder(null);
		userYearTF.setBackground(Color.WHITE);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(1, 52, 250, 6);
		yearUserDetailsPanel.add(separator_11);
		separator_11.setForeground(Color.BLACK);
		separator_11.setBackground(Color.WHITE);
		
		JButton btnCheckUsersUploaded = new JButton("Check user's uploaded documents");
		btnCheckUsersUploaded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentUI.showDocumentList(currentID,true);
			}
		});
		btnCheckUsersUploaded.setBounds(4, 392, 246, 23);
		detailsPanel.add(btnCheckUsersUploaded);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 364, 443);
		add(scrollPane);
		
		userListPanel = new JPanel();
		scrollPane.setViewportView(userListPanel);
		userListPanel.setBackground(Color.WHITE);
		userListPanel.setLayout(null);		
		
	}
	
	public void AddDetails(String id) {
		currentID=id;
		userListPanel.setVisible(false);
		scrollPane.setVisible(false);
		detailsPanel.setVisible(true);
		Profile view=Database.searchProfileByUserID(id);
		userFirstNameTF.setText(view.getFirstName());
		userLastNameTF.setText(view.getLastName());
		userIDTF.setText(""+view.getID());
		userTypeTF.setText(view.getType());
		if(view.getType().equals("Student")) {
			lblUserDepartment.setText("Branch");
			Student s=(Student) view;
			userDepartmentTF.setText(s.getBranch());
			userYearTF.setText(s.getYear());
			yearUserDetailsPanel.setVisible(true);
		}
		else if(view.getType().equals("Faculty")) {
			lblUserDepartment.setText("Department");
			Faculty f=(Faculty) view;
			userDepartmentTF.setText(f.getDept());
			yearUserDetailsPanel.setVisible(false);
		}
	}
	public void showUserList(String name) {
		detailsPanel.setVisible(false);
		scrollPane.setVisible(true);
		userListPanel.setVisible(true);
		ArrayList<String> userIDs=Database.searchUserbyName(name);
		int ypos=0;
		
		Component[] components=userListPanel.getComponents();
		for(Component c:components) {
			c.setVisible(false);
			remove(c);
		}
		
		for(String id:userIDs) {
			Profile p=Database.searchProfileByUserID(id);
			ResultPanel newPanel=new ResultPanel(p);
			newPanel.setBounds(0, ypos, 364, 25);
			newPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					AddDetails(id);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					newPanel.setBackground(Color.LIGHT_GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					newPanel.setBackground(Color.WHITE);
				}
			});
			ypos+=26;
			userListPanel.add(newPanel);			
		}
		userListPanel.setPreferredSize(new Dimension(364,ypos));
	}
}

class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResultPanel(Profile p) {
		setBounds(0, 0, 364, 25);
		setLayout(null);
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 6, 46, 14);
		add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel(p.getFirstName()+" "+p.getLastName());
		lblNewLabel.setBounds(66, 6, 129, 14);
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(205, 6, 46, 14);
		add(lblId_1);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId_1.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel(""+p.getID());
		lblNewLabel_2.setBounds(261, 6, 46, 14);
		add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.BLACK);
	}
}
