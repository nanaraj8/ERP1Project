package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateUnitOfMeasurement {

	public static void main(String[] args) throws InterruptedException {
		// Verify admin user is able to create Unit of Measurement
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
		
		driver.findElement(By.xpath("//span[@data-phrase='AddLink']")).click();
		
		driver.findElement(By.id("x_UOM_ID")).sendKeys("0020");
		driver.findElement(By.id("x_UOM_Description")).sendKeys("kgs");
		driver.findElement(By.id("btnAction")).click();
		
		String alertwindow=driver.getWindowHandle();
		driver.switchTo().window(alertwindow);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement confirm=driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		WebElement confirm2=driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm2.click();
		WebElement confirm3=driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm3.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys("0020");
		
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("(//button[@class='btn btn-primary ewButton'])[1]")).click();
		
		
		WebElement simpsearch=driver.findElement(By.id("btnsubmit"));
		Actions act2=new Actions(driver);
		act2.moveToElement(simpsearch).build().perform();
		simpsearch.click();
		Thread.sleep(2000);
		
		String number=driver.findElement(By.xpath("//span[contains(text(),'0020')]")).getText();
		if(number.equals("0020"))
		{
			System.out.println("done");
		}
		else
		{
			System.out.println("not done");
		}

		//button[@id='btnsubmit']
		
		
	}

}
