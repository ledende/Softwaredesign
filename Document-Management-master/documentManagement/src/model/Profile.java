package model;

public class Profile {
	private String firstName,lastName;
	private String id;
	private String password;
	private String type;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param id
	 * @param password
	 */
	public Profile(String firstName, String lastName, String id, String password,String type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.password = password;
		this.type = type;
	}
	
	/**
	 * 
	 */
	public Profile() {
		firstName="";
		lastName="";
		id="";
		password="";
		type="";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
