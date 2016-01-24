package com.iheart.vertical.abstractLayer;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


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

		    play.isDisplayed();
	    	//icon_play_inPlayer.isDisplayed();
	
		    System.out.println("Music is not playing. About to click.");
	
		    //icon_play_inPlayer.click();
		    play.click();

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
	
	//Thumbing down customizes your station without using a skip.
	public abstract void handleThumbDownPopUpForArtistStation();
	
	//This happens when you thumbup a already thumbuped song track
	public abstract void handleGladYouLikeItPopup();
	
	
	public abstract void handleGladAfterFavorite();
	
}
