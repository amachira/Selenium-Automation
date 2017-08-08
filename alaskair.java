package Trainings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.InvalidArgumentException;

public class alaskair {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "D:\\selenium java client\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.alaskaair.com/";
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='oneWay']")).click();
		driver.findElement(By.xpath(".//*[@id='fromCity1']")).click();
		driver.findElement(By.id("fromCity1")).sendKeys("ABC");;
		driver.findElement(By.xpath(".//*[@id='toCity1']")).click();
		driver.findElement(By.xpath(".//*[@id='toCity1']")).sendKeys("LAX");

		driver.findElement(By.xpath(".//*[@id='departureDate1']")).sendKeys("04/24/17");
		driver.findElement(By.xpath(".//*[@id='adultCount']")).click();
		Select s = new Select(driver.findElement(By.id("adultcount")));
	//	s.selectByIndex(2);
		s.selectByValue("1 adult");


	}

}
