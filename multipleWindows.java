package Trainings;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindows {
public static void main (String[] args)
{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://accounts.google.com/SignUp";
	driver.manage().window().maximize();
    driver.get(baseUrl);
    driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
    
    System.out.println(driver.getTitle());
    Set<String>ids = driver.getWindowHandles();
    Iterator<String>it=ids.iterator();
    String parentid = it.next();
    String childid = it.next();
    driver.switchTo().window(childid);
    System.out.println(driver.getTitle());
    
    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/p/a")).click();
    Set<String>ids1 = driver.getWindowHandles();
    Iterator<String>it1=ids1.iterator();
    String parentid1 = it1.next();
     String childid1 = it1.next();
    String child2 = it1.next();
    driver.switchTo().window(child2);
    System.out.println(driver.getTitle());
    
    driver.switchTo().window(parentid);
    System.out.println(driver.getTitle());
    
    
}

}
