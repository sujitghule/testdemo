package assignmentSelenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class alertpopupFramehandling 
{

	WebDriver driver;


	@Before
	public void setup() {

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");

	}

	public void switchToFrame() throws InterruptedException 
	{
		Actions hover= new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Alerts']")).click();

	}
	
	@Test @Ignore
	public void  Testcase_01() throws InterruptedException 
	{
		
		switchToFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]")).click();
		System.out.println("Testcase_01 : sucessfully");
	}
	
	
	@Test @Ignore
	public void Testcase_02() throws InterruptedException
	{
		switchToFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).click();
		
	
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		System.out.println("Alert bot text is ->" + alert.getText());
		Thread.sleep(2000);
		alert.dismiss();
		
		WebElement ConfirmMessage = driver.findElement(By.xpath("//p[@id='demo']"));
		
		
		Assert.assertEquals("You Pressed Cancel", ConfirmMessage.getText());
		Thread.sleep(2000);
		System.out.println("Testcase_02 : sucessfully");
	}

	@Test 
	public void Testcase_03() throws InterruptedException 
	{
		switchToFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		
		
		System.out.println("Testcase_03 : sucessfully");
	}






	@After
	public void teardown() 
	{
		driver.quit();
	}
}
