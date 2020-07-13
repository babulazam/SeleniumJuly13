package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) {
		WebDriver driver;
		
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		String actual_Value = driver.getTitle();
		String expected_Value = "Facebook - Log In or Sign Up";
		
		if(actual_Value.equals(expected_Value)) {
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}

		driver.close();
	}

}
