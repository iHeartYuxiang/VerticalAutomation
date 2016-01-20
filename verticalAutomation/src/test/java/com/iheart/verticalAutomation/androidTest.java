package com.iheart.verticalAutomation;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*; 

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class androidTest {

	private static final String DEVICE_NAME = "mySecondEmulator";
	// private static final String UDID ="6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; //IPHONE 5s
     private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	// private static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-gqsmhjopkcjlrpcwsssgazkzqabp/Build/Products/Debug-iphonesimulator/iHeartRadio.app";
	 private static final String APP_NAME = "/Users/1111128/Desktop/androidBuild/iHeartRadio-google-mobile-ampprod-debug.apk";
	 		
	 //private HomePage homePage;
	 private LoginPage loginPage;
	 //private SignUpPage signupPage;
	 private Player player;
	 //private SideNavigationBar sideNavBar;

	 //private ForYouPage forYouPage;
	 //private PerfectForPage perfectForPage;
	 //private DeepLink deepLink;
	 //private PodcastsPage podcastsPage;
	 
	 private AndroidDriver driver;
	  
	  private String sessionId;
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		//BasicConfigurator.configure();
		// driver = Utils.launchAPPinEmulator(DEVICE_NAME, APP_NAME);
	    driver = Utils.launchAPPinAndroidPhone(APP_NAME);
		
	   Page.setDriver(driver);
	   Page.clearErrors();
	   
     loginPage = new LoginPage(driver);
//     signupPage = new SignUpPage(driver);
   //  player = new Player(driver);
  //   sideNavBar = new SideNavigationBar(driver);
     
    // forYouPage = new ForYouPage(driver);
    // perfectForPage = new PerfectForPage(driver);
    // podcastsPage = new PodcastsPage(driver);
     
    // deepLink = new DeepLink(driver);
	    
	  }
	

	@Test
	public void testLogin() throws Exception {
	   try{
	       loginPage.login();
		 	
	   }catch(Exception e)
	   {   handleException(e);
	   }
	}
	
	  @After
	  public void tearDown() {
	     // driver.quit();  //moved into TestWatcher
		  if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	   
	  }
	  
	  
	  private void handleException(Exception e)
	  {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
	      /* 
          try{
	    	   Utils.takeScreenshot(driver, name.getMethodName());
          }catch(Exception eX)
          {
          	
          }
          */
	  }
	    

	
}
