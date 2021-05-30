package com.akshay.raxjsdemo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.akshay.raxjsdemo.messenger.database.DatabaseClass;
import com.akshay.raxjsdemo.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages() {
//		Message m1 = new Message(1L, "Hello World!", "Akshay");
//		Message m2 = new Message(2L, "Hello Jersey!", "Anand");
//		List<Message> list = new ArrayList<Message>();
//		list.add(m1);
//		list.add(m2);
//		return list;
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
}
