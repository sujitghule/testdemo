package assignmentSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assigment_8_ {


	String urlcheck ="http://automationpractice.com/index.php";

	String landingtitle ="My Store";
	
	By logoimg = By.xpath("//img[@class='logo img-responsive']");
	WebDriver driver;

	@Before
	public void setup()
	{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://automationpractice.com/");
	}

	@Test 
	public void test_1()
	{
		Assert.assertEquals(urlcheck, driver.getCurrentUrl());
		System.out.println("pass");
	}
	@Test
	public void test_2_()
	{
		Assert.assertEquals(landingtitle, driver.getTitle());
		System.out.println("pass second");
	}

@Test
public void test_3_() {
	WebElement logo = driver.findElement(logoimg);
	
	
	 
	 System.out.println("passs");
	
}

@Test@Ignore
public void test_4_() {
	WebElement height =driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
	
	
}
	@After
	public void teardown()
	{
		driver.quit();
	}
}
