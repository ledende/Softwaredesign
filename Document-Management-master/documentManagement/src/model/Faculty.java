package model;

public class Faculty extends Profile {
	private String dept;

	public Faculty() {
		super();
		
	}
	public Faculty(String firstName, String lastName, String id, String password,String type,String dept) {
		super(firstName,lastName,id,password,type);
		this.dept=dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	 public String toString() 
	    { 
	        return (super.toString()+ 
	                "Depatment= "+dept); 
	    } 
	
}
