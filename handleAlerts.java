package Trainings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handleAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\selenium java client\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.tizag.com/javascriptT/javascriptalert.php";
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath("html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input")).click();
		driver.switchTo().alert();
		
		System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().sendKeys("Hi"); // to send text in to the alerts 
		
		driver.switchTo().alert().accept();// for yes, ok, done buttons
		
		//driver.switchTo().alert().dismiss();// for cancel, no
	}

}
