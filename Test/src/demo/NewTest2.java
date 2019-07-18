package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;

	@Test(priority=0,groups = { "Regression" })
	public void loginToApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VSPICT\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
}

	@Test(priority=1,groups= {"Regression"})
	public void searchForUser() throws InterruptedException {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("vbtest");
		driver.findElement(By.className("searchbutton")).click();
		System.out.println("S1");

	}

	@Test(priority=2,groups = "Regression")
	public void deleteTheUser() throws InterruptedException {
		driver.findElement(By.xpath("//tr[@class='odd']/td/input[@type='checkbox']")).click();
		// find delete button by id
		//driver.findElement(By.id("btnDelete")).click();
		// find delete button by xpath
		//driver.findElement(By.xpath("//div[@class='top']/input[@type='submit' and @class='delete']")).click();
		System.out.println("S2");

	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}
}
