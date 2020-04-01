package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class OpenMre1 {

	
	
	@Test
	public void test() throws InterruptedException{
		//setting up the WebDriver for ChromDriver
		WebDriver driver = new ChromeDriver();
		
		//making sure the webpage will be opened in max(full size)
		driver.manage().window().maximize();
		
		//implicit wait will tell to the web driver to wait for certain amount of time before it throws a "No Such Element Exception"
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//opening webpage
		driver.get("http://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
		
		//verifying the logo
	    WebElement element =  driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/div/div/div/img"));
	    
	    //getting the size of the logo
	    System.out.println("Displayed text in image is : " + element.getSize());
	    
	    //making sure the logo is displayed
		if (!element.isDisplayed())
		{
			System.out.println("Element not displayed");
		}else {
			System.out.println("Element displayed");
		}
	    
		//typing user name
		driver.findElement(By.id("authUser")).sendKeys("admin");
		
		//typing password
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		//choosing the language
		Select language = new Select(driver.findElement(By.name("languageChoice")));
		language.selectByValue("1");
		
		//clicking the login bottom
	    driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button")).click();
	    
	    
	    //--------------------------------------------------------------------------------------------
	    
	    //move mouse over patient clinc
	    Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).perform();
	    
	    //click on new patient
	    driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
	    
	    //switch to frame
	    driver.switchTo().frame(driver.findElement(By.name("pat")));
	    
	    //wait for 2 seconds
	    Thread.sleep(2000);
	    
	    //create select class to choose name title
	    Select tit = new Select(driver.findElement(By.id("form_title"))); 
		tit.selectByValue("Mr.");
	    
		//type name
	    driver.findElement(By.id("form_fname")).sendKeys("Adam");
		 
		//type lastname
	    driver.findElement(By.id("form_lname")).sendKeys("Cohen");
	    
	    //wait for 2 seconds
	    Thread.sleep(2000); 
	    
	    //open DOB calender
	    driver.findElement(By.id("form_DOB")).click(); 
	    
	    //create action class
		Actions tit1 = new Actions (driver); 
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//double click on get today's date
		tit1.doubleClick(driver.findElement(By.className("xdsoft_today_button"))).perform(); 
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//create select class to choose gender
		Select gender = new Select(driver.findElement(By.id("form_sex"))); 
		gender.selectByValue("Male");
	    
		//click on create new patient
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		
		//wait for 2 seconds
		Thread.sleep(2000);
		//click on confirm button
		driver.findElement(By.xpath("/html/body/center/input")).click();
		
	
	    //--------------------------------------------------------------------------------------------
	    
		
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//printing text from alert
		System.out.println(driver.switchTo().alert().getText());
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//accepting alert
		driver.switchTo().alert().accept();
		 
		//wait for 2 seconds
		Thread.sleep(2000);
		
	
		
		
		//---------------------------------------------------------------------------------------------
	    
		
		//dealing with happy birthday alert
		
		
		//swith to happy birthday frame
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//getting text from frame
		System.out.println("The displayed text is : " + driver.findElement(By.className("h2")).getText());
		
		//Assert to be added
		AssertJUnit.assertEquals(driver.findElement(By.className("h2")).getText(),"Happy Birthday");
		
		//creating dob object
		WebElement dob = driver.findElement(By.xpath("/html/body/div/p/img"));
	
		//getting the size of the picture
		System.out.println("Displayed text in image is : " + dob.getSize());
	
		//making sure the picture is displayed
				if (!dob.isDisplayed())
				{
					System.out.println("Element not displayed");
				}else {
					System.out.println("Birthday picture is displayed");
				}
				
		
		
		//switch to default
		driver.switchTo().defaultContent();
				
		//closing birthday frame 		
		driver.findElement(By.className("closeDlgIframe")).click();
		        
	    //---------------------------------------------------------------------------------------------
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//move the mouse to billy smith
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"username\"]"))).perform();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//click logout
		act.click(driver.findElement(By.xpath("//*[@id=\"username\"]/div/ul/li[4]"))).perform();
		
		
		//---------------------------------------------------------------------------------------------
		
		
		
		
		//wait for 2 seconds 
		Thread.sleep(2000);
		
		//closing window
		driver.quit();
	}
		
	/*	 @Test(priority = 10)
         public void test1() throws InterruptedException {
			 
				//setting up the WebDriver for ChromDriver
				WebDriver driver = new ChromeDriver();
				
				//making sure the webpage will be opened in max(full size)
				driver.manage().window().maximize();
				
				//implicit wait will tell to the web driver to wait for certain amount of time before it throws a "No Such Element Exception"
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//opening webpage
				driver.get("http://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
				
				//verifying the logo
			    WebElement element =  driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/div/div/div/img"));
			    
			    //getting the size of the logo
			    System.out.println("Displayed text in image is : " + element.getSize());
			    
			    //making sure the logo is displayed
				if (!element.isDisplayed())
				{
					System.out.println("Element not displayed");
				}else {
					System.out.println("Element displayed");
				}
			    
				//typing user name
				driver.findElement(By.id("authUser")).sendKeys("admin");
				
				//typing password
				driver.findElement(By.id("clearPass")).sendKeys("pass");
				
				//choosing the language
				Select language = new Select(driver.findElement(By.name("languageChoice")));
				language.selectByValue("1");
				
				//clicking the login bottom
			    driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button")).click();
			    
			    
			    //--------------------------------------------------------------------------------------------
			    
			    //move mouse over patient clinc
			    Actions act = new Actions(driver);
			    act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).perform();
			    
			    //click on new patient
			    driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
			    
			    //switch to frame
			    driver.switchTo().frame(driver.findElement(By.name("pat")));
			    
			    //wait for 2 seconds
			    Thread.sleep(2000);
			    
			    //create select class to choose name title
			    Select tit = new Select(driver.findElement(By.id("form_title"))); 
				tit.selectByValue("Mr.");
			    
				//type name
			    driver.findElement(By.id("form_fname")).sendKeys("Adam");
				 
				//type lastname
			    driver.findElement(By.id("form_lname")).sendKeys("Cohen");
			    
			    //wait for 2 seconds
			    Thread.sleep(2000); 
			    
			    //open DOB calender
			    driver.findElement(By.id("form_DOB")).click(); 
			    
			    //create action class
				Actions tit1 = new Actions (driver); 
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//double click on get today's date
				tit1.doubleClick(driver.findElement(By.className("xdsoft_today_button"))).perform(); 
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//create select class to choose gender
				Select gender = new Select(driver.findElement(By.id("form_sex"))); 
				gender.selectByValue("Male");
			    
				//click on create new patient
				driver.findElement(By.id("create")).click();
				
				driver.switchTo().defaultContent();
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//switch to frame
				driver.switchTo().frame(driver.findElement(By.id("modalframe")));
				
				//wait for 2 seconds
				Thread.sleep(2000);
				//click on confirm button
				driver.findElement(By.xpath("/html/body/center/input")).click();
				
			
			    //--------------------------------------------------------------------------------------------
			    
				
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//printing text from alert
				System.out.println(driver.switchTo().alert().getText());
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//accepting alert
				driver.switchTo().alert().accept();
				 
				//wait for 2 seconds
				Thread.sleep(2000);
				
			
				
				
				//---------------------------------------------------------------------------------------------
			    
				
				//dealing with happy birthday alert
				
				
				//swith to happy birthday frame
				driver.switchTo().frame(driver.findElement(By.id("modalframe")));
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//getting text from frame
				System.out.println("The displayed text is : " + driver.findElement(By.className("h2")).getText());
				
				//Assert to be added
				AssertJUnit.assertEquals(driver.findElement(By.className("h2")).getText(),"Happy Birthday");
				
				//creating dob object
				WebElement dob = driver.findElement(By.xpath("/html/body/div/p/img"));
			
				//getting the size of the picture
				System.out.println("Displayed text in image is : " + dob.getSize());
			
				//making sure the picture is displayed
						if (!dob.isDisplayed())
						{
							System.out.println("Element not displayed");
						}else {
							System.out.println("Birthday picture is displayed");
						}
						
				
				
				//switch to default
				driver.switchTo().defaultContent();
						
				//closing birthday frame 		
				driver.findElement(By.className("closeDlgIframe")).click();
				        
			    //---------------------------------------------------------------------------------------------
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//move the mouse to billy smith
				act.moveToElement(driver.findElement(By.xpath("//*[@id=\"username\"]"))).perform();
				
				//wait for 2 seconds
				Thread.sleep(2000);
				
				//click logout
				act.click(driver.findElement(By.xpath("//*[@id=\"username\"]/div/ul/li[4]"))).perform();
				
				
				//---------------------------------------------------------------------------------------------
				
				
				
				
				//wait for 2 seconds 
				Thread.sleep(2000);
				
				//closing window
				driver.quit();
				*/
			 }
		 
	 
      
		
