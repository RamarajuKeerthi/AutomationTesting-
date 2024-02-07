package riyaz_Sir;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxAllCheked 
{
	private static final String JavascriptExecutor = null;
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void radioButtonCheked() throws InterruptedException
	{
		JavascriptExecutor scrol=(JavascriptExecutor)driver;
		scrol.executeScript("scroll(0,1200)");
		
		Thread.sleep(3000);
		
		List<WebElement> all = driver.findElements(By.xpath("//*[@name='option1']"));
		
		for (int i = 0; i < all.size(); i++) 
		{
			WebElement aa=all.get(i);
			if (!aa.isSelected()) 
			{
				all.get(i).click();
				Thread.sleep(3000);
			}
		}
		for (int i = 0; i < all.size(); i++) 
		{
			System.out.println(all.get(i).getAttribute("checked"));
		}
		
	}	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
