package TestNGProject.TestNGProject.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import TestNGProject.TestNGProject.commonLib.ReuseableMethods;
import TestNGProject.TestNGProject.locatorRepository.LocatorRepository;


public class LoginPage 
{
	public WebDriver driver;
	ReuseableMethods reuse;
	LocatorRepository obj;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		reuse= new ReuseableMethods(driver);
		//obj=PageFactory.initElements(driver, LocatorRepository.class);
		obj = new LocatorRepository();
	}

	private boolean validateLaunch()
	{
		return reuse.checkisDisplayed(obj.headerfield);
	}

	private void setUsername(String username)
	{
		reuse.TypeData(obj.usernamefield, username);
	}
	private void setPassword(String pwd)
	{
		reuse.TypeData(obj.passwordfield, pwd);
	}
	private void clickcheckbox()
	{
		if(!reuse.checkisSelected(obj.checkboxfield))
		{
			reuse.clickOnElement(obj.checkboxfield);
		}
	}

	private void clickLogin()
	{
		reuse.clickOnElement(obj.loginbttn);		
	}

	public String validLogin(String username, String password, String Title)
	{
		if(validateLaunch())
		{
			setUsername(username);
			setPassword(password);
			clickcheckbox();
			clickLogin();			
			reuse.explicitywait(Title);
		}
		else {System.out.println("fail to load application");}
		return reuse.getpageTitle();
	}


	public String inValidLogin(String username, String password)
	{
		if(validateLaunch())
		{
			setUsername(username);
			setPassword(password);
			clickcheckbox();
			clickLogin();			
			reuse.explicitywait3(obj.errormsg);
		}
		else {System.out.println("fail to load application");}
		return reuse.getTextFromField(obj.errormsg);
	}
	
	
	public boolean checkloginbutton()
	{
		return reuse.checkisDisplayed(obj.loginbttn);
	}
	
	public boolean checkusername()
	{
		return reuse.checkisDisplayed(obj.usernamefield);
	}
	
	public boolean checkpassword()
	{
		return reuse.checkisDisplayed(obj.passwordfield);
	}
	public boolean checkbox()
	{
		return reuse.checkisDisplayed(obj.checkboxfield);
	}
	
	
	
}
