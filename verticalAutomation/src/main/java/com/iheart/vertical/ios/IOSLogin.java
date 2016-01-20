package com.iheart.vertical.ios;

import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IOSLogin extends Login {
	

    @iOSFindBy(name="Facebook") public WebElement facebookButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
		private WebElement fbEmail;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	    private IOSElement fbPassword;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
		private IOSElement fbLogin;
	
	
	//WEB version
	@FindBy(name="email") private WebElement facebookEmail_web;
	@FindBy(name="pass") private WebElement facebookPass_web;
	@FindBy(name="login") private WebElement facebookLogin;
	
	
	//Native version
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") 
	   private WebElement facebookEmail_native;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	   private WebElement facebookPassword_native;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") 
	   private WebElement FBlogin_native;
	
	
	@iOSFindBy(name="Google") private WebElement googleButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	   private WebElement googleEmail;
	@iOSFindBy(name="Next") private WebElement nextButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	   private WebElement googlePassword;
	@iOSFindBy(name="Sign in") private WebElement signIn;
	//for first-timer
	@iOSFindBy(name="Continue") private WebElement continueButton; //for first-time login user
	@iOSFindBy(name="Allow") private WebElement allowButton;
	
	//for verification: Maybe shall move nav bar stuff up to the Page.java?
	@iOSFindBy(name="For You") private WebElement forYou;
	
	
	
	
    public IOSLogin()
    {
    	this(driver);
    }
	
    public IOSLogin(WebDriver driver)
    {
    	super(driver);
    	
    }
	
   public void login()
   {    super.login();
	    try{
           driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
	    }catch(Exception e)
	    {
	    	
	    }
	//	WaitUtility.sleep(5000);
		
		chooseStayConnected(false);
		
		
		//verify we are in!
	   
	    driver.findElement(By.name("For You")).getText();
	   try{
		   driver.findElement(By.name("For You")).getText();
	   }catch(Exception e)
	   {
		   errors.append("Home page is not shown.");
	   }
	}


   
   private void chooseStayConnected(boolean stayConnected)
	{    handlePossiblePopUp();
		tellUsWhatYouLike();
		try{
			 if (stayConnected)
				 driver.findElement(By.name("Get Notifications")).click();
			 else 
				 driver.findElement(By.name("Maybe Later")).click();
		}catch(Exception e)
		{
			
		}
		
		WaitUtility.sleep(2000);
	}
	
	//Want your local radio?
	private void handlePossiblePopUp()
	{
		try{
			    WaitUtility.sleep(1000);
			driver.findElement(By.name("No Thanks")).click();
		}catch(Exception e)
		{
			
		}
	}
	
   //Tell us what you like
	private void tellUsWhatYouLike()
	{   WaitUtility.sleep(2000);
		try{
		  driver.findElement(By.name("Rock")).click();
		  
		  driver.findElement(By.name("Done")).click();
		  WaitUtility.sleep(2000);
		}catch(Exception e)
		{
		  // e.printStackTrace();	
		}
	}
	
    
}
