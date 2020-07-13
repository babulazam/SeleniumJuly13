package demo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver; 
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		
		driver.findElement(By.cssSelector("#nav-search-dropdown-card > div")).click();
		
		driver.findElement(By.cssSelector("#searchDropdownBox > option:nth-child(10)")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirt");
		driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();
		//driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(17) > div > span > div > div > div:nth-child(4) > h2 > a > span")).click();
		Thread.sleep(5000);
		
		driver.close();

	}

}
