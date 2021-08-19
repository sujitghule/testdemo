package assignmentSelenium;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertbox {
	WebDriver driver;


	@Before
	public void setup() {

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");

	}
	
	
	@Test
	public void Testcase_1() throws InterruptedException 
	{
		driver.findElement(By.xpath("//a[@href='#myModal']")).click();
		Thread.sleep(3000);

		
	Alert alert = driver.switchTo().alert();
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='myModal']//div[@class='modal-content']")));		
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='modal-body']//a[@class='btn btn-primary'][normalize-space()='Launch modal']")).click();
		Thread.sleep(3000);
		
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='myModal2']//div[@class='modal-content']")));
		
		String msg=driver.findElement(By.xpath("//div[@class='modal fade rotate in']//div[@class='modal-body'][contains(text(),'This is the place where the content for the modal ')]")).getText();
		System.out.println("msg:"+msg);
		String actual ="This is the place where the content for the modal dialog displays.";
		assertEquals(msg, actual);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='myModal2']//a[@class='btn']")).click();
		
		System.out.println("sucessfully");
	}
	
	@After
	public void teardown() 
	{
		driver.quit();
	}

}
