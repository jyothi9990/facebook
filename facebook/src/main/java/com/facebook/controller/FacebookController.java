package com.facebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.serviceinterface.FacebookServiceInterface;
import com.facebook.utility.ServiceFactory;
import com.facebookinterface.FacebookControllerInterface;

public class FacebookController implements FacebookControllerInterface {
	Logger log=Logger.getLogger("FacebookController");
	FacebookServiceInterface fs=null;
	public FacebookController() {
		 fs=ServiceFactory.createObject();
	}
	public int signUpProfileController() {
		Scanner sc=new Scanner(System.in);
		log.info("Enter Your Name:");
		String name=sc.next();
		log.info("Enter Your Password:");
		String password=sc.next();
		log.info("Enter Your Email:");
		String email=sc.next();
		log.info("Enter Your Address:");
		String address=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		
		int i=fs.signUpProfileService(fu);
		if(i>0) {
			System.out.println("Profile Created for "+name);
		}
		else {
			System.out.println("Sorry........Your Profile is not created");
		}
		return i;
		
	}

	
   public int deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		
		log.info("Enter Your Email:");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		int i=fs.deleteProfileService(fu);
		
		if(i>0) {
			System.out.println("Profile is deleted");
		}
		else {
			System.out.println("Profile is not deleted");
		}
		return i;
		
		
	}

	public FacebookUser viewProfileController() {
		
		Scanner sc=new Scanner(System.in);
		
		log.info("Enter Your Email:");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser i=fs.viewProfileService(fu);
		if(i!=null) {
			System.out.println("*********");
			System.out.println("Your name is "+i.getName());
			System.out.println("Your password is "+i.getPassword());
			System.out.println("Your email is "+i.getEmail());
			System.out.println("Your address is "+i.getAddress());
			System.out.println("**********");
			
		}
		else {
			System.out.println("Cannot View Profile");
		}
		return i;
		
	}

	public List<FacebookUser> viewAllProfilesController() {
		List<FacebookUser> ll=fs.viewAllProfilesService();
		
		System.out.println(ll.size()+" records found in the database");
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
		return ll;
	}
	
	public List<FacebookUser> searchProfileController() {
		Scanner sc=new Scanner(System.in);
		
		 log.info("Enter your Name:");
		String name=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		List<FacebookUser> i=fs.searchProfileService(fu);
		System.out.println(i.size()+" records found in database");
		
			i.forEach(p->{
				System.out.println("***********");
				System.out.println("Your name is "+p.getName());
				System.out.println("Your password is "+p.getPassword());
				System.out.println("Your email is "+p.getEmail());
				System.out.println("Your address is "+p.getAddress());
				System.out.println("***********");
			});
			return i;
		
		
		
		}


	public int editProfileController() {
		System.out.println("Your Older Data");
		viewProfileController();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your New  Name:");
		String name=sc.next();
		
		System.out.println("Enter Your New Password:");
		String password=sc.next();
		
		System.out.println("Enter Your Old Email:");
		String email=sc.next();
		
		System.out.println("Enter Your New Address:");
		String address=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		int i=fs.editProfileService(fu);
		System.out.println("Updated data is..........");
		
		if(i>0) {
			System.out.println("*****************");
			System.out.println("Name is"+name);
			System.out.println("Password is"+password);
			System.out.println("Email is"+email);
			System.out.println("Address is"+address);
			System.out.println("*****************");
		}
		else {
			System.out.println("Sorry......Your Profile is not Updated");
		}
		return i;
		
	}


	
	public FacebookUser signInProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Email:");
		String email=sc.next();
		System.out.println("Enter your Password");
		String password=sc.next();
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser s1=fs.signInProfileService(fu);
		if(s1!=null) {
			System.out.println("************");
			System.out.println("Welcome to Facebook"+s1.getName());
			System.out.println("************");
		}
		else {
			System.out.println("Unable to Signin..........try again");
		}
		return s1;
		
	}
	
	public int createTimelineController() {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter Message ID:");
	    String messageid=sc.next();
	    System.out.println("Enter Sender ID:");
	    String sender=sc.next();
	    System.out.println("Enter Reciever ID:");
	    String reciever=sc.next();
	    System.out.println("Enter Message:");
	    String message=sc.next();
	    
	    
	    TimelineDetails tld=new TimelineDetails();
	    tld.setMessageid(messageid);
	    tld.setSender(sender);
	    tld.setReciever(reciever);
	    tld.setMessage(message);
	    
	    
	    
	    int i=fs.createTimelineService(tld);
	    
	    if(i>0) {
	    	System.out.println("Your timeline is Updated");
	    }
	    else {
	    	System.out.println("Sorry,unable to create timeline");
	    }
		return i;
		
	}

	
	
}

	
		
		
	


	


