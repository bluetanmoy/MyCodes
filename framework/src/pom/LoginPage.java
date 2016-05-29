package pom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class LoginPage {

	WebDriver driver;
	
	//########################## ELEMENTS #####################################
	@FindBy(xpath="//input[@name='uid']")
	WebElement UserID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement LOGIN;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement RESET;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement Title;
	//########################### INIT #########################################
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//########################## METHODS #######################################
	public void UserID_SET_TEXT(String username){
		UserID.sendKeys(username);
	}

	public void Password_SET_TEXT(String userpassword) {
		Password.sendKeys(userpassword);
	}
	
	public void LOGIN_CLICK(){
		LOGIN.click();
	}
	
	public void RESET_CLICK(){
		RESET.click();
	}
	
	public String GET_TITLE(){
		return Title.getText();
	}
	
	public void USER_ID_EMPTY_CHECK(){
		Assert.assertTrue(UserID.equals(null));
	}

	public void USER_PASSWORD_EMPTY_CHECK(){
		Assert.assertTrue(Password.equals(null));
	}
	//###########################################################################
}
