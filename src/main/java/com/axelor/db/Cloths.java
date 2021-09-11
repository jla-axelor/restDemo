package com.axelor.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cloths {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cloth_ID")
	private int cid;
	@Column(name = "Cloth_Name")
	private String cname;
	@ManyToOne
	private People people;
	
	public Cloths() {
		super();
	}
	

	public Cloths(String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.people = people;
	}


	public int getCid() {
		return cid;
	}


	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	

	public People getPeople() {
		return people;
	}


	public void setPeople(People people) {
		this.people = people;
	}


	@Override
	public String toString() {
		return "Cloths [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
	
	
	

}
