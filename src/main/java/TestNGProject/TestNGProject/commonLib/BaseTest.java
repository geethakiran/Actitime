package TestNGProject.TestNGProject.commonLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest 
{
	public WebDriver driver;
	public WebDriver selectBrowser(String browsername)
	{
		browsername=browsername.toLowerCase();
		switch(browsername)
		{
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", "Browser_Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome" : 
			System.setProperty("webdriver.chrome.driver", "Browser_Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "ie" : 
			System.setProperty("webdriver.ie.driver", "Browser_Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default :System.out.println("invalid type");
		System.exit(0); break;
		}
		return driver;
	}
}
