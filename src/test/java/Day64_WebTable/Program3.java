package Day64_WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		//How many Rows
		List<WebElement> rowList= driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		int rowCount = rowList.size(); 
		System.out.println("Row Count ="+ rowCount);
		
		// How many Cols
		List<WebElement> colList= driver.findElements(By.xpath("//table[@id=\"table1\"]/thead/tr/th"));
		int colCount = colList.size(); 
		System.out.println("Colum Number ="+ colCount);
		
		
		for(int i=1 ;i<=rowCount ;i++) {
			
			// String col =driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+i+"]/td")).getText();
		
			for(int j =1 ;j<= colCount ;j++) {
				
				String data =driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				
				System.out.print(data+" | ");
			}
			System.out.println();
		

	}
		}

}
