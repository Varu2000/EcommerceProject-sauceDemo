package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_OverviewPage extends AbstractComponents {

	
	public Checkout_OverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Finish']")
	WebElement finish;
	

	@FindBy(xpath = "//button[@id='cancel']")
	WebElement cancel;
	
	public OrderConfirmationPage finishOrder() {
		finish.click();
		return new OrderConfirmationPage(driver);
	}
	
	public void cancelOrder() {
		cancel.click();
	}
}

