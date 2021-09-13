package com.axelor.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class People {
	
	@Id
	@Column(name = "People_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(name = "People_Name")
	private String pname;
	@OneToMany(mappedBy = "people" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Cloths> cloths;
	
	
	
	
	public List<Cloths> getCloths() {
		return cloths;
	}

	public void setCloths(List<Cloths> cloths) {
		this.cloths = cloths;
	}

	public People() {
		super();
	}
	
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
