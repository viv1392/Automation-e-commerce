package purchase.Stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.model.LandingPage;
import pageObject.model.OrderConfirmation;
import pageObject.model.ProductCheckOut;
import pageObject.model.ProductInCart;
import prctiseAutomation.StandaloneTest;

public class PurchaseOrder extends StandaloneTest{
    LandingPage log;
	ProductCheckOut chkout1;
	ProductInCart crtitem1;
	OrderConfirmation orderconfirm1;
	WebElement expectedProduct;
	String productName = "ADIDAS ORIGINAL";
	
	@Given("I landed on the e commerce website")
	public void i_landed_website() throws IOException {
		 log =WebLanding();
		
		
	}


	@Given("^I logged in with (.+) and (.+)$")
	public void I_logged_in(String name, String password) {
		crtitem1 = log.login(name ,password);
	}
	@When("I added product in the cart$")
	public void I_added_product_in_the_cart() {
		crtitem1.productAdd();
		crtitem1.waitForProduct();
		chkout1 = crtitem1.clickOnTheCart();

		chkout1.checkOut();
		chkout1.countryselection();
		chkout1.scroll();
		orderconfirm1 = chkout1.orderPlace();
		
	}
@Then("I verify the product")
	public void I_verify_product() {
	expectedProduct = orderconfirm1.productVerification();

	String x = expectedProduct.getText();
    x.equalsIgnoreCase(productName);
	orderconfirm1.orderConfirmation();
}
}
