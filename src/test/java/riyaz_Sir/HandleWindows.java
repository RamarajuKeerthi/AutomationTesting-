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

public class HandleWindows 
{
	WebDriver driver;
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
	public void handleWindows()
	{
		String window=driver.getWindowHandle();
		System.out.println(window);
		driver.findElement(By.xpath("//*[@src='img/google-play.png']")).click();
		
		SwitchTiWindow();
		
	}
	private void SwitchTiWindow() 
	{
		Set<String> all=driver.getWindowHandles();
		Iterator<String>a = all.iterator();
		while (a.hasNext())
		{
			driver.switchTo().window(a.next());
			try 
			{	
				driver.findElement(By.xpath("(//*[@class='VfPpkd-YVzG2b'])[5]")).click();	
			} 
			catch (Exception e) 
				{
				
			}
		}
	}	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
		
	
}
