import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class CheckBoxDemo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'IndArm')]")).isSelected());
		
		driver.findElement(By.xpath("//input[contains(@name,'IndArm')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'IndArm')]")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@name,'IndArm')]")).isSelected());
		
		//System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled());
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"))
			System.out.println("Enabled");
		else 
			System.out.println("Disabled");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"))
			System.out.println("Enabled");
		else 
			System.out.println("Disabled");
	}

}
