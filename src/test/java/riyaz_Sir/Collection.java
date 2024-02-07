package riyaz_Sir;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Collection 
{
	@Test
	public void  collection  ()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0, 10000)");
		
		WebElement rr=driver.findElement(By.xpath("(//*[@class='navFooterLinkCol navAccessibility'])[3]"));
		
		List<WebElement> links=rr.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++)
		{
			
			System.out.println(links.get(i).getText());
		}
		
		
		
		driver.quit();
	}
}
