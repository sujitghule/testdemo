
package assignmentSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class mouseActions_ {

	WebDriver driver;

	@Before
	public void setup() 
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/droppable");
	}

	@Test 
	public void Testcase_01() throws InterruptedException
	{
		WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropArea=driver.findElement(By.xpath("//div[@id='droppable']"));


		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDrop(dragMe, dropArea).build().perform();


		System.out.println("Testcase_01 : successfully drop");  

	}
	@Test 
	public void Testcase_02() throws InterruptedException 
	{	

		driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
		Thread.sleep(2000);
		
		WebElement  AccetableDragme = driver.findElement(By.xpath("//div[normalize-space()='Acceptable']"));
		WebElement  dropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));

		
		Actions act = new Actions(driver);	
		act.dragAndDrop(AccetableDragme, dropHere).build().perform();
		Thread.sleep(5000);


		System.out.println("Testcase_02 : Accetable is successfully drop");  	
	}


	@After
	public void teardown() throws InterruptedException
	{

		driver.quit();
	}





}
