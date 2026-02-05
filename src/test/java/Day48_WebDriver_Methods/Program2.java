package Day48_WebDriver_Methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
	public static void main(String[] args) {
		
		//Open the Browser
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 1. get() method
        // This method is used to open an application by entering a URL in the browser.
        // It accepts a String URL as input.
		driver.get("https://www.amazon.in/"); 
		
		
		//2.GetTitle()
		String title = driver.getTitle();
		System.out.println("Page Title "+title);
		
		//3.getCurrent  Url
		String homePageURL = driver.getCurrentUrl();
		System.out.println("Home Page URL"+homePageURL);
		
		//CloseBrowser
		driver.close();
		
		
		
	}


}
