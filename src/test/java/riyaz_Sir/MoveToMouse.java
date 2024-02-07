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

 
public class MoveToMouse 
{
	 WebDriver driver;
	 Actions action;
	 
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
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
	public void moveToMouse() throws InterruptedException
	{
		//WebElement ele= driver.findElement(By.xpath("(//*[@class='xtXmba'])[3]"));
		action.moveToElement(driver.findElement(By.xpath("(//*[@class='xtXmba'])[4]")))
				.pause(5000)
				.moveToElement(driver.findElement(By.xpath("(//*[@class='xtXmba'])[3]")))
				.click(driver.findElement(By.xpath("//*[text()='All']")))
				.build()
				.perform();
		/*Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='All']")).click();
		driver.navigate().back();*/
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[text()='All']")).click();
	}	
}
