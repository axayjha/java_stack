package org.akshay.jaxrsdemo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.akshay.jaxrsdemo.messenger.database.DatabaseClass;
import org.akshay.jaxrsdemo.messenger.model.Profile;

public class ProfileService {
	
	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	static {
		profiles.put("Akshay", new Profile(1L, "Akshay", "Akshay", "Anand"));
	}
	public ProfileService() {
		
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
