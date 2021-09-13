package com.axelor.listner;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.GuiceModule.GuiceModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class GuiceListner  extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	protected List<? extends Module> getModules(final ServletContext context) {
		
		return Arrays.asList(new JpaPersistModule("people_details") , new GuiceModule());
		
	}
	
	@Override
	protected void withInjector(Injector injector) {
			
		injector.getInstance(PersistService.class).start();
	
	}

}
