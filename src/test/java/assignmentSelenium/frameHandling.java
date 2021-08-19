package assignmentSelenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class frameHandling {

	WebDriver driver;

	@Before
	public void setup()
	{
		driver=new ChromeDriver();
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
		driver.findElement(By.xpath("//a[text()='Frames']")).click();

	}

	@Test
	public void Testcase_01() throws InterruptedException
	{
		switchToFrame();

		WebElement firstFrame =driver.findElement(By.xpath("//li[@class='active']/a[text()='Single Iframe ']"));
		firstFrame.click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));

		WebElement textBox1 = driver.findElement(By.xpath("//input[@type='text']"));
		textBox1.sendKeys("Automation testing");

		System.out.println("Test case_01 : Text sucessfully send in box");
		Thread.sleep(2000);

		System.out.println("Test case_01 : Single frame sucessfully done");

	}

	@Test @Ignore
	public  void Testcase_02() throws InterruptedException
	{
		switchToFrame();

		WebElement multiFrameButton = driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']"));
		multiFrameButton.click();
		Thread.sleep(2000);

		WebElement frame1=(driver.findElement(By.xpath("//div[@id='Multiple']//iframe")));
		driver.switchTo().frame(frame1);

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='row']/iframe")));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement textBox2 = driver.findElement(By.xpath("//input[@type='text']"));
		textBox2.sendKeys("Automation testing");

		System.out.println("Test case_02 : Text sucessfully send in box");
		Thread.sleep(5000);

		System.out.println("Test case_02 : Multiple frame sucessfully done");


	}

	@After
	public void teardown()
	{
		driver.quit();
	}

}
