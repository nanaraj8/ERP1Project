package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogindetails {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master2");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		//String actresult1=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		String alertWindow=driver.getWindowHandle();
		driver.switchTo().window(alertWindow);
		String actResult2 =driver.findElement(By.xpath("//div[@class='alert alert-danger ewError']")).getText();
		String actResult3 =driver.findElement(By.xpath("//p[@class='text-danger']")).getText();
		
		if(actResult2.contains("Incorrect user ID or password") || actResult3.contains("Please enter password"))
		{
			System.out.println("logged out failed and test case passed");
		}
		else
		{
			System.out.println("logged in passesd and test case passed ");
		}

	}

}
