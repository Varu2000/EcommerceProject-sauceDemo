package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_InfoPage extends AbstractComponents{

	public Checkout_InfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name  = "firstName")
	WebElement frstName;
	
	@FindBy(id= "last-name")
	WebElement lstName;
	
	@FindBy(name  = "postalCode")
	WebElement zipCode;
	
	@FindBy(xpath  = "//input[@name='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath  = "//button[@id='cancel']")
	WebElement cancelBtn;
	
	
	public void checkoutInfo(String FName, String LName, String postalCode) {
		frstName.sendKeys(FName);
		lstName.sendKeys(LName);
		zipCode.sendKeys(postalCode);
	}
	
	public Checkout_OverviewPage continueOrder() {
		continueBtn.click();
		return new Checkout_OverviewPage(driver);
	}
	
	public void cancel() {
		cancelBtn.click();
	}
}
