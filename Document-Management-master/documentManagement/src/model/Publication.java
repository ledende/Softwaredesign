package model;

public class Publication extends Document{
	
	private String published_date;
	private String journal;
	private int impact_factor;
	private int citations;
	
	public Publication(int doc_id, String user_id, String title, String doc_type, String uploaded_date,String extension,String published_date,String journal,int impact_factor,int citations) {
		super(doc_id, user_id, title, doc_type, uploaded_date,extension);
		this.setPublished_date(published_date);
		this.journal=journal;
		this.impact_factor=impact_factor;
		this.citations=citations;
	}
	public Publication() {
		super();
		this.setPublished_date("");
		this.journal="";
		this.impact_factor=0;
		this.citations=0;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public int getImpact_factor() {
		return impact_factor;
	}
	public void setImpact_factor(int impact_factor) {
		this.impact_factor = impact_factor;
	}
	public String getPublished_date() {
		return published_date;
	}
	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}
	public int getCitations() {
		return citations;
	}
	public void setCitations(int citations) {
		this.citations = citations;
	}

	
}
