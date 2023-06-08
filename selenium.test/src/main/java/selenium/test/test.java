package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the Google homepage
	        driver.get("https://www.google.com");

	        // Find the search box element and enter a query
	        WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.sendKeys("Selenium WebDriver");
	        searchBox.submit();

	        // Wait for the search results to load
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Print the first search result title
	        WebElement firstResult = driver.findElement(By.cssSelector(".g .LC20lb"));
	        System.out.println("First search result: " + firstResult.getText());

	        // Close the browser window
	        driver.quit();
	        
	        System.out.println("close webdriver");
	        
	    }
	

}
