package devnug.classifiedsforolas;

public class Posting {

	private String school;
	private String quickDesc;
	private String desc;
	private String link;
	private String postDate;
	private String endDate;
	
	public Posting() {
		school = "";
		desc = "";
		link = "";
		postDate = "";
		endDate = "";
	}
	
	public Posting(String theSchool, String theQuickDesc, String theDesc, String theLink, String thePostDate) {
		school = theSchool;
		setQuickDesc(theQuickDesc);
		desc = theDesc;
		link = theLink;
		postDate = thePostDate;
	}
	
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getQuickDesc() {
		return quickDesc;
	}

	public void setQuickDesc(String quickDesc) {
		this.quickDesc = quickDesc;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
