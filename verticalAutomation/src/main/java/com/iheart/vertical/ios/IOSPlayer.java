package com.iheart.vertical.ios;



import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.iheart.vertical.abstractLayer.*;

import org.openqa.selenium.*;

import com.iheart.vertical.abstractLayer.WaitUtility;

public class IOSPlayer extends Player {
	
	//for ios
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement ios_back;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
		   public IOSElement ios_stationLabel;
		@iOSFindBy(name="Share") public IOSElement ios_share;
		@iOSFindBy(name="Favorite") public IOSElement ios_favorite;
		
		//Seems that this is depending upon from where the player is launched
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public IOSElement ios_songTrack_artist;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") public IOSElement ios_artist_artist;
		
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]")  public IOSElement ios_songTrack_live;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]")  public IOSElement ios_artist_live;
		
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")  public IOSElement ios_songTrack2_live;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")  public IOSElement ios_artist2_live;
		
		
		//podcast specific
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement ios_podcastImage;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public IOSElement ios_slideBar;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement ios_episodeName_podcast;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement ios_stationName_podcast;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")  public IOSElement ios_playButton_podcast;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]")   public IOSElement ios_more_podcast;
		
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public IOSElement ios_playButton_live; //doesn't apply for podcast
		//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public IOSElement playButton_artist;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public IOSElement ios_playButton_artist;
		//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[11]") public IOSElement more;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement ios_more_live;
		//@iOSFindBy(name="more") public IOSElement more;
		
		@iOSFindBy(name="skip") public IOSElement ios_skip;
		@iOSFindBy(name="scan") public IOSElement ios_scan;
		@iOSFindBy(name="Thumb up") public IOSElement ios_thumbUp;
		@iOSFindBy(name="Thumb down") public IOSElement ios_thumbDown;
		//FOR SHARE
		@iOSFindBy(name="Mail") public IOSElement ios_mail;
	    
		
	
	  public IOSPlayer()
	  {
		  this(driver);
	  }
	
	  public IOSPlayer(WebDriver driver)
	  {
		  super(driver);
	  }
	//This happens when you thumbup a already thumbuped song track
		public void handleGladYouLikeItPopup()
		{
			try{
				   driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[10]")).click();//No , thnak you.
			}catch(Exception e)
			{
				
			}
		}
		
		public void handleGladAfterFavorite()
		{
		  try{
		    driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")).click();//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]
		    WaitUtility.sleep(200);
		  }catch(Exception e)
		  {
			  
		  }
		}
		
		//Thumbing down customizes your station without using a skip.
		public void handleThumbDownPopUpForArtistStation()
		{
			try{
				//click on OKAY BUTTON of alert box: Thumbing down customizes your station without using a skip.
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
			    WaitUtility.sleep(1000);
			}catch(Exception e)
			{
				
			}
		}
		
		public  void locateElements(){
			 stationName = this.ios_stationLabel;
			 songTrack = this.ios_songTrack_artist;
			 playerArtist = this.ios_artist_artist;
			
			 more = this.ios_more_live;
			   favorite = this.ios_favorite;
			   share = this.ios_share;
			  
			  thumbUp = this.ios_thumbUp;
			  thumbDown = this.ios_thumbDown;
			 
			  play = this.ios_playButton_artist;
			// pause = this.ios_??? no pause?;
			// stop = this.ios_???nostop?;
			 
			  skip = this.ios_skip;
			 scan = this.ios_scan;
			  
			// volumnIcon =;
			// volumnBar;
			
			 //fullScreen;
			// collapseScreen;
				
			

			//FOR SHARE
			// public WebElement mail;
		}
		
		
		public  void handlePreRoll()
		{
			//DO NOTHING since simulator doesn't have preroll
		}
		

}
