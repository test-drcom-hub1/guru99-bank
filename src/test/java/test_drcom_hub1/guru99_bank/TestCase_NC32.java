package test_drcom_hub1.guru99_bank;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestCase_NC32 {
  WebDriver driver;
  Logger log;
  LoginPage objLoginPage;
  HomePage objHomePage;
  LeftMenu objLeftMenu;
  NewCustomerPage objNewCustomerPage;
  String actualBoxMsg;
	
  @BeforeTest
  public void openWebsite() throws Exception {
	  // set logger
	  log = Logger.getLogger("devpinoyLogger");
	  
	  // set driver
	  System.setProperty(Util.CHROME_DRIVER_CORE, Util.CHROME_DRIVER_PATH);
	  driver = new ChromeDriver();
	  log.debug("open Website");
	  driver.get(Util.baseURL);

	  // waiting time for loading page
	  driver.manage().timeouts().implicitlyWait(Util.timeOut, TimeUnit.SECONDS);
  }
  /*
   * Testcase #32: Check customer is not added twice
   * Step description:
   * 1) Go to site
   * 2) Click on link "New Customer"
   * 3) Enter all valid information of testcase #31
   * 4) Click Submit
   * Test data:
   * Dang Quang Minh
   * male
   * 01291986
   * 189 Q11
   * Ho Chi Minh
   * QTB
   * 111111
   * 0909
   * dangquangminh.vn@gmail.com
   * 123456
   */
  @Test
  public void checkCustomerIsNotAddedTwice() throws Exception {
	  
	  // login website
	  log.debug("login website");
	  objLoginPage = new LoginPage(driver);
	  // verify title of Login page
	  log.debug("verify title of Login page");
	  assertEquals(objLoginPage.expMsgTitlePage, driver.getTitle());
	  
	  objLoginPage.enterUserId(Util.adminId);
	  objLoginPage.enterPassword(Util.adminPassword);
	  objLoginPage.clickLoginButton();
	  Thread.sleep(2000);
	  
	  // verify title of manager homepage
	  log.debug("verify title of manager homepage");
	  objHomePage = new HomePage(driver);
	  assertEquals(objHomePage.expMsgManagerTitlePage, driver.getTitle());
	   
	  // click on link New Customer
	  log.debug("click on link New Customer");
	  objNewCustomerPage = new NewCustomerPage(driver);
	  objLeftMenu = new LeftMenu(driver);
	  objLeftMenu.clickNewCustomerLink();
	  
	  // verify title of New Customer page
	  log.debug("verify title of New Customer page");
	  try {
		  assertEquals(objNewCustomerPage.expMsgTitlePage, driver.getTitle());  
	  } catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
	  // enter valid information for New Customer
	  log.debug("enter valid information for New Customer");
	  objNewCustomerPage.enterCustomerName("Dang Quang Minh B");
	  objNewCustomerPage.selectMale();
	  objNewCustomerPage.enterDoB("01291986");
	  objNewCustomerPage.enterAddress("189 Q11");
	  objNewCustomerPage.enterCity("Ho Chi Minh");
	  objNewCustomerPage.enterState("QTB");
	  objNewCustomerPage.enterPIN("111111");
	  objNewCustomerPage.enterPhone("0909");
	  objNewCustomerPage.enterEmail("dangquangminhc.vn@gmail.com");
	  objNewCustomerPage.enterPassword("123456");
	  Thread.sleep(3000);
	  
	  // click on submit button
	  log.debug("click on submit button");
	  objNewCustomerPage.clickSubmitButton();
	  Thread.sleep(3000);
	  
	  // verify message text when registering customer successful!!!
	  log.debug("verify message text when registering customer successful!!!");
	  try {
		  assertEquals(objNewCustomerPage.expMsgCreatedNewCustomer, objNewCustomerPage.getCustomerRegisteredMessage());  
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  
	  Alert alt = driver.switchTo().alert();
	  actualBoxMsg = alt.getText();
	  
	  Thread.sleep(2000);
	  alt.accept();
	  Thread.sleep(2000);
	  // verify display message box if customer is added twice
	  log.debug("verify display message box if customer is added twice");
	  try {
		  assertEquals(objNewCustomerPage.expMsgDuplicatedEmail, actualBoxMsg);
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
  
  @AfterTest
  public void closeWebsite() throws Exception {
	  Thread.sleep(3000);
	  driver.close();  
  }
}
