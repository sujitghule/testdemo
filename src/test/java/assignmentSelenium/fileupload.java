package assignmentSelenium;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileupload {

	WebDriver driver;

	@Before
	public void setup()
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");


	}

	@Test
	public void Testcase_01() throws InterruptedException
	{
		WebElement choosefile=driver.findElement(By.xpath("//input[@id='imagesrc']"));
		choosefile.sendKeys("C:\\Users\\ghule\\Downloads\\online food ordering  project (1).docx");
		
		System.out.println("Testcase_01 : File upolad sucessfully");

		Thread.sleep(3000);
	}


	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
}
