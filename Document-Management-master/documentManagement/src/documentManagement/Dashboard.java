package documentManagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel createPanel;
	JLabel label;
	JToggleButton tglbtnUploadANew;
	JToggleButton tglbtnBrowse;
	JToggleButton tglbtnViewSubmittedDocuments;
	JButton btnProfile;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JSeparator separator;
	private JTextField textField;
	private JLabel label_1;
	private JComboBox<String> comboBox;
	private JLabel label_2;
	private JSeparator separator_1;
	private JTextField textField_1;
	private JLabel label_3;
	private JSeparator separator_2;
	private JTextField textField_2;
	private JLabel label_4;
	private JLabel label_5;
	private JButton button;
	private JSeparator separator_3;
	private JTextField textField_3;
	private JLabel label_6;
	private JTextField textField_4;
	private JSeparator separator_4;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel lblClose;
	private JPanel browsePanel;
	private JPanel viewPanel;
	private JLabel lblSearch;
	private JTextField textField_5;
	private JLabel lblFilter;

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, -1, 258, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(631, -1, 29, 480);
		contentPane.add(panel_3);
		
		browsePanel = new JPanel();
		browsePanel.setBounds(256, 0, 376, 470);
		browsePanel.setBackground(Color.WHITE);
		contentPane.add(browsePanel);
		browsePanel.setLayout(null);
		
		lblSearch = new JLabel("Search");
		lblSearch.setBounds(76, 43, 46, 14);
		browsePanel.add(lblSearch);
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(80, 68, 230, 20);
		browsePanel.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(76, 89, 238, 2);
		browsePanel.add(separator_5);
		
		lblFilter = new JLabel("Add filters");
		lblFilter.setForeground(SystemColor.textHighlight);
		lblFilter.setBounds(76, 102, 70, 14);
		browsePanel.add(lblFilter);
		browsePanel.setVisible(false);
		lblFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFilter.setText("<HTML><U>Add filters</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFilter.setText("<HTML>Add filters</HTML>");
			}
		});
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		welcomePanel.setBounds(256, 0, 376, 470);
		contentPane.add(welcomePanel);
		welcomePanel.setLayout(null);
		
		createPanel = new JPanel();
		createPanel.setBackground(Color.WHITE);
		createPanel.setBounds(256, 0, 376, 470);
		contentPane.add(createPanel);
		createPanel.setLayout(null);
		createPanel.setVisible(false);
		
		viewPanel = new JPanel();
		viewPanel.setBounds(256, 0, 376, 470);
		viewPanel.setBackground(Color.WHITE);
		contentPane.add(viewPanel);
		viewPanel.setLayout(null);
		viewPanel.setVisible(false);
		
		label = new JLabel("");
		label.setBounds(10, 4, 82, 30);
		panel.add(label);
		label.setIcon(new ImageIcon("D:\\logo.png"));
		
		tglbtnUploadANew = new JToggleButton("              Upload a new Document");
		tglbtnUploadANew.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				createPanel.setVisible(tglbtnUploadANew.isSelected());
				welcomePanel.setVisible(false);
			}
		});
		buttonGroup.add(tglbtnUploadANew);
		tglbtnUploadANew.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnUploadANew.setBackground(Color.DARK_GRAY);
		tglbtnUploadANew.setForeground(Color.WHITE);
		tglbtnUploadANew.setBounds(2, 113, 254, 47);
		panel.add(tglbtnUploadANew);
		tglbtnUploadANew.setBorder(null);
		
		tglbtnBrowse = new JToggleButton("              Browse Documents");
		tglbtnBrowse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				welcomePanel.setVisible(false);
				browsePanel.setVisible(tglbtnBrowse.isSelected());
			}
		});
		buttonGroup.add(tglbtnBrowse);
		tglbtnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnBrowse.setForeground(Color.WHITE);
		tglbtnBrowse.setBackground(Color.DARK_GRAY);
		tglbtnBrowse.setBounds(2, 209, 254, 47);
		panel.add(tglbtnBrowse);
		tglbtnBrowse.setFocusPainted(false);
		tglbtnBrowse.setBorder(null);
		
		tglbtnViewSubmittedDocuments = new JToggleButton("              View Submitted Documents");
		buttonGroup.add(tglbtnViewSubmittedDocuments);
		tglbtnViewSubmittedDocuments.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnViewSubmittedDocuments.setForeground(Color.WHITE);
		tglbtnViewSubmittedDocuments.setBackground(Color.DARK_GRAY);
		tglbtnViewSubmittedDocuments.setBounds(2, 256, 254, 47);
		panel.add(tglbtnViewSubmittedDocuments);
		tglbtnViewSubmittedDocuments.setFocusPainted(false);
		tglbtnViewSubmittedDocuments.setBorder(null);
		
		btnProfile = new JButton("Profile");
		btnProfile.setBackground(Color.GRAY);
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBounds(167, 11, 89, 23);
		panel.add(btnProfile);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profile profilepage=new profile();
				profilepage.setVisible(true);
				dispose();
			}
		});
		btnProfile.setFocusPainted(false);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.setForeground(Color.LIGHT_GRAY);
		lblLogout.setBounds(193, 45, 55, 23);
		panel.add(lblLogout);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginPage login=new loginPage();
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
		
		JLabel lblNewLabel = new JLabel("Welcome User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(86, 91, 205, 49);
		welcomePanel.add(lblNewLabel);
		
		JLabel lblUseTheButtons = new JLabel("Use the buttons at left to continue");
		lblUseTheButtons.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseTheButtons.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUseTheButtons.setBounds(86, 191, 205, 30);
		welcomePanel.add(lblUseTheButtons);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(39, 457, 258, 2);
		createPanel.add(separator);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setBounds(43, 432, 250, 24);
		createPanel.add(textField);
		
		label_1 = new JLabel("Targeted Audience");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(39, 403, 127, 20);
		createPanel.add(label_1);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(43, 357, 250, 30);
		createPanel.add(comboBox);
		
		label_2 = new JLabel("Document Type");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(39, 326, 100, 20);
		createPanel.add(label_2);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(39, 296, 108, 2);
		createPanel.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(189, 271, 100, 24);
		createPanel.add(textField_1);
		
		label_3 = new JLabel("-");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(163, 274, 16, 14);
		createPanel.add(label_3);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(185, 296, 108, 2);
		createPanel.add(separator_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(43, 271, 100, 24);
		createPanel.add(textField_2);
		
		label_4 = new JLabel("Valid From");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(39, 242, 100, 20);
		createPanel.add(label_4);
		
		label_5 = new JLabel("Valid Till");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(185, 242, 100, 20);
		createPanel.add(label_5);
		
		button = new JButton("Open");
		button.setForeground(Color.BLACK);
		button.setFocusPainted(false);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(262, 189, 78, 23);
		createPanel.add(button);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(39, 214, 204, 2);
		createPanel.add(separator_3);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(43, 189, 196, 24);
		createPanel.add(textField_3);
		
		label_6 = new JLabel("Choose File");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(39, 160, 100, 20);
		createPanel.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(43, 120, 250, 24);
		createPanel.add(textField_4);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(39, 145, 258, 2);
		createPanel.add(separator_4);
		
		label_7 = new JLabel("Document Name");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(39, 91, 100, 20);
		createPanel.add(label_7);
		
		label_8 = new JLabel("Create a Document");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(108, 47, 154, 21);
		createPanel.add(label_8);
		
		lblClose = new JLabel("Close");
		lblClose.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClose.setForeground(Color.DARK_GRAY);
		lblClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClose.setBounds(323, 11, 43, 17);
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
		createPanel.add(lblClose);
		
		
	}
}

