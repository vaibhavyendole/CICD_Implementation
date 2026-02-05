package Day64_WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		driver.get("https://practice.expandtesting.com/tables");
		
		//Find Table Rows Count
		List<WebElement> rowList =  driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		int rowCount = rowList.size();
		System.out.println("Row Count is : "+rowCount);
		
		//Find Table Column count
		List<WebElement>colList= driver.findElements(By.xpath("//table[@id=\"table1\"]/thead/tr/th"));
		int colCount = colList.size();
		System.out.println(colCount);
		
		//Find the Specific Element
		String specElement = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[2]/td[2]")).getText();
		System.out.println(specElement);
		
		//Validate Table Data
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=1; j<=colCount; j++)
			{
				String data = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(data.equalsIgnoreCase("tim"))
				{
					System.out.println("Value Time Find at Row "+i+ "and Column "+j);
				}
			}
		}
		
	}
	

}
