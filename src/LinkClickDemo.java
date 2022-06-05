import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkClickDemo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Count of total links on page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// to get count of links on footer section
		WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// to get count of links in 1st column of footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody//tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		// click on each link in 1st column and open in new tab
		int columnSize=columnDriver.findElements(By.tagName("a")).size();
		
		for(int i=1; i<columnSize;i++)
		{
			String linkPressKey = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(linkPressKey);
		}
		
		// get titles of each tab window and display in console
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}
}
