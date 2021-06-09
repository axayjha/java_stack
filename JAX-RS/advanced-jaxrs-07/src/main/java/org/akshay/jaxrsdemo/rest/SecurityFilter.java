package org.akshay.jaxrsdemo.rest;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> outHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (outHeader != null && outHeader.size() > 0) {
				String authToken = outHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
//				System.out.println(decodedString);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				if ("user".contentEquals(username) && "password".contentEquals(password)) {
					return;
				}
			}

			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource").build();
			requestContext.abortWith(unauthorizedStatus);
		}
	}

}
