package com.facebook;

import java.util.List;

import com.facebook.dao.FacebookDAO;
import com.facebook.daointerface.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

import junit.framework.TestCase;

public class DaoTesting extends TestCase {
   FacebookDAOInterface fd=null;
	protected void setUp() throws Exception {
		fd=new FacebookDAO();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		fd=null;
		super.tearDown();
	}

	public void testSignUpProfileDAO() {
		
	FacebookUser fu=new FacebookUser();
	
		fu.setName("sashi");
		fu.setPassword("jyow");
		fu.setEmail("sasch@gmail.com");
		fu.setAddress("jio");
		int i=fd.signUpProfileDAO(fu);
		
		assert i>0: "Test case failed for signup";
		
	}

	public void testDeleteProfileDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("oipugyuiioo@gmail.com");
		int i=fd.deleteProfileDAO(fu);
		assert i>0: "Test case failed for delete";
		
	}

	public void testViewProfileDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("sasch@gmail.com");
		FacebookUser i=fd.viewProfileDAO(fu);
		if(i!=null) {
			System.out.println("*********");
			System.out.println("Your name is "+i.getName());
			System.out.println("Your password is "+i.getPassword());
			System.out.println("Your email is "+i.getEmail());
			System.out.println("Your address is "+i.getAddress());
			System.out.println("**********");
			}
		assert i!=null:"Test failed to viewprofile";
	}

	public void testViewAllProfilesDAO() {
		FacebookUser fu=new FacebookUser();
		List<FacebookUser> ll=fd.viewAllProfilesDAO();
		if(ll!=null) {
			ll.forEach(s->{
				System.out.println("***********");
				System.out.println("Name is "+s.getName());
				System.out.println("Password is "+s.getPassword());
				System.out.println("Email is "+s.getEmail());
				System.out.println("Address is "+s.getAddress());
				System.out.println("***********");
				
			});
		}
		assert ll!=null:"Test failed to viewall profile";
	}

	public void testEditProfileDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setName("chandu");
		fu.setPassword("jop");
		fu.setEmail("jia@gmail.com");
		fu.setAddress("nandhayl");
		int i=fd.editProfileDAO(fu);
		assert i>0:"Test failed to edit profile";
	}

	public void testSearchProfileDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setName("bhaskar");
		List<FacebookUser> i=fd.searchProfileDAO(fu);
		assert i!=null:"Test failed to searchprofile";
		
	}

	public void testSignInProfileDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setEmail("abv@gmail.com");
		fu.setPassword("adf");
		FacebookUser s1=fd.signInProfileDAO(fu);
		assert s1!=null:"Test failed to searchprofile";
	}

	public void testCreateTimelineDAO() {
		  TimelineDetails tld=new TimelineDetails();
		    tld.setMessageid("hi");
		    tld.setSender("roi");
		    tld.setReciever("hji");
		    tld.setMessage("how r ");
		    
		    
		    
		    int i=fd.createTimelineDAO(tld);
		    assert i>0:"Test failed to createtimeline profile";
		    
	}

}
