package riyaz_Sir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick 
{
	
	WebDriver driver;
	Actions action;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	@AfterMethod
	public void closeChrome() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	@Test
	public void  rightClick  () throws InterruptedException
	{
		
		WebElement  rightClick  = driver.findElement(By.xpath("//*[@src='img/main-image-hotel-app.png']"));
		action.contextClick(rightClick).perform();
		//driver.findElement(By.xpath("//*[text()='Inspe]ct'")).click();
	}
	
	
	
	
	
	
}
