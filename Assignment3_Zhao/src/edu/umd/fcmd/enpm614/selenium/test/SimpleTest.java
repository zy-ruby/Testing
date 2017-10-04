/**************************************************************************/
/* TODO get this simple test to run before starting the ToyWebApp testing */
/**************************************************************************/

package edu.umd.fcmd.enpm614.selenium.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO add necessary imports

public class SimpleTest {
	private static WebDriver driver;
	
	@Before //or @BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/zhaoyu/Desktop/cs/" + "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
	}

	@After //or @AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testWebTitle() {
		assertEquals(driver.getTitle(),"Assignment 3 Toy Web App");
	}
	
	@Test
	public void testBottom() {
		WebElement bottom = driver.findElement(By.className("bottom"));
		assertNotNull(bottom);
		assertEquals("Copyright © 2010 - 2016 CSFalcon",bottom.getText());
	}
	
	@Test
	public void testTop() {
		WebElement top = driver.findElement(By.className("top"));
		assertNotNull(top);
		assertEquals("ENPM614",top.getText());
	}
	
	@Test
	public void testMath() {
		WebElement math  = driver.findElement(By.linkText("Math"));
		math.click();
		assertEquals(driver.getTitle(),"Assignment 3 Toy Web App - Math");
		assertEquals("http://localhost:8888/math.jsp",driver.getCurrentUrl());
	}
	
	@Test
	public void testForm() {
		WebElement form  = driver.findElement(By.linkText("Form"));
		form.click();
		assertEquals(driver.getTitle(),"Assignment 3 Toy Web App - Form");
		assertEquals("http://localhost:8888/form.jsp",driver.getCurrentUrl());
	}

}
