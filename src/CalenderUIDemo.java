import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderUIDemo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		while(!driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).getText().equalsIgnoreCase("November 2022"))
		{
			driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='next']")).click();
		}
		
		int noDays=driver.findElements(By.xpath("//div[@class='datepicker-days'] //td[@class='day']")).size();
		System.out.println(noDays);
		for(int i=0;i<noDays;i++)
		{
			String day=driver.findElements(By.xpath("//div[@class='datepicker-days'] //td[@class='day']")).get(i).getText();
			if(day.equalsIgnoreCase("28"))
			{
				driver.findElements(By.xpath("//div[@class='datepicker-days'] //td[@class='day']")).get(i).click();
				break;
			}
		}
		
	}
}
