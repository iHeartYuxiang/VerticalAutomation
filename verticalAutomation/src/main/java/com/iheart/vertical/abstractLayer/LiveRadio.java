package com.iheart.vertical.abstractLayer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

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
		
		if(player == null)
			System.out.println("Player is null");
		else
		    player.makeSureItIsPlaying();
		
		
		if (!chosenStation.equalsIgnoreCase(playingStation))
			handleError("Filter is not working.", "filterLiveStation");
	}
	
	
	
	private void filterStation()
	{   WaitUtility.sleep(1000);
		chooseCountry();
		WaitUtility.sleep(2000);
		//new Select(city).selectByIndex(3);
		chooseCity();
		WaitUtility.sleep(2000);
		chooseGenre();
	}
	
	public abstract void chooseCountry();
	public abstract void chooseCity();
	public abstract void chooseGenre();
}
