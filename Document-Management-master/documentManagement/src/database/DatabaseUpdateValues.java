package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import model.*;

public class DatabaseUpdateValues {
	private Statement st;
	
	public DatabaseUpdateValues(Statement st) {
		this.st=st;
	}
	/**
	 * Adding a new profile to database
	 */
	public void addProfile(Profile a)
	{
		try
		{
			st.executeUpdate("insert into Profile values('"+a.getFirstName()+"','"+a.getLastName()+"','"+a.getID()+"','"+a.getPassword()+"','"+a.getType()+"')");		
			System.out.println("Profile created");
			if(a.getType().equals("Faculty")) {
				Faculty f= (Faculty) a;
				st.executeUpdate("insert into Faculty values('"+a.getID()+"','"+f.getDept()+"')");
			}
			else if(a.getType().equals("Student")) {
				Student s= (Student) a;
				st.executeUpdate("insert into Student values('"+a.getID()+"','"+s.getBranch()+"','"+s.getYear()+"')");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error, addProfile " +e);
		}
	}
	
	public void addDocument(Document d,String path) {
		try {
			String title=d.getTitle();
			String type=d.getDoc_type();
			String user_id=d.getUser_id();
			ResultSet rs=st.executeQuery("select count(*) as rowcount from document");
			rs.next();
			int lastDocumentID=rs.getInt("rowcount");
			
			int i=path.lastIndexOf('.');
			String extension="";
			if(i>0)
				extension=path.substring(i);
			try {
				Files.copy(Paths.get(path), Paths.get("D:\\eclipse-workspace\\documentManagement\\localStorage\\"+(lastDocumentID+1)+extension));
				System.out.println("File copied");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Files not copied");
			}
			LocalDate now=LocalDate.now();
			//System.out.println(now);
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			Date today=Date.valueOf(now.toString());
			String uploadDate=dateFormat.format(today);
			d.setDoc_id(lastDocumentID+1);
			d.setUploaded_date(uploadDate);
			st.executeUpdate("insert into Document(creator_id,title,doc_type,uploaded_date,extension) values('"+user_id+"','"+title+"','"+type+"','"+uploadDate+"','"+extension+"')");
			System.out.println("Document added");
			
			if(type.equals("Publication")) {
				addPublication((Publication)d);
			}
			else if(type.equals("Notice")) {
				addNotice((Notice)d);
			}
		}
		catch(Exception e) {
			System.out.println("Error,addDocument "+e);
		}
	}
	public void addNotice(Notice a)
	{
		try
		{
			st.executeUpdate("insert into Notice values("+a.getDoc_id()+",'"+a.getValid_from()+"','"+a.getValid_till()+"')");		
			System.out.println("Notice Added");
		}
		catch(Exception e)
		{
			System.out.println("Error, addNoticeDetails " +e);
		}
	}
  
	public void addPublication(Publication a)
	{
		try
		{
			st.executeUpdate("insert into Publication values("+a.getDoc_id()+",'"+a.getJournal()+"','"+a.getPublished_date()+"',"+a.getImpact_factor()+","+a.getCitations()+")");		
			System.out.println("Publication Added");
		}
		catch(Exception e)
		{
			System.out.println("Error, addPublicationDetails " +e);
		}
	}
	
	void addNoticeAudience(int doc_id,ArrayList<String> departments,ArrayList<String> branchs,ArrayList<String> years)
	{
		try
		{	
			for(String d:departments) {
				st.executeUpdate("insert into NoticeDepartmentAudience values("+doc_id+",'"+d+"')");
			}
			for(String b:branchs) {
				st.executeUpdate("insert into NoticeBranchAudience values("+doc_id+",'"+b+"')");
			}
			for(String y:years) {
				st.executeUpdate("insert into NoticeYearAudience values("+doc_id+",'"+y+"')");
			}
			System.out.println("NoticeAudience added");
		}
		catch(Exception e)
		{
			System.out.println("Error, addNoticeAudienceDetails " +e);
		}
	}
}