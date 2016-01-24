package com.iheart.vertical.android;

import com.iheart.vertical.abstractLayer.*;


import static org.junit.Assert.*; 

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




import io.appium.java_client.android.AndroidDriver;

public class androidTest {

	//private static final String DEVICE_NAME = "Samsung Galaxy S3 - 4.3 - API 18 - 720x1280";
	private static final String DEVICE_NAME = "mySecondEmulator";
	 private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	 private static final String APP_NAME = "/Users/1111128/Desktop/androidBuild/iHeartRadio-google-mobile-ampprod-debug.apk";
	 		
	 private AndroidNavigation navigation;
	 private AndroidLogin loginPage;
	 private AndroidPlayer player;
	 private AndroidLiveRadio liveRadio;
	 
	
	 private AndroidDriver driver;
	  
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		 
	    driver = Utils.launchAPPinGenymotion(DEVICE_NAME, APP_NAME);
		// driver = Utils.launchAPPinAndroidPhone( APP_NAME);
		
	    Page.setDriver(driver);
		   Page.mediaType = "android";
		   
		   Page.clearErrors();
		   
		   loginPage = new AndroidLogin(driver);
		   navigation = new AndroidNavigation(driver);
		   
		   player = new AndroidPlayer(driver);
	       Page.setPlayer(player);
	       liveRadio = new AndroidLiveRadio(driver);
	   
	  }
	

	@Test
	public void testLogin() throws Exception {
	   try{
	      loginPage.login();
		 	
	   }catch(Exception e)
	   {   handleException(e);
	   }
	}
	
	@Test
	public void testFilterLiveStation() throws Exception {
		System.out.println("test method:" +  name.getMethodName() );
	   try{
		   loginPage.login();
		   navigation.gotoPage("liveRadio");
		   liveRadio.filterLiveStation();
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
