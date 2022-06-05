import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSortDemo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Test\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement>elements=driver.findElements(By.xpath("//tr/td[1]"));
		List<String>originalList=elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String>price=elements.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
	}

	private static String getPrice(WebElement s) {
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}
}
