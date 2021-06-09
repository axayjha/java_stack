package org.akshay.jaxrsdemo.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.akshay.jaxrsdemo.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
//		Response response = client.target("http://localhost:8080/advanced-jaxrs-06/webapi/messages/1").request().get();
//		System.out.println(response.readEntity(Message.class).getMessage());
		
		// OR
		
//		WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-06/webapi/messages/1");
//		Builder builder = target.request();
//		Response response = builder.get();
//		Message message = response.readEntity(Message.class);
		
		// OR
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-06/webapi/");
		WebTarget messagesTarget =  baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message.getMessage());
		
		
		Message newMessage = new Message(4, "new msg from client", "akshay");
		Response postResponse = messagesTarget.request()
		.post(Entity.json(newMessage));
		
		System.out.println(postResponse.readEntity(Message.class).getMessage());
	}
}
