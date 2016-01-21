package com.iheart.vertical.web;


import com.iheart.vertical.abstractLayer.*;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.fail;


import org.junit.runner.Description;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.JavascriptExecutor;



public class WebLogin extends Login {
	
	//for web
    @FindBy(css=".icon-account") public WebElement web_loginButton;
	@FindBy(css = "input[name='username']") public WebElement web_userName;
	@FindBy(css = "input[name='password']") public WebElement web_password;
	@FindBy(css = "#dialog > div > div.dialog.ui-on-grey > div.wrapper > div > form > button") public WebElement web_login;
	
 
    public WebLogin()
    {
    	this(driver);
    }
	
    public WebLogin(WebDriver driver)
    {
    	super(driver);
    	
    }
	
	public void locateElements()
	{
		loginButton = web_loginButton;
		userName = web_userName;
		password = web_password;
		login = web_login;
	}
	
	
}
