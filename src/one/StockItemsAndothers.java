package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StockItemsAndothers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();

	}

}
