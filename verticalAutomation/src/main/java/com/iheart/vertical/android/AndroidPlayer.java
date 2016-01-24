package com.iheart.vertical.android;


import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import  org.openqa.selenium.*;

public class AndroidPlayer extends Player {
	

		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.widget.ImageButton[1]") 
			public AndroidElement android_back;
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.widget.TextView[1]")
		   public AndroidElement android_stationLabel;
		
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.TextView[1]")
		     private AndroidElement android_share;
		   @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
		   		private AndroidElement android_share_messaging;
		   @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
		   		private AndroidElement android_share_facebook;
		   @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	   		private AndroidElement android_share_blueTooth;
	      @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	   		private AndroidElement android_share_copyLink;
	 
	   //What song is playing?   
	   @AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]") 
	       private AndroidElement android_songTrack;
	   @AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]") 
	   		private AndroidElement android_artist;
			
	 //  @AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]")  public AndroidElement android_songTrack_live;
	 //  @AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]")  public AndroidElement android_artist_live;
			
	      
	      
		   
				
		//Seems that this is depending upon from where the player is launched
	    /*
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public AndroidElement android_songTrack_artist;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") public AndroidElement android_artist_artist;
		
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]")  public AndroidElement android_songTrack_live;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]")  public AndroidElement android_artist_live;
		
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")  public AndroidElement android_songTrack2_live;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")  public AndroidElement android_artist2_live;
		
		
		//podcast specific
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public AndroidElement android_podcastImage;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public AndroidElement android_slideBar;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public AndroidElement android_episodeName_podcast;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public AndroidElement android_stationName_podcast;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")  public AndroidElement android_playButton_podcast;
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]")   public AndroidElement android_more_podcast;
		
		@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public AndroidElement android_playButton_live; //doesn't apply for podcast
			@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public AndroidElement android_playButton_artist;
			@AndroidFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public AndroidElement android_more_live;
			
		*/	
			
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")
		  private AndroidElement android_play;
		
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[3]") 
			private AndroidElement android_skip;
		@AndroidFindBy(name="scan") public AndroidElement android_scan;
		
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]") 
		private AndroidElement android_thumbDown;
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[2]") 
		public AndroidElement android_thumbUp;
		
		@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.ImageView[1]") 
			private AndroidElement android_favorite;

		//FOR SHARE
		@AndroidFindBy(name="Mail") public AndroidElement android_mail;
	    
		
	
	
	
	public AndroidPlayer(WebDriver driver)
	{
		super(driver);
	}

	public  void handleThumbDownPopUpForArtistStation()
	{
		
	}
	
	public  void handleGladYouLikeItPopup(){}
	
	
	
	public  void handleGladAfterFavorite(){
		
	}
	
	public  void locateElements(){
		 stationName = this.android_stationLabel;
		 songTrack = this.android_songTrack;
		 playerArtist = this.android_artist;
		
		 //android player doesn't have more....
		 more = null;
		   favorite = this.android_favorite;
		   share = this.android_share;
		  
		  thumbUp = this.android_thumbUp;
		  thumbDown = this.android_thumbDown;
		 
		  play = this.android_play;
		// pause = this.android_??? no pause?;
		// stop = this.android_???nostop?;
		 
		  skip = this.android_skip;
		 scan = this.android_scan;
		  
		// volumnIcon =;
		// volumnBar;
		
		 //fullScreen;
		// collapseScreen;
			
		

		//FOR SHARE
		// public WebElement mail;
	}
	
}
