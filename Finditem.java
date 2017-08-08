package Trainings;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Pattern;
import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Finditem{
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		//  System.setProperty("webdriver.gecko.driver", "D:\\selenium java client\\geckodriver.exe");
			 System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
				 driver = new ChromeDriver();

		  //driver = new FirefoxDriver();
		  baseUrl = "https://www.amazon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitled2() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("twotabsearchtextbox")).click();
	    driver.findElement(By.id("twotabsearchtextbox")).clear();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipad air 2 case");
	    driver.findElement(By.cssSelector("input.nav-input")).click();
	    driver.findElement(By.cssSelector("img[alt=\"Plastic\"]")).click();
	  /*  driver.findElement(By.id("low-price")).clear();
	    driver.findElement(By.id("low-price")).sendKeys("20");
	    driver.findElement(By.id("high-price")).clear();
	    driver.findElement(By.id("high-price")).sendKeys("100");
	    driver.findElement(By.cssSelector("input.leftNavGoBtn")).click();
	    *///driver.findElement(By.linkText("4.6 out of 5 stars")).click();
	    
	    Actions a = new Actions(driver);
	    a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[2]/input"))).click().sendKeys("20").build().perform();
		 //  a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[2]/input"))).sendKeys("20").build().perform();
		   a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[4]/input"))).click().sendKeys("100").build().perform();
		   //a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[4]/input"))).sendKeys("100").build().perform();
		   a.moveToElement(driver.findElement(By.cssSelector("input.leftNavGoBtn"))).click().build().perform();

	    a.moveToElement(driver.findElement(By.xpath(".//*[@name='B00PUOK150']/span/a/i[1]/span"))).build().perform();
		
	    a.click().build().perform();
	    //System.out.println(driver.findElement(By.xpath(".//*[@id='result_0']/div/div[6]/span/span/a/i[1]/span")).getText());

	    System.out.println(driver.findElement(By.xpath(".//*[@id='a-popover-content-3']/div/div/div/div[1]/span")).getText());
	   
	  }

	  @After
	  public void tearDown() throws Exception {
//	    driver.quit();
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


