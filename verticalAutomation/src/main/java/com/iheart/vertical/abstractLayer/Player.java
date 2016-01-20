package com.iheart.vertical.abstractLayer;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.iheart.selenium.webAutomation.WaitUtility;


public abstract class Player extends Page{
	
	/*  There are 2 players on the same page for web, one under section 'hero', another under id 'player'.  need to distinguish those)
	stationName = ;
	 songTrack;
	 playerArtist;
	
	 more;
	   favorite;
	   share;
	  
	  thumbUp;
	  thumbDown;
	 
	  play;
	 pause;
	 stop;
	 
	  skip;
	 scan;
	  
	 volumnIcon;
	 volumnBar;
	
	 fullScreen;
	 collapseScreen;
		
	*/
	
	//for web

	 //meta data
	 @FindBy(css=".player-station") public WebElement web_stationName;
	 @FindBy(css=".player-song") public WebElement web_songTrack;
	 @FindBy(css=".player-artist") public WebElement web_playerArtist;
	
	 
	 /*
	     *<nav class="dropdown" role="navigation" data-reactid=".23bll5otp1c.9.0.2.1.1”>
			<ul data-reactid=".23bll5otp1c.9.0.2.1.1.0">
				<li data-reactid=".23bll5otp1c.9.0.2.1.1.0.$=1$favorite:$dropdown|0">
 				<a class="" href="javascript: void 0;" role="button" title="Add to Favorites" data-reactid=".23bll5otp1c.9.0.2.1.1.0.$=1$favorite:$dropdown|0.$favorite">Add to Favorites</a></li>
				<li data-reactid=".23bll5otp1c.9.0.2.1.1.0.$=1$share:$dropdown|1">
						<a class="" href="javascript: void 0;" role="button" title="Share" data-reactid=".23bll5otp1c.9.0.2.1.1.0.$=1$share:$dropdown|1.$share">Share</a>
				</li>
			</ul>
		  </nav> 
	     */
		
		@FindBy(css=".icon-more-horizontal") public WebElement web_more;
		
	    
		@FindBy(css="div.align-left:nth-child(3) > div:nth-child(2) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)") 
			public WebElement web_share;
		//Add to favorite
		@FindBy(css=".favorite") protected WebElement web_favorite;
		@FindBy(css=".icon-favorite-filled") protected WebElement web_icon_fav_filled;
		
		@FindBy(css=".dialog-title") public WebElement web_sharePageTitle;
		@FindBy(css="button._42ft:nth-child(2)") public WebElement web_shareOnFacebook;
		
		//Common for live radios and custom radios
		//thumbUp
		@FindBy(css="button.medium:nth-child(2)") protected WebElement web_thumbUp_button;
		
		
		@FindBy(css=".icon-thumb-up-unfilled") protected WebElement web_thumbUp;
		@FindBy(css=".icon-thumb-up-filled") protected WebElement web_thumbUpDone;
		 
	    @FindBy(css="button.medium:nth-child(1)") protected WebElement web_thumbDown;
	    @FindBy(css=".icon-thumb-down-filled") protected WebElement web_thumbDownDone;
		

	
	
	//GROWLS
		@FindBy(css=".growls") public WebElement growls;
		
		//for doSkip()
		
		@FindBy(css=".icon-skip") public WebElement web_icon_skip;
		@FindBy(css=".icon-scan") public WebElement web_icon_scan;
		
	   
		
		//player buttons
		
		@FindBy(id="player") public WebElement web_player;
		
		@FindBy(css=".icon-play") public WebElement icon_play;
	    @FindBy(css="button.idle:nth-child(3)")  public WebElement web_icon_play_inPlayer;
	   
		@FindBy(css=".icon-stop") public WebElement web_icon_stop;
		@FindBy(css=".icon-pause") public WebElement web_icon_pause;
		@FindBy(css="#player > div.player-right.ui-on-dark > button:nth-child(2) > span:nth-child(3)") 
			public WebElement web_listenHistory;
		@FindBy(css="#player > div.player-right.ui-on-dark > button:nth-child(1) > span:nth-child(3)")
		    public WebElement web_myStations;
		
	   
		
	
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
    
	
	
	
	public  WebElement stationName;
	public WebElement songTrack;
	public WebElement playerArtist;
	
	public WebElement more;
	  public WebElement favorite;
	  public WebElement share;
	  
	 public WebElement thumbUp;
	 public WebElement thumbDown;
	 
	 
	
	 public WebElement play;
	 public WebElement pause;
	 public WebElement stop;
	 
	 
	  public WebElement skip;
	  public WebElement scan;
	  
	
	 public WebElement volumnIcon;
	  public WebElement volumnBar;
	
	  public WebElement fullScreen;
	  public WebElement collapseScreen;
		
	

	//FOR SHARE
	 public WebElement mail;
    
	
	public Player()
	{
		super();
	}
	
	public Player(WebDriver _driver)
	{
		super(_driver);   
		setPlayer(this);
	}
	
	
	public void perMedia()
	{
		if (Page.mediaType.equals("web"))
		{   
			stationName = this.web_stationName;
			 songTrack = this.web_songTrack;
			 playerArtist = this.web_playerArtist;
			
			 more = this.web_more;
			 favorite = this.web_favorite;
			 share =this.web_share;
			  
			  thumbUp = this.web_thumbUp;
			  thumbDown = this.web_thumbDown;
			 
			  play = this.web_icon_play_inPlayer;
			 pause = this.web_icon_pause;
			 stop = this.web_icon_stop;
			 
			  skip = this.web_icon_skip;
			 scan = this.web_icon_scan;
			  
		//	 volumnIcon;
		//	 volumnBar;
			
			// fullScreen;
		//	 collapseScreen;
				
			

			//FOR SHARE
			// public WebElement mail;
		}else if (Page.mediaType.equals("ios"))
		{
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
				
	}
	
	
	//Why only 2 elements?
	private void verfiyCommonIcons(String callingMethod)
	{
		if(!isElementPresent(stationName))
		{    errors.append("No station name is displayed.");
		}
		
		if(!isElementPresent(songTrack))
		{    errors.append("No sound track name is displayed.");
		}
		
		if(!isElementPresent(play))
			   errors.append("Play icon is not displayed.");
		
		/*
		if(!isElementPresent(scan) )
			   errors.append("Scan icon is not displayed.");
		*/
		
		if(!isElementPresent(more))
			   errors.append(".... is not displayed.");
		
		
		if(!isElementPresent(thumbUp))
			   errors.append("No Thumb Up icon is displayed.");
		
		if(!isElementPresent(thumbDown))
			   errors.append("No Thumb Down icon is displayed.");
		
		
		//if(!isElementPresent(more))
		//	   errors.append(".... is not displayed.");
		
		if(errors.length() > 1)
			handleError("", callingMethod);
	}
	
	public void doSkip(String type)
	{
		String currentTrack, nowPlaying;
		currentTrack = getNowPlaying(type);
		
	    //skip.tap(1, 1);
		skip.click();
	    WaitUtility.sleep(2000);
	    nowPlaying = getNowPlaying(type);
	    System.out.println("before/after:" + currentTrack + "/" + nowPlaying);
	    //Verify new episode is playing
	    if (currentTrack.equals(nowPlaying))
	    	handleError("Skip is not working.", "doSkipFor" + type);
	}
	
	
	
	
	public void doShare()
	{
		more.click();
		share.click();
		if(!isElementPresent(mail))
			handleError("Share button is not working.", "doShare");
	}   
	
	public void doThumbUp()
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbUpDisabled() && count < 3)
		{	System.out.println("thumbUp button is disabled. Scan now..");
		    try{
			   scan.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbUpDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbUpDone())
		{	thumbUp.click();
		     WaitUtility.sleep(1000);
			//FOR IOS there is popups
		     //Sometimes 'Like iheartRadio?" pops up
		     if (Page.mediaType.equals("ios"))
				handleGladYouLikeItPopup();
			
		}

	     
	    thumbUp.click();
		//Glad you like it!  We'll let our DJs know.
	    String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See growls:" + response);
		
		//Sometimes 'Like iheartRadio?" pops up
		if (Page.mediaType.equals("ios"))
				handleGladYouLikeItPopup();
	}
	
	//This happens when you thumbup a already thumbuped song track
	public abstract void handleGladYouLikeItPopup();
	
	
	public abstract void handleGladAfterFavorite();
	
	
	
	//this needs to be tested
	private boolean isThumbUpDisabled()
	{    return !thumbUp.isEnabled();
	
	}
	
	private boolean isThumbDownDisabled()
	{
		return !thumbDown.isEnabled();
		
	}
	
	
	//This is for live radio
	public void doThumbDown()
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbDownDisabled() && count < 3)
		{	System.out.println("thumbDown button is disabled. Scan now..");
		    try{
			   scan.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbDownDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbDownDone())
		{	thumbDown.click();
		     WaitUtility.sleep(1000);
		   //Sometimes 'Like iheartRadio?" pops up
		     if (Page.mediaType.equals("ios"))
			     handleGladYouLikeItPopup();
			
		}
		
		thumbDown.click();
		WaitUtility.sleep(1000);
		
		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
	//	System.out.println("See thumbDOWN DOWN growls:" + response);
		
		
	//	if (! response.contains("heard enough"))
	//		handleError("Thump Down is not working properly.", "doThumbDown");
		
	}
	
	public void doThumbDown(String stationType)
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbDownDisabled() && count < 3)
		{	System.out.println("thumbDown button is disabled. Scan now..");
		    try{
		       if(stationType.equals("live"))	
			      scan.click();
		       else
		    	   skip.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbDownDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbDownDone())
		{	thumbDown.click();
		     WaitUtility.sleep(1000);
		   //Sometimes 'Like iheartRadio?" pops up
		     if (Page.mediaType.equals("ios"))
		    	 handleGladYouLikeItPopup();
			
		}
		
		thumbDown.click();
		WaitUtility.sleep(1000);
		if (Page.mediaType.equals("ios") && stationType.equals("artist"))
			handleThumbDownPopUpForArtistStation();
														
		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See thumbDOWN DOWN growls:" + response);
		

		if (Page.mediaType.equals("ios") && stationType.equals("live"))
		{   if (!response.contains("heard enough"))
			   handleError("Thump Down is not working properly.", "doThumbDown");
		}
		/*
		else // No growl when alert is showing up "Thumbing down customizes your station without using a skip." 
		{
			if (!response.contains("OK, we’ll adjust your music mix."))
				   handleError("Thump Down is not working properly.", "doThumbDown");
		}
	   	*/
		
	}
	
	private boolean isThumbUpDone()
	{
		
		boolean isDone = false;
		try{
			//if yes, its value is 1; otherwise, blank
			String value = thumbUp.getAttribute("value");
			
			System.out.println("Is thumpUp done:" + value );
			  
		   isDone = value.equals("1");
		   
		}catch(Exception e)
		{
			
		}
		return isDone;
	}
	
	private boolean isThumbDownDone()
	{
		
		boolean isDone = false;
		try{
			//if yes, its value is 1; otherwise, blank
			String value = thumbDown.getAttribute("value");
			
			System.out.println("Is thumpDown done:" + value );
			  
		   isDone = value.equals("1");
		   
		}catch(Exception e)
		{
			
		}
		return isDone;
	}
	
	public void doFavorite()
	{   //if faved before, its value is 1;
		if (isFavDone()) //unfav it
		{
			favorite.click();
			WaitUtility.sleep(1000);
			handleUnFavConfirmation();
		}
		
		favorite.click();
		WaitUtility.sleep(500);

		handleGladAfterFavorite();
		
		//Verify that icon is filled
		if (!favorite.getAttribute("value").equals("1"))
			handleError("Add to Favorite failed.", "doFavorite");
		
	/*
		String response = "";
		response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
	    System.out.println("See favorite growls:" + response);
		
		
		//Station added to your favorites!
		if (!response.contains("Station added"))
			handleError("Add to Favorite failed.", "doFavorite");
			
	*/		
		  
	}
	
	//Are you sure you want to delete this preset?
	private void handleUnFavConfirmation()
	{
		try{
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
		    WaitUtility.sleep(1000);
		}catch(Exception e)
		{
			
		}
	}
	
	//Thumbing down customizes your station without using a skip.
	public abstract void handleThumbDownPopUpForArtistStation();
	
	
	private boolean isFavDone()
	{
		boolean isDone = false;
		
	    try{
	    	isDone = favorite.getAttribute("value").equals("1");
	    }catch(Exception e)
	    {
	    	
	    }
	    
	    return isDone;
	}
	
	public void doScan()
	{
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		
		scan.click();
		WaitUtility.sleep(5000);
		//Verify that new song is playing 
		String newSong =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			handleError("Scan is not working.", "doScan");
		
	}
	
	public void doSkip()
	{
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		
		skip.click();
		WaitUtility.sleep(5000);
		//Verify that new song is playing 
		String newSong =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			handleError("Skip is not working.", "doSkip");
		
	}
	
	public void pauseAndResume(String type)
	{   WebElement theOne;
	    play.click();
		//verify it is paused
	    if(!play.getAttribute("name").contains("play"))
	    	errors.append("Station playing is not paused.");
	    
	    play.click();
	    //verify it is resumed
	    if(!play.getAttribute("name").contains("pause"))
	    	errors.append("Station playing is not RESUMED.");
	    
	}
	
	public boolean isPlaying(String type)
	{  
		boolean isPlaying = false;
		
		WebElement theOne;
	    
	  //verify that it is playing: Get its attribute: class shall be 'pause'
	    String klasses = play.getAttribute("name");
	    System.out.println("See playbutton classes:" + klasses);
	    if (klasses.contains("pause") || klasses.contains("stop"))
	    	isPlaying = true;
		
	    return isPlaying;
	}
	
	private String getNowPlaying(String type)
	{  
	    return songTrack.getText();
	}
	
	public void makeSureItIsPlaying()
	{   
	    try{

		    icon_play.isDisplayed();
	    	//icon_play_inPlayer.isDisplayed();
	
		    System.out.println("Music is not playing. About to click.");
	
		    //icon_play_inPlayer.click();
		    icon_play.click();

	    }catch(Exception e)

	    {   System.out.println("Music is playing. ");
	    	return;
	    }
	    
	    handlePreRoll();
	    
	}
	
	//to be done
	public void handlePreRoll()
	{   
		 WaitUtility.sleep(45000);
		 
	}
	
	
	
}
