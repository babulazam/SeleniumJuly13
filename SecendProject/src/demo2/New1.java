package demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class New1 {

	public static void main(String[] args) {
		System.setProperty("webDriver.Chrome.driver","Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up";
		
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Test case passed");
			
		}
		else {
			System.out.println("Test case failed");
		}
			driver.close();
	}

}
