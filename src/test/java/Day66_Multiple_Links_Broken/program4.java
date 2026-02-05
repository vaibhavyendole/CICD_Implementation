package Day66_Multiple_Links_Broken;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class program4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		//Navigate to URL
		driver.get("http://www.deadlinkcity.com/");
		
		//Get List of Links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links : "+links.size());
		
		int brokenLinkcount = 0; 
		
		//For Loop - Handle All Url
		for(WebElement element : links)
		{
			String url = element.getAttribute("href");
			
			if(url.isEmpty() || url == null)
			{
				System.out.println();
				System.out.println("URL is empty or null , skipping");
				continue;
			}
			
			try {
				
				URL link = new URL (url);
				
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection(); 
				httpconn.setConnectTimeout(5000);
				httpconn.connect();
				
				 int responseCode = httpconn.getResponseCode();
				 
				 if(responseCode>=400)
				 {
					 System.out.println(responseCode + "--->" + url + "| BrokenLink");
					 brokenLinkcount++;
				 }
				 else
				 {
					 System.out.println(responseCode + "--->" + url + "| Valid Link");
				 }
				 
			} catch(Exception e)
			{
				System.out.println("Expection for URL : "+ url);
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Total broken Links : "+ brokenLinkcount);
	}

}
