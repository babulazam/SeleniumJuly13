package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlartBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver; 
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
		
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.close();		
	}


}
