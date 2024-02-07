package riyaz_Sir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHanding 
{
	WebDriver driver;
	Actions action;
	 
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
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
		
		driver.findElement(By.xpath("//*[@name='proceed']")).click();
		
		Thread.sleep(5000);
		
		Alert rr=driver.switchTo().alert();
		
		rr.accept();
		
		driver.findElement(By.xpath("//*[@id='login1']")).sendKeys("rama122");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@name='proceed']")).click();
		
		rr=driver.switchTo().alert();
		
		Thread.sleep(5000);
		
		rr.accept();
		
		//System.out.println(rr.getText());
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("rama@122");
		
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@name='proceed']")).click();
		
		System.out.println(rr.getText());
		
	}
}
