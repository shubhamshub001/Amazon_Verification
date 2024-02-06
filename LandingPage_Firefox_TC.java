package TestScenarios;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Project04_pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage_Firefox_TC {
	static LandingPage page;
	static FirefoxDriver driver;
	
	@Test
	public void verifyproduct() throws InterruptedException
	{
		//Launch chrome Browser
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		Thread.sleep(5000);
		//Search the  E-commerce site
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
