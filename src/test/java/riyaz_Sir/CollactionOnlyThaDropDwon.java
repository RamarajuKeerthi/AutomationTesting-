package riyaz_Sir;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CollactionOnlyThaDropDwon 
{
	@SuppressWarnings("deprecation")
	@Test
	public void collactionOnlyThaDropDwon () throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0, 10000)");*/
		
		WebElement rr=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		
		Select ram =new Select(rr);
		
		List<WebElement> links=ram.getOptions();
		
		System.out.println(links.size());
		
		/*for (int i = 0; i < links.size(); i++)
		{
			System.out.println(links.get(i).getText());
		}*/
		for (WebElement alllinks : links) 
		{
			System.out.println(alllinks.getText());
		}
		
		Thread.sleep(3000);
		
		driver.quit();
			
	}
}
