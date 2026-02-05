package Day68_Synchromization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Create webDriverWait object
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("Admin"); 
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("admin123"); 
		
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']")));
		login.click();
		
		WebElement dashboardText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
	
		
		if (dashboardText.isDisplayed()) {
			System.out.println("PASS");
		} else {

			System.out.println("DAIL");
		}
	}
		
}
