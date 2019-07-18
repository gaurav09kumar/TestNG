package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Groups {

	WebDriver driver;

	@Test(groups = { "Regression1" })
	public void Login() {

	}

	@Test(priority=0,groups = { "Regression1" })
	public void ApplicationLogin() {

		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Application loaded successfully");
	}
	// if we give priority it wont execute in alphabetical order
	@Test(priority=2,dependsOnGroups = "Regression1")
	public void LoadAdmin() {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
	}

	@Test(priority=1,dependsOnGroups = "Regression1")
	public void LoadPIM() {
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VSPICT\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
	}

}
