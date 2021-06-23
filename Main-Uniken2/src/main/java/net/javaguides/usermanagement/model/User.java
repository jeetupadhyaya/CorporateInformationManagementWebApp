package net.javaguides.usermanagement.model;

//package net.javaguides.usermanagement.model;


public class User {
	private int sn;
	private String corporate_name;
	private String corporateid;
	private String accountnumber;
	
	public User(String corporate_name, String corporateid, String accountnumber) {
		super();
		this.corporate_name = corporate_name;
		this.corporateid = corporateid;
		this.accountnumber = accountnumber;
	}

	public User(int sn, String corporate_name, String corporateid, String accountnumber) {
		super();
		this.sn = sn;
		this.corporate_name = corporate_name;
		this.corporateid = corporateid;
		this.accountnumber = accountnumber;
	}

	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getCorporateName() {
		return corporate_name;
	}
	public void setCorporateName(String corporate_name) {
		this.corporate_name = corporate_name;
	}
	public String getCorporateId() {
		return corporateid;
	}
	public void setCorporateId(String corporateid) {
		this.corporateid = corporateid;
	}
	public String getAccountNumber() {
		return accountnumber;
	}
	public void setAccountNumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
}