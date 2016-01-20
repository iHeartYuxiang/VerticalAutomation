package com.iheart.vertical.ios;


import com.iheart.vertical.abstractLayer.*;
import com.iheart.vertical.ios.*;
import com.iheart.vertical.web.WebLogin;

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
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class iosTest {
	private static final String DEVICE_NAME = "QA iPhone 5s";
	 private static final String UDID ="6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; //IPHONE 5s
	//private static final String UDID = "d7cb4ae985ed62b786a621597c9c0d53a4c1e678";
	 private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	// private static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-gqsmhjopkcjlrpcwsssgazkzqabp/Build/Products/Debug-iphonesimulator/iHeartRadio.app";
	 private static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-cgjadqsrbgztopfcrtkodcgtscgf/Build/Products/Debug-iphonesimulator/iHeartRadio.app";
	 
	 
	 private IOSLogin loginPage;
	 
	// private Player player;
	
	 
	 private IOSDriver driver;
	  
	  private String sessionId;
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		//BasicConfigurator.configure();
	//   driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
		 driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
	  //driver = Utils.launchAPPinRealDevice(DEVICE_NAME, UDID, BUNDLE_ID, IPA_NAME);
		
	   Page.setDriver(driver);
	   
	   Page.clearErrors();
	   
	   //loginPage = PageFactory.initElements(driver, IOSLogin.class);
	   loginPage = new IOSLogin(driver);
	    
	  }
	
	

	@Test
	public void testLogin() throws Exception {
		System.out.println("test method:" +  name.getMethodName() );
	   try{
		   loginPage.login();
	   }catch(Exception e)
	   {   handleException(e);
	   }
	}
	

	
	  @After
	  public void tearDown() {
	   //   driver.quit();  //moved into TestWatcher
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
	    
	
	  @Rule
	    public TestRule watcher = new TestWatcher() {
	        @Override
	        public void finished(Description description) {
	           // driver.quit();
	        }

	        @Override
	        public void failed(Throwable e, Description description) {
	          
	        	try {
	               
	        		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	               // String filePathRoot = "C:\\_Jenkins\\workspace\\" + jenkinsJobName + "\\target\\surefire-reports\\";
	        		String currentPath =  System.getProperty("user.dir");
	        		String path = currentPath + "\\target\\surefire-reports\\";
	        		
	                String fullFilePath = path + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

	                FileUtils.copyFile(screenshot, new File(fullFilePath));
	                
	        		
	            } catch(Exception ex) {
	                System.out.println(ex.toString());
	                System.out.println(ex.getMessage());
	            }

	          // driver.quit();
	        }
	    };

	  
}
