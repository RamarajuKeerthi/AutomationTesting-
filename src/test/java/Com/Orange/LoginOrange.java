package Com.Orange;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrange 
{
	@Test
	public void lginOrange () throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		driver.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
		
		WebElement all = driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[2]"));
		all.click();
		driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-link'])[1]")).click();
		
		/*for (int i = 0; i <all.size() ; i++) 
		{
			WebElement aa=all.get(i);
			if (!aa.isSelected()) 
			{
				all.get(i).click();
			}
			
			for (int j = 0; j <all.size(); j++) 
			{
				System.out.println(all.get(j).getAttribute("oxd-table-decorator-card"));
			}
		
		}*/
		Thread.sleep(5000);
		driver.quit();
	}
}
