package test_drcom_hub1.guru99_bank;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {
	// set Chrome browser driver
	public static String dirPath = System.getProperty("user.dir");
	public static final String CHROME_DRIVER_CORE = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = dirPath + "\\src\\main\\chromedriver.exe";
	
	// set base URL
	public static String baseURL = "http://demo.guru99.com/V1/";
	public static String adminId ="mngr98195";
	public static String adminPassword = "gygUtUt";
	
	// set wait time
	public static int timeOut = 20;
	
	// take screenshot
	public static void takeScreenShot(WebDriver driver, String screenShotFileName) {
		String scrFilePath = dirPath + "\\src\\test\\screenshot\\";
		//take screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// save screenshot to desired location
		try {
			FileUtils.copyFile(scrFile, new File(scrFilePath + screenShotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
