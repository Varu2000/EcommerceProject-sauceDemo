package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.ReadDataFromExcel;

public class BasePage {

	public WebDriver driver;

	public String fileName = "";

	@DataProvider(name = "Logindata") 
	public String[][] dataProvider() throws IOException {
		String[][] exceldata = ReadDataFromExcel.getExceldata(fileName);
		return exceldata;
		
		
	}
	@BeforeMethod()
	public LoginPage setUp() {

		launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getUrl("https://www.saucedemo.com/");
		return new LoginPage(driver);
	}

	public WebDriver launchBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}

		return driver;
	}

	public void getUrl(String url) {
		driver.get(url);
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  "..//reports//" + testcaseName + ".png";
	}

	public void close() {
		driver.close();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}



