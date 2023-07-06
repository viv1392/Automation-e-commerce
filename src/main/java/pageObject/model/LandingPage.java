package pageObject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcompo.utilities.AbstractComponent;

public class LandingPage extends AbstractComponent {
	public WebDriver driver;
	public ProductInCart crtitem;
	public LandingPage(WebDriver driver) {
		super(driver);
	  this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="userEmail")
	WebElement mailel;
	@FindBy(id="userPassword")
	WebElement pass;
	@FindBy(id="login")
	WebElement log1;
	//public void WebLanding() {
	//	driver.get("https://rahulshettyacademy.com/client/");
	//}
	public ProductInCart login(String mail,String password) {
		mailel.sendKeys(mail);
		pass.sendKeys(password);
		log1.click();
	    crtitem = new ProductInCart(driver);
			return crtitem;
	}

}

//driver.get("https://rahulshettyacademy.com/client/");
		//driver.findElement(By.id("userEmail")).sendKeys("72vivekpandey72@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Vivek12345@");
		//driver.findElement(By.id("login")).click();
