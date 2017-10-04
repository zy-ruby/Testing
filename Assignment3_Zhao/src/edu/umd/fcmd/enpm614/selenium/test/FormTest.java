package edu.umd.fcmd.enpm614.selenium.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {

private static WebDriver driver;
	
	@Before //or @BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/zhaoyu/Desktop/cs/" + "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/form.jsp");
//		System.out.println("hey we go3");
	}

	@After //or @AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testClickColors() {
		ArrayList<WebElement> colors = (ArrayList<WebElement>) driver.findElements(By.name("colors"));
		WebElement red = colors.get(0);
		assertTrue(red.isDisplayed());
		assertTrue(red.isEnabled());
		assertTrue(!red.isSelected());
		red.click();
		assertTrue(red.isSelected());
		WebElement white = colors.get(1);
		assertTrue(!white.isSelected());
		white.click();
		assertTrue(white.isSelected());
		WebElement blue = colors.get(2);
		assertTrue(!blue.isSelected());
		blue.click();
		assertTrue(blue.isSelected());
	}
	
	@Test
	public void testAgree() {
		WebElement agree = driver.findElement(By.name("agree"));
		assertTrue(agree.isDisplayed());
		assertTrue(agree.isEnabled());
		assertTrue(!agree.isSelected());
		agree.click();
		assertTrue(agree.isSelected());
	}
	

	@Test
	public void testSubmit() {
		WebElement toyForm = driver.findElement(By.name("toyForm"));
		WebElement characters = driver.findElement(By.name("characters"));
		characters.sendKeys("abc");
		ArrayList<WebElement> colors = (ArrayList<WebElement>) driver.findElements(By.name("colors"));
		WebElement red = colors.get(0);
		red.click();
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();
		toyForm.submit();
		WebElement charRev = driver.findElement(By.name("charRev"));
		assertEquals("abc",charRev.getAttribute("value"));
		WebElement colRev = driver.findElement(By.name("colRev"));
		assertEquals("red",colRev.getAttribute("value"));
		WebElement agrRev = driver.findElement(By.name("agrRev"));
		assertEquals("agree",agrRev.getAttribute("value"));
	}
	
	@Test
	public void testSubmitBlankCharacters() {
		WebElement toyForm = driver.findElement(By.name("toyForm"));
		WebElement characters = driver.findElement(By.name("characters"));
		characters.sendKeys("");
		ArrayList<WebElement> colors = (ArrayList<WebElement>) driver.findElements(By.name("colors"));
		WebElement red = colors.get(0);
		red.click();
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();
		toyForm.submit();
		WebElement error = driver.findElement(By.name("error"));
		assertEquals("some fields were left empty...",error.getAttribute("value"));
	}
	
	@Test
	public void testSubmitBlankColors() {
		WebElement toyForm = driver.findElement(By.name("toyForm"));
		WebElement characters = driver.findElement(By.name("characters"));
		characters.sendKeys("abc");
		WebElement agree = driver.findElement(By.name("agree"));
		agree.click();
		toyForm.submit();
		WebElement error = driver.findElement(By.name("error"));
		assertEquals("some fields were left empty...",error.getAttribute("value"));
	}
	

	@Test
	public void testSubmitBlankAgree() {
		WebElement toyForm = driver.findElement(By.name("toyForm"));
		WebElement characters = driver.findElement(By.name("characters"));
		characters.sendKeys("abc");
		ArrayList<WebElement> colors = (ArrayList<WebElement>) driver.findElements(By.name("colors"));
		WebElement red = colors.get(0);
		red.click();
		toyForm.submit();
		WebElement error = driver.findElement(By.name("error"));
		assertEquals("some fields were left empty...",error.getAttribute("value"));
	}
}
