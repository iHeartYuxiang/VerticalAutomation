package com.iheart.vertical.ios;


import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IOSLiveRadio extends LiveRadio {
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[2]/UIAStaticText[1]")
    	public  IOSElement ios_cities;
	//@iOSFindBy(name="Cities")
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[7]/UIAStaticText[1]")
		public  IOSElement ios_al_mobile; //or by name="Mobile"
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[1]/UIAStaticText[1]")
	public  IOSElement ios_firstStation;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[1]/UIAStaticText[1]")
		public  IOSElement ios_firstStationLabel;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
		public  IOSElement ios_stationPlaying;
	
   public IOSLiveRadio()
   {
	   this(driver);
   }
	
   public IOSLiveRadio(WebDriver _driver)
   {
	   super(_driver);
   }
	
	public void chooseCountry()
	{
		//Do nothing
	}
	   
	public void chooseCity()
	{
		//choose state, choose city
		ios_cities.click();
		ios_al_mobile.click();
	}
	
	public void chooseGenre()
	{
		//DO NOTHING
	}
    
	public void locateElements()
	{  firstStation = this.ios_firstStation;
	   firstStationLabel = this.ios_firstStationLabel;
	   stationPlaying = this.ios_stationPlaying;
	}
	
}
