package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//********************************** WebElements ***************************
	@FindBy(xpath = "//td[@style='color: green']")
	WebElement homePageUserName;
	//***************************************************************************
	//****************************** init ***************************************
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//***************************************************************************
	//********************************** METHOD *********************************	
	public String getHomePageDashBoardUserName() {
		return homePageUserName.getText();
	}
}
