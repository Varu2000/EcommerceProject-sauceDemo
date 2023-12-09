package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponents {

	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a//div[@class='inventory_item_name ']")
	List<WebElement> products;

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	WebElement addToCart;
	
	@FindBy(xpath = "//button[@data-test='back-to-products']")
	WebElement backToProd;


	public void addProduct(List<String> proName) {
		for (int i = 0; i < products.size(); i++) {
			String pro = products.get(i).getText();
			if (proName.contains(pro)) {
				products.get(i).click();
				addToCart.click();
				backToProd.click();
			}
		}
	}

	public CartPage goToCart() {
		cartPage();
		return new CartPage(driver);
	}
}
