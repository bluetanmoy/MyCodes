package pageFactory;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//********************************** WebElements ***************************
	@FindBy(xpath="//h2[@class='barone']")
	WebElement titleText;
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement login;
	//***************************************************************************
	//************************************init***********************************
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//****************************************************************************
	//************************************ methods *******************************
	public void setUserID(String strUserID){
		userID.sendKeys(strUserID);
	}
	
	public void setPassword(String strPassWord){
		password.sendKeys(strPassWord);
	}
	
	public void clickLogin() {
		login.click();	
	}
	
	public String getLoginTitle(){
		return titleText.getText();
	}
	//*****************************************************************************
	//************************************ METHOD *********************************
	public void loginToDemoSite(String strUserID, String strPassWord) {
		this.setUserID(strUserID);
		this.setPassword(strPassWord);
		this.clickLogin();
	}
}
