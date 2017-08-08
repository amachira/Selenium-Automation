package Trainings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class reCaptcha {
public static void main (String[] args)
{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();
	String baseUrl = "http://www.cooperindustries.com/content/public/en/power_systems/contact-us.html";
	driver.manage().window().maximize();
    driver.get(baseUrl);
    System.out.println(driver.findElements(By.tagName("iframe")).size());
    if (driver.getPageSource().contains("I'm not a robot"));
    {
    	System.out.println("Pass");
    	
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.switchTo().frame(0);
    Actions a = new Actions(driver);
    a.moveToElement(driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]"))).build().perform();
    a.click(driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]"))).build().perform();
    a.click().build().perform();
    driver.switchTo().defaultContent();
    System.out.println(driver.findElements(By.tagName("iframe")).size());
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='recaptcha challenge']")));
    Actions a1 = new Actions(driver);
    a1.moveToElement(driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']"))).build().perform();
    a1.click(driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']"))).build().perform();
    a1.click().build().perform();
    
}
}
