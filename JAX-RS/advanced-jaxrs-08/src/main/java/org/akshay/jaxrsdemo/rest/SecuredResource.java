package org.akshay.jaxrsdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.akshay.jaxrsdemo.rest.filter.JWTTokenNeeded;

@Path("secured")
public class SecuredResource {
	
	@GET
	@Path("message")
	@JWTTokenNeeded
	@Produces(MediaType.TEXT_PLAIN)
	public String securedMethod() {
		return "This API needs login";
	}

}
