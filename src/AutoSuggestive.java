import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("uni");
		Thread.sleep(3000);
		
		List<WebElement>options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("United Kingdom (UK)"))
			{
				option.click();
				break;
			}
		}
		
	}
}
