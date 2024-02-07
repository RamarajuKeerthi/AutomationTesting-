package riyaz_Sir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excle_Automation 
{
	@Test
	public void  collection  () throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		String path="E:\\RAMARAJU\\AutomationTesting\\src\\test\\resources\\Excle.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		
		Workbook wb=WorkbookFactory.create(file);
		
		Sheet scarch= wb.getSheet("Sheet1");
		
		int count=scarch.getPhysicalNumberOfRows();
		
		for (int i = 0; i < count; i++) {
			
			String ram=scarch.getRow(i).getCell(0).getStringCellValue();
			
			WebElement rr=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
			
			Thread.sleep(3000);
			
			rr.clear();
			
			rr.sendKeys(ram);
			
			rr.submit();
			
		}
			driver.quit();
	}
}
