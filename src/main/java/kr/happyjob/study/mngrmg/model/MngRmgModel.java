package kr.happyjob.study.mngrmg.model;

public class MngRmgModel {
	
	
	public int getRev_no() {
		return rev_no;
	}
	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getRev_title() {
		return rev_title;
	}
	public void setRev_title(String rev_title) {
		this.rev_title = rev_title;
	}
	public String getRev_content() {
		return rev_content;
	}
	public void setRev_content(String rev_content) {
		this.rev_content = rev_content;
	}
	public String getRev_date() {
		return rev_date;
	}
	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}
	public String getRev_status() {
		return rev_status;
	}
	public void setRev_status(String rev_status) {
		this.rev_status = rev_status;
	}
	public String getRev_uploader() {
		return rev_uploader;
	}
	public void setRev_uploader(String rev_uploader) {
		this.rev_uploader = rev_uploader;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private int rev_no;
	private String loginID;
	private int user_no;
		
	private String rev_title;
	private String rev_content;
	private String rev_date;
	private String rev_status;
	private String rev_uploader;

	private String name;
	
}