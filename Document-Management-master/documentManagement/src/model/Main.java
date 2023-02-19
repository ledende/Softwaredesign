package model;

import GUI.LoginPageGUI;
import database.Database;

public class Main {
	public static void main(String args[]) {
		//Creates a connection with database
		Database.Initialize();
		
		//Opening the Login Page
		LoginPageGUI login=new LoginPageGUI();
		login.setVisible(true);
		
	}
}
