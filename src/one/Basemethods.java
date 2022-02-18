package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Basemethods {
	
	 public WebDriver driver;
	 
	 public WebElement username;
	 public WebElement password;
	 public String userNameValue;
	 public String passwordValue;
		
		public void openBrowser(String browserType)
		{			
			if(browserType.equals("chrome")) 			
			{
				System.setProperty("webdriver.chrome.driver", "D:\\mychrome\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else 
			{
				System.out.println("Invalid Browser Type..");
			}
		}
		
		public void launchERP(String url) 		
		{
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		
		public void loginERP(String username, String password) 
		{
			driver.findElement(By.xpath("//input[@id='username']")).clear();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
			String actResult = driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
			
			if(actResult.equals("Dashboard")) 
			{
				System.out.println("Login is successful, Testcase is passed from base");
			} 
			else 
			{
				System.out.println("Testcase is Failed, login failed");
			}
		}
		
		public void Reset()
		{
			
			driver.findElement(By.id("btnreset")).click();
			username = driver.findElement(By.id("username"));
			userNameValue = username.getAttribute("value");
			password = driver.findElement(By.id("password"));
			passwordValue = password.getAttribute("value");
			
		}
		
		public void AddStockitems() throws InterruptedException
		{
			WebElement addStock = driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]"));
			addStock.click();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			WebElement StockCategory=driver.findElement(By.xpath("//select[@id='x_Category']"));
			Select sel=new Select(StockCategory);
			Thread.sleep(5000);
			sel.selectByIndex(3);
			
			WebElement SupplierNumber=driver.findElement(By.id("x_Supplier_Number"));
			Select sel2=new Select(SupplierNumber);
			sel2.selectByIndex(3);
			
			driver.findElement(By.xpath("//input[@id='x_Stock_Name']")).sendKeys("sony NW-A105");
			
			WebElement UnitOfMeasurement=driver.findElement(By.id("x_Unit_Of_Measurement"));
			Select sel3=new Select(UnitOfMeasurement);
			sel3.selectByIndex(1);
			
			driver.findElement(By.id("x_Purchasing_Price")).sendKeys("50000");
			Thread.sleep(5000);
			driver.findElement(By.id("x_Selling_Price")).sendKeys("58000");
			driver.findElement(By.id("x_Notes")).sendKeys("provide some more details");
			
			driver.findElement(By.id("btnAction")).click();
			
			String alertwindow=driver.getWindowHandle();
			driver.switchTo().window(alertwindow);
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement confirm=driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
			confirm.click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		}
		
		public void accessToStockItemsPage()
		{
			WebElement ele3=driver.findElement(By.linkText("Stock Items"));
			ele3.click();
			//String actulresult=driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
			//Assert.assertTrue(actulresult.equals("Stock Items"));
		}
		public void CreateStockCategories()
		{
			
		}
		public void unitOfMeasurement()
		{
			
			WebElement ele=driver.findElement(By.id("mi_a_stock_items"));
			Actions act=new Actions(driver);
			act.moveToElement(ele).build().perform();
			
			driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']")).click();
			
			driver.findElement(By.xpath("//span[@data-phrase='AddLink']")).click();
			
			driver.findElement(By.id("x_UOM_ID")).sendKeys("0009");
			driver.findElement(By.id("x_UOM_Description")).sendKeys("kgs");
			driver.findElement(By.id("btnAction")).click();
			
		}
	
		public void advancedSearch() throws InterruptedException
	{		
		driver.findElement(By.linkText("Stock Items")).click();
		driver.findElement(By.xpath("//span[@data-caption='Advanced Search']")).click();
		Thread.sleep(5000);
		
		
	}
	
	public void SimpleSearch()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys("sony NW-A105");
		//driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();//dropdown
		//driver.findElement(By.xpath("//a[contains(text(),'Exact match')]")).click();
		WebElement simpsearch=driver.findElement(By.id("btnsubmit"));
		simpsearch.click();
				
	}
	public void measurementsearch() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys("0020");
		WebElement simpsearch=driver.findElement(By.id("btnsubmit"));
		Actions act2=new Actions(driver);
		act2.moveToElement(simpsearch).build().perform();
		simpsearch.click();
		Thread.sleep(2000);
		
		String number=driver.findElement(By.xpath("//span[contains(text(),'0020')]")).getText();
		Assert.assertTrue(number.equals("0020"));
	}
	

	public void updateRecord() throws InterruptedException {
		//WebElement ele4=driver.findElement(By.xpath("(//button[@data-original-title='Actions'])[1]"));
		/*WebElement ele4=driver.findElement(By.xpath("(//span[@data-caption='Actions'])[1]"));
		Actions act4=new Actions(driver);
		act4.moveToElement(ele4).build().perform();
		Thread.sleep(5000);
		ele4.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//b[@class='caret'])[8]")).click();
		Thread.sleep(5000);*/
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		Thread.sleep(5000);
		WebElement ele4=driver.findElement(By.xpath("(//span[@data-caption='Actions'])[1]"));
		Actions act4=new Actions(driver);
		act4.moveToElement(ele4).build().perform();
		Thread.sleep(5000);
		ele4.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//b[@class='caret'])[8]")).click();
		Thread.sleep(5000);
	//	WebElement ele5=driver.findElement(By.xpath("(//a[@class='ewAction ewMultiUpdate'])[1]"));
		driver.findElement(By.xpath("(//ul//li//a[@class='ewAction ewMultiUpdate'])[1]")).click();
	//	ele5.click();		
	}
	public void DeleteRecord() throws InterruptedException
	{
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		Thread.sleep(5000);
		WebElement ele4=driver.findElement(By.xpath("(//span[@data-caption='Actions'])[1]"));
		Actions act4=new Actions(driver);
		act4.moveToElement(ele4).build().perform();
		Thread.sleep(5000);
		ele4.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//b[@class='caret'])[8]")).click();
		Thread.sleep(5000);
		WebElement ele5=driver.findElement(By.xpath("(//a[@class='ewAction ewMultiDelete'])[1]"));
		ele5.click();
	}
	
	//span[@data-caption='Search']
	
	
	//button[@type='submit']
	public void DeleteMultipleStockrecord() throws InterruptedException
	{
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(5000);
		WebElement ele4=driver.findElement(By.xpath("(//span[@data-caption='Actions'])[1]"));
		Actions act4=new Actions(driver);
		act4.moveToElement(ele4).build().perform();
		Thread.sleep(5000);
		ele4.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//b[@class='caret'])[8]")).click();
		Thread.sleep(5000);
		WebElement ele5=driver.findElement(By.xpath("(//a[@class='ewAction ewMultiDelete'])[1]"));
		ele5.click();
	}
	public void Createsearchfilter() throws InterruptedException
	{
		WebElement ele5=driver.findElement(By.xpath("(//span[@data-caption='Actions'])[1]"));
		Actions act5=new Actions(driver);
		act5.moveToElement(ele5).build().perform();
		Thread.sleep(5000);
		ele5.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//b[@class='caret'])[7]")).click();
		//driver.findElement(By.xpath("//button[@data-original-title='Filters']")).click();
	}
	public void deletesearchfilter()
	{
		
	}
	public void ExportWordFormat()
	{
		driver.findElement(By.xpath("(//b[@class='caret'])[6]")).click();
	}
	public void EmailFormat()
	{
		driver.findElement(By.xpath("//a[@id='emf_a_stock_items']")).click();
	}
	public void printFriendly()
	{
		driver.findElement(By.id("data-original-title"));
	}public void CSVFormat()
	{
		driver.findElement(By.xpath("//a[@id='emf_a_stock_items']")).click();
	}
	public void XMLFormat()
	{
		driver.findElement(By.xpath("//a[@id='emf_a_stock_items']")).click();
	}
	public void HTMLFormat()
	{
		driver.findElement(By.xpath("//a[@id='emf_a_stock_items']")).click();
	}
	public void pageSize()
	{
		WebElement ele7=driver.findElement(By.name("recperpage"));
		Select pagesize=new Select(ele7);
		pagesize.selectByValue("5");
		
	}
	public void navigation()
	{
		driver.findElement(By.xpath("(//a[@data-original-title='Next'])[1]")).click();
	}
	
	}


