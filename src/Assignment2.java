import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys("Ajinkya");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajinkya@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("ajinkya123");
		
		driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
		
		WebElement gender=driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		
		Select dropdown= new Select(gender);
		
		dropdown.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("07/06/1995");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	}
}
