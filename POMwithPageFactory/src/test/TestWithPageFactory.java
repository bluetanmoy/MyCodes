package test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.HomePage;
import pageFactory.LoginPage;

public class TestWithPageFactory {

	
	WebDriver driver;
	
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void testHomePageAppearCorrect(){
		
		LoginPage objLoginPage = new LoginPage(driver);
		HomePage objHomePage = new HomePage(driver);
		
		String loginPageTitle = objLoginPage.getLoginTitle();
		System.out.println(loginPageTitle);
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		objLoginPage.loginToDemoSite("mngr35977", "epArUbU");
		String managerID = objHomePage.getHomePageDashBoardUserName();
		System.out.println(managerID);
		Assert.assertTrue(objHomePage.getHomePageDashBoardUserName().toLowerCase().contains("manger id : mngr35977"));
		
	}
}
