package com.facebook;

import java.util.List;
import java.util.Scanner;

import com.facebook.controller.FacebookController;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebookinterface.FacebookControllerInterface;

import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	FacebookControllerInterface fc=null;

	protected void setUp() throws Exception {
		fc=new FacebookController();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		fc=null;
		super.tearDown();
	}

	public void testSignUpProfileController() {
		int i=fc.signUpProfileController();
		assert i>0: "Test failed to signup profile";
	}

	public void testDeleteProfileController() {
		int i=fc.deleteProfileController();
		assert i>0: "Test failed to delete profile";
	}

	public void testViewProfileController() {
		FacebookUser i=fc.viewProfileController();
		assert i!=null:  "Test failed to view profile";
	}

	public void testViewAllProfilesController() {
		List<FacebookUser> ll=fc.viewAllProfilesController();
		assert ll!=null: "Test failed to viewallprofiles";
	}

	public void testSearchProfileController() {
		List<FacebookUser> i=fc.searchProfileController();
		assert i!=null: "Test failed to search profile";
	} 

	public void testEditProfileController() {
		
		int i=fc.editProfileController();
		assert i>0:"Test failed to edit profile";
		
		
	}

	public void testSignInProfileController() {
	
		FacebookUser s1=fc.signInProfileController();
		assert s1!=null:"Test failed to signinprofile";
		
	}

	public void testCreateTimelineController() {
		 
		    int i=fc.createTimelineController();
		    assert i>0:"Test failed to create timeline";
	}

}
