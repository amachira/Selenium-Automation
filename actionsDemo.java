package Trainings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
public static void main (String[] args)
{
	 System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		//implicitly wait where we declared globally to wait for 10 seconds before throwing a rejection.
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String baseUrl = "https://www.amazon.com/";
		driver.manage().window().maximize();
	driver.get(baseUrl);
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
	//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipad air 2 case");
	    driver.findElement(By.cssSelector("input.nav-input")).click();
	    driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("img[alt=\"Plastic\"]")).click();
	   a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[2]/input"))).click().sendKeys("20").build().perform();
	 //  a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[2]/input"))).sendKeys("20").build().perform();
	   a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[4]/input"))).click().sendKeys("100").build().perform();
	   //a.moveToElement(driver.findElement(By.xpath("//*[@class='customPriceV2']/form/table/tbody/tr/td[4]/input"))).sendKeys("100").build().perform();
	   a.moveToElement(driver.findElement(By.cssSelector("input.leftNavGoBtn"))).click().build().perform();
	a.moveToElement(driver.findElement(By.xpath(".//*[@name='B00PUOK150']/span/a/i[1]/span"))).clickAndHold().build().perform();
	
    a.click().build().perform();
    //System.out.println(driver.findElement(By.xpath(".//*[@id='result_0']/div/div[6]/span/span/a/i[1]/span")).getText());

    System.out.println(driver.findElement(By.xpath(".//*[@id='a-popover-content-3']/div/div/div/div[1]/span")).getText());
  
	

}
}
