import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableDemo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int noElements=driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]")).size();
		int sum=0, value=0;;
		for(int i=0;i<noElements;i++)
		{
			String text=driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]")).get(i).getText();
			value=Integer.parseInt(text);
			System.out.println(value);
			sum=sum+value;
		}
		System.out.println(sum);
		String actualValue=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int actValue=Integer.parseInt(actualValue);
		System.out.println(actValue);
		Assert.assertEquals(sum, actValue);
	}
}
