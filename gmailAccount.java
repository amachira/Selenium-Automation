package Trainings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmailAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			@SuppressWarnings("unused")
			String baseUrl;
			baseUrl= "https://accounts.google.com/";
			 //driver.get(baseUrl + "/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&scc=1&rip=1#identifier");
			driver.get("https://accounts.google.com/");
			driver.findElement(By.linkText("Create account")).click();
			driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("Anagesh");
			driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("Mac");
			driver.findElement(By.xpath(".//*[@id='GmailAddress']")).sendKeys("anageshmac");
			driver.findElement(By.xpath(".//input[@id='Passwd']")).sendKeys("bottle1234");
			driver.findElement(By.xpath(".//input[@id='PasswdAgain']")).sendKeys("bottle1234");
			driver.findElement(By.xpath(".//*[@id='BirthMonth']")).click();
		//	driver.findElement(By.xpath(".//*[@aria-activedescendent=':6']")).click();
			//driver.findElement(By.className("goog-menu goog-menu-vertical")).click();
			
		driver.findElement(By.xpath(".//*[@id=':7']")).click();
			//driver.findElement(By.xpath(".//*[@aria-owns=':6']")).();
		//	driver.findElement(By.xpath(".//*[@id='BirthDay']")).click();
			driver.findElement(By.xpath(".//*[@id='BirthDay']")).sendKeys("18");
			driver.findElement(By.cssSelector("[id=BirthYear]")).sendKeys("1987");
			driver.findElement(By.cssSelector("[id=Gender]")).click();	
			driver.findElement(By.xpath(".//div[@id='Gender']/div[2]/div[2]/div")).click();
			driver.findElement(By.cssSelector("input[id='RecoveryPhoneNumber']")).sendKeys("12345678887");	
			driver.findElement(By.cssSelector("#RecoveryEmailAddress")).sendKeys("an@gmail.com");
		
		
	}

}
