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
	}

	@GET
	@Path("/showPeople")
	public void displayPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		List<People> pp = ps.displayPeople();
		req.setAttribute("list", pp);
		req.getRequestDispatcher("../displayPeople.jsp").forward(req, res);
	}

	@GET
	@Path("/updateselectedPeople")
	public void updateSelectedPeople(@Context HttpServletRequest req, @Context HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("uid"));
		String name = req.getParameter("name");
		
		req.setAttribute("uid", id);
		req.setAttribute("name", name);
		
		req.getRequestDispatcher("../updateP.jsp").forward(req, res);
	}

	@POST
	@Path("/updatePeople")
	public void updatePeople(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter("id"));
		ps.updatePeople(id, req.getParameter("name"));
		displayPeople(req, res);
	}

	@GET
	@Path("/deletePeople")
	public void delepePeople(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		ps.deletePeople(Integer.parseInt(req.getParameter("uid")));
		displayPeople(req, res);
	}
	
	@GET
	@Path("addClothsWithName")
	public void addClothsWithName(@Context HttpServletRequest req,@Context HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("pid",(String)req.getParameter("uid"));
		req.getRequestDispatcher("../addCloths.jsp").forward(req, res);
	}
	@POST
	@Path("addPeopleCloths")
	public void addPeopleCloths(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int pid =Integer.parseInt(req.getParameter("pid"));
		String clothName = req.getParameter("cloth");
		Cloths c = new Cloths(clothName);
		ps.addCloths(c, pid);
		displayPeople(req, res);
		
	}

}
