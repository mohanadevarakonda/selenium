package selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest1 {

	 public WebDriver driver;
     @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
        
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        
            
    }
}
