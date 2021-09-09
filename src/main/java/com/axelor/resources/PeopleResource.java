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
import com.axelor.Services.PeopleService;
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
	}

	@GET
	@Path("/showPeople")
	public void displayPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<People> pp = ps.displayPeople();
		req.setAttribute("list", pp);
//		req.getRequestDispatcher("../displayPeople.jsp").forward(req, res);
	}

	@GET
	@Path("/updateselectedPeople")
	public void updateSelectedPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("uid"));
		req.setAttribute("uid", id);
		req.getRequestDispatcher("../updateP.jsp").forward(req, res);
	}

	@POST
	@Path("/updatePeople")
//	public Response updatePeople(@Context HttpServletRequest req , @Context HttpServletResponse res) {
	public Response updatePeople(@FormParam("id") int id, @FormParam("name") String name) {
//		int id = Integer.parseInt( req.getParameter("id"));
		String updatedName = ps.updatePeople(id, name);
//		 People p =  pm.get().find(People.class, id);
		return Response.ok(updatedName).build();

	}

	@GET
	@Path("/deletePeople")
	public Response delepePeople(@Context HttpServletRequest req, @Context HttpServletResponse res) {
		ps.deletePeople(Integer.parseInt(req.getParameter("uid")));
		return Response.ok("Deleted").build();
	}

}
