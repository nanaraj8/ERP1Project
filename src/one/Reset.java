package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reset {

	public static void main(String[] args) throws InterruptedException {
		// Reset Button
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnreset")).click();
		WebElement username = driver.findElement(By.id("username"));
		String userNameValue = username.getAttribute("value");
		WebElement password = driver.findElement(By.id("password"));
		String passwordValue = password.getAttribute("value");
        
       // Check whether username and password fields are blank
        if(userNameValue.isEmpty() && passwordValue.isEmpty())
        {
           System.out.println("Reset Button is working, Testcase is passed");
        } else {
        	System.out.println("Reset Button is not working, Testcase is failed");
        }
	}

}
