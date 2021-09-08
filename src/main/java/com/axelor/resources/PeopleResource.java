package com.axelor.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.axelor.Services.PeopleService;
import com.axelor.db.People;
import com.google.inject.Inject;

@Path("People")
public class PeopleResource {
	
	@Inject
	public PeopleService ps;
	
	@POST
//	@Path("/createPeople")
	public void createPeople(@FormParam("name") String name ) {
		
		People p = new People(name);
		ps.createPeople(p);
	}
}
