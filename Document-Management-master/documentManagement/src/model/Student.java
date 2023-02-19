package model;

public class Student extends Profile{
	private String branch;
	private String year;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String id, String password,String type,String branch, String year) {
		super(firstName,lastName,id,password,type);
		this.branch = branch;
		this.year = year;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String toString() 
    { 
        return (super.toString()+ 
                "Branch=" + branch + "Year="+year ); 
    } 
	
}

