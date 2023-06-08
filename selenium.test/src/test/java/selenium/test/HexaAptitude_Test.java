package selenium.test;



	import java.util.List;
	import java.util.Random;
	import java.util.concurrent.ThreadLocalRandom;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;



public class HexaAptitude_Test {
	WebDriver driver;
	String baseurl;
	Actions actions;
	String email;
	String fname;
	int total_ques;

	public Boolean flag= true;


	@FindBy(xpath = "//a[@id='next_btn' and contains(@class, 'button')]")
	    WebElement NextBtn;

	@FindBy(xpath="//a[@id='nextsec_btn' and contains(@class, 'button')]")
	    WebElement ProceedToSectionBtn;

	@FindBy(id="endtest_btn")
	     WebElement EndTestBtn;

	@FindBy(xpath = "//div[1]/h5[contains(text(), 'Question')]")
	WebElement FirstQuestion;

	@BeforeTest
	public void SetUp() throws Exception {

	System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
	driver= new ChromeDriver();

	baseurl="https://assessments.firstnaukri.com/TE/712895243";

	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void HexaTest() throws Exception{
	driver.get(baseurl);
	actions = new Actions(driver);

	WebElement Name = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtname']"));   //enter username
	   WebElement Email = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtemail']")); //enter email
	   WebElement Master_Key= driver.findElement(By.xpath("//input[contains(@name,'ctl00$ContentPlaceHolder1$txtmasterkey') and @id='ctl00_ContentPlaceHolder1_txtmasterkey']"));
	   WebElement Submit= driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_Button1' and @value='Submit']")); //submit btn
	   
	   
	   Name.sendKeys(getRandomName());
	Email.sendKeys(getRandomEmail());
	Master_Key.sendKeys("a123456");
	Submit.click();



	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	//takes you to custom form


	driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Radhika Joshi\\Desktop\\definitions.png"); //uploading the image

	driver.findElement(By.id("text15490")).sendKeys(fname);  //firstname
	driver.findElement(By.id("text15491")).sendKeys("testlastname");
	   new Select(driver.findElement(By.name("text15492"))).selectByVisibleText("Female");  //select gender
	   driver.findElement(By.id("text15493")).sendKeys(email);   //input email
	   driver.findElement(By.id("confirmtext15493")).sendKeys(email); //confirm email
	   driver.findElement(By.id("text15494")).sendKeys("123456"); //phone no.
	   driver.findElement(By.id("text15495")).sendKeys("45678");  //alternate mobile no.
	   driver.findElement(By.id("text15496")).sendKeys("testguardian"+System.currentTimeMillis()); //guardian name
	   new Select(driver.findElement(By.name("text15497"))).selectByVisibleText("INDIAN");  //nationality
	   new Select(driver.findElement(By.name("day"))).selectByVisibleText("1");   //day
	   new Select(driver.findElement(By.name("month"))).selectByVisibleText("2");  //month
	   new Select(driver.findElement(By.name("year"))).selectByVisibleText("1966");  //year
	   driver.findElement(By.id("text15499")).sendKeys("abc park street"); //permanent address
	   driver.findElement(By.id("text15500")).sendKeys("xyz avenue");  //current address
	   driver.findElement(By.id("text15501")).sendKeys("test city");  //city name
	   new Select(driver.findElement(By.name("text15502"))).selectByVisibleText("Goa"); //state
	   driver.findElement(By.id("text15503")).sendKeys("123456"); //postal code
	   driver.findElement(By.id("text15504")).sendKeys("456123");  //college registration id
	   driver.findElement(By.id("text15505")).sendKeys("90");   // 10th %age
	   driver.findElement(By.id("text15506")).sendKeys("50");  //  12th %age
	   driver.findElement(By.id("text15507")).sendKeys("80"); // UG degree %age
	   new Select(driver.findElement(By.name("text15508"))).selectByVisibleText("2017"); //UG degree year of passing
	   new Select(driver.findElement(By.name("text15509"))).selectByVisibleText("B.Tech"); //UG Degree
	   new Select(driver.findElement(By.name("text15510"))).selectByVisibleText("CSE");
	   new Select(driver.findElement(By.name("text15511"))).selectByVisibleText("Goa"); //UG College state
	   driver.findElement(By.id("text15512")).sendKeys("Test College");  //U.G. College name
	   new Select(driver.findElement(By.name("text15513"))).selectByVisibleText("M.Tech");  //P.G. Stream
	   driver.findElement(By.id("text15514")).sendKeys("55");  //PG %age
	   new Select(driver.findElement(By.name("text15515"))).selectByVisibleText("2019"); //PG year
	   new Select(driver.findElement(By.name("text15516"))).selectByVisibleText("Goa");  //P.G. location
	   driver.findElement(By.id("text15517")).sendKeys("test PG college"); //P.G. college name
	   new Select(driver.findElement(By.name("text15518"))).selectByVisibleText("No"); //any backlogs
	   new Select(driver.findElement(By.name("text15520"))).selectByVisibleText("No"); //Gap in education
	   new Select(driver.findElement(By.name("text15522"))).selectByVisibleText("No"); //differently abled
	   
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	   actions.moveToElement(driver.findElement(By.id("btncussave"))).click().build().perform(); //click on save and continue
	   System.out.println("successfully clicked on save button");
	   
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.findElement(By.name("btn_redirect")).click();

	while(flag) {

	for(int i=0;i<numberOfQuesOnScreen();i++) {

	int j=i+1;
	System.out.println("i: "+i);
	System.out.println("j: "+j);


	int size= driver.findElements(By.xpath("//*[@id='quesdivshow']/div[1]/div/label")).size(); //size of the radio btn or checkbox

	System.out.println("total number of radio buttons on screen:"+size);

	WebElement RadioCheckBox = driver.findElement(By.xpath("//*[@id='quesdivshow']/div[" + j
	+ "]/div/label[" + getRandomInteger(1, size) + "]/input"));
	String str = RadioCheckBox.getAttribute("type");

	if (str.equals("radio")) {
	// actions.moveToElement(RadioCheckBox).click().build().perform();
	Thread.sleep(2000);

	actions.moveToElement(driver.findElement(By.xpath("//*[@id='quesdivshow']/div[" + j + "]/div/"
	+ "label[" + getRandomInteger(1, size) + "]/input"))).click().perform();

	}

	else if (str.equals("checkbox")) {
	Thread.sleep(2000);

	// driver.findElement(By.xpath("//*[@id='quesdivshow']/div["+j+"]/div/label["+TestUtil.getRandomInteger(1,3)+"]/input")).click();
	List<WebElement> elements = driver
	.findElements(By.xpath("//*[@id='quesdivshow']/div[" + j + "]/div/label/input"));
	for (WebElement el : elements) {
	actions.moveToElement(el).click().perform();
	}
	// actions.moveToElement(RadioCheckBox).click().build().perform();
	// actions.moveToElement(RadioCheckBox).click().build().perform();
	}
	}
	ClickNextButton();
	}

	}




	public String getRandomEmail() {
	String e_mail;
	// int randomInt=random.nextInt(10000);
	e_mail="testemail"+System.currentTimeMillis()+"@testmail.com";
	email=e_mail;
	System.out.println(email);
	return e_mail;
	}

	public String getRandomName() {
	String username;
	username ="testuser"+System.currentTimeMillis();
	fname=username;
	System.out.println(fname);
	return username;

	}

	public void ClickNextButton() throws InterruptedException {
	//clicks on next button

	actions=new Actions(driver);
	Thread.sleep(10000);

	/*if(NextBtn.isDisplayed()) {
	  actions.moveToElement(NextBtn).click().perform();
	  flag= true;

	}*/
	if(driver.findElement(By.xpath("//a[@id='next_btn' and contains(@class, 'button')]")).isDisplayed()) {
	actions.moveToElement(driver.findElement(By.xpath("//a[@id='next_btn' and contains(@class, 'button')]"))).click().perform();
	  flag= true;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	 

	}
	else if(ProceedToSectionBtn.isDisplayed()) {
	actions.moveToElement(ProceedToSectionBtn).click().perform();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	flag= true;
	}

	else if(EndTestBtn.isDisplayed()) {
	try {
	actions.moveToElement(EndTestBtn).click().perform();
	flag=false;
	}
	catch(StaleElementReferenceException e) {
	actions.moveToElement(EndTestBtn).click().perform();
	flag=false;
	}
	}
	}

	public int numberOfQuesOnScreen() { // returns total number of questions on every screen.

	return driver.findElements(By.xpath("//h5[contains(text(), 'Question')]")).size();
	}

	public void TotalNo0fQuestions() { // total number of questions in the test
	String str = FirstQuestion.getText();
	String que_str = str.replace("Question 1 of ", "");

	try {
	total_ques = Integer.parseInt(que_str.trim());
	System.out.println("Total number of ques: " + total_ques);
	} catch (NumberFormatException e) {
	System.out.println("Number Format Exception: " + e.getMessage());
	}

	}

	      public int getRandomInteger(int min, int max) {

	return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	}  
