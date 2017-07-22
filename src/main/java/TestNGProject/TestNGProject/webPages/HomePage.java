package TestNGProject.TestNGProject.webPages;



import org.openqa.selenium.WebDriver;

import TestNGProject.TestNGProject.commonLib.ReuseableMethods;
import TestNGProject.TestNGProject.locatorRepository.LocatorRepository;


public class HomePage 
{
	public WebDriver driver;
	ReuseableMethods reuse;
	LocatorRepository obj;
	public HomePage(WebDriver driver)
	{
		reuse = new ReuseableMethods(driver);
		this.driver=driver;
		obj= new LocatorRepository();
	}
	
	public void timeTrackTab()
	{
		reuse.explicitywait1(obj.timetrackmenu);
		if(!reuse.getpageTitle().contains("Enter"))
		{
			reuse.clickOnElement(obj.timetrackmenu);
		}
	}

	public void taskTab()
	{
		reuse.explicitywait1(obj.taskmenu);
		if(!reuse.getpageTitle().contains("Open"))
		{
			reuse.clickOnElement(obj.taskmenu);
		}
	}
	
	public void reportTab()
	{
		if(!reuse.getpageTitle().contains("Reports"))
		{
			reuse.clickOnElement(obj.reportmenu);
		}
	}
	
	public void userTab()
	{
		if(!reuse.getpageTitle().contains("User"))
		{
			reuse.clickOnElement(obj.usermenu);
		}
	}
	
	public void logout()
	{
		if(!reuse.getpageTitle().contains("Login"))
		{
			reuse.clickOnElement(obj.loggoutlink);
		}
	}


}
