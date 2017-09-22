package test_drcom_hub1.guru99_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
	WebDriver driver;
	
	// declaring variables/objects of textbox
	By txtCustomerName = By.xpath("//input[@name='name']");
	By txtDoB = By.xpath("//input[@name='dob']");
	By txtAddress = By.xpath("//textarea[@name='addr']");
	By txtCity = By.xpath("//input[@name='city']");
	By txtState = By.xpath("//input[@name='state']");
	By txtPin = By.xpath("//input[@name='pinno']");
	By txtPhone = By.xpath("//input[@name='telephoneno']");
	By txtEmail = By.xpath("//input[@name='emailid']");
	
	// declaring variables/objects of radiobutton
	By rbtMale = By.xpath("//input[@name='rad1']//parent::td/input[1]");
	By rbtFemale = By.xpath("//input[@name='rad1']//parent::td/input[2]");
	
	// declaring variables/objects of buttons
	By btnSubmit = By.xpath("//input[@type='submit']");
	By btnReset = By.xpath("//input[@type='reset']");
	
	// declaring variables/objects of messages
	By lblCustomerRegistered = By.xpath("//tbody//p[@class='heading3']");
	
	
	// initializing constructor
	public NewCustomerPage(WebDriver driver) {
		driver = this.driver;
	}
	
	// method enter value into Customer Name field
	public void enterCustomerName(String customerName) {
		driver.findElement(txtCustomerName).clear();
		driver.findElement(txtCustomerName).sendKeys(customerName);
	}
	
	// method select radiobutton Male
	public void selectMale() {
		driver.findElement(rbtMale).click();
	}
	
	// method select radiobutton Female
	public void selectFemale() {
		driver.findElement(rbtFemale).click();
	}
	
	// method enter value into DoB field
	public void enterDoB(String dateOfBirth) {
		driver.findElement(txtDoB).clear();
		driver.findElement(txtDoB).sendKeys(dateOfBirth);
	}
	
	// method enter value into Address field
	public void enterAddress(String address) {
		driver.findElement(txtAddress).clear();
		driver.findElement(txtAddress).sendKeys(address);
	}
	
	// method enter value into City field
	public void enterCity(String city) {
		driver.findElement(txtCity).clear();
		driver.findElement(txtCity).sendKeys(city);
	}
	
	// method enter value into State field
	public void enterState(String state) {
		driver.findElement(txtState).clear();
		driver.findElement(txtState).sendKeys(state);
	}
	
	// method enter value into PIN field
	public void enterPIN(String pin) {
		driver.findElement(txtPin).clear();
		driver.findElement(txtPin).sendKeys(pin);
	}
	
	// method enter value into Telephone field
	public void enterPhone(String phone) {
		driver.findElement(txtPhone).clear();
		driver.findElement(txtPhone).sendKeys(phone);
	}
	
	// method enter value into Email field
	public void enterEmail(String email) {
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	// method click on button Submit
	public void clickSubmitButton() {
		driver.findElement(btnSubmit).click();
	}
	
	// method click on button Reset
	public void clickResetButton() {
		driver.findElement(btnReset).click();
	}
	
	// method get message when creating new customer successful
	public String getCustomerRegisteredMessage() {
		return driver.findElement(lblCustomerRegistered).getText();
	}
}
