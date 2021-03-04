package demo.guru99project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99 {
	
	ChromeDriver driver;
	String customerId;
	String accountId;
	
		public void invokeBrowser()
		{
			System.setProperty("webdriver.chrome.driver", "D:\\jar files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://demo.guru99.com/v4");	
		}
	    
		public void getTitle()
		{
			System.out.println("Page Title "+driver.getTitle());   
		}
		
		/*
		 * public void navigateCommands() {
		 * driver.navigate().to("https://www.facebook.com"); //It is called as
		 * "Method Chaning". driver.navigate().back();//it will take one step back to
		 * the browsing history. driver.navigate().forward();//it will take one step
		 * forward to the browsing history. driver.navigate().refresh();//it will reload
		 * the page }
		 */

		public void closeBrowser()
		{
			driver.close(); //closes the current instance of a browser
			//driver.quit(); //closes all the instance of the browser
		}
		
		public void login(String username, String password)
		{
			driver.findElement(By.name("uid")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("btnLogin")).click();
		}
		
		public void addingNewCustomer(String cutomerName, String address, String password)
		{
			driver.findElement(By.linkText("New Customer")).click();
			driver.findElement(By.xpath("//input[@value = 'f']")).click();
			driver.findElement(By.id("dob")).sendKeys("11-03-2021");
			driver.findElement(By.name("name")).sendKeys(cutomerName);
			driver.findElement(By.name("addr")).sendKeys(address);
			driver.findElement(By.name("city")).sendKeys("Chandigarh");
			driver.findElement(By.name("state")).sendKeys("punjab");
			driver.findElement(By.name("pinno")).sendKeys("160055");
			driver.findElement(By.name("telephoneno")).sendKeys("9876778283");
			
			String emailId = "aa"+System.currentTimeMillis()+"@gmail.com";
			System.out.println("Email Id "+emailId);
			driver.findElement(By.name("emailid")).sendKeys(emailId);
			
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("sub")).click();
		}
		
		public String getCustomerId()
		{
			customerId = driver.findElement(By.xpath("//table[@id='customer']//td[text()='Customer ID']//following-sibling::td")).getText();
		    return customerId;	
		}
		
		public void addNewAccount(String customerID)
		{
			driver.findElement(By.linkText("New Account")).click();
			driver.findElement(By.name("cusid")).sendKeys(customerID);
			
			WebElement account = driver.findElement(By.name("selaccount"));
			Select accountType = new Select(account);
			accountType.selectByVisibleText("Current");
			
			driver.findElement(By.name("inideposit")).sendKeys("20000");
			driver.findElement(By.name("button2")).click();	
		}
		
		public String getAccountId()
		{
			accountId = driver.findElement(By.xpath("//table[@name='account']//td[text()='Account ID']//following-sibling::td")).getText();
		    return accountId;
		}

}
