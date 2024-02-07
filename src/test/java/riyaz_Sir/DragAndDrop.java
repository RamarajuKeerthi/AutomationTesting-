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

public class DragAndDrop 
{
	WebDriver driver;
	 Actions action;
	 
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
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
	public void dragAndDrop () throws InterruptedException
	{
		driver.switchTo().frame(0);
		WebElement deag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(deag, drop).perform();

	}	
}
