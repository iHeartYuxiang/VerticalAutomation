package com.iheart.vertical.abstractLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public abstract class ArtistRadio extends Page{

	public WebElement searchField;
    public  WebElement firstLiveTextLink;
    
    //for filter station
    public WebElement firstStationLabel;
    public WebElement country;
    public WebElement city;
    public WebElement genresDropDown;
    public WebElement firstStation;
    public WebElement stationPlaying;
  
    public ArtistRadio()
    {
    	this(driver);
    }
    
    public ArtistRadio(WebDriver driver)
    {
    	super(driver);
    }
    
    
    public void search(String artist)
    {
    	
    }
    
    
	
}
