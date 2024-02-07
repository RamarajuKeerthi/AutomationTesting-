package riyaz_Sir;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MulitipleHandileWindows 
{
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void handleWindows() throws InterruptedException
	{
		String window=driver.getWindowHandle();
		
		System.out.println(window);
		
		driver.findElement(By.xpath("//*[@src='img/google-play.png']")).click();
		
		SwitchTiWindow("Adactin.com - Hotel Reservation System");
		
	
		
		driver.findElement(By.xpath("(//*[@class='VfPpkd-YVzG2b'])[5]")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().window(window);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@src='img/ios-button.png']")).click();
		
		SwitchTiWindow("TestFlight - Apple");
		
		
		
		driver.findElement(By.xpath("//a[text()='Quick Look']")).click();
		
		
		
	}
	private void SwitchTiWindow(String string) 
	{
		Set<String> all=driver.getWindowHandles();
		
		System.out.println(all);
		
		Iterator<String>a = all.iterator();
		
		while (a.hasNext())
		{
			driver.switchTo().window(a.next());
			String abe = driver.getTitle();
			
			try 
			{	
				
			} 
			catch (Exception e) 
				{
				
			}
		}
	}	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
		
	
}
