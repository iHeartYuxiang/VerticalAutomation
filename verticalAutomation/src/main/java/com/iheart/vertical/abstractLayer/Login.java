package com.iheart.vertical.abstractLayer;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class Login  extends Page{
		
    //for web
    @FindBy(css=".icon-account") public WebElement web_loginButton;
	@FindBy(css = "input[name='username']") public WebElement web_userName;
	@FindBy(css = "input[name='password']") public WebElement web_password;
	@FindBy(css = "#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > form > button") public WebElement web_login;
	
	//for ios 
	@iOSFindBy(name="Log In") private IOSElement ios_loginButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")
    	private IOSElement ios_userName;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]")
		private IOSElement ios_password;
	@iOSFindBy(xpath= "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") private IOSElement ios_login;
	
    public WebElement loginButton, userName, password, login;
    
	
	public Login()
	{
		this(driver);
		perMedia();
		
	}
	
	public Login(WebDriver driver)
	{
		super(driver);
		perMedia();
		
	}
	
	public void perMedia()
	{
		if (Page.mediaType.equals("web"))
		{   
			loginButton = web_loginButton;
			userName = web_userName;
			password = web_password;
			login = web_login;
		}else if (Page.mediaType.equals("ios"))
		{
			loginButton = ios_loginButton;
			userName = ios_userName;
			password = ios_password;
			login = ios_login;
		}
				
	}
	
	//What about sign up? I guess that I will worry about that later.
	
	public void login()
	{ 
		login(USER_NAME, PASSWORD);
	}
	
	public void login(String _userName, String _password)
	{   
		int count = 0;    
		do{
			
			try{
			   loginButton.click();
			   
			}catch(Exception e)
			{
				
			}
			WaitUtility.sleep(1500);
			
			count++;
		}while (count< 6 && !driver.getPageSource().contains("Don't have an account?"));
		
		WaitUtility.sleep(1000);
    	userName.sendKeys(_userName);
	    password.sendKeys(_password);
	
		login.click();
		
		WaitUtility.sleep(1000);
	}
	
   
}
