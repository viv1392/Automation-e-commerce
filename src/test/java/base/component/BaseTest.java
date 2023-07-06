package base.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.model.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage log;

	public WebDriver driverInItilize() throws IOException {
		Properties prop = new Properties();
		String file = System.getProperty("user.dir") + "\\src\\main\\java\\globalData\\Global.properties";
		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edgebrowser")) {
			// code here

		} else if (browserName.equalsIgnoreCase("fireFox")) {
			// code here
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	public List<HashMap<String, String>> dataReader(String filePath) throws IOException {
		String jasonfile = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jasonfile,
				new TypeReference<List<HashMap<String, String>>>() {

				});
		return data;

	}

	public String screenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot scrshot = ((TakesScreenshot) (driver));
		File srce = scrshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports1//" + testCaseName + ".png");
		FileUtils.copyFile(srce, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	@BeforeMethod
	public LandingPage WebLanding() throws IOException {
		driver = driverInItilize();
		log = new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		return log;
	}

	@AfterMethod
	public void driverClouser() {
		driver.close();
	}

}
