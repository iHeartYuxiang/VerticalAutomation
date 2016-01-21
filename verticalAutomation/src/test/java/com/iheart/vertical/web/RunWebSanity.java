package com.iheart.vertical.web;


import com.iheart.vertical.abstractLayer.*;

import java.io.File;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;


public class RunWebSanity {

		WebDriver driver;
		
		WebNavigation navigation;
		WebLogin loginPage;
		WebPlayer player;
		WebLiveRadio liveRadio;
		
		
		//String browser = "firefox";
		String browser = "chrome";
		
		static String userCity = "";
		
		 
		final String URL = "http://www.iheart.com";
		
		@Rule public TestName name = new TestName();
		
		
		@Before
	    public void init() throws Exception {
	        driver = Utils.launchBrowser(URL, browser);
	        Page.setDriver (driver);
	       
	      //  loginPage = PageFactory.initElements(driver, WebLogin.class);
	       // player = PageFactory.initElements(driver, WebPlayer.class);
	       loginPage = new WebLogin(driver);
	       player = new WebPlayer(driver);
	       Page.setPlayer(player);
	       liveRadio = new WebLiveRadio(driver);
	        
	        Page.getErrors().delete(0, Page.getErrors().length());
	        
	         //Wait for page to load
	        WaitUtility.sleep(5000);
	    }
	    
		
		
		  @Test
	     public void testLogin() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         
	         
	         try{
	             loginPage.login();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         
	        
	         System.out.println(name.getMethodName() + " is Done.");
	     }     
		  
		  
		 @Test
	     public void testFilterLiveStation() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         
	         
	         try{
	             loginPage.login();
	             navigation.gotoPage("liveRadio");
	             liveRadio.filterLiveStation();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         
	        
	         System.out.println(name.getMethodName() + " is Done.");
	     }     
		
		
		  @Test
		     public void testPlayer_skip() throws Exception
		     {   
		         System.out.println("test method:" +  name.getMethodName() );
		         
		         
		         try{
		             loginPage.login();
		             player.doSkip();
		         }catch(Exception e)
		         {
		             handleException(e);
		         }      
		         
		        
		         System.out.println(name.getMethodName() + " is Done.");
		     }     
		
		  
		
		     @After
			    public void tearDown() throws Exception{
		    	   
			    	if (Page.getErrors().length() > 0)
						 fail(Page.getErrors().toString());
			    	   
			    	
			    }
			
			    private void handleException(Exception e)
			    {   Page.getErrors().append("Exception is thrown.");
			        e.printStackTrace();
			        /*
		            try{
			    	   Page.takeScreenshot(driver, name.getMethodName());
		            }catch(Exception eX)
		            {
		            	
		            }
		            */
			    }
			    
			   
			    
			    @Rule
			    public TestRule watcher = new TestWatcher() {
			        @Override
			        public void finished(Description description) {
			        //    driver.quit();
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

			            //driver.quit();
			        }
			    };
		
	
}
