package selenium.test;

import org.testng.annotations.Test;

@Test
public class TestClass  extends BaseTest{
	   
	   
    HomePage homePage = new  HomePage  (driver);


   @Test
   public void test1() {
       System.out.println("test 1 method starts here");
       homePage.clickLogin();
   }
   
   @Test
   public void test2() {
       System.out.println("Test 2 method starts here");
       System.out.println("Shared Value in Test 2: " );
   }
}
