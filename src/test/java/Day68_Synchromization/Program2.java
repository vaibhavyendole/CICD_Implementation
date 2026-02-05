package Day68_Synchromization;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		WebElement username = waitForVisibility(driver, By.name("username"), 10);
		username.sendKeys("Admin");
		
		WebElement password =  waitForVisibility(driver, By.name("password"), 15);
		password.sendKeys("admin123");
		
		WebElement loginBtn = waitForClickable(driver, By.xpath("//button[text()=' Login ']"),20 );
		loginBtn.click();
		
		//driver.quit();
		
		
	}
	
	public static WebElement waitForVisibility(WebDriver driver, By Locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)); 
	}
	
	public static WebElement waitForClickable(WebDriver driver, By Locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}

}
