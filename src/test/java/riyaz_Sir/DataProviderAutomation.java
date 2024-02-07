package riyaz_Sir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAutomation
{
	WebDriver driver;
	Actions action;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void closeChrome() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	@Test(dataProvider="getdata")
	public void  dataProviderAutomation(String UserName,String Password) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(UserName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='login']")).click();
	
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(Password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='login']")).click();
		
		
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="reyaz0310";
		obj[0][1]="reyaz123";
		
		obj[1][0]="reyaz0310";
		obj[1][1]="reyaz123";
		
		return obj;
		
	}

	
}
