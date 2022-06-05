import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkDemo 
{
	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int totalLinks = footer.findElements(By.tagName("a")).size();
		
		for(int i=0;i<totalLinks;i++)
		{
			String url=footer.findElements(By.tagName("a")).get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode=conn.getResponseCode();
			if(statusCode>400)
				System.out.println(statusCode+" Link is Broken");
			else
				System.out.println(statusCode);
		}
	}
}
