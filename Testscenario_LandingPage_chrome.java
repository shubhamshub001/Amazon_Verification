package TestScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Project04_pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testscenario_LandingPage_chrome {
	static LandingPage page;
	static WebDriver driver;
	
	@Test
	public void verifyproduct() throws InterruptedException
	{
		//Launch chrome Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		//Search th E-commerce site
		driver.get("https://www.flipkart.com/");
		//maximize
		driver.manage().window().maximize();
		page = new LandingPage(driver);
		//search-iphone 12
		page.proddetail("iphone12");
		//Click on iphone12
		page.Inputsearch();
		//Next tab select iphone12 64Gb
		page.iphone12();
		page.switchto();
		//Now add product to the cart
		page.Addcart();
		page.verifyiphone();
		page.changeadd();
		page.pastepin();
		page.submitpincode();
		driver.quit();	
	}

}
