package selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class test2 {

	 WebDriver driver;
	    ExtentReports extent;

	    @BeforeClass
	    public void setUp() {
	        // Set up the WebDriver
	       
	    	System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
	        driver = new ChromeDriver();

	        // Set up ExtentReports
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Report.html");

	        // Create an ExtentReports instance and attach the reporter
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // Create a test and log some information
	        ExtentTest test = extent.createTest("My First Test");
	        test.info("This is a test!");
	    }

	    @Test
	    public void validateNaukriURL() {
	        // ... Previous code to validate naukri.com URL
	    }

	    @Test
	    public void testSearchJobs() {
	        driver.get("https://www.naukri.com/");

	        // Locate search input field and search button
	        WebElement searchInput = driver.findElement(By.id("qsb-keyword-sugg"));
	        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn']"));

	        // Enter search query and click the search button
	        searchInput.sendKeys("Selenium");
	        searchButton.click();

	        // Wait for the search results to load
	        try {
	            Thread.sleep(5000); // Adjust the wait time according to the page load time
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Locate the list of search results
	        List<WebElement> searchResults = driver.findElements(By.xpath("//article[@class='jobTuple bgWhite br4 mb-8']"));

	        // Iterate through the search results and click on the search result with the title "Selenium Java"
	        boolean seleniumJavaFound = false;
	        for (WebElement searchResult : searchResults) {
	            String jobTitle = searchResult.findElement(By.className("title")).getText();
	            if (jobTitle.contains("Selenium Java")) {
	                searchResult.findElement(By.className("title")).click();
	                seleniumJavaFound = true;
	                break;
	            }
	        }

	        ExtentTest test = extent.createTest("Test Search Jobs and Select Selenium Java");
	       
			Assert.assertTrue(seleniumJavaFound, "Selenium Java search result not found.");
	        test.log(Status.PASS, "Selenium Java search result found and clicked.");
	    }

	    @AfterClass
	    public void tearDown() {
	        extent.flush();
	        driver.quit();
	    }
	}
