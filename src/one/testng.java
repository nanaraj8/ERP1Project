package one;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testng {
	
	@BeforeTest
	  public void createTestdata() {
		  System.out.println("Create the testData for testcases..");	 
		  System.out.println(".........................");	
	  }
	@AfterTest
	  public void cleanupTestdata() {
		  System.out.println(".............................");	  	
		  System.out.println("cleanup the testData for testcases..");
	  }
		
	@BeforeMethod
	  public void login() {
		  System.out.println("I will execute before every testcase");	  		  
	  }
	
	@AfterMethod
	  public void logout() {
		  System.out.println("I will execute before every testcase");	  		  
	  }
	
	@Test(priority=1)
	public void testcase1() {
	  System.out.println("I will execute testcase-1");	  	  
	}
	@Test(priority=2)
	public void testcase2() {
	  System.out.println("I will execute testcase-2");	  	  
	}

	@Test(priority=3)
	public void testcase3() {
	  System.out.println("I will execute testcase-3");	  	  
	}

}
