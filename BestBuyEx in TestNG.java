import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BestBuyEx {
	private WebDriver driver;
	private String baseUrl;

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void beforetest() throws IOException
	{
	System.out.println("Delete Cookies");	
	//driver.manage().deleteAllCookies();
	System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
	//System.setProperty("webdriver.gecko.driver", "D:\\selenium java client\\geckodriver.exe");	
	
//	driver = new FirefoxDriver();
	driver = new ChromeDriver();	
//	driver.manage().deleteAllCookies();
	Properties prop1 = new Properties();
	FileInputStream fis = new FileInputStream("D:\\TestNGTraining\\datadriven.properties");
	prop1.load(fis);
//	System.out.print(prop.getProperty("url"));
	driver.get(prop1.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@class='modal fade email-submission-modal in']/div/div/div[1]/button/span[2]")).click();
	
	}
	
	@Test
	public void acntlogin1() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("D:\\TestNGTraining\\datadriven.properties");
	prop.load(fis);
	//System.out.print(prop.getProperty("url"));
	//driver.get(prop.getProperty("url"));
	
	WebDriverWait wd = new WebDriverWait(driver,20);
	wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='profileMenuWrap1']")));
	driver.findElement(By.xpath(".//*[@id='profileMenuWrap1']")).click();
	driver.findElement(By.xpath(".//*[@id='profileMenu1']/a")).click();
	driver.findElement(By.xpath(".//*[@id='fld-e']")).click();
	driver.findElement(By.xpath(".//*[@id='fld-e']")).clear();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//System.out.println(prop.getProperty("username"));
//	System.out.println(prop.getProperty("password"));
	String u = prop.getProperty("username");
	String p = prop.getProperty("password");
	
	driver.findElement(By.xpath(".//*[@id='fld-e']")).sendKeys(u);
    driver.findElement(By.xpath(".//*[@id='fld-p1']")).click();
	driver.findElement(By.xpath(".//*[@id='fld-p1']")).clear();
	driver.findElement(By.xpath(".//*[@id='fld-p1']")).sendKeys(p);
	driver.findElement(By.cssSelector(".cia-form__submit-button.js-submit-button")).click();
  
	}
	
    @Test(dataProvider = "getData", enabled = true)
	public void buyLaptops(String laptopname) throws AWTException
	{
    	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    	
    	driver.findElement(By.xpath("//*[@id='gh-search-input']")).click();	
	    driver.findElement(By.xpath("//*[@id='gh-search-input']")).clear();
	    driver.findElement(By.xpath("//*[@id='gh-search-input']")).sendKeys(laptopname);
	    driver.findElement(By.xpath(".//*[@id='header']/div[1]/div[2]/div[2]/form/button")).click();
	    WebElement prod = driver.findElement(By.xpath(".//*[@id='main-results']/div[3]/div[1]/div/div[2]/div/div[1]/h4/a"));
		
		
		Actions a = new Actions(driver);
	
		//a.moveToElement(driver.findElement(By.xpath(".//*[@id='main-results']/div[3]/div[1]/div/div[2]/div/div[1]/h4/a"))).contextClick().build().perform();
		a.moveToElement(prod);
		a.contextClick(prod).build().perform(); 
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		a.contextClick().release();
	}
		
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object[3][1];
		data[0][0] = "HP laptop";
		data[1][0] = "Dell laptop";
		data[2][0] = "Lenovo Laptop";
		return data;
	}
	
}