import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeTabDemo 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String>handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		String parentId=it.next();
		String childId=it.next();
		
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/#/index");
		
		String courseName=driver.findElements(By.xpath("//div[@class='upper-box'] //a")).get(0)
				.getText();
		
		driver.switchTo().window(parentId);
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		
		// Capture screenshot of webelement
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("name.jpg"));
		
		// Get height & width of webelement
		System.out.println("Height: "+name.getRect().getDimension().getHeight());
		System.out.println("Width: "+name.getRect().getDimension().getWidth());
	}
}
