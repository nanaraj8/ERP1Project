package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homepage {
	 
	WebDriver driver;
	
	
	public void Verify_admin_user_is_able_to_access_the_Stock_Items_Page()
	{
		driver.findElement(By.linkText("Stock Items")).click();
		String actulresult=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(actulresult.equals("Stock Items"));
	}
	
	public void Verify_admin_user_is_able_to_access_Customers_Page()
	{
		driver.findElement(By.partialLinkText("Customer")).click();
		String actulresult2=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(actulresult2.equals("Customers"));
	}
	
	public void Verify_admin_user_is_able_to_access_Stock_categories_Page()
	{
		WebElement ele=driver.findElement(By.id("mi_a_stock_items"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		WebElement ele2=driver.findElement(By.linkText("Stock Categories"));
		act.moveToElement(ele2).build().perform();
		ele2.click();
		String Categories=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(Categories.contains("Categories"));
	}
	
	public void Verify_admin_user_is_able_to_access_Unit_of_measurement_Page()
	{
		WebElement ele=driver.findElement(By.id("mi_a_stock_items"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']")).click();
		String measurement=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(measurement.equals("Unit of Measurement"));
	}

}
