package com.axelor.resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.axelor.Services.ClothsService;
import com.axelor.Services.PeopleService;
import com.axelor.db.Cloths;
import com.axelor.db.People;
import com.google.inject.Inject;

@Path("People")
public class PeopleResource {

	@Inject
	public PeopleService ps;
	

	@POST
	@Path("/createPeople")
	public void createPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		People p = new People(req.getParameter("name"));
		ps.createPeople(p);
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
	}

	@GET
	@Path("/showPeople")
	public void displayPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<People> pp = ps.displayPeople();
		req.setAttribute("list", pp);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
	}
	
	@POST
	@Path("/updatePeople")
	public void updatePeople(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter("id"));
		ps.updatePeople(id, req.getParameter("name"));
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
	}

	@GET
	@Path("/deletePeople")
	public void delepePeople(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		ps.deletePeople(Integer.parseInt(req.getParameter("uid")));
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
	}
	
	@GET
	@Path("/displayPeopleByName")
	public void displayPeopleByName(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		String name =  req.getParameter("name");
		List<People> p = ps.displayPeopleByName(name);
		req.setAttribute("list", p);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
		
		
	}
	

}
