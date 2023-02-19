package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	Connection con;
	public Dbconnection()
	{
		con=null;
	}
	public Connection create()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/documentManagement","root","password");
			System.out.println("Connection Done");
		}
		catch(SQLException e1)
		{
			System.out.println(e1);
		}
		return con;
	}
}
