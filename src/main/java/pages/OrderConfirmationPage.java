package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends AbstractComponents{

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "h2[class='complete-header']")
	WebElement confirmText;
	
	@FindBy(name = "back-to-products")
	WebElement back;
	
	public String getConfirmText() {
		String cnfmText = confirmText.getText();
		System.out.println(cnfmText);
		return cnfmText;
	}
	
	public ProductPage backHome() {
		back.click();
		return new ProductPage(driver);
	}
}
