package purchase.Stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.model.LandingPage;
import pageObject.model.OrderConfirmation;
import pageObject.model.ProductCheckOut;
import pageObject.model.ProductInCart;
import prctiseAutomation.StandaloneTest;

public class ProductVerification extends StandaloneTest{
	
	LandingPage log;
	ProductCheckOut chkout1;
	ProductInCart crtitem1;
	OrderConfirmation orderconfirm1;
	WebElement expectedProduct;
	String productName = "ADIDAS ORIGINAL222";
	 
	@Given("I land on the e commercr website")
	public void I_land_website () throws IOException{
		log=WebLanding();
	}
	@Given("^I log in with (.+) and (.+)$")
	public void i_logged_in(String name,String password) {
		crtitem1 = log.login(name ,password);
	}
	@When("I add product in the cart")
	public void i_added_product() {
		crtitem1.productAdd();
		crtitem1.waitForProduct();
		chkout1 = crtitem1.clickOnTheCart();

		chkout1.checkOut();
		chkout1.countryselection();
		chkout1.scroll();
		orderconfirm1 = chkout1.orderPlace();
	}
	@Then("I verify the ordered product")
	public void i_verifiy_product() {
		expectedProduct = orderconfirm1.productVerification();

		String x = expectedProduct.getText();
	    Assert.assertEquals(productName, x);
		orderconfirm1.orderConfirmation();	
	}
}
