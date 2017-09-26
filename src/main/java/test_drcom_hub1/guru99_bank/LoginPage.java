package test_drcom_hub1.guru99_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	// declaring expected message
	String expMsgTitlePage = "Guru99 Bank Home Page";
	
	// declaring variables/objects of textboxs
	By txtUserId = By.xpath("//input[@name='uid']");
	By txtPassword = By.xpath("//input[@name='password']");
	
	// declaring variables/objects of buttons
	By btnLogin = By.xpath("//input[@name='btnLogin']");
	By btnReset = By.xpath("//input='btnReset'");
	
	// initializing contructor
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	// method enter value into UserId field
	public void enterUserId (String userId) {
		driver.findElement(txtUserId).clear();
		driver.findElement(txtUserId).sendKeys(userId);
	}
	
	// method enter value into UserId field
	public void enterPassword (String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	// method click on button LOGIN
	public void clickLoginButton () {
		driver.findElement(btnLogin).click();
	}
	
	// method click on button RESET
	public void clickResetButton() {
		driver.findElement(btnReset).click();
	}
}
