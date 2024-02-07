package riyaz_Sir;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandilIfram
{	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();
	}
	@Test
	public void handleWindows() throws InterruptedException
	{
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//*[@href='monkeyspaw.htm']")).click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@href='http://users.ipa.net/%7Edjhill/frmain.html']")).click();
		
	}	
	@AfterMethod
	public void close() throws InterruptedException
	{
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		driver.close();
	}
}
