package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import one.Basemethods;

public class TestNGScript2 {
	
	Basemethods base;
	
	String url="http://orangehrm.qedgetech.com/webapp/login.php";
	String uname="admin";
	String password="master";
	
	@BeforeMethod
	public void OpenERPApp()
	{
		base=new Basemethods();	
		base.openBrowser("chrome");
		base.launchERP(url);
		base.loginERP(uname, password);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		base.driver.close();
	}
	
	@Test(enabled=false)
	public void TC04_Verify_admin_user_is_able_to_access_the_Stock_Items_Page()
	{
		base.driver.findElement(By.linkText("Stock Items")).click();
		String actulresult=base.driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(actulresult.equals("Stock Items"));
	}
	
	@Test(enabled=false)
	public void TC05_Verify_admin_user_is_able_to_access_Customers_Page()
	{
		base.driver.findElement(By.partialLinkText("Customer")).click();
		String actulresult2=base.driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(actulresult2.equals("Customers"));
	}
	
	@Test(enabled=false)
	public void TC06_Verify_admin_user_is_able_to_access_Stock_categories_Page()
	{
		WebElement ele=base.driver.findElement(By.id("mi_a_stock_items"));
		
		Actions act=new Actions(base.driver);
		act.moveToElement(ele).build().perform();
		
		WebElement StockCat=base.driver.findElement(By.linkText("Stock Categories"));
		act.moveToElement(StockCat).build().perform();
		StockCat.click();
		
		String Categories=base.driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		
		Assert.assertTrue(Categories.contains("Categories"));
	}
	
	@Test
	public void TC07_Verify_admin_user_is_able_to_access_Unit_of_measurement_Page()
	{
		WebElement ele=base.driver.findElement(By.id("mi_a_stock_items"));
		Actions act=new Actions(base.driver);
		act.moveToElement(ele).build().perform();
		
		base.driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']")).click();
		String measurement=base.driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		
		//String measurement=base.driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		Assert.assertTrue(measurement.equals("Unit of Measurement"));
	}


}
