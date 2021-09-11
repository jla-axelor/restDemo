package com.axelor.Services;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.Cloths;
import com.axelor.db.People;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;



@Singleton
public class PeopleServiceImp implements PeopleService {

	@Inject
	public Provider<EntityManager> emp;
	
	@Transactional
	public boolean createPeople(People p) {
		 emp.get().persist(p);
		return true;
	}
	
	@Override
	@Transactional
	public List<People> displayPeople() {
		EntityManager em =  emp.get();
		Query q = em.createQuery("from People order by pid");
		@SuppressWarnings("unchecked")
		List<People> p = q.getResultList();
		
		return p;
		
		}
	
	@Override
	@Transactional
	public String updatePeople(int pid , String pname) {
		EntityManager em =  emp.get();
		People p = em.find(People.class, pid);
		p.setPname(pname);
		String name = p.getPname();
		return name;
	}
	@Override
	@Transactional
	public People deletePeople(int pid) {
		EntityManager em =  emp.get();
		People p = em.find(People.class, pid);
		em.remove(p);
		return p;
	}
	
	public void addCloths(Cloths c , int pid) {
		EntityManager em =  emp.get();
		People p = em.find(People.class, pid);
		c.setPeople(p);
		p.setCloths(Arrays.asList(c));
	}
}
