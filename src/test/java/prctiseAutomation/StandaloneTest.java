package prctiseAutomation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.component.BaseTest;
import pageObject.model.OrderConfirmation;
import pageObject.model.ProductCheckOut;
import pageObject.model.ProductInCart;

public class StandaloneTest extends BaseTest {
	ProductCheckOut chkout1;
	ProductInCart crtitem1;
	OrderConfirmation orderconfirm1;
	WebElement expectedProduct;

	@Test(dataProvider = "getData",priority=2)
	public void productPurchaseError(HashMap<String, String> input) {

		String productName = "ADIDAS ORIGINAL222";
		crtitem1 = log.login(input.get("mail"), input.get("password"));

		crtitem1.productAdd();
		crtitem1.waitForProduct();
		chkout1 = crtitem1.clickOnTheCart();

		chkout1.checkOut();
		chkout1.countryselection();
		chkout1.scroll();
		orderconfirm1 = chkout1.orderPlace();

		expectedProduct = orderconfirm1.productVerification();

		String x = expectedProduct.getText();
		Assert.assertEquals(productName, x);
		orderconfirm1.orderConfirmation();

	}
	@Test(dataProvider="getData",priority=1)
	public void productPurchase(HashMap<String, String> input) {
		String productName1 = "ADIDAS ORIGINAL";
		crtitem1 = log.login(input.get("mail"), input.get("password"));

		crtitem1.productAdd();
		crtitem1.waitForProduct();
		chkout1 = crtitem1.clickOnTheCart();

		chkout1.checkOut();
		chkout1.countryselection();
		chkout1.scroll();
		orderconfirm1 = chkout1.orderPlace();

		expectedProduct = orderconfirm1.productVerification();

		String x = expectedProduct.getText();
		x.equalsIgnoreCase(productName1);
		orderconfirm1.orderConfirmation();

		
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = dataReader(
				System.getProperty("user.dir") + "\\src\\test\\java\\purchasedata\\purchasedata.json");

		return new Object[][] { { data.get(0) } };
	}
}
