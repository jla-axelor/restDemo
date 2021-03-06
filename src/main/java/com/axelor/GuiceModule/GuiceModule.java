package com.axelor.GuiceModule;

import com.axelor.resources.ClothsResource;
import com.axelor.resources.PeopleResource;
import com.google.inject.AbstractModule;
import com.axelor.Services.ClothsService;
import com.axelor.Services.ClothsServiceImp;
import com.axelor.Services.PeopleService;
import com.axelor.Services.PeopleServiceImp;

public class GuiceModule extends AbstractModule{
	
	@Override
	protected void configure() {
	
		bind(PeopleService.class).to(PeopleServiceImp.class);
		bind(ClothsService.class).to(ClothsServiceImp.class);
		bind(PeopleResource.class);
		bind(ClothsResource.class);
	
	}

}
