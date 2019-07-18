package demo;
// groups and parameters
//refer xml file 
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Groups_with_Parameters {

	WebDriver driver;

	@Test(groups = { "Regression1", "Smoke1" })
	public void Login() {

	}

	@Test(groups = { "Regression1" })
	@Parameters({"username", "password"})
	public void ApplicationLogin(String username, String password) {

		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Application loaded successfully");
	}
	// if we give priority it wont execute in alphabetical order
	@Test(groups = "Regression1")
	public void LoadAdmin() {
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
	}

	@Test(groups = "Smoke1")
	public void LoadPIM() {
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
	}

	@BeforeClass(groups = { "Regression1", "Smoke1" })
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VSPICT\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
	}

}
