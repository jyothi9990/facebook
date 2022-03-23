package com.facebookinterface;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookControllerInterface {
     
	int signUpProfileController();

	int deleteProfileController();

	FacebookUser viewProfileController();

	List<FacebookUser> viewAllProfilesController();

	int editProfileController();

	List<FacebookUser> searchProfileController();

	FacebookUser signInProfileController();

	int createTimelineController();

	

	

	

	
	

	
	
}
