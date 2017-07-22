package TestNGProject.TestNGProject.testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNGProject.TestNGProject.commonLib.BaseTest;
import TestNGProject.TestNGProject.utility.ConstatVariables;
import TestNGProject.TestNGProject.webPages.LoginPage;


public class LoginTest 
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

	@Test(description="validating login with valid login")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		String res=loginpage.validLogin(ConstatVariables.username, ConstatVariables.password, ConstatVariables.title);
		Assert.assertEquals(res, ConstatVariables.title,"fail to login");
	}

	@Test(description="validating login with In valid login")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		String res=loginpage.inValidLogin(ConstatVariables.usernameInvalid, ConstatVariables.password);
		Assert.assertTrue(res.contains("Please try again"),"failed due to error");
	}

	@Test(description="validat login page fleids visible")
	public void test3()
	{
		LoginPage loginpage = new LoginPage(driver);
		boolean a=loginpage.checkbox();
		soft.assertTrue(a,"failed to display checkbox");
		boolean b=loginpage.checkloginbutton();
		soft.assertTrue(b,"failed to display login ");
		boolean c=loginpage.checkpassword();
		soft.assertTrue(c,"failed to display password");
		boolean d=loginpage.checkusername();
		soft.assertTrue(d,"failed to display usename");
		soft.assertAll();
	}
	
	@Test(description="validat login page fleids visible")
	public void test4()
	{
		LoginPage loginpage = new LoginPage(driver);
		boolean a=loginpage.checkbox();
		soft.assertTrue(a,"failed to display checkbox");
		boolean b=loginpage.checkloginbutton();
		soft.assertTrue(b,"failed to display login ");
		boolean c=loginpage.checkpassword();
		soft.assertTrue(c,"failed to display password");
		boolean d=loginpage.checkusername();
		soft.assertTrue(d,"failed to display usename");
		soft.assertAll();
	}
	
	//sdfdsfdsf




}
