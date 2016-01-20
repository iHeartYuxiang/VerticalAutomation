package com.iheart.vertical.abstractLayer;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;

import com.iheart.vertical.web.WebLogin;
import com.iheart.vertical.web.WebNavigation;
import com.iheart.vertical.web.WebPlayer;


public abstract class LiveRadio extends Page {

    public WebElement firstLive;
    public  WebElement firstLiveTextLink;
    
    //for filter station
    public WebElement firstStationLabel;
    public WebElement country;
    public WebElement city;
    public WebElement genresDropDown;
    public WebElement firstStation;
    public WebElement stationPlaying;
  
    
    
   
    public Login loginPage;// = PageFactory.initElements(driver, Login.class);
	public Player player;// = PageFactory.initElements(driver, Player.class);
    
    
    public LiveRadio()
    {
    	this(driver);
    }
    
    public LiveRadio(WebDriver driver)
    {
    	super(driver);
    }
    
	public void thumbUp()
	{
		loginPage.login();
		Navigation.gotoPage("liveRadio");
		int count = 0; 
		do {
			firstLive.click();
			WaitUtility.sleep(300);
			count++;
		}while (driver.getTitle().contains("Popular") && count < 5);	
		
		player.makeSureItIsPlaying();
		
	     player.doThumbUp();
	}
    
	
	public void filterLiveStation()
	{   
		Navigation.gotoPage("liveRadio");
	    
		filterStation();
		String chosenStation = firstStationLabel.getText();
		System.out.println("chosen station:" + chosenStation);
		firstStation.click();
		//Increase waiting time since sometime it is slow or it is just buffering
		WaitUtility.sleep(8000);
		
		String playingStation = stationPlaying.getText();
		System.out.println("station PLAYING:" + playingStation);
		
		player.makeSureItIsPlaying();
		
		
		if (!chosenStation.equalsIgnoreCase(playingStation))
			handleError("Filter is not working.", "filterLiveStation");
	}
	
	private void filterStation()
	{   WaitUtility.sleep(1000);
		new Select(country).selectByVisibleText("Mexico");
		WaitUtility.sleep(2000);
		//new Select(city).selectByIndex(3);
		new Select(driver.findElement(By.name("city"))).selectByIndex(1);
		WaitUtility.sleep(2000);
		new Select(genresDropDown).deselectByIndex(2);
	}
	
    
}
