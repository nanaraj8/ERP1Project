package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import one.Basemethods;

public class TestNGScript5 {
	
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
	
	
	public void TC22_Verify_admin_user_is_able_to_print_the_stock_items()
	{
		base.printFriendly();
	}
	public void TC23_Verify_admin_user_is_able_to_export_the_stock_Items_in_a_CSV_format()
	{
		
	}
	public void TC24_Verify_admin_user_is_able_to_able_to_export_the_stock_Items_in_a_XML_format()
	{
		
	}
	public void TC25_Verify_admin_user_is_able_to_export_the_stock_items_in_a_HTML_format()
	
	{
		
	}
	public void TC26_Verify_admin_user_is_able_to_set_the_Page_Size()
	
	{
		base.accessToStockItemsPage();
		
	}
	public void TC27_Verify_admin_user_is_able_to_Navigate_to_the_next_page()
	
	{
		base.navigation();
	}

}
