package com.iheart.vertical.web;


import com.iheart.vertical.abstractLayer.*;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

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



public class WebPlayer extends Player {
	
	public WebPlayer()
	{
		this(driver);
	}
	public WebPlayer(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	public  void handleThumbDownPopUpForArtistStation()
	{
		//do nothing
	}

		public  void handleGladYouLikeItPopup(){
			
		}
		
		
		public  void handleGladAfterFavorite()
		{
			
		}
		
}
