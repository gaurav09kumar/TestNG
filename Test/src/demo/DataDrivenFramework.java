package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataDrivenFramework {
	WebDriver driver;

	@Test(dataProvider="getData")
	public void f(String username, String password) {
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtUsername']/following::input[1]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='txtUsername']/following::input[2]")).click();
	}
	@DataProvider(name="getData")
	public Object getdata() {
		Object[][] data= new Object[3][2];
		
		data[0][0]= "Admin1";
		data[0][1]= "admin";
		
		data[1][0]= "Admin1";
		data[1][1]= "admin";
		
		data[2][0]= "Admin";
		data[2][1]= "admin123";
		return data;
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
