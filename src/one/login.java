package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		String actresult=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		if(actresult.equals("Dashboard"))
		{
			System.out.println("succesfully logged and testcase passed");
		}
		else
		{
			System.out.println("failed to  logged and testcase failed");
		}
		
		driver.findElement(By.xpath("//a[@id='logout']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK!')]")).click();
		
		String actualurl="http://orangehrm.qedgetech.com/webapp/login.php";
		
		if(actualurl.equals("http://orangehrm.qedgetech.com/webapp/login.php"))
		{
			System.out.println("loggedout successfully and testcase passed");
		}
		else
		{
			System.out.println("loggedout failed and testcase failed");
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='btnreset']")).click();
	}

}
