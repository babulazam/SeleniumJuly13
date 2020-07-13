package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.EqualsMethod;

public class Test2 {

	public static void main(String[] args) {
		WebDriver driver;
		
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("aeffghjv@gmail.com");
		driver.findElement( By.id("pass")).sendKeys("passs");
		driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div"));
		System.out.println("The email or phone number you’ve entered doesn’t match any account. Sign up for an account.");	
		
		String actualMsg = driver.findElement(By.id("error_box")).getText();
		System.out.println(actualMsg);
		
		String expectedMsg = "Wrong credentials\n" + 
				"Invalid username or password";
		
		if(actualMsg.equals(expectedMsg)) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
		driver.close();

		
		}
		
	}


