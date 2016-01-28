package com.iheart.vertical.abstractLayer;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class Login  extends Page{
		
    
	
    public WebElement loginButton, userName, password, login;
    
	
	public Login()
	{
		this(driver);
		
	}
	
	public Login(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	
	//What about sign up? I guess that I will worry about that later.
	
	public void login()
	{ 
		login(USER_NAME, PASSWORD);
	}
	
	public void login(String _userName, String _password)
	{  // WaitUtility.sleep(2000);
		//Set Location?
		if (Page.mediaType.equals("android"))
			setLocation();
		
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
	
	
	public abstract void setLocation();
   
}
