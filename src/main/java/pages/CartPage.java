package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[.='Checkout']")
	WebElement checkout;

	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement contiueShop;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> productsList;

	public Checkout_InfoPage gotoCheckout() {
		checkout.click();
		return new Checkout_InfoPage(driver);
	}

	public ProductPage continueShopping() {
		contiueShop.click();
		return new ProductPage(driver);
	}
	public List<String> prodConfirm() {
		List<String> collect = productsList.stream().map(x->x.getText()).collect(Collectors.toList());
		System.out.println(collect);
		return collect;
	}
}