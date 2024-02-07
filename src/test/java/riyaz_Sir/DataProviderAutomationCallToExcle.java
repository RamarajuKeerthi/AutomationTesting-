package riyaz_Sir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAutomationCallToExcle
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
	public Object[][] getdata() throws IOException
	{
		String path="E:\\RAMARAJU\\AutomationTesting\\src\\test\\resources\\Book2.xlsx";
		
		FileInputStream fs=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		Sheet sh=wb.getSheet("rr");
		int rows=sh.getPhysicalNumberOfRows()-1;
		int cell=sh.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj=new Object[rows][cell];
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cell; j++)
			{
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
	
		return obj;
		
	}

	
}
