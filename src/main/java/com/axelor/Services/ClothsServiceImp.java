package com.axelor.Services;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.Cloths;
import com.axelor.db.People;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;


public class ClothsServiceImp implements ClothsService {
	
	@Inject
	public Provider<EntityManager> emp;
	
	@Override
	@Transactional
	public void addCloths(Cloths c , int pid) {
		EntityManager em =  emp.get();
		People p = em.find(People.class, pid);
		c.setPeople(p);
		p.setCloths(Arrays.asList(c));
	}
	
	@Override
	@Transactional
	public String updateCloths(int cid, String cname) {
		EntityManager em =  emp.get();
		Cloths c = em.find(Cloths.class, cid);
		 c.setCname(cname);
		  return c.getCname();
		
	}
	@Override
	@Transactional
	public void deleteCloths(int cid) {
		EntityManager em =  emp.get();
		Cloths c = em.find(Cloths.class, cid);
		People p =  c.getPeople();
//		List<Cloths> cc = Arrays.asList(c); 
		p.getCloths().remove(c);
		em.remove(c);
		
	}
}
