package TestNGProject.TestNGProject.webPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeTrack extends HomePage
{
	public TimeTrack(WebDriver driver) 
	{
		super(driver);		
	}

	public void selectItemFromDropdown(String expUser)
	{
		reuse.explicitywait1(obj.dropdownlink);
		int count=0;
		while(count<4)
		{
			try
			{
				reuse.clickOnElement(obj.dropdownlink);
				List<WebElement> list1 =driver.findElements(obj.dropdownitems);
				for (WebElement var : list1) 
				{
					System.out.println(var.getText());
					if(var.getText().equals(expUser))	
					{
						var.click(); break;
					}
				}count=count+4; break;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
		reuse.explicitywait(obj.dropdownlink, expUser);
	}

	public void calender(String month, String date) 
	{		
		int count=0;
		while(count<4)
		{
			try
			{
				Thread.sleep(5000);
				int i=0;
				reuse.clickOnElement(obj.calenderLink);
				for(i=0; i<3;i++)
				{
					String monthlble=reuse.getTextFromField(obj.monthlabel);
					System.out.println(monthlble);
					if(!monthlble.contains(month))
					{
						reuse.clickOnElement(obj.forwardbtn);
					}
					else {break;}
					count=count+4;
				}
				if(i>=3)
				{
					for(int j=0; j<6;j++)
					{
						String monthlble=reuse.getTextFromField(obj.monthlabel);
						if(!monthlble.contains(month))
						{
							reuse.clickOnElement(obj.previousbtn);					
						}
						else {break;}
						count=count+4;
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
		selectdate(date);
	}

	private void selectdate(String date)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int count=0;
		while(count<4)
		{
			try
			{
				WebElement tble=driver.findElement(obj.calenderTable);
				List<WebElement>row=tble.findElements(By.tagName("tr"));
				for(int i=0; i<row.size();i++)
				{
					List<WebElement>column=row.get(i).findElements(By.tagName("td"));
					for(int j=0; j<column.size();j++)
					{
						String actdate=column.get(j).getText();
						if(actdate.equals(date))
						{
							column.get(j).click(); count=count+4; 
							break;							
						}
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}

	public void selectTask(String taskname, String hrs)
	{
		int count=0;
		while(count<4)
		{
			try
			{
				Thread.sleep(5000);
				reuse.clickOnElement(obj.addrecentTask);
				Thread.sleep(5000);
				List<WebElement> list1 = driver.findElements(obj.recenttaskitems);
				for(WebElement var : list1) 
				{
					if(var.getText().equals(taskname))
					{
						var.click(); count =count+4;
						break;
					}
				}reuse.keysinputESCAction();
				count=count+4;
				typeHrdata(taskname,hrs);
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}


	private void typeHrdata(String taskname, String hrs)
	{
		By hrfield=By.xpath("//span[text()='"+taskname+"']/following::input[@class='text inputTT']");
		int count=0;
		while(count<4)
		{
			try
			{
				List<WebElement> list2 = driver.findElements(hrfield);

				for(int i=0; i<5; i++)
				{
					list2.get(i).clear();
					list2.get(i).sendKeys(hrs);
				}
				count=count+4;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}

	public String submitbtn()
	{
		reuse.clickOnElement(obj.savebtn);
		reuse.explicitywait1(obj.msg);
		return reuse.getTextFromField(obj.msg);
	}
}
