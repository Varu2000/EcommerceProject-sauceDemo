package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='user-name']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginbtn;
	
	public ProductPage login(String Name, String Pass) {
		userName.sendKeys(Name);
		password.sendKeys(Pass);
		loginbtn.click();
		return new ProductPage(driver);
	}
}
