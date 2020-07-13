package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		
		String actual_Value = driver.getTitle();
		String expected_Value = "Facebook–log in or sign up";
		
		
		if(expected_Value.equals(actual_Value)) {
			System.out.println("Test Case Passed");
		}
		else 
		{
			
		System.out.println("Test Case Failed");
		}
	
		driver.close();



	}

}
