package com.iheart.vertical.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.iheart.vertical.abstractLayer.*;

public class IOSNavigation extends Page implements Navigation {
	
	
	//*******  Side Navigation Bar *******
		
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")
	        public  IOSElement navIcon;
		@iOSFindBy(name="Now Playing")
	       public  IOSElement playingIcon;

		@iOSFindBy(name="iheartradio_logo_full")
	       public IOSElement iheartradio_logo_full;
		
		@iOSFindBy(name="Home") public IOSElement home;
		@iOSFindBy(name="My Stations") public IOSElement myStations;
		@iOSFindBy(name="Live Radio") public IOSElement liveRadio;
		@iOSFindBy(name="Artist Radio") public IOSElement artistRadio;
		@iOSFindBy(name="Podcasts") public IOSElement podcasts;
		@iOSFindBy(name="Perfect For") public IOSElement perfectFor;
		@iOSFindBy(name="Listening History") public IOSElement listeningHistory;
	
		//@iOSFindBy(name="Alarm Clock") public IOSElement alarm;
		@iOSFindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]")
				public IOSElement alarm;
		//@iOSFindBy(name="Sleep Timer") public IOSElement sleep;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIAStaticText[1]")
				public IOSElement sleep;
		@iOSFindBy(name="Songs") public IOSElement songs;
		//@iOSFindBy(name="Settings") public IOSElement settings;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]/UIAStaticText[1]") 
				public IOSElement settings;
	   
		//****** End of Side Nav page ******
		
		
		//Fields in Settings page
		@iOSFindBy(name="Logged In As") private IOSElement loggedInAs;
		@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")
		   private IOSElement logout;
		
		public IOSNavigation(IOSDriver _driver)
		{
			super(_driver);
		}
		
		//Put header and player related methods here
		public  void gotoHomePage()
		{
			navIcon.click();
			home.click();
		}
		
	public  void gotoPage(String pageName)
	{
		 switch (pageName) {
	        case "liveRadio":
	        	navIcon.click();
				liveRadio.click();
	            break;
	        case "artistRadio":
	        	navIcon.click();
				artistRadio.click();
	        	break;
	        case "perfectFor":
	        	navIcon.click();
				perfectFor.click();
	        	break;
	        case "podcasts":
	        	navIcon.click();
				podcasts.click();
	            break;
	        case "home":
	        	navIcon.click();
				home.click();
	            break;
	        default:
	        	navIcon.click();
				home.click();
	            throw new IllegalArgumentException("Page doesn't exist: " + pageName);
	    }
	}
	
    public void locateElements()
    {
    	
    }
	
}
