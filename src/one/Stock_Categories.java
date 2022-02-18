package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Stock_Categories {

	public static void main(String[] args) throws InterruptedException {
		// Verfiy admin user is able to access the Stock Categories Page
		
		/*steps:
			1-open browser
			2-launch the application
			*/
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
		
	//	WebElement ele2=driver.findElement(By.xpath("//li[@id='mi_a_stock_categories'])"));
	//	act.moveToElement(ele2).build().perform();
	//	ele2.click();
	//	driver.findElement(By.xpath("//a[contains(text(),'Stock Categories')]")).click();
		WebElement ele2=driver.findElement(By.linkText("Stock Categories"));
		act.moveToElement(ele2).build().perform();
		ele2.click();
		String Categories=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		if(Categories.contains("Categories"))
		{
			System.out.println("your aable to access stock Categories and testcase paassed");
		}
		else
		{
			System.out.println("TestCase failed");
		}
		
	}

}
