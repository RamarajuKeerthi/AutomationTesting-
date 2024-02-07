package riyaz_Sir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesAutomation 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void propertiesAutomation( ) throws IOException, InterruptedException
	{
		String path="E:\\RAMARAJU\\AutomationTesting\\src\\test\\resources\\PropertiesFile\\Adactinhotelapp.Properties";
		FileInputStream file= new FileInputStream(path);
		Properties pop=new Properties();
		pop.load(file);
		
		String r=pop.getProperty("url");
		String r1=pop.getProperty("username");
		String r2=pop.getProperty("password");
		
		driver.get(r);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(r1);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(r1);
		driver.findElement(By.xpath("//*[@name='login']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
	
}
