import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Ajinkya");
		
		driver.findElement(By.name("inputPassword")).sendKeys("ajinkya123");
		
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ajinkya");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ajinkya@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("98989898998");
		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		String pass=driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText().split("'")[1].trim();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Ajinkya");
		
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		
		
		
	}
}
