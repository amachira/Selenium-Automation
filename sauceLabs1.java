package Trainings;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class sauceLabs1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
DesiredCapabilities dc = DesiredCapabilities.chrome();
//dc.setCapability("version", "5");
dc.setCapability("platform", "Android");
WebDriver driver = new RemoteWebDriver(new URL("http://ana:a4ca4cbb-5db9-4a58-a66d-c0e1a9001de2@ondemand.saucelabs.com:80/wd/hub"),dc);

//String baseUrl = "https://www.makemytrip.com/";

driver.get("https://www.makemytrip.com/flights");

driver.findElement(By.xpath(".//*[@id='js-switch__option']/div[1]/label")).click();

// to use the isDisplayed functionality 
//Assert.assertFalse(driver.findElement(By.xpath(".//*[@id='js-MultiCityOptions']/div")).isDisplayed());

driver.findElement(By.xpath(".//*[@id='js-switch__option']/div[3]/label")).click();
//Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='js-MultiCityOptions']/div")).isDisplayed());
int count;
count = driver.findElements(By.xpath(".//*[@id='js-MulCityOptions']/div")).size();
if (count == 0)
{
	System.out.println("Element does not exist");
	
}

// to use the isEnabled functionality 
//System.out.println(driver.findElement(By.xpath(".//*[@id='hp-widget__return']")).isEnabled());
driver.findElement(By.xpath(".//*[@id='js-switch__option']/div[1]/label")).click();
System.out.println(driver.findElement(By.xpath(".//*[@id='hp-widget__return']")).isEnabled());
driver.findElement(By.xpath(".//*[@id='js-switch__option']/div[2]/label")).click();
System.out.println(driver.findElement(By.xpath(".//*[@id='hp-widget__return']")).isEnabled());

Thread.sleep(3000L);
driver.findElement(By.xpath(".//*[@id='js-switch__option']/div[2]/label")).click();
System.out.println(driver.findElement(By.xpath("html/body/div[1]/section/div/div[1]/h2")).getText());

driver.findElement(By.xpath(".//*[@id='hp-widget__sfrom']")).click();
driver.findElement(By.xpath(".//*[@id='hp-widget__sfrom']")).sendKeys("DEL");
//driver.findElement(By.xpath(".//*[@class='locationFilter autocomplete_to']/ul/li[2]/div/p/span[1]")).isSelected();

driver.findElement(By.xpath(".//*[@id='hp-widget__sTo']")).click();
driver.findElement(By.xpath(".//*[@id='hp-widget__sTo']")).sendKeys("GOA");	
//driver.findElement(By.xpath(".//*[@class='locationFilter autocomplete_from']/ul/li[6]")).click();	


driver.findElement(By.xpath(".//*[@id='hp-widget__depart']")).click();

driver.findElement(By.xpath(".//*[@class='dateFilter hasDatepicker']/div/div[1]/table/tbody/tr[3]/td[5]/a")).click();

driver.findElement(By.xpath(".//*[@id='hp-widget__return']")).click();
Thread.sleep(3000L);
driver.findElement(By.xpath(".//*[@class='dateFilterReturn hasDatepicker']/div/div[1]/table/tbody/tr[5]/td[5]/a")).click();


driver.findElement(By.xpath(".//*[@id='hp-widget__paxCounter']")).click();

driver.findElement(By.xpath(".//*[@id='js-adult_counter']/li[4]")).click();
driver.findElement(By.xpath(".//*[@id='js-child_counter']/li[4]")).click();

driver.findElement(By.xpath(".//*[@id='js-filterOptins']/div/div[9]/div/p/a")).click();

driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();	





	}

}
