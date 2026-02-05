package Day66_Multiple_Links_Broken;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Open the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		//Open the URl
		driver.get("https://www.facebook.com/");
		
		//Step 4 : Find all Anchors (<a>) 
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		System.out.println("Total link count: " + links.size());
        System.out.println("===================================");
        
        // Step 5: Iterate through each link
		for(WebElement link : links)
		{
			String linkText = link.getText();
			String linkURL = link.getAttribute("href");
			
			if(linkText.isEmpty())
			{
				 linkText = "(No Visible Text)";
			}
			if(linkURL.isEmpty())
			{
				linkURL = "(No URL)";
			}
		}
	}

}
