package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateStockItems {

	public static void main(String[] args) throws InterruptedException {
		// Create stock items
		
		System.setProperty("webdriver.chrome.driver", "D:\\mychrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		driver.findElement(By.linkText("Stock Items")).click();
		driver.findElement(By.xpath("//span[@data-phrase='AddLink']")).click();
		
		//creating stock items
		
		WebElement StockCategory=driver.findElement(By.id("x_Category"));
		Select sel=new Select(StockCategory);
		Thread.sleep(5000);
		sel.selectByVisibleText("Asd665 i");
		//sel.selectByValue("42");
		//sel.selectByIndex(2);
		WebElement SupplierNumber=driver.findElement(By.id("x_Supplier_Number"));
		Select sel2=new Select(SupplierNumber);
		sel2.selectByIndex(3);
		
		//driver.findElement(By.id("x_Stock_Number")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='x_Stock_Name']")).sendKeys("soni");
		
		WebElement UnitOfMeasurement=driver.findElement(By.id("x_Unit_Of_Measurement"));
		Select sel3=new Select(UnitOfMeasurement);
		sel3.selectByIndex(1);
		
		driver.findElement(By.id("x_Purchasing_Price")).sendKeys("50000");
		Thread.sleep(5000);
		driver.findElement(By.id("x_Selling_Price")).sendKeys("58000");
		driver.findElement(By.id("x_Notes")).sendKeys("provide some more details");
		
		driver.findElement(By.id("btnAction")).click();
		
		//driver.findElement(By.linkText("Stock Items")).click();
		//base.searchStockItem(stockName);
		String alertwindow=driver.getWindowHandle();
		driver.switchTo().window(alertwindow);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement confirm=driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
	
		
	}

}
