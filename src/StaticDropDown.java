import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(2);
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		Thread.sleep(2000);
		int adult=4,child=2,infant=1,i=0;
		
		while(i<adult-1)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}
		i=0;
		while(i<child)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
			i++;
		}
		i=0;
		while(i<infant)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();
			i++;
		}
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='paxinfo']")).getText());
	}
}
