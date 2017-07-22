package TestNGProject.TestNGProject.testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNGProject.TestNGProject.commonLib.BaseTest;
import TestNGProject.TestNGProject.utility.ConstatVariables;
import TestNGProject.TestNGProject.webPages.HomePage;
import TestNGProject.TestNGProject.webPages.LoginPage;
import TestNGProject.TestNGProject.webPages.TimeTrack;



public class TimeTrackTest 
{
	public WebDriver driver;
	SoftAssert soft;
	@BeforeMethod
	public void setUp()
	{
		BaseTest basetest= new BaseTest();
		driver=basetest.selectBrowser(ConstatVariables.browser);
		driver.get(ConstatVariables.baseurl);
		driver.manage().window().maximize();
		soft= new SoftAssert();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test(description="create new task")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstatVariables.username, ConstatVariables.password, ConstatVariables.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstatVariables.taskusername);
		timetrack.calender(ConstatVariables.expMonth, ConstatVariables.expdate);
		timetrack.selectTask(ConstatVariables.taskname1, ConstatVariables.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstatVariables.username, ConstatVariables.password, ConstatVariables.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstatVariables.taskusername);
		timetrack.calender(ConstatVariables.expMonth, ConstatVariables.expdate);
		timetrack.selectTask(ConstatVariables.taskname2, ConstatVariables.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test3()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstatVariables.username, ConstatVariables.password, ConstatVariables.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstatVariables.taskusername);
		timetrack.calender(ConstatVariables.expMonth, ConstatVariables.expdate);
		timetrack.selectTask(ConstatVariables.taskname3, ConstatVariables.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test4()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstatVariables.username, ConstatVariables.password, ConstatVariables.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstatVariables.taskusername1);
		timetrack.calender(ConstatVariables.expMonth, ConstatVariables.expdate);
		timetrack.selectTask(ConstatVariables.taskname2, ConstatVariables.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
}
