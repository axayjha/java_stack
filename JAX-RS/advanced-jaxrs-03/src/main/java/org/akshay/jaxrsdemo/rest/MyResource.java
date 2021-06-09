package org.akshay.jaxrsdemo.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {
	
	
	// cant have below for singleton
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExmple;
	
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "It works! path param: " + pathParamExample + " and query param: " + queryParamExmple;
	}

}
