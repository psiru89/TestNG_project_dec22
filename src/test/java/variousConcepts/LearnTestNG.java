package variousConcepts;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnTestNG {

	WebDriver driver;
	    By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
		By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
	    By CUSTOMER_MENU_FIELD= By.xpath("//span[contains(text(), 'Customers')]");
	    By ADD_CUSTOMER_MENU_FIELD=By.xpath("//a[contains(text(), 'Add Customer')]");
	    By FULL_NAME_FIELD=By.xpath("//input [@id='account']");
	    By COUNTRY_DROPDOWN_FIELD=By.xpath("//select[@id='cid']");
			 
	
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void LoginTest() {
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		
		
	Assert.assertEquals(driver.findElement(DASHBOARD_HEADER_FIELD).getText(), "Dashboard", "Dashboard page not found!");
		
	}
	
	
}
