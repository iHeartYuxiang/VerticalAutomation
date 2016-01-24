package com.iheart.vertical.android;


import com.iheart.vertical.abstractLayer.*;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.*;

public class AndroidLogin  extends Login{

	//Set location
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
	   public AndroidElement android_zip;
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")
	   public AndroidElement android_setLocation;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
	   public AndroidElement android_skip;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[1]")
      public AndroidElement android_ok;
	
	//Login 
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.ImageView[1]

    @AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]")
	   public AndroidElement android_loginButton;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
	   public AndroidElement android_userName;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[2]")
	   public AndroidElement android_password;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
	   public AndroidElement android_login;
	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	   private AndroidElement lable;
	
	public AndroidLogin(WebDriver driver)
	{
		super(driver);
	}
	
	public void locateElements()
	{
		loginButton = this.android_loginButton;
		userName = this.android_userName;
		password = this.android_password;
		
		login = this.android_login;
	}
	
    public void setLocation()
    {   
        System.out.println("Label:" + lable.getText());
    	//android_zip.sendKeys("10001");
    	//android_setLocation.click();
        android_skip.click();
        android_ok.click();
        WaitUtility.sleep(5000);
        
        
    }
	
}
