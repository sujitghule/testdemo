package assignmentSelenium;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class assertionsCheck {
	WebDriver driver;
	String test1="xyz";
	String test2="xyz@gmail.com";
	@Before
	public void setup() 
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/text-box");					
	}

	@Test
	public void Testcase_01() throws InterruptedException
	{

		WebElement input1 =driver.findElement(By.xpath("//input[@id='userName']"));
		input1.sendKeys(test1);
		String inputValue=input1.getAttribute("value");				
		Assert.assertEquals(test1,inputValue);						//assertion method
		System.out.println("Testcase_01 : Username execution passed");

		Thread.sleep(3000);

		WebElement input2 =driver.findElement(By.xpath("//input[@id='userEmail']"));
		input2.sendKeys(test2);
		String inputValue2=input2.getAttribute("value");
		Assert.assertEquals(test2, inputValue2);					//assertion method
		System.out.println("Testcase_01 : Email execution passed");

		Thread.sleep(3000);
		
		WebElement input3 =driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		input3.sendKeys("abc,lmn,xyz-123");
		System.out.println("Testcase_01 : currentAddress execution passed");
		
		WebElement input4 =driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		input4.sendKeys("abc,lmn,xyz-123");
		System.out.println("Testcase_01 : permanentAddress execution passed");
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@id='submit']"));
		Actions act = new Actions(driver);							//actions method
		act.click();

		System.out.println("Sucessfully All details fill");

	}

	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
