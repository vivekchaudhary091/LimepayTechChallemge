package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.LumaPage;
import com.qa.testbase.TestBase;

public class LumaPageTest extends TestBase {
	
	LumaPage lumaPage;
	
	 public LumaPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lumaPage=new LumaPage();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
