package test_drcom_hub1.guru99_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenu {
	WebDriver driver;
	
	// declaring variables/objects of LEFT MENU
	By lnkNewCustomer = By.xpath("//li//a[text()='New Customer']");
	
	// initializing contructor
	public LeftMenu(WebDriver driver) {
		driver = this.driver;
	}
	
	// method click on link "New Customer"
	public void clickNewCustomerLink() {
		driver.findElement(lnkNewCustomer).click();
	}
}
