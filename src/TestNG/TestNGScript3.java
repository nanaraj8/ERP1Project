package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import one.Basemethods;

public class TestNGScript3 {
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
	public void TC08_Verify_admin_user_is_able_to_create_Stock_Item() throws InterruptedException
	{

		base.accessToStockItemsPage();
		base.AddStockitems();
	}
	@Test(enabled=false)
	public void TC09_Verify_admin_user_is_able_to_create_Stock_Category () throws InterruptedException
	{
		//span[@data-phrase='AddLink']
	}
	@Test(enabled=false)
	public void TC10_Verify_admin_user_is_able_to_create_Unit_of_Measurement() throws InterruptedException
	{
		base.unitOfMeasurement();
		base.measurementsearch();
	}
	@Test(enabled=false)
	public void TC11_Verify_admin_user_is_able_to_search_the_stock_Items_by_using_simple_search()
	{
		base.accessToStockItemsPage();
		base.SimpleSearch();
		String test1=base.driver.findElement(By.xpath("//span[contains(text(),'sony NW-A105')]")).getText();
		Assert.assertTrue(test1.equals("sony NW-A105"));
		
	}
	
	@Test
	public void TC12_Verify_admin_user_is_able_to_search_the_stock_Items_by_using_Advanced_search() throws InterruptedException
	{
		base.accessToStockItemsPage();
		base.advancedSearch();
		
	}
}
