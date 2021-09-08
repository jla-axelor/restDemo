package com.axelor.Services;

import javax.persistence.EntityManager;

import com.axelor.db.People;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;



@Singleton
public class PeopleServiceImp implements PeopleService {

	@Inject
	public Provider<EntityManager> emp;
	
	@Transactional
	public boolean createPeople(People p) {
		EntityManager em =  emp.get();
		em.persist(p);
		return true;
	}
}
