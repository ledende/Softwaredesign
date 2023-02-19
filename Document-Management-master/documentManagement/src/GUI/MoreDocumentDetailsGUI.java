package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import database.Database;
import model.*;

import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MoreDocumentDetailsGUI extends JFrame {

	private JPanel contentPane;
	private JLabel creatorLBL;
	private JLabel uploadateLBL;
	private JLabel titleLBL;
	private JLabel typedetailsLBL;
	private JLabel citationsLBL;
	private JLabel hindexLBL;
	private JLabel lblDocDate;
	private JLabel impactfactorLBL;
	private JLabel jounalLBL;
	private JLabel validfromLBL;
	private JPanel noticePanel;
	private JLabel validtillLBL;
	private JPanel publciationPanel;

	/**
	 * Create the frame.
	 */
	public MoreDocumentDetailsGUI(Document doc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(760, 100, 325, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JLabel lblClose = new JLabel("Close");
		lblClose.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClose.setForeground(Color.BLACK);
		lblClose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClose.setBounds(246, 11, 53, 20);
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
				lblClose.setForeground(Color.BLACK);
			}
		});
		
		noticePanel = new JPanel();
		noticePanel.setBackground(Color.WHITE);
		noticePanel.setBounds(3, 173, 320, 178);
		contentPane.add(noticePanel);
		noticePanel.setLayout(null);
		
		JLabel lblNewLable = new JLabel("Valid From");
		lblNewLable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLable.setEnabled(true);
		lblNewLable.setBounds(10, 11, 115, 14);
		noticePanel.add(lblNewLable);
		
		validfromLBL = new JLabel("New label");
		validfromLBL.setBounds(35, 31, 90, 14);
		noticePanel.add(validfromLBL);
		
		validtillLBL = new JLabel("New label");
		validtillLBL.setBounds(189, 31, 90, 14);
		noticePanel.add(validtillLBL);
		
		JLabel lbllable3 = new JLabel("Valid Till");
		lbllable3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbllable3.setEnabled(true);
		lbllable3.setBounds(164, 11, 115, 14);
		noticePanel.add(lbllable3);
		
		JLabel lblNewLabel_3 = new JLabel("Targeted Audience");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 51, 115, 14);
		noticePanel.add(lblNewLabel_3);
		
		JPanel facultyPanel = new JPanel();
		facultyPanel.setLayout(null);
		facultyPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Faculty Department", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		facultyPanel.setBackground(Color.WHITE);
		facultyPanel.setBounds(10, 68, 125, 111);
		noticePanel.add(facultyPanel);
		
		JPanel branchPanel = new JPanel();
		branchPanel.setLayout(null);
		branchPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Student Branch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		branchPanel.setBackground(Color.WHITE);
		branchPanel.setBounds(134, 68, 101, 106);
		noticePanel.add(branchPanel);
		
		JPanel yearPanel = new JPanel();
		yearPanel.setLayout(null);
		yearPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Student Year", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		yearPanel.setBackground(Color.WHITE);
		yearPanel.setBounds(235, 68, 83, 105);
		noticePanel.add(yearPanel);
		noticePanel.setVisible(false);
		
		publciationPanel = new JPanel();
		publciationPanel.setBackground(Color.WHITE);
		publciationPanel.setBounds(4, 173, 317, 178);
		contentPane.add(publciationPanel);
		publciationPanel.setLayout(null);
		publciationPanel.setVisible(false);
		
		JLabel lblType = new JLabel("Publication Date");
		lblType.setBounds(10, 0, 132, 14);
		publciationPanel.add(lblType);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDocDate = new JLabel("New label");
		lblDocDate.setBounds(35, 20, 257, 14);
		publciationPanel.add(lblDocDate);
		
		JLabel lblHindex = new JLabel("H-index");
		lblHindex.setBounds(10, 40, 46, 14);
		publciationPanel.add(lblHindex);
		lblHindex.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		hindexLBL = new JLabel("New label");
		hindexLBL.setBounds(35, 60, 107, 14);
		publciationPanel.add(hindexLBL);
		
		JLabel lblNewLabel_1 = new JLabel("Journal in which published");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 125, 153, 14);
		publciationPanel.add(lblNewLabel_1);
		
		jounalLBL = new JLabel("New label");
		jounalLBL.setVerticalAlignment(SwingConstants.TOP);
		jounalLBL.setBounds(35, 145, 257, 14);
		publciationPanel.add(jounalLBL);
		
		JLabel lblImpactFactorOf = new JLabel("Impact Factor of Journal");
		lblImpactFactorOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblImpactFactorOf.setBounds(10, 80, 153, 14);
		publciationPanel.add(lblImpactFactorOf);
		
		impactfactorLBL = new JLabel("New label");
		impactfactorLBL.setBounds(35, 100, 107, 14);
		publciationPanel.add(impactfactorLBL);
		
		JLabel lblNewLabel_4 = new JLabel("Number of Citations");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(169, 40, 138, 14);
		publciationPanel.add(lblNewLabel_4);
		
		citationsLBL = new JLabel("New label");
		citationsLBL.setBounds(195, 60, 86, 14);
		publciationPanel.add(citationsLBL);
		contentPane.add(lblClose);
		
		JLabel label = new JLabel("Title:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 33, 42, 14);
		contentPane.add(label);
		
		titleLBL = new JLabel(doc.getTitle());
		titleLBL.setVerticalAlignment(SwingConstants.TOP);
		titleLBL.setHorizontalAlignment(SwingConstants.LEFT);
		titleLBL.setBounds(35, 53, 257, 34);
		contentPane.add(titleLBL);
		
		JLabel label_2 = new JLabel("Creator/Uploader:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 93, 108, 14);
		contentPane.add(label_2);
		
		Profile creator=Database.searchProfileByUserID(doc.getUser_id());
		creatorLBL = new JLabel(creator.getFirstName()+" "+creator.getLastName());
		creatorLBL.setBounds(35, 113, 257, 14);
		contentPane.add(creatorLBL);
		
		JLabel lblDateUploaded = new JLabel("Date Uploaded:");
		lblDateUploaded.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateUploaded.setBounds(10, 133, 94, 14);
		contentPane.add(lblDateUploaded);
		
		uploadateLBL = new JLabel(doc.getUploaded_date());
		uploadateLBL.setBounds(35, 153, 257, 14);
		contentPane.add(uploadateLBL);
		
		JButton btnViewDocument = new JButton("View Document");
		btnViewDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file=new File("D:\\eclipse-workspace\\documentManagement\\localStorage\\"+doc.getDoc_id()+doc.getExtension());
				if(file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnViewDocument.setBounds(95, 353, 135, 23);
		contentPane.add(btnViewDocument);
		
		typedetailsLBL = new JLabel(doc.getDoc_type()+" Details");
		typedetailsLBL.setFont(new Font("Tahoma", Font.BOLD, 13));
		typedetailsLBL.setHorizontalAlignment(SwingConstants.CENTER);
		typedetailsLBL.setBounds(65, 11, 190, 18);
		contentPane.add(typedetailsLBL);
		
		if(doc.getDoc_type().equals("Publication")) {
			publciationPanel.setVisible(true);
			Publication p=(Publication) doc;
			lblDocDate.setText(p.getPublished_date());
			hindexLBL.setText(""+calculateHindex(doc.getUser_id()));
			citationsLBL.setText(""+p.getCitations());
			impactfactorLBL.setText(""+p.getImpact_factor());
			jounalLBL.setText(p.getJournal());
		}
		else if(doc.getDoc_type().equals("Notice")) {
			noticePanel.setVisible(true);
			ArrayList<String> departments=Database.noticeDepartments(doc.getDoc_id());
			ArrayList<String> branchs=Database.noticeBranchs(doc.getDoc_id());
			ArrayList<String> years=Database.noticeYears(doc.getDoc_id());
			int y1=0;
			for(String d:departments) {
				JLabel newlabel=new JLabel(d);
				System.out.println(d);
				facultyPanel.add(newlabel);
				newlabel.setBounds(2, y1+14, 123, 17);
				newlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
				newlabel.setForeground(Color.BLACK);
				newlabel.setBackground(Color.LIGHT_GRAY);
				newlabel.setHorizontalAlignment(SwingConstants.LEFT);
				y1+=18;
			}
			int y2=0;
			for(String b:branchs) {
				JLabel newlabel=new JLabel(b);
				System.out.println(b);
				branchPanel.add(newlabel);
				newlabel.setBounds(2, 14+y2, 99, 17);
				newlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
				newlabel.setForeground(Color.BLACK);
				newlabel.setBackground(Color.LIGHT_GRAY);
				newlabel.setHorizontalAlignment(SwingConstants.LEFT);
				y2+=18;
			}
			int y3=0;
			for(String y:years) {
				JLabel newlabel=new JLabel(y);
				System.out.println(y);
				yearPanel.add(newlabel);
				newlabel.setBounds(2, y3+14, 81, 17);
				newlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
				newlabel.setForeground(Color.BLACK);
				newlabel.setBackground(Color.LIGHT_GRAY);
				newlabel.setHorizontalAlignment(SwingConstants.LEFT);
				y3+=18;
			}
			Notice n=(Notice)doc;
			validfromLBL.setText(n.getValid_from());
			validtillLBL.setText(n.getValid_till());
			
			
		}
	}
	
	int calculateHindex(String user_id) {
		int hindex=0;
		ArrayList<Integer> docIDList=Database.searchPublicationByUserID(user_id);
		ArrayList<Integer> citations=new ArrayList<Integer>();
		for(int d:docIDList) {
			Publication p=(Publication) Database.searchDocbyDocID(d);
			citations.add(p.getCitations());
		}
		int length=citations.size();
		for(int i=0; i<length; i++){
			int smaller = Math.min(citations.get(i), length-i);
			hindex = Math.max(hindex, smaller);
		}
		return hindex;
	}
}
