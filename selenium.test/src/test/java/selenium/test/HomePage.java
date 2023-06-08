package selenium.test;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject{

    public  HomePage  (WebDriver driver) {
        super(driver);
    }
   
    public void clickLogin() {
        System.out.println("Clicked login");
    }

}
 
