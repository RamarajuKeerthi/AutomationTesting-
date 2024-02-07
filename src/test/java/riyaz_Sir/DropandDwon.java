package riyaz_Sir;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropandDwon 
{
	@Test
	public void  dropandDwon ()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		WebElement rr=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		
		//rr.click();
		
		Select dropdwon=new Select(rr);
		
		
		dropdwon.selectByVisibleText("Baby");
		
		//dropdwon.selectByIndex(4);
		
		//dropdwon.selectByValue("search-alias=stripbooks");
		
		
		
		
		driver.quit();
	}
}
