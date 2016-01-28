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
			@FindBy(css=".icon-favorite-unfilled") protected WebElement web_icon_fav_unfilled;
			
			
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
		
	
	public void locateElements()
	{
		stationName = this.web_stationName;
		 songTrack = this.web_songTrack;
		 playerArtist = this.web_playerArtist;
		
		 more = this.web_more;
		 favorite = this.web_icon_fav_unfilled;
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
	}
	
	public  void handlePreRoll()
	{
		WaitUtility.sleep(45000);
	}
	
	
}
