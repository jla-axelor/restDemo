package com.axelor.resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.http.annotation.Contract;

import com.axelor.Services.ClothsService;
import com.axelor.db.Cloths;
import com.axelor.db.People;
import com.google.inject.Inject;

@Path("Cloths")
public class ClothsResource {
	
	@Inject
	ClothsService cs;

	@POST
	@Path("/addCloths")
	public void addPeopleCloths(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int pid =Integer.parseInt(req.getParameter("pid"));
		String clothName = req.getParameter("cloth");
		Cloths c = new Cloths(clothName);
		cs.addCloths(c, pid);
		req.setAttribute("pid", pid);
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
	}
	
	@POST
	@Path("/updateCloths")
	public void updateCloths(@Context HttpServletRequest req , @Context HttpServletResponse res) throws IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		String name= req.getParameter("name");
		cs.updateCloths(cid, name);
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
		
		
	}
	
	@GET
	@Path("/deleteCloths")
	public void deleteCloth(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		cs.deleteCloths(cid);
		res.sendRedirect(req.getContextPath()+"/People/showPeople");
	}
	
	
	
	
	
}
