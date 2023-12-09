package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pages.CartPage;
import pages.Checkout_InfoPage;
import pages.Checkout_OverviewPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductPage;

public class Test_001 extends BasePage {

	String[] names = { "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie",
			"Test.allTheThings() T-Shirt (Red)" };
	List<String> proName = Arrays.asList(names);

	@BeforeTest
	public void setData() {
		fileName = "SauceDemo_Data";
	}

	@Test(dataProvider = "Logindata")
	public void purchase(String[] data) throws InterruptedException {

		LoginPage lgn = new LoginPage(driver);
		ProductPage prod = lgn.login(data[0], data[1]);
		prod.addProduct(proName);
		Thread.sleep(1000);
		CartPage cart = prod.goToCart();
		Thread.sleep(1000);
		List<String> prodConfirm = cart.prodConfirm();

		Assert.assertEquals(prodConfirm, proName);
		Checkout_InfoPage checkout_Info = cart.gotoCheckout();
		checkout_Info.checkoutInfo(data[2], data[3], data[4]);
		Checkout_OverviewPage checkout_Overview = checkout_Info.continueOrder();
		OrderConfirmationPage orderConfirmation = checkout_Overview.finishOrder();
		String text = orderConfirmation.getConfirmText();
		Assert.assertEquals(text, "Thank you for your order!");
	}
}
