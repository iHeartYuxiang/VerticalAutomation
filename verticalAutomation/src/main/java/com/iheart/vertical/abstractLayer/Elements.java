package com.iheart.vertical.abstractLayer;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.Map;
import java.util.HashMap;

public class Elements {
	
	//For web
	public static final  String web_loginButton_css =".icon-account";
	public static  final  String web_userName_css = "input[name='username']";
	public static  final  String web_password_css = "input[name='password']";
	public static final  String web_login_css = "#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > form > button";
	 
	
	//For Mobile - ios
	public static final  String ios_loginButton_css ="[name='Log In']";
	public static  final  String ios_userName_css = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]";
	public static  final  String ios_password_css = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]";
	public static final  String ios_login_css = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]";
	 
	/*
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")
    private IOSElement userName;
@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]")
   private IOSElement password;
@iOSFindBy(name="Log In") private IOSElement loginButton;
    */

	
	
	
	public static final String getElement(String element)
	{
		if (Page.mediaType.equals("web"))
			return web_loginButton_css;
		else 
			return ios_loginButton_css;
	}
	
}

