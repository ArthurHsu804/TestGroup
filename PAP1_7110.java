package grid;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class PAP1_7110 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String nodeUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://10.176.18.212/";
		
//本機端執行
//		System.setProperty("webdriver.ie.driver", "D:/testGroup/tools/selenium/IEDriverServer_Win32_2.52.0/IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		
		// driver = new FirefoxDriver();
//		 System.setProperty("webdriver.chrome.driver", "D:/testGroup/tools/selenium/chromedriver_win32/chromedriver.exe");
//		 driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		

// use selenium grid
		          
		nodeUrl = "http://10.175.2.27:4444/wd/hub"; //Machine-A IPAdress  with Port No.
		
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		//capability.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		//DesiredCapabilities capability = DesiredCapabilities.chrome();
	    //DesiredCapabilities capability = DesiredCapabilities.firefox();
		
//		capability.setBrowserName("internet explorer");
//		capability.setCapability("platform", "WINDOWS");

		driver = new RemoteWebDriver(new URL(nodeUrl), capability);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void testPAWebDriver() throws Exception {
		
		// 登入區域
		driver.get(baseUrl + "/INSWeb/#");
		driver.findElement(By.name("userID")).clear();
	    driver.findElement(By.name("userID")).sendKeys("S122531322");
	    driver.findElement(By.name("passWD")).clear();
	    driver.findElement(By.name("passWD")).sendKeys("S122531322");
	    driver.findElement(By.name("index_r7_c8")).click();
	    driver.findElement(By.id("SWITCHED_EMPLOYEE_ID_S122531322")).click();
		
		// 左邊menu Tree選綜
		driver.switchTo().frame("leftFrame");//注意要切回左邊,以免找不到element
		driver.findElement(By.xpath("//table[8]/tbody/tr/td[2]/a/strong")).click();
		driver.switchTo().frame("leftFrame");//注意要切回左邊,以免找不到element

		// 選到旅綜個人報備
		driver.findElement(By.cssSelector("#Link_6 > font")).click();
		driver.findElement(By.cssSelector("#Link_16 > font")).click();
		driver.switchTo().frame("mainFrame");//注意要切回中間,以免找不到element
		
		// 打單過程
		driver.findElement(By.id("CUSTOMER_NAME_OF_APPLICANT")).clear();
	    driver.findElement(By.id("CUSTOMER_NAME_OF_APPLICANT")).sendKeys("旅綜測試");
	    new Select(driver.findElement(By.id("IDNTFCTN_TYPE_OF_APPLICANT"))).selectByVisibleText("1:身分證號");
	    driver.findElement(By.id("CUSTOMER_ID_OF_APPLICANT")).clear();
	    driver.findElement(By.id("CUSTOMER_ID_OF_APPLICANT")).sendKeys("S122531322");
	    new Select(driver.findElement(By.id("RELATIVE_WITH_INSURED"))).selectByVisibleText("1:本人");
	    driver.findElement(By.id("APPLCNT_BIRTHDAY")).clear();
	    driver.findElement(By.id("APPLCNT_BIRTHDAY")).sendKeys("0680101");
	    driver.findElement(By.id("ZIP_CODE_OF_APPLICANT")).clear();
	    driver.findElement(By.id("ZIP_CODE_OF_APPLICANT")).sendKeys("110");
	    driver.findElement(By.id("ADDRESS_OF_APPLICANT")).clear();
	    driver.findElement(By.id("ADDRESS_OF_APPLICANT")).sendKeys("號");
	    driver.findElement(By.id("PHONE_CODE1_OF_APPLICANT")).clear();
	    driver.findElement(By.id("PHONE_CODE1_OF_APPLICANT")).sendKeys("02");
	    driver.findElement(By.id("PHONE1_OF_APPLICANT")).clear();
	    driver.findElement(By.id("PHONE1_OF_APPLICANT")).sendKeys("12345678");
	    driver.findElement(By.id("CUSTOMER_NAME_OF_INSURED")).clear();
	    driver.findElement(By.id("CUSTOMER_NAME_OF_INSURED")).sendKeys("旅綜測試");
	    driver.findElement(By.id("START_DATE")).clear();
	    driver.findElement(By.id("START_DATE")).sendKeys("1050310");
	    driver.findElement(By.id("START_TIME")).clear();
	    driver.findElement(By.id("START_TIME")).sendKeys("08");
	    driver.findElement(By.id("INSRNCE_DAY")).clear();
	    driver.findElement(By.id("INSRNCE_DAY")).sendKeys("2");
	    new Select(driver.findElement(By.id("TRAVEL_SITE"))).selectByVisibleText("1:國內");
	    driver.findElement(By.id("DEATH_DISABLER_INSURED")).clear();
	    driver.findElement(By.id("DEATH_DISABLER_INSURED")).sendKeys("100");
	    new Select(driver.findElement(By.id("IS_DDA"))).selectByVisibleText("0:否");
	    driver.findElement(By.id("RMBSMNT")).clear();
	    driver.findElement(By.id("RMBSMNT")).sendKeys("0");
	    driver.findElement(By.id("DISCOUNT_PREMIUM")).clear();
	    driver.findElement(By.id("DISCOUNT_PREMIUM")).sendKeys("36");
	    new Select(driver.findElement(By.id("TRAVEL_CONVNTE"))).selectByVisibleText("0:否");
	    new Select(driver.findElement(By.id("RATE_TYPE"))).selectByVisibleText("1:ㄧ般件");
	    driver.findElement(By.id("AGENT_ID")).clear();
	    driver.findElement(By.id("AGENT_ID")).sendKeys("S122531322");
	    driver.findElement(By.id("AGENT_ID")).sendKeys(Keys.TAB);
	    
	    
	    Thread.sleep(2000);
	    driver.findElement(By.id("btnInsert")).click();
//	    WebElement element3 = driver.findElement(By.id("btnInsert"));
//	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
//	    executor3.executeScript("arguments[0].click();", element3);
	    
	    Alert alert = driver.switchTo().alert();//
		System.out.println("@@@:" + alert.getText());
		alert.accept();//// Click on OK button on pop-up

		Thread.sleep(2000); //避免公會回來時(doInsert), 其他Ajax效果尚未作完,先等待
		boolean check = driver.findElement(By.id("btnPrint")).isEnabled();
		System.out.println("@@@@: is" + check);
		
		assertTrue(check);
		
	    
		
	   
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit(); // for testing
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
