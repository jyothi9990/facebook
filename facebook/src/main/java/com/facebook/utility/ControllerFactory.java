package com.facebook.utility;

import com.facebook.controller.FacebookController;
import com.facebookinterface.FacebookControllerInterface;

public class ControllerFactory {

	public static FacebookControllerInterface createObject() {
		
		return new FacebookController();
	}

}
