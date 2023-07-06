package pageObject.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcompo.utilities.AbstractComponent;

public class ProductInCart extends AbstractComponent{
	public WebDriver driver;
	public ProductCheckOut chkout;
	public ProductInCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//button[text()=' Add To Cart'])[2]")
	WebElement productForCart;
	By toast=By.xpath("//div[text()=' Product Added To Cart ']");
	@FindBy(xpath="//label[text()='1']")
	WebElement ClickOnCart;
	
	public void productAdd() {
		productForCart.click();
		
	}
	public void waitForProduct() {
	  waitUntil(toast);
	}
	public ProductCheckOut clickOnTheCart() {
		ClickOnCart.click();
	     chkout=new ProductCheckOut(driver);
		return chkout;
		
	}

}
