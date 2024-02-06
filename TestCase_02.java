package TestScenarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_02 {
	
	public WebDriver driver;
	List<WebElement> phones;
	List<WebElement> price;
	private int list;
	
	//Launch chrome browser
	@Test(priority=1)
	public void prodlist()
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//search for mobile phone
	@Test(priority=2)
	public void phonesearch()
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobile phones", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	/*
	 * Fetch all the mobile phones listed in the product listing page along with
	 * their prices and output them to an excel file and store them inside folder
	 * ‘Testresult’ in ‘src/test/resources’
	 */
	
	@Test(priority=3)
	public void sreachresult()
	{
		phones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		int noOf_phones=phones.size();
		System.out.println("Number of phones displayed="+noOf_phones);
		for(int i=1;i<noOf_phones-1;i++)
		{
			System.out.println(phones.get(i).getText());
		}
        //get the price form result
		price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		list=price.size();
		for(int i=0;i<=list-1;i++)
		{
			System.out.println(price.get(i).getText());
		}
	}
	
	//to write the phone names and its price in the Excel file
	@Test(priority=4)
	public void Write_Excel() throws IOException
	{
		File f = new File("D:\\JAVA_selenium\\Eclipse_IDE\\New folder\\Project_04\\src\\main\\resources\\Text1.xlsx");
		
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("Project_04_output");
		XSSFRow r = s.createRow(0);
		r.createCell(0).setCellValue("ITEMS");
		r.createCell(1).setCellValue("PRICES");
		
		for(int i=0; i<list-1; i++)
		{
			XSSFRow r1 = s.createRow(i+1);
			r1.createCell(0).setCellValue(phones.get(i).getText());
			r1.createCell(1).setCellValue(price.get(i).getText());
		}
		
		FileOutputStream fop = new FileOutputStream(f);
		try {
			w.write(fop);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		w.close();
		driver.close();
	}
	

}
