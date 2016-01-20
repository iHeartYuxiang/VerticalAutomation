package com.iheart.vertical.web;

import com.iheart.vertical.abstractLayer.*;
	


public class WebNavigation extends Page implements Navigation{

	
	
	public static void gotoPage(String pageType)
	{
		String newURL = urlTo(pageType);
		
		driver.get(newURL);
		WaitUtility.sleep(2000);
	}
	
	private static String urlTo(String pageType)
	{   String newURL= "";
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("SEE current url:"  + currentURL);
		
		
	    String part1 = currentURL.split("//")[0];
	    String part2  = currentURL.split("//")[1].split("/")[0];
	    switch (pageType) {
        case "liveRadio":
        	newURL = part1 + "//" + part2 + "/live/country/US/" ;
            break;
        case "artistRadio":
        	newURL = part1 + "//" + part2 + "/artist/" ;
        	break;
        case "perfectFor":
        	newURL = part1 + "//" + part2 + "/perfect-for/" ;
        	break;
        case "podcasts":
        	newURL = part1 + "//" + part2 + "/show/" ;
            break;
        case "profilePage":
        	newURL = part1 + "//" + part2 +"/my/" ;
            break;
        case "genresPage":
        	newURL = part1 + "//" + part2 + "/genre/" ;
            break;    
        default:
        	newURL = currentURL;
            throw new IllegalArgumentException("Invalid Page Type: " + pageType);
    }
	    
		System.out.println("SEE new url:"  + newURL );
		
		return  newURL;
		
	}
	
	
}
