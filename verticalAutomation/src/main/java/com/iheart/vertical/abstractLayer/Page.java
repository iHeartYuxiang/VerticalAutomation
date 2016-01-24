package com.iheart.vertical.abstractLayer;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public abstract class Page {
	
	
	public static WebDriver driver;
	
	static Player player;
	//Real device requires longer reponse time
	static boolean isRealDevice = false;
	Logger logger = Logger.getLogger(Page.class);
	
	static String browser ="";
	public static String mediaType = "web";//could be ios, android, and auto_ios, auto_android
	//static final String USER_NAME ="iheartrocks999@gmail.com";
	//This part shall be moved to run file
	static final String USER_NAME ="iheartrocks888@gmail.com";
	static final String PASSWORD ="iheart001";
	static final String FACEBOOK_USER_NAME = USER_NAME;
	static final String GOOGLE_USER_NAME = USER_NAME;
	
	//for ubiquitous Search function
	private static WebElement searchField;
	private static String searchTerm;
	private static WebElement searchButton;
	
	public static final String screenshot_folder="iosScreenshots";
	public static StringBuffer errors = new StringBuffer(); 
	
	public Page()
	{  
		//PageFactory.initElements(driver, this);
		if (mediaType.equals("ios"))
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
		else if (mediaType.equalsIgnoreCase("android"))
		{	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}else 
		{
			try{
				   PageFactory.initElements(driver, this);
				}catch(Exception e)
				{}
		}
	}
	
	public Page(WebDriver _driver)
	{   
		this.driver = _driver;
		
		//PageFactory.initElements(driver, this);
		if (mediaType.equals("ios") || mediaType.equals("android"))
		{	
			
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		}else if (mediaType.equalsIgnoreCase("web"))
		{	try{
			   PageFactory.initElements(driver, this);
			}catch(Exception e)
			{}
		}
		
	   locateElements();
	}
	
	public abstract void locateElements();
	
	public static void search(String searchTerm)
	{   System.out.println("See  mediaType:" + mediaType);
	   if(mediaType.equals("ios"))
	   {   System.out.println("in ios section.");
		   searchButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"));
		   searchField = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]"));
		  
		   searchButton.click();
	   }else if (mediaType.equals("web"))
	   {   System.out.println("in WEB section.");
		   searchField = driver.findElement(By.cssSelector("#page-view-container > div > div.header > div.header-wrapper > div > div.header-right > form > div.form-group.ui-inline-block.search-input > input"));
		   
	   }
		
		searchField.sendKeys(searchTerm);
	}
	
	
	
	public boolean  isElementPresent(WebElement element)
	{
		 try{
			  System.out.println("see element:" +  element.getText());
			   return true;
		   }catch(Exception e)
		   {  // e.printStackTrace();
			   return false;
		   }
	}
	
	public static void setBrowser(String _browser)
	{
		browser = _browser;
	}
	
	
	
	//The popup: Like iHeartRadio? Let us know!
	public void likeIheart()
	{
		
	}
	
	public static void setDriver(WebDriver _driver)
	{
		driver = _driver;
	}
	
	public static void setPlayer(Player _player)
	{
		player = _player;
	}
	
	
	public static void setIsRealDevice(boolean isOrNot)
	{
		isRealDevice = isOrNot;
	}
	
	public static boolean getIsRealDevice()
	{
		return isRealDevice ;
	}
	
	
	
	public void waitForPreroll()
	{
		WaitUtility.sleep(38000);
	}
	
	public static StringBuffer getErrors()
	{
		return errors;
	}
	
	public void handleError(String msg, String methodName) 
	{
		errors.append(msg);
		try{
		   Utils.takeScreenshot( driver,  methodName);
		}catch(Exception e)
		{
			System.out.println("Exception is thrown taking screenshot.");
		}
	}
	
	
	public String  switchWindow()
	{
		//Switch to new tab where the sign-up is
		String winHandleBefore = driver.getWindowHandle();
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}	
		return winHandleBefore;
	}
	
	
	public void realDeviceWait(int seconds)
	{
		if (isRealDevice)
			WaitUtility.sleep(seconds);
	}
	
	public static void clearErrors()
	{
		errors.setLength(0);
	}
}
