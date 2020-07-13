package demo2;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouceHover {

	public static void main(String[] args) {
		WebDriver driver; 
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		WebElement accntlist = driver.findElement(By.id("nav-link-accountList"));
		
		Actions hover = new Actions(driver);
		hover.moveToElement(accntlist).perform();
		
		driver.findElement(By.linkText("Your Orders")).click();

		driver.close();
	}

}
