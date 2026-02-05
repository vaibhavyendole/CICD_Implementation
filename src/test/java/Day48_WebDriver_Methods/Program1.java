package Day48_WebDriver_Methods;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {
	public static void main(String[] args) {
		/*
		 * Methods - Close() | Quit()| get() | navigate() back refresh forward |
		 * 
		 * 
	     * Test Case:
	     * 1. Launch browser (Chrome)
	     * 2. Open application URL
	     * 3. Validate application title page
	     * 4. Close browser
	     */
		
		
		
		//Launch Chrome Browser
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Go to FB Url
		driver.get("https://www.facebook.com"); 
		
		//Get Title
		String actTitle = driver.getTitle(); 
		System.out.println(actTitle);
		
		//Validate Title
		String expTitle="Facebook – log in or sign up";
		if(actTitle.equals(expTitle))
				{
					System.out.println("TestCase Pass");
				}
		else
		{
			System.out.println("TestCase Fail");
		}
		
		// 5 Close Browser
        driver.close();
        
        
	}

}
