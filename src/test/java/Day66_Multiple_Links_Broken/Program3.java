package Day66_Multiple_Links_Broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		System.out.println("Total links found :"+links);
		
		int brokenLinkCount  = 0;
		
		for(WebElement element : links) {
			
			String url = element.getAttribute("href");
			
			//skip empty or null url
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL is empty or null , skipping");
				continue;
			}
			
			try {
				URL link = new URL(url);
				//Open HTTP connection
				
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.setConnectTimeout(4000);
				httpconn.connect();
				
				int responseCode = httpconn.getResponseCode();
				
				if(responseCode >= 400) {
					
					System.out.println(responseCode + "--->" + url + "| BrokenLink");
					brokenLinkCount++;
				}
				else {
					System.out.println(responseCode + "--->" + url + "| Valid Link");
				}
				
				
			} catch (Exception e) {
				System.out.println("Expection for URL : "+ url);
				e.printStackTrace();
			}
		}
		
		System.out.println("Total broken Links : "+brokenLinkCount);
		
	}

}