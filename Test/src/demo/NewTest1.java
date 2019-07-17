package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;

	@Test(priority = 0)
	public void loginToApplication() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 1, dependsOnMethods = { "loginToApplication" })
	public void searchForUser() throws InterruptedException {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("prasanth95");
		driver.findElement(By.className("searchbutton123")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 2, dependsOnMethods = { "searchForUser" })
	public void deleteTheUser() throws InterruptedException {
		driver.findElement(By.xpath("//tr[@class='odd']/td/input[@type='checkbox']")).click();
		// find delete button by id
		driver.findElement(By.id("btnDelete")).click();
		// find delete button by xpath
		// driver.findElement(By.xpath("//div[@class='top']/input[@type='submit' and
		// @class='delete']")).click();
		Thread.sleep(5000);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VSPICT\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
