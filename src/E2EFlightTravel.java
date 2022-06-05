import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2EFlightTravel 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='PNQ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"))
			System.out.println("Second calender is enabled");
		else
			System.out.println("Second calender is disabled");
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		
		for(int i=0; i<4;i++)
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		WebElement items=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		
		Select dropdown=new Select(items);
		
		dropdown.selectByIndex(2);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
	}
}
