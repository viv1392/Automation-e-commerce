package pageObject.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcompo.utilities.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {
	WebDriver driver;
	public OrderConfirmation(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//div[text()='adidas original']")
	WebElement productele;
	@FindBy(xpath="//h1[text()=' Thankyou for the order. ']")
	WebElement Orderconfirmation;
	
	public WebElement productVerification() {
		productele.getText();
		return productele;
		
		
	}
	public void orderConfirmation() {
		String Orderconfirm =Orderconfirmation.getText();
		System.out.println(Orderconfirm );
	}

}


//WebElement ele = driver.findElement(By.xpath("//div[text()='adidas original']"));
//String expectedProduct = ele.getText();
//expectedProduct.equalsIgnoreCase(productName);
//String Orderconfirmation = driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).getText();
//System.out.println(Orderconfirmation);