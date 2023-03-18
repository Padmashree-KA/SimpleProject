package com.employee_management_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dname")
	private String dname;
	
	@Column(name="dphoneNo")
	private String dphoneNo;
	@Column(name="dEmail")
	private String dEmail;
	@Column(name="dEntentionNo")
	private  String dEntentionNo;
	
	public Department() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDphoneNo() {
		return dphoneNo;
	}

	public void setDphoneNo(String dphoneNo) {
		this.dphoneNo = dphoneNo;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getdEntentionNo() {
		return dEntentionNo;
	}

	public void setdEntentionNo(String dEntentionNo) {
		this.dEntentionNo = dEntentionNo;
	}
	
	
	

}
