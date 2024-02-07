
package riyaz_Sir;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGXml_Automation
{
	@SuppressWarnings("deprecation")
	@Test
	@Parameters({"browser","username","password"})
	public void  testNGXml_Automation  (String browser,String username,String password ) throws InterruptedException
	{
		WebDriver driver=null;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='login']")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}
	
}
