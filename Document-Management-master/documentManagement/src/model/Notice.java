package model;

public class Notice extends Document{
	private String valid_from;
	private String valid_till;
	
	public Notice() {
		super();
		valid_from="";
		valid_till="";
	}
	public Notice(int doc_id, String user_id, String title, String doc_type, String uploaded_date,String extension,String valid_from,String valid_till) {
		super(doc_id, user_id, title, doc_type, uploaded_date,extension);
		this.valid_from=valid_from;
		this.valid_till=valid_till;
	}
	public String getValid_from() {
		return valid_from;
	}
	public void setValid_from(String valid_from) {
		this.valid_from = valid_from;
	}
	public String getValid_till() {
		return valid_till;
	}
	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}
	
}
