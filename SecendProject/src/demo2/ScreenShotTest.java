package demo2;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotTest {
WebDriver driver;
	
	@BeforeTest
		public void openBrowser () {
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}
	@Test
	
	public void verifyFligtBooking() throws IOException {
		try {
			driver.findElement(By.name("userName")).sendKeys("mercury1");
			driver.findElement(By.name("password")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			
			driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(9) > td:nth-child(2) > font > font > input[type=radio]:nth-child(2)"));
			driver.findElement(By.name("findFlights")).click();
			
			driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9) > tbody > tr:nth-child(5) > td.frame_action_xrows > input[type=radio]")).click();
			driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(10) > tbody > tr:nth-child(5) > td.frame_action_xrows > input[type=radio]")).click();
			driver.findElement(By.name("reserveFlights")).click();
			
			driver.findElement(By.name("passFirst0")).sendKeys("Jhon");
			driver.findElement(By.name("passLast0")).sendKeys("Smith");
			driver.findElement(By.name("creditnumber")).sendKeys("456321789");
			driver.findElement(By.name("buyFlights")).click();
			
			String actualText = driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p > font > b > font:nth-child(2)")).getText();
			String expectedText = "Your itinerary has been booked!";
			
			Assert.assertEquals(actualText, expectedText);
		} catch (Exception ex) {
			takeScreenshot();
			Assert.fail("Script failed due to Exception" +ex);
		}
		

		
		
	}
	private void takeScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\New folder\\screenshot"+(new Random().nextInt())+".jpg"));
		
	}
	@AfterTest
	  public void closeBrowser() {
	    driver.close();
		
	}
}