package testNG;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountSetup {
	
  @Test
  public void beforetest() throws IOException, SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QAdbt?verifyServerCertificate=false&useSSL=true", "root","");
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery("select * from logindtls");
		while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         String fname = rs.getString("firstname");
	         String lname = rs.getString("lastname");
	         String mailid = rs.getString("email_id");
	         String passwd1 = rs.getString("password1");
	         String passwd2 = rs.getString("passowrd2");
	         int phno  = rs.getInt("phone_number");
	         String number = Integer.toString(phno);
	         System.out.println("Database Connection");
	 		
	         //Display values
	         /*System.out.print(id);
	         System.out.print(fname);
	         System.out.print(lname);
	         System.out.print(mailid);
	         System.out.println(passwd1);
	         System.out.println(passwd2);
	         System.out.println(phno);*/	
	
	       System.setProperty("webdriver.chrome.driver", "D:\\selenium java client\\chromedriver_win32\\chromedriver.exe");	
			WebDriver  driver = new ChromeDriver();
			String baseUrl;
			baseUrl= "https://accounts.google.com/SignUp?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount";
			 //driver.get(baseUrl + "/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&scc=1&rip=1#identifier");
			driver.get(baseUrl);
		//	driver.findElement(By.linkText("Create account")).click();
			driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys(fname);
			driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(lname);
			driver.findElement(By.xpath(".//*[@id='GmailAddress']")).sendKeys(mailid);
			driver.findElement(By.xpath(".//input[@id='Passwd']")).sendKeys(passwd1);
			driver.findElement(By.xpath(".//input[@id='PasswdAgain']")).sendKeys(passwd2);
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
			driver.findElement(By.xpath(".//*[@id='RecoveryPhoneNumber']")).sendKeys(number);
//			driver.findElement(By.cssSelector("input[id='RecoveryPhoneNumber']")).sendKeys(phno);	
			driver.findElement(By.cssSelector("#RecoveryEmailAddress")).sendKeys("anagheswar@gmail.com");

	      }
	}


}