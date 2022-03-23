package com.facebook;

import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.service.FacebookService;
import com.facebook.serviceinterface.FacebookServiceInterface;

import junit.framework.TestCase;

public class ServiceTesting extends TestCase {
    FacebookServiceInterface fs=null;
	protected void setUp() throws Exception {
		fs=new FacebookService();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		fs=null;
		super.tearDown();
	}

	public void testSignUpProfileService() {
		
		FacebookUser fu=new FacebookUser();
		fu.setName("bhuvan");
		fu.setPassword("bhuva");
		fu.setEmail("bhuvan@gmail.com");
		fu.setAddress("ongo");
		int i=fs.signUpProfileService(fu);
		
		assert i>0: "Test case failed for signup";
		
		
	}

	public void testDeleteProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("rash@gmail.com");
		int i=fs.deleteProfileService(fu);
		assert i>0: "Test case failed to delete profile";
	}
	

	public void testViewProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("jia@gmail.com");
		
		FacebookUser v=new FacebookUser();
		assert v!=null:"test failed";
	}

	public void testViewAllProfilesService() {
		FacebookUser fu=new FacebookUser();
		List<FacebookUser> ll=fs.viewAllProfilesService() ;
		if(ll!=null) {
			ll.forEach(s->{
				System.out.println("***********");
				System.out.println("Name is "+s.getName());
				System.out.println("Password is "+s.getPassword());
				System.out.println("Email is "+s.getEmail());
				System.out.println("Address is "+s.getAddress());
				System.out.println("***********");
				
			});
		assert ll!=null:"Test failed for viewallprofiles service";
	}
	}

	public void testEditProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setName("rash");
		fu.setPassword("adf");
		fu.setEmail("abv@gmail.com");
		fu.setAddress("hydf");
		int i=fs.editProfileService(fu);
		assert i>0:"Test failed to edit profile";
		

		
	}

	public void testSearchProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setName("bhaskar");
		List<FacebookUser> i=fs.searchProfileService(fu);
		assert i!=null:"Test failed to searchprofile";
		
		
		
	}

	public void testSignInProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("abv@gmail.com");
		fu.setPassword("adf");
		FacebookUser s1=fs.signInProfileService(fu);
		assert s1!=null:"Test failed to searchprofile";
		
	}

	public void testCreateTimelineService() {
		  
	    TimelineDetails tld=new TimelineDetails();
	    tld.setMessageid("hi");
	    tld.setSender("roi");
	    tld.setReciever("hji");
	    tld.setMessage("how r ");
	    
	    
	    
	    int i=fs.createTimelineService(tld);
	    assert i>0:"Test failed to createtimeline profile";
	    
		
	}

}
