package Day65_JavaScriptExcutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get("https://www.w3schools.com");
		
		//Scroll Down 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		js.executeScript("window.scrollBy(0, 4000);");
		
		//Scroll Up
		js.executeScript("window.scrollBy(0, -2000);");
		
		//Scroll Till element
		WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'W3Schools Spaces')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//Pass the Value
		WebElement username =driver.findElement(By.id("email"));
		WebElement passowrd =driver.findElement(By.id("pass"));
		WebElement loginBtn=driver.findElement(By.name("login"));
		
		js.executeScript("arguments[0].value='standard_user'", username);
		
		js.executeScript("arguments[0].value='secret_sauce'", passowrd);
		
		js.executeScript("arguments[0].click();", loginBtn);
	
		
		
		
		Thread.sleep(2000);
		

		
		
		

	}

}
