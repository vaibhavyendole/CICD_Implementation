package Day50_Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
				/*
		         * XPath by Attribute
		         * ------------------
		         * Syntax:
		         *      //tagName[@attributeName='attributeValue']
		         *
		         * Example:
		         *      //input[@id='email']
		         *
		         * Used when:
		         * - Element has unique stable attribute (id, name, type, class, etc.)
		         * - ID/Name is available and reliable
		         */
		//Open the Browser
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.facebook.com/");
		
		 // Enter username using XPath by attribute (id)
		
		
		WebElement ID = driver.findElement(By.id("email"));
		ID.sendKeys("Test"); 
		
		WebElement Password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		Password.sendKeys("Password");
		
		WebElement Login = driver.findElement(By.name("login"));
		
		Login.click();
		
		//Xpath by Attribute
		WebElement Password2 = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		
		//Xpath by Text Value
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")); 
		
		//Xpath by Contain - Text
		driver.findElement(By.xpath("//a[contains(text(),'Forgotten')]")); 
		
		//Xpath by Contains - Attribute
		driver.findElement(By.xpath("//a[contains(@href,'=facebook_login')]"));
		
		//linkText
		driver.findElement(By.linkText("Create a Page"));
		
		//partial Link text
		driver.findElement(By.partialLinkText("create"));
		
		//by Id 
		driver.findElement(By.id("email"));
		
		//by tagname
		driver.findElement(By.tagName("textarea"));
		
		//byName
		
		

	}

}
