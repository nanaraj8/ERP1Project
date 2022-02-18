package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stockitems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		driver.findElement(By.linkText("Stock Items")).click();
		String actulresult=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		if(actulresult.equals("Stock Items"))
		{
			System.out.println("You are able to access Stock Items page");
		}
		else
		{
			System.out.println("no you are not able to access Stock Items page");
		}
		
		driver.findElement(By.partialLinkText("Customer")).click();
		String actulresult2=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		if(actulresult2.equals("Customers"))
		{
			System.out.println("You are able to access Customers page");
		}
		else
		{
			System.out.println("no you are not able to access Customers page");
		}
		
	/*	Thread.sleep(5000);
		driver.findElement(By.linkText("Stock Categories")).click();
		String actulresult3=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		if(actulresult2.equals("Stock Categories"))
		{
			System.out.println("You are able to access Stock Categories page");
		}
		else
		{
			System.out.println("no you are not able to access Stock Categories page");
		} */
		
		
	}

}
