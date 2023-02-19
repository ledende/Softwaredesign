package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import database.Database;
import model.*;

import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class DashboardGUI extends JFrame {

	private JPanel contentPane;
	private JPanel DashboardPanel;
	private JPanel uploadDocumentsPanel;
	JLabel label;
	JToggleButton tglbtnUploadANew;
	JToggleButton tglbtnVeiwableNotice;
	JToggleButton tglbtnViewSubmittedDocuments;
	JButton btnProfile;
	private JLabel label_1;
	private JComboBox<String> doctypeCB;
	private JLabel label_2;
	private JSeparator separator_1;
	private JTextField validTillTF;
	private JLabel label_3;
	private JSeparator separator_2;
	private JTextField validFromTF;
	private JLabel label_4;
	private JLabel label_5;
	private JButton btnChooseFile;
	private JSeparator separator_3;
	private JTextField chooseFileTF;
	private JLabel label_6;
	private JTextField titleTF;
	private JSeparator separator_4;
	private JLabel lblDocumentTitle;
	private JLabel lblUploadADocument;
	private JPanel viewAvailableNoticePanel;
	private JPanel viewSubmittedDocumentsPanel;
	private JCheckBox mechanicalCheckBox;
	private JCheckBox cseCheckBox;
	private JCheckBox cceCheckBox;
	private JCheckBox eceCheckBox;
	private JCheckBox mmeCheckBox;
	private JCheckBox hssCheckBox;
	private JCheckBox mathematicsCheckBox;
	private JCheckBox firstCheckBox;
	private JCheckBox fourthCheckBox;
	private JCheckBox thirdCheckBox;
	private JCheckBox secondCheckBox;
	private JPanel departmentPanel;
	private JPanel branchPanel;
	private JPanel yearPanel;
	private JButton btnNewButton;
	private final ButtonGroup toggleButtonGroup = new ButtonGroup();
	private JFileChooser fileChooser;
	private JCheckBox electronicsCheckBox;
	private JCheckBox computersCheckBox;
	private JCheckBox facultyCheckBox;
	private JCheckBox studentCheckBox;
	private final ButtonGroup searchUserRadioButtonGroup = new ButtonGroup();
	private JTextField searchUserTF;
	private JLabel lblSubmittedDocuments;
	private JPanel showSumittedDocumentsResultPanel;
	private JScrollPane submittedDocumentsScrollPane;
	private JPanel searchDocumentPanel;
	private JTextField searchDocumentTF;
	private JPanel searchUserPanel;
	private JPanel welcomePanel;
	private JPanel panel;
	private JPanel showDocumentSearchResultPanel;
	private JLabel lblNewLabel_1;
	private JPanel showAvailableNoticeResultPanel;
	private JScrollPane availableNoticeScrollPane;
	
	
	private UserDetailsPanel userDetailsPanel;
	private JPanel noticeAddPanel;
	private JPanel noticeAddPanel2;
	private JPanel publicationAddPanel;
	private JTextField journalTF;
	private JLabel lblNumberOfCitations;
	private JTextField citationsTF;
	private JSeparator separator_6;
	private JLabel lblImpactFactorOf;
	private JTextField impactFactorTF;
	private JSeparator separator_7;
	private JLabel lblNewLabel_3;
	private JTextField publicationDateTF;
	private JSeparator separator_8;
	
	/**
	 * Create the frame.
	 */
	public DashboardGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 40, 659, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		fileChooser=new JFileChooser("D:\\acad");
		
		viewAvailableNoticePanel = new JPanel();
		viewAvailableNoticePanel.setBounds(255, 0, 384, 580);
		viewAvailableNoticePanel.setBackground(Color.WHITE);
		contentPane.add(viewAvailableNoticePanel);
		viewAvailableNoticePanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Available Notices");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 384, 35);
		viewAvailableNoticePanel.add(lblNewLabel_1);
		
		availableNoticeScrollPane = new JScrollPane();
		availableNoticeScrollPane.setBounds(0, 57, 384, 512);
		viewAvailableNoticePanel.add(availableNoticeScrollPane);
		
		showAvailableNoticeResultPanel = new JPanel();
		showAvailableNoticeResultPanel.setBackground(Color.WHITE);
		availableNoticeScrollPane.setViewportView(showAvailableNoticeResultPanel);
		showAvailableNoticeResultPanel.setLayout(null);
		viewAvailableNoticePanel.setVisible(false);
		
		searchDocumentPanel = new JPanel();
		searchDocumentPanel.setBackground(Color.WHITE);
		searchDocumentPanel.setBounds(255, 0, 384, 580);
		contentPane.add(searchDocumentPanel);
		searchDocumentPanel.setLayout(null);
		searchDocumentPanel.setVisible(false);
		
		JLabel lblSearchDocument = new JLabel("Search Document");
		lblSearchDocument.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchDocument.setBounds(68, 11, 146, 24);
		searchDocumentPanel.add(lblSearchDocument);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setForeground(Color.BLACK);
		separator_12.setBounds(68, 67, 238, 2);
		searchDocumentPanel.add(separator_12);
		
		searchDocumentTF = new JTextField();
		searchDocumentTF.setColumns(10);
		searchDocumentTF.setBorder(null);
		searchDocumentTF.setBackground(Color.WHITE);
		searchDocumentTF.setBounds(69, 44, 230, 20);
		searchDocumentPanel.add(searchDocumentTF);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String documentSearch=searchDocumentTF.getText();
					if(documentSearch.equals("")) {
						throw new Exception("Enter a search Query");
					}
					ArrayList<Integer> docList=Database.searchDocbyName(documentSearch);
					int ypos=0;
					Component[] components=showDocumentSearchResultPanel.getComponents();
					for(Component c:components) {
						c.setVisible(false);
						remove(c);					
					}
					
					for(int doc_id:docList) {
						Document d=Database.searchDocbyDocID(doc_id);
						DocumentResultPanelGUI newPanel=new DocumentResultPanelGUI(d);
						newPanel.setBounds(0, ypos, 366, 87);
						showDocumentSearchResultPanel.add(newPanel);
						newPanel.setVisible(true);
						newPanel.setColor(Color.BLACK);
						newPanel.setForeground(Color.BLACK);
						ypos+=88;
						//System.out.println(""+doc_id);
					}
					showDocumentSearchResultPanel.setPreferredSize(new Dimension(374, ypos));
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		button.setBounds(140, 107, 89, 23);
		searchDocumentPanel.add(button);
		
		JScrollPane searchDocumentScrollPane = new JScrollPane();
		searchDocumentScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		searchDocumentScrollPane.setBounds(0, 132, 384, 437);
		searchDocumentPanel.add(searchDocumentScrollPane);
		
		showDocumentSearchResultPanel = new JPanel();
		showDocumentSearchResultPanel.setForeground(Color.BLACK);
		searchDocumentScrollPane.setViewportView(showDocumentSearchResultPanel);
		showDocumentSearchResultPanel.setBackground(Color.WHITE);
		showDocumentSearchResultPanel.setLayout(null);
		
		uploadDocumentsPanel = new JPanel();
		uploadDocumentsPanel.setBounds(255, 0, 384, 580);
		contentPane.add(uploadDocumentsPanel);
		uploadDocumentsPanel.setBackground(Color.WHITE);
		uploadDocumentsPanel.setLayout(null);
		uploadDocumentsPanel.setVisible(false);
		
		publicationAddPanel = new JPanel();
		publicationAddPanel.setBackground(Color.WHITE);
		publicationAddPanel.setBounds(39, 203, 254, 54);
		uploadDocumentsPanel.add(publicationAddPanel);
		publicationAddPanel.setLayout(null);
		publicationAddPanel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Journal where published");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(0, 0, 155, 14);
		publicationAddPanel.add(lblNewLabel_2);
		
		journalTF = new JTextField();
		journalTF.setForeground(Color.BLACK);
		journalTF.setBounds(5, 25, 245, 24);
		publicationAddPanel.add(journalTF);
		journalTF.setColumns(10);
		journalTF.setBorder(null);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(0, 50, 260, 2);
		publicationAddPanel.add(separator_5);
		
		JPanel publicationAddPanel2 = new JPanel();
		publicationAddPanel2.setBounds(39, 343, 327, 171);
		publicationAddPanel2.setBackground(Color.WHITE);
		uploadDocumentsPanel.add(publicationAddPanel2);
		publicationAddPanel2.setLayout(null);
		publicationAddPanel2.setVisible(false);
		
		lblNumberOfCitations = new JLabel("Number of Citations");
		lblNumberOfCitations.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfCitations.setBounds(0, 0, 155, 14);
		publicationAddPanel2.add(lblNumberOfCitations);
		
		citationsTF = new JTextField();
		citationsTF.setForeground(Color.BLACK);
		citationsTF.setColumns(10);
		citationsTF.setBorder(null);
		citationsTF.setBounds(5, 25, 245, 24);
		publicationAddPanel2.add(citationsTF);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(0, 50, 260, 2);
		publicationAddPanel2.add(separator_6);
		
		lblImpactFactorOf = new JLabel("Impact Factor of Journal");
		lblImpactFactorOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblImpactFactorOf.setBounds(0, 60, 155, 14);
		publicationAddPanel2.add(lblImpactFactorOf);
		
		impactFactorTF = new JTextField();
		impactFactorTF.setForeground(Color.BLACK);
		impactFactorTF.setColumns(10);
		impactFactorTF.setBorder(null);
		impactFactorTF.setBounds(5, 85, 245, 24);
		publicationAddPanel2.add(impactFactorTF);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(0, 110, 260, 2);
		publicationAddPanel2.add(separator_7);
		
		lblNewLabel_3 = new JLabel("Publication Date (dd-MM-yyyy)");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(0, 120, 188, 14);
		publicationAddPanel2.add(lblNewLabel_3);
		
		publicationDateTF = new JTextField();
		publicationDateTF.setForeground(Color.BLACK);
		publicationDateTF.setColumns(10);
		publicationDateTF.setBorder(null);
		publicationDateTF.setBounds(5, 144, 245, 24);
		publicationAddPanel2.add(publicationDateTF);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(0, 169, 260, 2);
		publicationAddPanel2.add(separator_8);
		
		noticeAddPanel = new JPanel();
		noticeAddPanel.setBackground(Color.WHITE);
		noticeAddPanel.setBounds(39, 203, 254, 54);
		uploadDocumentsPanel.add(noticeAddPanel);
		noticeAddPanel.setLayout(null);
		noticeAddPanel.setVisible(false);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 52, 108, 2);
		noticeAddPanel.add(separator_1);
		separator_1.setForeground(Color.BLACK);
		
		validTillTF = new JTextField();
		validTillTF.setBounds(150, 25, 100, 24);
		noticeAddPanel.add(validTillTF);
		validTillTF.setForeground(Color.BLACK);
		validTillTF.setColumns(10);
		validTillTF.setBorder(null);
		validTillTF.setBackground(Color.WHITE);
		
		label_3 = new JLabel("-");
		label_3.setBounds(114, 30, 26, 14);
		noticeAddPanel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		separator_2 = new JSeparator();
		separator_2.setBounds(146, 52, 108, 2);
		noticeAddPanel.add(separator_2);
		separator_2.setForeground(Color.BLACK);
		
		validFromTF = new JTextField();
		validFromTF.setBounds(4, 25, 100, 24);
		noticeAddPanel.add(validFromTF);
		validFromTF.setForeground(Color.BLACK);
		validFromTF.setColumns(10);
		validFromTF.setBorder(null);
		validFromTF.setBackground(Color.WHITE);
		
		label_4 = new JLabel("Valid From");
		label_4.setBounds(0, 0, 100, 20);
		noticeAddPanel.add(label_4);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		label_5 = new JLabel("Valid Till");
		label_5.setBounds(146, 0, 100, 20);
		noticeAddPanel.add(label_5);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		noticeAddPanel2 = new JPanel();
		noticeAddPanel2.setBackground(Color.WHITE);
		noticeAddPanel2.setBounds(39, 343, 327, 171);
		uploadDocumentsPanel.add(noticeAddPanel2);
		noticeAddPanel2.setLayout(null);
		noticeAddPanel2.setVisible(false);
		
		label_1 = new JLabel("Targeted Audience");
		label_1.setBounds(0, 0, 127, 20);
		noticeAddPanel2.add(label_1);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		facultyCheckBox = new JCheckBox("Faculty");
		facultyCheckBox.setBounds(2, 20, 72, 23);
		noticeAddPanel2.add(facultyCheckBox);
		facultyCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				setEnabledFaculty(facultyCheckBox.isSelected());
			}
		});
		facultyCheckBox.setBackground(Color.WHITE);
		
		studentCheckBox = new JCheckBox("Student");
		studentCheckBox.setBounds(126, 20, 72, 23);
		noticeAddPanel2.add(studentCheckBox);
		studentCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setEnabledStudent(studentCheckBox.isSelected());
			}
		});
		studentCheckBox.setBackground(Color.WHITE);
		
		departmentPanel = new JPanel();
		departmentPanel.setBounds(0, 42, 111, 129);
		noticeAddPanel2.add(departmentPanel);
		departmentPanel.setBorder(new TitledBorder(null, "Department", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		departmentPanel.setBackground(Color.WHITE);
		departmentPanel.setLayout(null);
		
		mathematicsCheckBox = new JCheckBox("Mathematics");
		mathematicsCheckBox.setBounds(6, 99, 88, 23);
		departmentPanel.add(mathematicsCheckBox);
		mathematicsCheckBox.setBackground(Color.WHITE);
		
		hssCheckBox = new JCheckBox("HSS");
		hssCheckBox.setBounds(6, 79, 88, 23);
		departmentPanel.add(hssCheckBox);
		hssCheckBox.setBackground(Color.WHITE);
		
		mechanicalCheckBox = new JCheckBox("Mechanical");
		mechanicalCheckBox.setBounds(6, 59, 88, 23);
		departmentPanel.add(mechanicalCheckBox);
		mechanicalCheckBox.setBackground(Color.WHITE);
		
		electronicsCheckBox = new JCheckBox("Electronics");
		electronicsCheckBox.setBounds(6, 39, 88, 23);
		departmentPanel.add(electronicsCheckBox);
		electronicsCheckBox.setBackground(Color.WHITE);
		
		computersCheckBox = new JCheckBox("Computer");
		computersCheckBox.setBounds(6, 19, 99, 23);
		departmentPanel.add(computersCheckBox);
		computersCheckBox.setBackground(Color.WHITE);
		
		branchPanel = new JPanel();
		branchPanel.setBounds(135, 43, 94, 128);
		noticeAddPanel2.add(branchPanel);
		branchPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Branch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		branchPanel.setBackground(Color.WHITE);
		branchPanel.setLayout(null);
		
		cseCheckBox = new JCheckBox("CSE");
		cseCheckBox.setBounds(6, 21, 79, 23);
		branchPanel.add(cseCheckBox);
		cseCheckBox.setBackground(Color.WHITE);
		
		cceCheckBox = new JCheckBox("CCE");
		cceCheckBox.setBounds(6, 41, 79, 23);
		branchPanel.add(cceCheckBox);
		cceCheckBox.setBackground(Color.WHITE);
		
		eceCheckBox = new JCheckBox("ECE");
		eceCheckBox.setBounds(6, 61, 79, 23);
		branchPanel.add(eceCheckBox);
		eceCheckBox.setBackground(Color.WHITE);
		
		mmeCheckBox = new JCheckBox("Mechanical");
		mmeCheckBox.setBounds(6, 81, 79, 23);
		branchPanel.add(mmeCheckBox);
		mmeCheckBox.setBackground(Color.WHITE);
		
		yearPanel = new JPanel();
		yearPanel.setBounds(240, 44, 87, 126);
		noticeAddPanel2.add(yearPanel);
		yearPanel.setBorder(new TitledBorder(null, "Year", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		yearPanel.setBackground(Color.WHITE);
		yearPanel.setLayout(null);
		
		fourthCheckBox = new JCheckBox("4th year");
		fourthCheckBox.setBounds(1, 74, 79, 23);
		yearPanel.add(fourthCheckBox);
		fourthCheckBox.setBackground(Color.WHITE);
		
		thirdCheckBox = new JCheckBox("3rd year");
		thirdCheckBox.setBounds(1, 54, 79, 23);
		yearPanel.add(thirdCheckBox);
		thirdCheckBox.setBackground(Color.WHITE);
		
		secondCheckBox = new JCheckBox("2nd year");
		secondCheckBox.setBounds(1, 34, 79, 23);
		yearPanel.add(secondCheckBox);
		secondCheckBox.setBackground(Color.WHITE);
		
		firstCheckBox = new JCheckBox("1st year");
		firstCheckBox.setBounds(1, 14, 79, 23);
		yearPanel.add(firstCheckBox);
		firstCheckBox.setBackground(Color.WHITE);
		
		doctypeCB = new JComboBox<String>();
		doctypeCB.addItem("Select");
		doctypeCB.addItem("Publication");
		doctypeCB.addItem("Notice");
		doctypeCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(doctypeCB.getSelectedItem().equals("Publication")) {
					if(doctypeCB.getItemAt(0).equals("Select"))
						doctypeCB.removeItem("Select");
					
					noticeAddPanel.setVisible(false);
					noticeAddPanel2.setVisible(false);
					
					publicationAddPanel2.setVisible(true);
					publicationAddPanel.setVisible(true);
				}
				else if(doctypeCB.getSelectedItem().equals("Notice")) {
					if(doctypeCB.getItemAt(0).equals("Select"))
						doctypeCB.removeItem("Select");
					publicationAddPanel2.setVisible(false);
					publicationAddPanel.setVisible(false);
					
					noticeAddPanel.setVisible(true);
					noticeAddPanel2.setVisible(true);
				}
			}
		});
		doctypeCB.setBackground(Color.WHITE);
		doctypeCB.setBounds(43, 164, 250, 30);
		
		uploadDocumentsPanel.add(doctypeCB);
		
		label_2 = new JLabel("Document Type");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(39, 133, 100, 20);
		uploadDocumentsPanel.add(label_2);
		
		btnChooseFile = new JButton("Choose FIle");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(contentPane);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    chooseFileTF.setText(selectedFile.getAbsolutePath());
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    /*
				    try {
				    	Files.copy(selectedFile.toPath(), Paths.get("E:\\shared\\documentManagement\\localStorage\\1"));
				    }
				    catch(Exception e1) {
				    	System.out.println(e1);
				    }
				    */
				}
			}
		});
		btnChooseFile.setForeground(Color.BLACK);
		btnChooseFile.setFocusPainted(false);
		btnChooseFile.setBackground(Color.LIGHT_GRAY);
		btnChooseFile.setBounds(262, 298, 104, 23);
		uploadDocumentsPanel.add(btnChooseFile);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(39, 325, 204, 2);
		uploadDocumentsPanel.add(separator_3);
		
		chooseFileTF = new JTextField();
		chooseFileTF.setForeground(Color.BLACK);
		chooseFileTF.setColumns(10);
		chooseFileTF.setBorder(null);
		chooseFileTF.setBackground(Color.WHITE);
		chooseFileTF.setBounds(43, 298, 196, 24);
		uploadDocumentsPanel.add(chooseFileTF);
		
		label_6 = new JLabel("Choose File");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(39, 273, 100, 20);
		uploadDocumentsPanel.add(label_6);
		
		titleTF = new JTextField();
		titleTF.setForeground(Color.BLACK);
		titleTF.setColumns(10);
		titleTF.setBorder(null);
		titleTF.setBackground(Color.WHITE);
		titleTF.setBounds(43, 88, 250, 24);
		uploadDocumentsPanel.add(titleTF);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(39, 115, 258, 2);
		uploadDocumentsPanel.add(separator_4);
		
		lblDocumentTitle = new JLabel("Document Title");
		lblDocumentTitle.setForeground(Color.BLACK);
		lblDocumentTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDocumentTitle.setBounds(39, 63, 100, 20);
		uploadDocumentsPanel.add(lblDocumentTitle);
		
		lblUploadADocument = new JLabel("Upload a Document");
		lblUploadADocument.setHorizontalAlignment(SwingConstants.CENTER);
		lblUploadADocument.setForeground(Color.BLACK);
		lblUploadADocument.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUploadADocument.setBounds(112, 22, 163, 30);
		uploadDocumentsPanel.add(lblUploadADocument);
		
		btnNewButton = new JButton("Add Document");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String title=titleTF.getText();
					if(title.equals("")) {
						throw new Exception("Enter a title");
					}
					String path=chooseFileTF.getText();
					if(path.equals("")) {
						throw new Exception("Select a File");
					}
					String type=(String) doctypeCB.getSelectedItem();
					if(type.equals("Publication")) {
						String journal=journalTF.getText();
						int impactFactor=0,citations=0;
						String published_date=publicationDateTF.getText();
						try {
							Date date=new SimpleDateFormat("dd-MM-yyyy").parse(published_date);
						}
						catch(ParseException pe) {
							throw new Exception("Enter the date like dd-MM-yyyy");
						}
						
						int dd = Integer.parseInt(published_date.substring(0, 2));
						int MM =Integer.parseInt(published_date.substring(3, 5));
						int yyyy = Integer.parseInt(published_date.substring(6));
						if(!checkDate(dd, MM, yyyy)) {
							throw new Exception("Enter valid Publication date");
						}
						try {
							impactFactor=Integer.parseInt(impactFactorTF.getText());
							citations=Integer.parseInt(citationsTF.getText());
							if(impactFactor < 0 || citations < 0) {
								throw new NumberFormatException();
							}
						}
						catch(NumberFormatException ne) {
							throw new Exception("Impact Factor/Number of Citations must be positive integers");
						}
						Publication p=new Publication(-1, Database.getCurrentProfile().getID(),title,type,"", path, published_date, journal, impactFactor,citations);
						Database.addDocument(p,path);
					}
					else if(type.equals("Notice")) {
						String validfrom=validFromTF.getText();
						String validtill=validTillTF.getText();
						Date date1,date2;
						try {
							date1=new SimpleDateFormat("dd-MM-yyyy").parse(validfrom);
							date2=new SimpleDateFormat("dd-MM-yyyy").parse(validtill);
						}
						catch(ParseException pe) {
							throw new Exception("Enter the date in above format dd-MM-yyyy ");
						}
						int dd1 = Integer.parseInt(validfrom.substring(0, 2));
						int MM1 =Integer.parseInt(validfrom.substring(3, 5));
						int yyyy1 = Integer.parseInt(validfrom.substring(6));
						
						int dd2 = Integer.parseInt(validtill.substring(0, 2));
						int MM2 = Integer.parseInt(validtill.substring(3, 5));
						int yyyy2 = Integer.parseInt(validtill.substring(6));
						
						if(!checkDate(dd1, MM1, yyyy1)) {
							throw new Exception("Enter a valid 'Valid From' date");
						}
						if(!checkDate(dd2, MM2, yyyy2)) {
							throw new Exception("Enter a valid 'Valid Till' date");
						}
						if (date1.compareTo(date2) > 0){
							 throw new Exception("validfrom is after validtill");
						}
						
						ArrayList<String> departments=new ArrayList<String>();
						ArrayList<String> branchs=new ArrayList<String>();
						ArrayList<String> years=new ArrayList<String>();
						if(facultyCheckBox.isSelected()) {
							for(Component c:departmentPanel.getComponents()) {
								JCheckBox c2=(JCheckBox) c;
								if(c2.isSelected()) {
									departments.add(c2.getText());
								}
							}
						}
						if(studentCheckBox.isSelected()) {
							for(Component c:branchPanel.getComponents()) {
								JCheckBox c2=(JCheckBox) c;
								if(c2.isSelected()) {
									branchs.add(c2.getText());
								}
							}
							for(Component c:yearPanel.getComponents()) {
								JCheckBox c2=(JCheckBox) c;
								if(c2.isSelected()) {
									years.add(c2.getText());
								}
							}
						}
						
						if(departments.isEmpty() && branchs.isEmpty() && years.isEmpty()) {
							throw new Exception("Select atleast one targeted audience");
						}
						if(!branchs.isEmpty()) {
							if(years.isEmpty()) {
								for(Component c:yearPanel.getComponents()) {
									JCheckBox c2=(JCheckBox) c;
									years.add(c2.getText());
								}
							}
						}
						else if(branchs.isEmpty()) {
							if(!years.isEmpty()) {
								for(Component c:branchPanel.getComponents()) {
									JCheckBox c2=(JCheckBox) c;
									branchs.add(c2.getText());
								}
							}
						}
						
						Notice n=new Notice(-1, Database.getCurrentProfile().getID(),title,type,"", path, validfrom, validtill);
						Database.addDocument(n,path);
						Database.addNoticeAudience(((Document)n).getDoc_id(), departments, branchs, years);
					}
					else {
						throw new Exception("Select a Valid Type");
					}
					
					
					noticeAddPanel.setVisible(false);
					noticeAddPanel2.setVisible(false);
					publicationAddPanel2.setVisible(false);
					publicationAddPanel.setVisible(false);
					titleTF.setText("");
					chooseFileTF.setText("");
					doctypeCB.removeAll();
					doctypeCB.addItem("Select");
					doctypeCB.addItem("Publication");
					doctypeCB.addItem("Notice");
					journalTF.setText("");
					impactFactorTF.setText("");
					citationsTF.setText("");
					validFromTF.setText("");
					validTillTF.setText("");
					setEnabledFaculty(false);
					setEnabledFaculty(false);
					facultyCheckBox.setSelected(false);
					studentCheckBox.setSelected(false);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(114, 531, 153, 28);
		uploadDocumentsPanel.add(btnNewButton);
		
		viewSubmittedDocumentsPanel = new JPanel();
		viewSubmittedDocumentsPanel.setBounds(255, 0, 383, 580);
		viewSubmittedDocumentsPanel.setBackground(Color.WHITE);
		contentPane.add(viewSubmittedDocumentsPanel);
		viewSubmittedDocumentsPanel.setLayout(null);
		
		lblSubmittedDocuments = new JLabel("Submitted Documents");
		lblSubmittedDocuments.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmittedDocuments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubmittedDocuments.setBounds(10, 11, 363, 38);
		viewSubmittedDocumentsPanel.add(lblSubmittedDocuments);
		
		submittedDocumentsScrollPane = new JScrollPane();
		submittedDocumentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		submittedDocumentsScrollPane.setBounds(0, 97, 383, 472);
		viewSubmittedDocumentsPanel.add(submittedDocumentsScrollPane);
		
		showSumittedDocumentsResultPanel = new JPanel();
		submittedDocumentsScrollPane.setViewportView(showSumittedDocumentsResultPanel);
		showSumittedDocumentsResultPanel.setBounds(0, 97, 383, 472);
		showSumittedDocumentsResultPanel.setBackground(Color.WHITE);
		showSumittedDocumentsResultPanel.setLayout(null);
		viewSubmittedDocumentsPanel.setVisible(false);
		
		searchUserPanel = new JPanel();
		searchUserPanel.setBackground(Color.WHITE);
		searchUserPanel.setBounds(255, 0, 384, 580);
		contentPane.add(searchUserPanel);
		searchUserPanel.setLayout(null);
		searchUserPanel.setVisible(false);
		
		JLabel lblSearchUser = new JLabel("Search User");
		lblSearchUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchUser.setBounds(64, 11, 126, 24);
		searchUserPanel.add(lblSearchUser);
		
		userDetailsPanel =new UserDetailsPanel(this);
		userDetailsPanel.setBounds(5, 133, 376, 443);
		searchUserPanel.add(userDetailsPanel);
		userDetailsPanel.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(64, 67, 238, 2);
		searchUserPanel.add(separator);
		
		JRadioButton idRadioBtn = new JRadioButton("By ID");
		searchUserRadioButtonGroup.add(idRadioBtn);
		idRadioBtn.setBackground(Color.WHITE);
		idRadioBtn.setBounds(65, 77, 109, 23);
		searchUserPanel.add(idRadioBtn);
		idRadioBtn.setSelected(true);
		
		JRadioButton nameRadioBtn = new JRadioButton("By Name");
		searchUserRadioButtonGroup.add(nameRadioBtn);
		nameRadioBtn.setBackground(Color.WHITE);
		nameRadioBtn.setBounds(193, 77, 109, 23);
		searchUserPanel.add(nameRadioBtn);
		
		searchUserTF = new JTextField();
		searchUserTF.setColumns(10);
		searchUserTF.setBorder(null);
		searchUserTF.setBackground(Color.WHITE);
		searchUserTF.setBounds(65, 44, 230, 20);
		searchUserPanel.add(searchUserTF);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userSearch=searchUserTF.getText();
				try {
				if(userSearch.equals("")) {
					throw new Exception("Enter a search Query");
				}
					
				if(idRadioBtn.isSelected()) 
				{
					try 
					{
						String id=userSearch;
						if(id.equals("")){
							throw new Exception("Enter valid ID");
						}
						if(Database.checkIDAlreadyExists(id)) {
							userDetailsPanel.setVisible(true);
							userDetailsPanel.AddDetails(id);
							userDetailsPanel.setBounds(10,133,364,443);
						}
						else 
						{
							throw new Exception("No user with ID: "+id);
						}
					}
					catch(Exception e) {
						System.out.println("Error: searchUserDashboardGUI"+e);
					}
				}
				else if(nameRadioBtn.isSelected()) {
					userDetailsPanel.setVisible(true);
					userDetailsPanel.showUserList(userSearch);
					userDetailsPanel.setBounds(10,133,364,443);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
			}
		});
		btnSearch.setBounds(143, 107, 89, 23);
		searchUserPanel.add(btnSearch);
		
		
		DashboardPanel = new JPanel();
		DashboardPanel.setBackground(Color.DARK_GRAY);
		DashboardPanel.setBounds(0, 0, 254, 580);
		contentPane.add(DashboardPanel);
		DashboardPanel.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 4, 82, 30);
		DashboardPanel.add(label);
		label.setIcon(new ImageIcon("D:\\eclipse-workspace\\documentManagement\\src\\logo.png"));
		
		tglbtnUploadANew = new JToggleButton("              Upload a new Document");
		toggleButtonGroup.add(tglbtnUploadANew);
		tglbtnUploadANew.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				uploadDocumentsPanel.setVisible(tglbtnUploadANew.isSelected());
				searchDocumentPanel.setVisible(false);
				searchUserPanel.setVisible(false);
				viewSubmittedDocumentsPanel.setVisible(false);
				viewAvailableNoticePanel.setVisible(false);
				welcomePanel.setVisible(false);
			}
		});
		tglbtnUploadANew.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnUploadANew.setBackground(Color.DARK_GRAY);
		tglbtnUploadANew.setForeground(Color.WHITE);
		tglbtnUploadANew.setBounds(0, 255, 256, 47);
		DashboardPanel.add(tglbtnUploadANew);
		tglbtnUploadANew.setBorder(null);
		
		tglbtnVeiwableNotice = new JToggleButton("              View available notices");
		toggleButtonGroup.add(tglbtnVeiwableNotice);
		tglbtnVeiwableNotice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				welcomePanel.setVisible(false);
				viewAvailableNoticePanel.setVisible(tglbtnVeiwableNotice.isSelected());
				Component[] components=showAvailableNoticeResultPanel.getComponents();
				for(Component c:components) {
					remove(c);
					c.setVisible(false);
				}
				showAvailableNoticeList();
			}
		});
		tglbtnVeiwableNotice.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnVeiwableNotice.setForeground(Color.WHITE);
		tglbtnVeiwableNotice.setBackground(Color.DARK_GRAY);
		tglbtnVeiwableNotice.setBounds(0, 302, 256, 47);
		DashboardPanel.add(tglbtnVeiwableNotice);
		tglbtnVeiwableNotice.setFocusPainted(false);
		tglbtnVeiwableNotice.setBorder(null);
		tglbtnViewSubmittedDocuments = new JToggleButton("              View Submitted Documents");
		tglbtnViewSubmittedDocuments.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				viewSubmittedDocumentsPanel.setVisible(tglbtnViewSubmittedDocuments.isSelected());
				if(tglbtnViewSubmittedDocuments.isSelected()) {					
					showDocumentList(Database.getCurrentProfile().getID(), false);					
				}
			}
		});
		toggleButtonGroup.add(tglbtnViewSubmittedDocuments);
		tglbtnViewSubmittedDocuments.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnViewSubmittedDocuments.setForeground(Color.WHITE);
		tglbtnViewSubmittedDocuments.setBackground(Color.DARK_GRAY);
		tglbtnViewSubmittedDocuments.setBounds(0, 349, 256, 47);
		DashboardPanel.add(tglbtnViewSubmittedDocuments);
		tglbtnViewSubmittedDocuments.setFocusPainted(false);
		tglbtnViewSubmittedDocuments.setBorder(null);
		
		btnProfile = new JButton("Profile");
		btnProfile.setBackground(Color.GRAY);
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBounds(155, 11, 89, 23);
		DashboardPanel.add(btnProfile);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfileGUI profilepage=new ProfileGUI();
				profilepage.setVisible(true);
				dispose();
			}
		});
		btnProfile.setFocusPainted(false);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.setForeground(Color.LIGHT_GRAY);
		lblLogout.setBounds(193, 45, 55, 23);
		DashboardPanel.add(lblLogout);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPageGUI login=new LoginPageGUI();
				login.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setText("<HTML><U><B>Logout</B></U></HTML>");
				lblLogout.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setText("<HTML>Logout</HTML>");
				lblLogout.setForeground(Color.WHITE);
			}
		});
		
		JToggleButton toggleSearchUserButton = new JToggleButton("               Search User");
		toggleSearchUserButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				searchUserPanel.setVisible(toggleSearchUserButton.isSelected());
				searchDocumentPanel.setVisible(false);
				uploadDocumentsPanel.setVisible(false);
				viewSubmittedDocumentsPanel.setVisible(false);
				viewAvailableNoticePanel.setVisible(false);
			}
		});
		toggleButtonGroup.add(toggleSearchUserButton);
		toggleSearchUserButton.setHorizontalAlignment(SwingConstants.LEFT);
		toggleSearchUserButton.setForeground(Color.WHITE);
		toggleSearchUserButton.setFocusPainted(false);
		toggleSearchUserButton.setBorder(null);
		toggleSearchUserButton.setBackground(Color.DARK_GRAY);
		toggleSearchUserButton.setBounds(0, 172, 256, 47);
		DashboardPanel.add(toggleSearchUserButton);
		
		JToggleButton tglbtnSearchDocument = new JToggleButton("               Search Document");
		tglbtnSearchDocument.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				searchUserPanel.setVisible(false);
				uploadDocumentsPanel.setVisible(false);
				viewSubmittedDocumentsPanel.setVisible(false);
				viewAvailableNoticePanel.setVisible(false);
				searchDocumentPanel.setVisible(tglbtnSearchDocument.isSelected());
				if(tglbtnSearchDocument.isSelected()) {
					Component[] components=showDocumentSearchResultPanel.getComponents();
					for(Component c:components) {
						c.setVisible(false);
						remove(c);
					}
				}
			}
		});
		toggleButtonGroup.add(tglbtnSearchDocument);
		tglbtnSearchDocument.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnSearchDocument.setForeground(Color.WHITE);
		tglbtnSearchDocument.setFocusPainted(false);
		tglbtnSearchDocument.setBorder(null);
		tglbtnSearchDocument.setBackground(Color.DARK_GRAY);
		tglbtnSearchDocument.setBounds(0, 125, 256, 47);
		DashboardPanel.add(tglbtnSearchDocument);
		
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		welcomePanel.setBounds(255, 0, 383, 580);
		contentPane.add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome "+Database.getCurrentProfile().getFirstName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 91, 356, 89);
		welcomePanel.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(638, -1, 22, 581);
		contentPane.add(panel);
		
		
		setEnabledFaculty(false);
		setEnabledStudent(false);
	}
	public void setEnabledFaculty(boolean b) {
		Component[] departmentComponents=departmentPanel.getComponents();
		for(Component c:departmentComponents ) {
			c.setEnabled(b);
			((JCheckBox)c).setSelected(false);
		}
	}
	public void setEnabledStudent(boolean b) {
		Component[] branchComponents=branchPanel.getComponents();
		for(Component c:branchComponents ) {
			c.setEnabled(b);
			((JCheckBox)c).setSelected(false);
		}
		Component[] yearComponents=yearPanel.getComponents();
		for(Component c:yearComponents ) {
			c.setEnabled(b);
			((JCheckBox)c).setSelected(false);
		}
	}
	
	public void showDocumentList(String currentID,boolean check) {
		searchDocumentPanel.setVisible(false);
		searchUserPanel.setVisible(false);
		viewAvailableNoticePanel.setVisible(false);
		uploadDocumentsPanel.setVisible(false);
		viewSubmittedDocumentsPanel.setVisible(true);
		Profile p=Database.searchProfileByUserID(currentID);
		if(check)
			lblSubmittedDocuments.setText("Submitted Documents by "+p.getFirstName()+" "+p.getLastName());
		else
			lblSubmittedDocuments.setText("My Submitted Documents");
		lblSubmittedDocuments.setFont(new Font("Tahoma", Font.BOLD, 16));
		Component[] components=showSumittedDocumentsResultPanel.getComponents();
		for(Component c:components) {
			remove(c);
			c.setVisible(false);
		}
		
		ArrayList<Integer> doc_IDList=Database.searchDocByUserID(currentID);
		int ypos=0;
		try {
			for(int doc_id:doc_IDList) {
				Document d=Database.searchDocbyDocID(doc_id);
				DocumentResultPanelGUI newPanel=new DocumentResultPanelGUI(d);
				newPanel.setBounds(0, ypos, 366, 87);
				showSumittedDocumentsResultPanel.add(newPanel);
				newPanel.setVisible(true);
				ypos+=88;
			}
		}
		catch(Exception ne) {
			ne.printStackTrace();
		}
		showSumittedDocumentsResultPanel.setPreferredSize(new Dimension(368, ypos));
	}
	public void showAvailableNoticeList() {
		searchDocumentPanel.setVisible(false);
		searchUserPanel.setVisible(false);
		uploadDocumentsPanel.setVisible(false);
		viewSubmittedDocumentsPanel.setVisible(false);
		viewAvailableNoticePanel.setVisible(true);
		lblSubmittedDocuments.setFont(new Font("Tahoma", Font.BOLD, 16));
		Component[] components=showAvailableNoticeResultPanel.getComponents();
		for(Component c:components) {
			remove(c);
			c.setVisible(false);
		}
		int ypos=0;
		
		if(Database.getCurrentProfile().getType().equals("Faculty")) {
			Faculty f=(Faculty) Database.getCurrentProfile();
			ArrayList<Integer> doc_IDList=Database.viewableNoticesFaculty(f.getDept());
			try {
				for(int doc_id:doc_IDList) {
					Document d=Database.searchDocbyDocID(doc_id);
					if(d.getDoc_type().equals("Notice")) {
						DocumentResultPanelGUI newPanel=new DocumentResultPanelGUI(d);
						newPanel.setBounds(0, ypos, 366, 87);
						showAvailableNoticeResultPanel.add(newPanel);
						newPanel.setVisible(true);
						ypos+=88;
					}
				}
			}
			catch(Exception ne) {
				ne.printStackTrace();
			}
		}
		else if(Database.getCurrentProfile().getType().equals("Student")) {
			System.out.println("casting");
			Student s=(Student) Database.getCurrentProfile();
			ArrayList<Integer> doc_IDList=Database.viewableNoticesStudent(s.getBranch(), s.getYear());
			try {
				for(int doc_id:doc_IDList) {
					Document d=Database.searchDocbyDocID(doc_id);
					if(d.getDoc_type().equals("Notice")) {
						DocumentResultPanelGUI newPanel=new DocumentResultPanelGUI(d);
						newPanel.setBounds(0, ypos, 366, 87);
						showAvailableNoticeResultPanel.add(newPanel);
						newPanel.setVisible(true);
						ypos+=88;
					}
				}
			}
			catch(Exception ne) {
				ne.printStackTrace();
			}
		}
		/*ArrayList<Integer> doc_IDList=Database.searchDocByUserID(userID);		
		try {
			for(int doc_id:doc_IDList) {
				Document d=Database.searchDocbyDocID(doc_id);
				if(d.getDoc_type().equals("Notice")) {
					DocumentResultPanelGUI newPanel=new DocumentResultPanelGUI(d);
					newPanel.setBounds(0, ypos, 366, 87);
					showAvailableNoticeResultPanel.add(newPanel);
					newPanel.setVisible(true);
					ypos+=88;
				}
			}
		}
		catch(Exception ne) {
			ne.printStackTrace();
		}*/
		
		showAvailableNoticeResultPanel.setPreferredSize(new Dimension(368, ypos));
	}
	
	public static boolean checkDate(int day,int month,int year) {
		boolean isTrueDate = true ;
		System.out.println(""+day+month+year);
		if(year<=0) {
			return false;
		}
		
	    if(month > 12 || month <1){
	    	isTrueDate = false;
	    }
	    else if (month == 1 || month == 3 || month == 5 || month ==  7 || month ==  8 || month ==  10 || month == 12){
	        if (day <= 31 && day>=1)
	        {   
	        	isTrueDate = true;
	        }
	        else
	        {
	        	isTrueDate = false;
	        }
	    }
	    else if (month == 4 || month == 6 || month == 9 || month == 11)
	    {
	    	if (day <= 30 && day>=1)
	    	{
	    		isTrueDate = true;
	    	}
	         else
	         {
	             isTrueDate = false;
	         }
	
	    }
	    else if (month == 2) // February check
	    {
	    	if (year % 4 == 0) // Leap year check for February
	    	{
	    		if (day <= 29 && day>=1)
	    		{
	    			isTrueDate = true;
	    		}
	    		else
	    		{
	    			isTrueDate = false;
	    		}
	    	}
	    	else if (year % 4 != 0)
	    	{
	    		if (day <= 28 && day>=1)
	    		{
	    			isTrueDate = true;
	    		}
	    		else
	    		{
	                 isTrueDate = false;
	            }
	    	}
	    }
	    return isTrueDate ;
	}
}

