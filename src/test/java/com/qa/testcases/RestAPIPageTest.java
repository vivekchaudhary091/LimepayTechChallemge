package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.RestAPIPage;
import com.qa.testbase.TestBase;

public class RestAPIPageTest extends TestBase{

	public RestAPIPage restAPITest;
	
	public RestAPIPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		generateToken();
		restAPITest=new RestAPIPage();
	}
	
	@Test
	public void generateTokenTest() {
		restAPITest.generateToken(prop.getProperty("name"), prop.getProperty("email"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
