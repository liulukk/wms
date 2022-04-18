package www.ourhouse.testng_xslt;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class demo {
	@Test
	public void test1() {
		assertEquals(1, 1);
	}
	@Test
	public void test2() {
		assertEquals(2, 1);
	}
	@Test
	public void test3() {
		assertEquals(3, 1);
	}
	@Test
	public void test4() {
		assertEquals(5, 5);
	}
	@Test
	public void test5() {
		assertEquals(5, 5);
		System.out.println("test5***********");
	}
	

}
