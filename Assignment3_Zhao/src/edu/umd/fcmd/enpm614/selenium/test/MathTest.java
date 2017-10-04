package edu.umd.fcmd.enpm614.selenium.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MathTest {

	private static WebDriver driver;
	@Before //or @BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/zhaoyu/Desktop/cs/" + "chromedriver");
		driver = new ChromeDriver();
	}

	@After //or @AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testPlus() {
		driver.get("http://localhost:8888/math.jsp?param1=1&operation=plus&param2=2");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("3",result.getAttribute("value"));
	}
	
	@Test
	public void testPlus2() {
		driver.get("http://localhost:8888/math.jsp?param1=-10&operation=plus&param2=-20");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("-30",result.getAttribute("value"));
	}
	
	@Test
	public void testMinus1() {
		driver.get("http://localhost:8888/math.jsp?param1=1&operation=minus&param2=2");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("-1",result.getAttribute("value"));
	}
	
	@Test
	public void testMinus2() {
		driver.get("http://localhost:8888/math.jsp?param1=0&operation=minus&param2=-5");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("5",result.getAttribute("value"));
	}
	
	@Test
	public void testOtherOperation() {
		driver.get("http://localhost:8888/math.jsp?param1=0&operation=multiply&param2=-5");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("supported operations are 'plus' and 'minus' only...",result.getAttribute("value"));
	}
	
	@Test
	public void testNonInteger() {
		driver.get("http://localhost:8888/math.jsp?param1=1.0&operation=plus&param2=2");
		WebElement result = driver.findElement(By.name("result"));
		assertEquals("param1 and param2 must be integers...",result.getAttribute("value"));
	}

}
