package selenium.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlwaysRuntest {

	@BeforeSuite
	public void failedBeforeSuite() {
		System.out.println("I'm beforeSuite. I should be alone in console log. Going to fail...");
		throw new RuntimeException();
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("BUG: I'm beforeTest and I was invoked (((( ");
		throw new RuntimeException();
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("BUG: I'm beforeClass and I was invoked (((( ");
		throw new RuntimeException();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("BUG: I'm beforeMethod and I was invoked (((( ");
		throw new RuntimeException();
	}

	@Test
	public void testMethod() {
		System.out.println("I'm testMethod");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("I'm testMethod");
	}
	
	
	
}
