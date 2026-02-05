package Day48_WebDriver_Methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 /*
         * ----------------------------------------------------------
         * Difference between get() and navigate()
         * ----------------------------------------------------------
         *
         * get(String URL)
         * - Used to open a webpage.
         * - Does NOT store browser history.
         * - Back, forward navigation is NOT supported.
         * - Page loads completely before next command runs.
         *
         * navigate().to(String URL)
         * - Also opens a webpage.
         * - Stores browser history.
         * - Supports back() and forward() navigation.
         * - Does NOT wait for complete page load (faster).
         *
         * Use get() → When simply opening the first URL.
         * Use navigate().to() → When switching between multiple URLs.
         *
         * ----------------------------------------------------------
         */
		
		
		//Open the Browser
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 driver.get("https://www.facebook.com/");
	     System.out.println("Title after get(): " + driver.getTitle());
	     
	     // navigate().to() method - opens another webpage
	     driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
	     Thread.sleep(2000);
	     driver.navigate().back();
	     
	     Thread.sleep(2000);
	     driver.navigate().forward();
	     
	     Thread.sleep(2000);
	     driver.navigate().refresh();
		

	}

}
