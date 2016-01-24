package com.iheart.vertical.android;

import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.*;


public class AndroidNavigation extends Page implements Navigation {
	

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")  
		public AndroidElement android_navIcon;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]") 
	    private AndroidElement android_home;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")
	   public AndroidElement android_liveRadio;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")
	  public AndroidElement android_artistRadio;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[1]")
		public AndroidElement android_podcasts;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.TextView[1]")
		public AndroidElement android_perfectFor;
	
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.TextView[1]")  
		public AndroidElement android_listeningHistory;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[8]/android.widget.TextView[1]")
		public AndroidElement android_alarm;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[9]/android.widget.TextView[1]")
		public AndroidElement android_sleepTimer;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[10]/android.widget.TextView[1]")
		public AndroidElement android_accountSettings;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[11]/android.widget.TextView[1]")
		public AndroidElement android_exitApp;
	
	public AndroidNavigation(AndroidDriver _driver)
	{
		super(_driver);
	}
	
	
    private void goto_direct(AndroidElement _page)
    {
    	android_navIcon.click();
    	_page.click();
    }
	
	public  void gotoPage(String pageName)
	{
		 switch (pageName) {
	        case "liveRadio":
	        	goto_direct(android_liveRadio);
	            break;
	        case "artistRadio":
	        	goto_direct(android_artistRadio);
	        	break;
	        case "perfectFor":
	        	goto_direct(android_perfectFor);
	        	break;
	        case "podcasts":
	        	goto_direct(android_podcasts);
	            break;
	        case "home":
	        	goto_direct(android_home);
	            break;
	        default:
	        	goto_direct(android_home);
	            throw new IllegalArgumentException("Page doesn't exist: " + pageName);
	    }
	}
	
    public void locateElements()
    {
    	
    	
    }
	
}
