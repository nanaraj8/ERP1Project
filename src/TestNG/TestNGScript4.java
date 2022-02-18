package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import one.Basemethods;

public class TestNGScript4 {
	
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
	public void TC14_Verify_admin_user_is_able_to_update_the_stock_Item() throws InterruptedException
	{
		base.accessToStockItemsPage();
		base.updateRecord();
	}
	@Test(enabled=false)
	public void TC15_Verify_admin_user_is_able_to_Delete_the_stock_Item_record() throws InterruptedException
	{
		base.accessToStockItemsPage();
		base.DeleteRecord();
	}
	@Test(enabled=false)
	public void TC16_Verify_admin_user_is_able_to_Delete_multiple_stock_Item_record() throws InterruptedException
	{
		base.accessToStockItemsPage();
		base.DeleteMultipleStockrecord();
	}
	@Test(enabled=false)
	public void TC17_Verify_admin_user_is_able_to_create_the_search_filter() throws InterruptedException
	{
		base.accessToStockItemsPage();
		base.SimpleSearch();
		Thread.sleep(5000);
		base.Createsearchfilter();
		//pending
	}
	public void TC18_Verify_admin_user_is_able_to_create_the_delete_search_filter()
	{
		
		
	}
	public void TC19_Verify_admin_user_is_able_to_export_stock_Items_in_a_word_format()
	{
		base.accessToStockItemsPage();
	//	(//b[@class='caret'])[6]
		
	}
	public void TC20_Verify_admin_user_is_able_to_export_stock_Items_in_a_excel_format()
	{
		base.ExportWordFormat();
	}
	public void TC21_Verify_admin_user_is_able_to_send_an_email_of_stock_Items()
	{
		
		
	}
	
}
