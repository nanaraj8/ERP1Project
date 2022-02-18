package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UnitOfMeasurement {

	public static void main(String[] args) throws InterruptedException {
		// Verfiy admin user is able to access the Unit of Measurement Page

		System.setProperty("webdriver.chrome.driver", "D:\\mychrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		WebElement ele=driver.findElement(By.id("mi_a_stock_items"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		//driver.findElement(By.linkText("Unit of Measurement")).click();
		driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']")).click();
		String measurement=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		
		if(measurement.equals("Unit of Measurement"))
		{
			System.out.println("your aable to access Unit of Measurement and testcase paassed");
		}
		else
		{
			System.out.println("TestCase failed");
		}
		

	}

}
