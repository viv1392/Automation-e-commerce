package pageObject.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcompo.utilities.AbstractComponent;

public class ProductCheckOut extends AbstractComponent {
	public WebDriver driver;
	public OrderConfirmation orderconfirm;
	public ProductCheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutclick;
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryInput;
	@FindBy(xpath=" //span[text()=' India']")
	WebElement country;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement order;
	public void checkOut() {
		checkOutclick.click();
		
	}
	public void countryselection() {
		countryInput.sendKeys("ind");
		country.click();
	    
		
	}
	public OrderConfirmation orderPlace() {
		order.click();
	    orderconfirm= new OrderConfirmation(driver);
		return orderconfirm;
	}

}


//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("indi");
//driver.findElement(By.xpath(" //span[text()=' India']")).click();
//Actions act = new Actions(driver);
//act.scrollByAmount(0, 600).build().perform();
//driver.findElement(By.xpath("//a[text()='Place Order ']")).click();