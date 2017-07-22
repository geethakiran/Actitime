

package TestNGProject.TestNGProject.commonLib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseableMethods 
{
	public WebDriver driver;
	WebDriverWait wait;
	
	public ReuseableMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(By elementpath)
	{
		driver.findElement(elementpath).click();
	}
	
	public void TypeData(By elementpath, String text)

	{
		driver.findElement(elementpath).sendKeys(text);		
	}

	public String getTextFromField(By elementpath)
	{
		return driver.findElement(elementpath).getText();	
	}

	public String getpageTitle()
	{
		return driver.getTitle();
	}

	public boolean checkisSelected(By elementpath)
	{
		return driver.findElement(elementpath).isSelected();
	}

	
	public boolean checkisEnabled(By elementpath)
	{
		return driver.findElement(elementpath).isEnabled();
	}

	public boolean checkisDisplayed(By elementpath)
	{
		return driver.findElement(elementpath).isDisplayed();
	}

	public void explicitywait1(By elementpath)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementpath));
	}

	
	public void explicitywait(String Title)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(Title));
	}
	
	public void explicitywait3(By elementpath)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elementpath));
	}
	
	public void explicitywait(By elementpath, String text)
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBe(elementpath, text));
	}

	public void keysinputESC(By elementpath)
	{
		driver.findElement(elementpath).sendKeys(Keys.ESCAPE);
	}

	public void keysinputESCAction()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}


	public void keysinputTAB(By elementpath)
	{
	
		driver.findElement(elementpath).sendKeys(Keys.TAB);
	}
	
	
	public void screen(WebDriver driver)
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path="screenshot";
		
		DateFormat dateFormat = new SimpleDateFormat("dd-yyyy-mm_hh-mm-ss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String timestampFolderName =dateFormat.format(date);        
		String currentsessionFolder =path +"\\"+ timestampFolderName +"\\"+timestamp+".png";
		File SnapFloder = new File(currentsessionFolder);          
		try {
			FileUtils.copyFileToDirectory(scrFile, SnapFloder);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
