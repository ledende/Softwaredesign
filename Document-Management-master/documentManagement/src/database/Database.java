package database;
import java.sql.*;
import java.util.ArrayList;

import model.*;

public class Database {
	private static Connection conn=null;
	private static Statement st=null;
	private static Profile currentProfile;
	
	/**
	 * Connecting to Database 
	 */
	public static void Initialize() {
		try {
			Dbconnection dbconnection=new Dbconnection();
			conn=dbconnection.create();
			st=conn.createStatement();
			DatabaseCreateTables databaseCreateTables=new DatabaseCreateTables(st);
			databaseCreateTables.createProfileTable();	
			databaseCreateTables.createDocumentTable();
			databaseCreateTables.createNoticeTable();
			databaseCreateTables.createPublicationTable();
			databaseCreateTables.createFacultyTable();
			databaseCreateTables.createStudentTable();
			databaseCreateTables.createNoticeAudienceTables();
			System.out.println("Done");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Verifying the password for particular ID
	 */
	public static boolean checkPassword(String id,String s)
	{
		try
		{
			ResultSet rs=st.executeQuery("select * from Profile where id like '"+id+"' ");
			rs.next();
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String password=rs.getString("password");
			String type=rs.getString("type");
			//Checks password and retrieves Profile
			if(password.equals(s)) {
				if(type.equals("Student")) {
					ResultSet rs2=st.executeQuery("select * from Student where id like '"+id+"' ");
					rs2.next();
					String branch=rs2.getString("branch");
					String year=rs2.getString("year");
					Student stu=new Student(firstname,lastname,id,password,type,branch,year);
					currentProfile=stu;
				}
				else if(type.equals("Faculty")) {
					ResultSet rs2=st.executeQuery("select * from Faculty where id like '"+id+"' ");
					rs2.next();
					String department=rs2.getString("dept");
					Faculty f=new Faculty(firstname,lastname,id,password,type,department);
					currentProfile=f;
				}
				System.out.println("Logged In");
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error, checkPassword "+e);
			
		}
		return false;
	}
	
	/**
	 * Adding a new profile to database
	 */
	public static void addProfile(Profile a)
	{
		DatabaseUpdateValues databaseUpdateValues=new DatabaseUpdateValues(st);
		databaseUpdateValues.addProfile(a);
		currentProfile=a;
	}
	/**
	 * Adding a new document to database
	 */
	public static void addDocument(Document d,String path) {
		DatabaseUpdateValues databaseUpdateValues=new DatabaseUpdateValues(st);
		databaseUpdateValues.addDocument(d,path);
	}
	
	public static void addNoticeAudience(int doc_id,ArrayList<String> departments,ArrayList<String> branchs,ArrayList<String> years) {
		DatabaseUpdateValues databaseUpdateValues=new DatabaseUpdateValues(st);
		databaseUpdateValues.addNoticeAudience(doc_id, departments, branchs, years);
	}

	/**
	 * @return the currentProfile
	 */
	public static Profile getCurrentProfile() {
		return currentProfile;
	}	
	/**
	 * Updates profile
	 */
	public static void updateProfile(Profile p) {
		try {
			if(p.getPassword().equals("")) {
				p.setPassword(currentProfile.getPassword());
			}
			st.execute("update Profile set firstname='"+p.getFirstName()+"',lastName='"+p.getLastName()+"',password='"+p.getPassword()+"' where id="+currentProfile.getID());
			currentProfile=p;
			System.out.println("Profile Updated");
		}
		catch(Exception e) {
			System.out.println("Error, updateProfile "+e);
		}
	}
	
	
	/**
	 * @return True for if the certain ID already exists
	 */
	public static boolean checkIDAlreadyExists(String id) {
		try {
			ResultSet rs=st.executeQuery("select count(*) as rowcount from Profile where id like'"+id+"'");
			rs.next();
			int count=rs.getInt("rowcount");
			if(count==0) {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error, checkID "+e);
		}
		return true;
	}
	/**
	 * @return Document Object for particular DocID
	 */
	public static Document searchDocbyDocID(int doc_id)
	{
		Document newDocument=null;
		try
		{
			ResultSet rs=st.executeQuery("select * from Document where doc_id= "+doc_id+" ");
			rs.next();
			String creator_id=rs.getString("creator_id");
			String title=rs.getString("title");
			String doc_type=rs.getString("doc_type");
			String uploaded_date=rs.getString("uploaded_date");
			String extension=rs.getString("extension");
			if(doc_type.equals("Publication")) {
				ResultSet rs2=st.executeQuery("select * from Publication where doc_id= "+doc_id+" ");
				rs2.next();
				String published_date=rs2.getString("published_date");
				String journal=rs2.getString("journal");
				int impactFactor=rs2.getInt("impact_factor");
				int citations=rs2.getInt("citations");
				newDocument=new Publication(doc_id,creator_id,title,doc_type,uploaded_date,extension,published_date,journal,impactFactor,citations);	
			}
			else if(doc_type.equals("Notice")) {
				ResultSet rs2=st.executeQuery("select * from Notice where doc_id= "+doc_id+" ");
				rs2.next();
				String validfrom=rs2.getString("valid_from");
				String validtill=rs2.getString("valid_till");
				newDocument=new Notice(doc_id,creator_id,title,doc_type,uploaded_date,extension,validfrom, validtill);
			}
			//newDocument=new Document(doc_id,creator_id,title,doc_type,uploaded_date,extension);			
		}
		catch(Exception e)
		{
			System.out.println("searchbyDocID"+e);
		}
		return newDocument;
	}
	
	/**
	 * @param user_id
	 * @return Profile Object for particular ProfileID
	 */
	public static Profile searchProfileByUserID(String user_id)
	{
		Profile newProfile=null;
		try
		{
			ResultSet rs=st.executeQuery("select * from Profile where id like '"+user_id+"' ");
			rs.next();
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String password=rs.getString("password");
			String type=rs.getString("type");
			if(type.equals("Student")) {
				ResultSet rs2=st.executeQuery("select * from Student where id like '"+user_id+"' ");
				rs2.next();
				String branch=rs2.getString("branch");
				String year=rs2.getString("year");
				Student s=new Student(firstname,lastname,user_id,password,type,branch,year);
				newProfile=s;
			}
			else if(type.equals("Faculty")) {
				ResultSet rs2=st.executeQuery("select * from Faculty where id like '"+user_id+"' ");
				rs2.next();
				String department=rs2.getString("dept");
				Faculty f=new Faculty(firstname,lastname,user_id,password,type,department);
				newProfile=f;
			}	
		}
		catch(Exception e)
		{
			System.out.println("Error, searchByProfile"+e);
		}
		
		return newProfile;
	}
	/**
	 * @return ArrayList of DocID for particular userID
	 */
	public static ArrayList<Integer> searchDocByUserID(String creator_id)
	{
		ArrayList<Integer> documentIDList=new ArrayList<Integer>();
		try
		{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Document where creator_id like '"+creator_id+"' ");
			if(creator_id=="")
				rs=st.executeQuery("select * from Document");
			while(rs.next())
			{
				int doc_id=rs.getInt("doc_id");
				documentIDList.add(doc_id);
			}
		}
		catch(Exception e)
		{
			System.out.println("searchDocByUserID"+e);
		}
		return documentIDList;
	}
	
	
	public static ArrayList<Integer> searchPublicationByUserID(String creator_id)
	{
		ArrayList<Integer> documentIDList=new ArrayList<Integer>();
		try
		{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Document where creator_id like '"+creator_id+ "' and doc_type like 'Publication'");
			if(creator_id.equals(""))
				rs=st.executeQuery("select * from Document");
			while(rs.next())
			{
				int doc_id=rs.getInt("doc_id");
				documentIDList.add(doc_id);
			}
		}
		catch(Exception e)
		{
			System.out.println("searchDocByUserID"+e);
		}
		return documentIDList;
	}
	
	/**
	 * @return ArrayList of userID for particular username
	 */
	public static ArrayList<String> searchUserbyName(String name)
	{
		ArrayList<String> userIDList=new ArrayList<String>();
		try
		{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select id from Profile where firstname like '"+name+ "%' or lastname like '"+name+"%'");
			while(rs.next())
			{
				String creator_id=rs.getString("id");
				userIDList.add(creator_id);
			}
		}
		catch(Exception e)
		{
			System.out.println("searchUserbyName"+e);
		}
		
		return userIDList;
	}
	/**
	 * @return ArrayList of DocID for particular documentName
	 */
	public static ArrayList<Integer> searchDocbyName(String docName)
	{
		ArrayList<Integer> docIDList=new ArrayList<Integer>();
		try
		{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Document where title like '%"+docName+"%'");
			while(rs.next())
			{
				int doc_id=rs.getInt("doc_id");
				docIDList.add(doc_id);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("searchDocbyName"+e);
		}
		return docIDList;
	}
	
	public static ArrayList<Integer> viewableNoticesFaculty(String Department){
		ArrayList<Integer> docList=new ArrayList<Integer>();
		try {
			ResultSet rs=st.executeQuery("Select * from NoticeDepartmentAudience where department like '"+Department+"'");
			while(rs.next()) {
				docList.add(rs.getInt("doc_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error, viewableNoticesFaculty "+e);
		}
		return docList;
	}
	
	
	public static ArrayList<Integer> viewableNoticesStudent(String Branch,String Year){
		ArrayList<Integer> docList=new ArrayList<Integer>();
		ArrayList<Integer> docBranchList=new ArrayList<Integer>();
		ArrayList<Integer> docYearList=new ArrayList<Integer>();
		try {
			ResultSet rs1=st.executeQuery("Select * from NoticeBranchAudience where branch like '"+Branch+"'");
			while(rs1.next()) {
				docBranchList.add(rs1.getInt("doc_id"));
			}
			ResultSet rs2=st.executeQuery("Select * from NoticeYearAudience where year like '"+Year+"'");
			while(rs2.next()) {
				docYearList.add(rs2.getInt("doc_id"));
			}
			for(int b:docBranchList) {
				if(docYearList.contains(b)) {
					docList.add(b);
					System.out.println(b);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Error, viewableNoticesFaculty "+e);
		}
		return docList;
	}
	
	public static ArrayList<String> noticeDepartments(int doc_id){
		ArrayList<String> departments=new ArrayList<String>();
		try {
			ResultSet rs=st.executeQuery("select department from NoticeDepartmentAudience where doc_id="+doc_id);
			while(rs.next()) {
			departments.add(rs.getString("department"));
			}
		} catch (SQLException e) {
			System.out.println("Error,noticeDepartments " + e);
		}
		return departments;
	}
	public static ArrayList<String> noticeBranchs(int doc_id){
		ArrayList<String> branchs=new ArrayList<String>();
		try {
			ResultSet rs=st.executeQuery("select branch from NoticeBranchAudience where doc_id="+doc_id);
			while(rs.next()) {
			branchs.add(rs.getString("branch"));
			}
		} catch (SQLException e) {
			System.out.println("Error,noticeBranchs " + e);
		}
		return branchs;
	}
	public static ArrayList<String> noticeYears(int doc_id){
		ArrayList<String> years=new ArrayList<String>();
		try {
			ResultSet rs=st.executeQuery("select year from NoticeYearAudience where doc_id="+doc_id);
			while(rs.next()) {
			years.add(rs.getString("year"));
			}
		} catch (SQLException e) {
			System.out.println("Error,noticeDepartments " + e);
		}
		return years;
	}
}
