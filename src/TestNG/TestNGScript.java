package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import one.Basemethods;

public class TestNGScript {	
		
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
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		base.driver.close();
	}
	
	@Test
	public void TC01_Verify_the_login_valid_credidentials()
	{
		base.loginERP(uname, password);
	//	Assert.assertTrue(actResult.equals("Dashboard"));
	}
	
	@Test
	public void TC02_Verify_the_Logout()
	{
		base.loginERP(uname, password);
		
		base.driver.findElement(By.id("mi_logout")).click();
		Assert.assertTrue(base.driver.findElement(By.id("btnsubmit")).isEnabled());
	
	}
	
	@Test
	public void TC03_Verify_the_Reset_Button()
	{
		base.Reset();
     	Assert.assertTrue(base.userNameValue.isEmpty() && base.passwordValue.isEmpty());
		
	
	}
}
