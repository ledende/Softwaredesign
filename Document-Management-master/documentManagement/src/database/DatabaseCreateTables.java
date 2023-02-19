package database;

import java.sql.SQLException;
import java.sql.*;

public class DatabaseCreateTables {
	private Statement st=null;
	
	public DatabaseCreateTables(Statement st) {
		this.st=st;
	}
	
	/**
	 * Creating Profile Table
	 */
	public void createProfileTable() throws SQLException {
		st.execute("create table if not exists Profile(firstname varchar(20),lastname varchar(20),id varchar(20) primary key,password varchar(35),type varchar(20))");
		System.out.println("Profile Table Created/Already Present");
	} 
	
	/**
	 * Creating Document Table
	 */
	public void createDocumentTable()
	{
		try
		{
			st.execute("create table if not exists Document(doc_id int primary key auto_increment,creator_id varchar(20),title varchar(15),doc_type varchar(15),uploaded_date varchar(15),extension varchar(100),FOREIGN KEY (creator_id) REFERENCES Profile(id))");
			System.out.println("Document Table Created/Already Present");
		}
		catch(Exception e)
		{
			System.out.println("createDocumentTable"+e);
		}
	}
	/**
	 * Creating Student Table
	 */
	public void createStudentTable()
	{
		try
		{
			st.execute("create table if not exists Student(id varchar(20) primary key,branch varchar(15),year varchar(15),FOREIGN KEY (id) REFERENCES Profile(id))");
			System.out.println("Student Table Created/Already Present");
		}
		catch(Exception e)
		{
			System.out.println("createStudentTable"+e);
		}
	}
	/**
	 * Creating Faculty Table
	 */
	public void createFacultyTable()
	{
		try
		{
			st.execute("create table if not exists Faculty(id varchar(20) primary key,dept varchar(10),FOREIGN KEY (id) REFERENCES Profile(id))");
			System.out.println("Faculty Table Created/Already Present");
		}
		catch(Exception e)
		{
			System.out.println("createFacultyTable"+e);
		}
	}
	/**
	 * Creating Notice Table
	 */
	public void createNoticeTable()
	{
		try
		{
			st.execute("create table if not exists Notice(doc_id int primary key,valid_from varchar(15),valid_till varchar(15), FOREIGN KEY (doc_id) REFERENCES Document(doc_id)) ");
		}
		catch(Exception e)
		{
			System.out.println("createNoticeTable"+e);
		}
	}
	/**
	 * Creating Publication Table
	 */
	public void createPublicationTable()
	{
		try
		{
			st.execute("create table if not exists Publication(doc_id int primary key,journal varchar(20),published_date varchar(10),impact_factor int,citations int, FOREIGN KEY (doc_id) REFERENCES Document(doc_id))");
		}
		catch(Exception e)
		{
			System.out.println("createPublicationTable"+e);
		}
	}
	/**
	 * Creating Notice Audience Table
	 */
	public void createNoticeAudienceTables()
	{
		try
		{
			st.execute("create table if not exists NoticeDepartmentAudience(doc_id int,department varchar(15),FOREIGN KEY (doc_id) REFERENCES Document(doc_id))");
			st.execute("create table if not exists NoticeBranchAudience(doc_id int,branch varchar(15),FOREIGN KEY (doc_id) REFERENCES Document(doc_id))");
			st.execute("create table if not exists NoticeYearAudience(doc_id int,year varchar(15),FOREIGN KEY (doc_id) REFERENCES Document(doc_id))");
		}
		catch(Exception e)
		{
			System.out.println("createNoticeAudienceTable"+e);
		}
	}
}
