package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login 
{
	WebDriver driver;
	@Given("user open {string} browser")
	public void user_open_browser(String browser) 
	{
		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}

	@Then("launch url {string}")
	public void launch_url(String url)
	{
	    driver.get(url);
	}

	@When("enter text {string} using xpath {string}")
	public void enter_text_using_xpath(String text, String xpath) 
	{
	    driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("enter password {string} using xpath {string}")
	public void enter_password_using_xpath(String password, String xpath) 
	{
		driver.findElement(By.xpath(xpath)).sendKeys(password);
	}

	@When("click button {string}")
	public void click_button(String xpath) 
	{
	   driver.findElement(By.xpath(xpath)).click();
	}

	@Then("close")
	public void close() 
	{
	   driver.close();
	}
}
