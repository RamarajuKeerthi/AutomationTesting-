package riyaz_Sir;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.store.Locale;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetScreenShot
{
	WebDriver driver;
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
		driver.quit();
	}
	@Test
	public void tekeScreenShot() throws InterruptedException, ParseException, IOException
	{
		String pattern = "dd-M-yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		//System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		 File  src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	 
		 File file=new File ("E:\\RAMARAJU\\AutomationTesting\\src\\test\\resources"+date+".png");
		 FileUtils.copyFile(src, file);
	}		
}
