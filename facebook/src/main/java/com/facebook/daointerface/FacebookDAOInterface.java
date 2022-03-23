package com.facebook.daointerface;

import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public interface FacebookDAOInterface {

	int signUpProfileDAO(FacebookUser fu);


	int deleteProfileDAO(FacebookUser fu);

	FacebookUser viewProfileDAO(FacebookUser fu);

	List<FacebookUser> viewAllProfilesDAO();

	int editProfileDAO(FacebookUser fu);


	

	List<FacebookUser> searchProfileDAO(FacebookUser fu);

	

	FacebookUser signInProfileDAO(FacebookUser fu);

	int createTimelineDAO(TimelineDetails tld);


	
	
	
	

}
