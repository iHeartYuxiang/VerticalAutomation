package com.iheart.vertical.ios;



import com.iheart.vertical.abstractLayer.*;

import org.openqa.selenium.By;

import org.openqa.selenium.*;

import com.iheart.vertical.abstractLayer.WaitUtility;

public class IOSPlayer extends Player {
	
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

}
