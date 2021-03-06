package com.axelor.Services;

import java.util.List;

import com.axelor.db.Cloths;
import com.axelor.db.People;


public interface PeopleService  {

	public boolean createPeople(People p);
	public List<People> displayPeople();
	public String updatePeople(int pid, String pname);
	public People deletePeople (int pid);
	public List<People> displayPeopleByName(String name);
}
