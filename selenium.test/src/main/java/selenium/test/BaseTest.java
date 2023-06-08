package selenium.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameters;

public abstract class BaseTest {

	    protected WebDriver driver;
	    protected String baseUrl;

	    @BeforeTest
	  
	    public void setUp(@Optional("https://example.com") String baseUrl) {
	       // this.baseUrl = baseUrl;
	        // Initialize WebDriver and other setup steps
	        // ...
	        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	    }

	    @AfterTest
	    public void tearDown() {
	        // Quit WebDriver and perform cleanup steps
	        // ...
	    }
	}

	



