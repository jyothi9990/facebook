package com.facebook.serviceinterface;

import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public interface FacebookServiceInterface {
	
	int signUpProfileService(FacebookUser fu);

	
	int deleteProfileService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);

	List<FacebookUser> viewAllProfilesService();

	int editProfileService(FacebookUser fu);

	List<FacebookUser> searchProfileService(FacebookUser fu);


	FacebookUser signInProfileService(FacebookUser fu);


	int createTimelineService(TimelineDetails tld);

	
	
	 

	

}
