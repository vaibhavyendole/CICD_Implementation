package Day64_WebTable;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//Find out How many rows are there
		
		List<WebElement> RowCount= driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		int RC = RowCount.size(); 
		System.out.println(RC);
		
		//How many Colums 
		int NumCol = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th")).size();
		System.out.println("Col : "+NumCol);

		//Retrieve specific Cell
		
		String LtCountry = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[3]/td[3]")).getText();
		
		System.out.println(LtCountry);
		
		//Retrive All Col and Data
		
		for(int i =2; i<=RC; i++)
		{
			for(int j =1; j<=NumCol; j++)
			{
				String AllData= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print("All Data "+AllData);
				if(AllData.equals("Mexico"))
				{
					System.out.println("found Data At Row"+i+" Column"+j);
				}
			}
		}
		
		
	}

}
