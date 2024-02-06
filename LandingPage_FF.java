package Project04_pageobject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LandingPage_FF {
	FirefoxDriver driver;
	
	//Specify Element Locators
	By searchprodpage1 = By.xpath("//input[@name='q']");
	By searchInput = By.xpath("//span[contains(text(),'iphone12')]");
	By selectExpt = By.xpath("//*[contains(text(),'APPLE iPhone 12 (Blue, 64 GB)')]");
	By addtocart = By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]");
	By verifycart = By.xpath("//span[contains(text(),'Place Order')]");
	By pincode = By.xpath("//button[contains(text(),'Enter Delivery Pincode')]");
	By deliveryadd = By.xpath("//input[@type='TEXT']");
	By submitpin = By.xpath("//div[contains(text(),'Submit')]"); 
	
	
	public LandingPage_FF(WebDriver driver)
	{
		this.driver=(FirefoxDriver) driver;
	}
	
	public void proddetail(String pname) throws InterruptedException
	{
		driver.findElement(searchprodpage1).sendKeys(pname);
		Thread.sleep(5000);
	}
	
	public void Inputsearch() throws InterruptedException
	{
		driver.findElement(searchInput).click();
		Thread.sleep(5000);
	}
	
	public void iphone12() throws InterruptedException
	{
		driver.findElement(selectExpt).click();;
		Thread.sleep(5000);
	}
	//switch to next tab
	public void switchto() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
	}
	
	public void Addcart() throws InterruptedException
	{
		driver.findElement(addtocart).click();
		Thread.sleep(5000);
	}
	
	public void verifyiphone() throws InterruptedException
	{
		String ptext1 = driver.findElement(verifycart).getText();
		System.out.println(ptext1);
	}
	
	public void changeadd() throws InterruptedException
	{
		driver.findElement(pincode).click();
		Thread.sleep(3000);
	}
	
	public void pastepin() throws InterruptedException
	{
		driver.findElement(deliveryadd).sendKeys("591201");
		Thread.sleep(3000);
	}
	
	public void submitpincode() throws InterruptedException
	{
		driver.findElement(submitpin).click();
		Thread.sleep(5000);
	}

}
