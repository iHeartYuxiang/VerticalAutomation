package com.iheart.vertical.ios;


import com.iheart.vertical.abstractLayer.*;

import static org.junit.Assert.*; 

import org.apache.commons.io.FileUtils;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import io.appium.java_client.ios.IOSDriver;

public class iosTest {
	private static final String DEVICE_NAME = "QA iPhone 5s";
	 private static final String UDID ="6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; //IPHONE 5s
	//private static final String UDID = "d7cb4ae985ed62b786a621597c9c0d53a4c1e678";
	 private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	// private static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-gqsmhjopkcjlrpcwsssgazkzqabp/Build/Products/Debug-iphonesimulator/iHeartRadio.app";
	 private static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-cgjadqsrbgztopfcrtkodcgtscgf/Build/Products/Debug-iphonesimulator/iHeartRadio.app";
	 
	 private IOSNavigation navigation;
	 private IOSLogin loginPage;
	 private IOSPlayer player;
	 private IOSLiveRadio liveRadio;
	 
	 private IOSDriver driver;
	
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		//BasicConfigurator.configure();
	//   driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
		 driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
	  //driver = Utils.launchAPPinRealDevice(DEVICE_NAME, UDID, BUNDLE_ID, IPA_NAME);
		
	   Page.setDriver(driver);
	   Page.mediaType = "ios";
	   
	   Page.clearErrors();
	   
	   
	   navigation = new IOSNavigation(driver);
	   //loginPage = PageFactory.initElements(driver, IOSLogin.class);
	   loginPage = new IOSLogin(driver);
	   player = new IOSPlayer(driver);
       Page.setPlayer(player);
       liveRadio = new IOSLiveRadio(driver);
	    
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
	
	@Test
	public void testSearch_ThumbUp_ThumbDown_Skip_Favorite() throws Exception {
		System.out.println("test method:" +  name.getMethodName() );
		System.out.println("CHECK IT RIGHT NOW:" + Page.mediaType);
	   try{
		   loginPage.login();
		   navigation.gotoPage("artistRadio");
		   Page.search("groban");
		   
           //liveRadio.filterLiveStation();
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
