package com.akshay.raxjsdemo.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.akshay.raxjsdemo.messenger.model.Message;
import com.akshay.raxjsdemo.messenger.resources.beans.MessageFilterBean;
import com.akshay.raxjsdemo.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessages() {
//		return "Hello";
//	}
	
	MessageService messageService = new MessageService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> getMessages(@QueryParam("year") int year,
//									@QueryParam("start") int start,
//									@QueryParam("size") int size) {
//		if (year != 0) {
//			return messageService.getAllMessagesForYear(year);
//		}
//		else if (start >= 0 && size > 0) {
//			return messageService.getAllMessagesPaginated(start, size);
//		}
//		else
//			return messageService.getAllMessages();
//	}
	
	
	// Same thing as above commented block with BeanParam
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if (filterBean.getYear() != 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		else if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		else
			return messageService.getAllMessages();
	}
	
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Message addMessage(Message message) {
//		return messageService.addMessage(message);
//	}
//	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage =  messageService.addMessage(message);
//		return Response.status(Status.CREATED).entity(newMessage).build();
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId) {
		messageService.removeMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	

}
