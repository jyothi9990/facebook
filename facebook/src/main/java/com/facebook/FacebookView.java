package com.facebook;

import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.utility.ControllerFactory;
import com.facebookinterface.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args) {
		
		String s="y";
		Scanner sc=new Scanner(System.in);
		
		while(s.equals("y")) {
		System.out.println("***********");
		System.out.println("Welcome to Facebook");
		System.out.println("***********");
		System.out.println("Press 1 to SignUp");
		System.out.println("Press 2 to SignIn");
		System.out.println("*************");
		System.out.println("Enter your choice:");
		int ch=sc.nextInt();
		FacebookControllerInterface fc=ControllerFactory.createObject();
		FacebookUser si;
		switch(ch) {
		case 1:fc.signUpProfileController();
		    break;
		case 2:si=fc.signInProfileController();
		    
		    if(si!=null) {
		    	while(s.equals("y")) {
		System.out.println("Press 1 to Delete Profile");
		System.out.println("Press 2 to View Profile");
		System.out.println("Press 3 to ViewAll Profiles");
		System.out.println("Press 4 to Edit Profile");
		System.out.println("Press 5 to Search Profile");
		System.out.println("Press 6 to Create Timeline");
		System.out.println("Enter your Function:");
		int b=sc.nextInt();
		
		
		
		switch(b) {
		case 1:fc.deleteProfileController();
			break;
		case 2:fc.viewProfileController();
		    break;
		case 3:fc.viewAllProfilesController();
		    break;
		case 4:fc.editProfileController();
		    break;
		case 5:fc.searchProfileController();
		    break;
		case 6:fc.createTimelineController();
		    break;
		
		default:
			System.out.println("You have entered Wrong Choice");
		}
		System.out.println("Press y to Continue");
		s=sc.next();
		}

	}
		    else {
		    	System.out.println("Ooops!You are not Registered User.....Please Press 1 to SignUp");
		    }

}
		}
	}
}

// test fo pushing
