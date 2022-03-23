package com.facebook.service;

import java.util.List;

import com.facebook.daointerface.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.serviceinterface.FacebookServiceInterface;
import com.facebook.utility.DAOFactory;

public class FacebookService implements FacebookServiceInterface {
	FacebookDAOInterface fd=null;
	public FacebookService() {
		 fd=DAOFactory.createObject();
	}
	public int signUpProfileService(FacebookUser fu) {
		int i=fd.signUpProfileDAO(fu);
		return i;
	}

	public int deleteProfileService(FacebookUser fu) {
		
		return fd.deleteProfileDAO(fu);
	}

	public FacebookUser viewProfileService(FacebookUser fu) {
		return fd.viewProfileDAO(fu) ;
	}

	@Override
	public List<FacebookUser> viewAllProfilesService() {
		
		return fd.viewAllProfilesDAO();
	}


	public int editProfileService(FacebookUser fu) {
		
		return fd.editProfileDAO(fu);
	}

	public List<FacebookUser> searchProfileService(FacebookUser fu) {
		return fd.searchProfileDAO(fu);
	}

	
	public FacebookUser signInProfileService(FacebookUser fu) {
		return fd.signInProfileDAO(fu);
	}
	
	public int createTimelineService(TimelineDetails tld) {
		
		return fd.createTimelineDAO(tld);
	}

	
	

	

	

	
	

	
	

}
