package com.cleartripRoundTrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingFlight {

	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Test WorkSpace\\ClearTrip\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);

		// driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com");
		
		WebDriverWait wait= new WebDriverWait(driver, 30);

		//--------------------------------------------------------------------
		
		WebElement roundTripButton=driver.findElement(By.id("RoundTrip"));
		roundTripButton.click();
		
//		driver.findElement(By.id("FromTag")).sendKeys("mumbai");
		WebElement fromTextbox=driver.findElement(By.id("FromTag"));
		fromTextbox.sendKeys("Mumbai");
		
		WebElement Mumbai=driver.findElement(By.xpath("//a[contains(@id,'ui-id')]"));
		
		Actions action= new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(Mumbai));
		
		action.moveToElement(Mumbai).click().build().perform();
		
		
		WebElement ToTextbox=driver.findElement(By.id("ToTag"));
		ToTextbox.sendKeys("nagpur");
		
		//can be written as
//		WebElement Nagpur = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[contains(text(),'Nagpur, IN - Dr. Babasaheb Ambedkar (NAG)')]")));

		WebElement Nagpur =driver.findElement(By.xpath("//a[contains(text(),'Nagpur, IN - Dr. Babasaheb Ambedkar (NAG)')]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(Nagpur));
		
		action.moveToElement(Nagpur).click().build().perform();
		
		//-----------------------------------------------------------------------------
	}

}
