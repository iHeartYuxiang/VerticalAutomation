package com.iheart.vertical.android;



import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebDriver;

public class AndroidLiveRadio extends LiveRadio {
	
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	public  AndroidElement android_cities;
	//@AndroidFindBy(name="Cities")
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[6]/android.widget.TextView[1]")
		//@AndroidFindBy(css="android.widget.TextView")
		public  AndroidElement android_al_mobile; //or by name="Mobile"
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	public  AndroidElement android_firstStation;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
		public  AndroidElement android_firstStationLabel;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.widget.TextView[1]")
		public  AndroidElement android_stationPlaying;
	
	
	
	public AndroidLiveRadio()
	{
	   this(driver);
	}
	
	public AndroidLiveRadio(WebDriver _driver)
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
		android_cities.click();
		WaitUtility.sleep(2000);
		android_al_mobile.click();
	}
	
	public void chooseGenre()
	{
		//DO NOTHING
	}
	
	public void locateElements()
	{  firstStation = this.android_firstStation;
	   firstStationLabel = this.android_firstStationLabel;
	   stationPlaying = this.android_stationPlaying;
	}


}
