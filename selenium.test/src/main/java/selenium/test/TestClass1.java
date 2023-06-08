package selenium.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass1 {
    @Test(dataProvider = "testData")
    public void testCase1(String data) {
        // Test case implementation
        System.out.println("Test Data: " + data);
    }

    @DataProvider(name = "testData")
    public Object[][] provideTestData() {
        return new Object[][]{
            {"Data 1"},
            {"Data 2"},
            {"Data 3"}
        };
    }
}
