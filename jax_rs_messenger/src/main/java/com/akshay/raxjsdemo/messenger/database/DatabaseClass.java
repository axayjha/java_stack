package com.akshay.raxjsdemo.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.akshay.raxjsdemo.messenger.model.Message;
import com.akshay.raxjsdemo.messenger.model.Profile;

public class DatabaseClass {
	public static Map<Long, Message> messages = new HashMap<Long, Message>();
	public static Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
}
