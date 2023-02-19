package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

import database.Database;
import model.Document;
import model.Profile;

public class DocumentResultPanelGUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Document current;
	private JLabel lblDate;
	private JLabel lblDetails;
	private JLabel lblCreator;
	private JLabel lblTitles;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	public DocumentResultPanelGUI(Document d) {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		current=d;
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 350, 87);
		setVisible(true);
		setLayout(null);
		
		label = new JLabel("Title:");
		label.setBounds(10, 11, 42, 14);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(label);
		
		lblTitles = new JLabel(current.getTitle());
		lblTitles.setBounds(62, 11, 272, 14);
		lblTitles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTitles);
		
		
		label_1 = new JLabel("Creator/Uploader:");
		label_1.setBounds(10, 36, 108, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(label_1);
		
		Profile creator=Database.searchProfileByUserID(current.getUser_id());
		
		lblCreator = new JLabel(creator.getFirstName()+" "+creator.getLastName());
		lblCreator.setBounds(128, 36, 206, 14);
		lblCreator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblCreator);
		
		lblDetails = new JLabel("More Detials");
		lblDetails.setBounds(256, 61, 78, 14);
		lblDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetails.setForeground(Color.BLACK);
		add(lblDetails);
		lblDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MoreDocumentDetailsGUI moreDocumentDetailsGUI=new MoreDocumentDetailsGUI(current);
				moreDocumentDetailsGUI.setVisible(true);
				System.out.println("hi");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDetails.setText("<HTML><U><B>More Details</B></U></HTML>");
				lblDetails.setForeground(SystemColor.activeCaptionBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDetails.setText("<HTML>More Details</HTML>");
				lblDetails.setForeground(Color.BLACK);
			}
		});

		label_2 = new JLabel("Date:");
		label_2.setBounds(10, 61, 46, 14);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(label_2);
		
		lblDate = new JLabel(current.getUploaded_date());
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDate.setBounds(62, 61, 80, 14);
		add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(59, 27, 279, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(125, 52, 212, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(59, 77, 86, 2);
		add(separator_2);
		
		JLabel lblType = new JLabel("<html><u>"+current.getDoc_type()+"</u></html>");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblType.setBounds(164, 61, 93, 14);
		add(lblType);
		setColor(Color.BLACK);
	}
	public void setColor(Color c) {
		lblDate.setForeground(c);
		lblDetails.setForeground(c);
		lblCreator.setForeground(c);
		lblTitles.setForeground(c);
		label.setForeground(c);
		label_1.setForeground(c);
		label_2.setForeground(c);
	}
}
