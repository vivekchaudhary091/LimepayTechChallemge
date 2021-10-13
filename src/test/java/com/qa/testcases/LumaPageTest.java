package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LumaPage;
import com.qa.testbase.TestBase;

public class LumaPageTest extends TestBase {
	
	public LumaPage lumaPage;
	
	 public LumaPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lumaPage=new LumaPage();
		
	}
	
	@Test
	public void addItemToCart() {
		lumaPage.addItemIntoCart();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
