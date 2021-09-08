package com.axelor.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class People {
	
	@Id
	@Column(name = "People_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(name = "People_Name")
	private String pname;
	
	
	
	public People(String pname) {
		super();
		this.pname = pname;
		
	}


	public int getPid() {
		return pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	@Override
	public String toString() {
		return "People [pid=" + pid + ", pname=" + pname + "]";
	}
	
	
	
	
	
}
