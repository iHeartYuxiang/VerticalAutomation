package com.iheart.vertical.android;

import com.iheart.vertical.abstractLayer.*;

public class AndroidNavigation extends Page implements Navigation {

	
	
	
	
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
