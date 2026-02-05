package Day66_Multiple_Links_Broken;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		
		//Navigate to URL
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links "+links );
		
		int brokenlink = 0; 
		
		for(WebElement element : links)
		{
			String url = element.getAttribute("href");
			
			if(url==null||url.isEmpty())
			{
				System.out.println("Empty URls");
				continue;
			}
			
			try {
				URL link = new URL(url); 
				
				HttpsURLConnection httpsConn = (HttpsURLConnection) link.openConnection();
				httpsConn.setConnectTimeout(5000); 
				httpsConn.connect(); 
				
				int responseCode = httpsConn.getResponseCode();
				
				if(responseCode>400)
				{
					System.out.println(responseCode + "--->" + url + "| BrokenLink");
					brokenlink++; 
				}
				else
				{
					System.out.println(responseCode + "--->" + url + "| Valid Link");
				}}
				catch(Exception e)
				{
					System.out.println();
					e.printStackTrace();
				}
				
				System.out.println("Broken Link Count "+brokenlink);
				
			}
		}
		
		
			
	}

