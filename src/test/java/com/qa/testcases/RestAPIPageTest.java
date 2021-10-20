package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qa.pages.RestAPIPage;
import com.qa.testbase.TestBase;



public class RestAPIPageTest extends TestBase{

	public RestAPIPage restAPITest;
	
	public RestAPIPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		restAPITest=new RestAPIPage();
	}
	
	@Test(enabled = false)
	public void generateTokenTest() {
		restAPITest.generateToken(prop.getProperty("name"), prop.getProperty("email"));
	}
	
	@Test(enabled = false)
	public void getAccessTokenTest() throws UnirestException {
		restAPITest.toGetAccessOfToken();
		
	}
	
	@Test(enabled = false)
	public void toGetLocationTest() throws UnirestException  {
		restAPITest.toGetLocation();
	}
	
	@Test
	public void verifyStateTest() throws UnirestException {
		restAPITest.verifyState();
	}
	
	@Test
	public void verifyResponseTest() throws UnirestException {
		int code=restAPITest.verifyResponse();
		Assert.assertEquals(code, 200);
	}
	
	
	  @AfterMethod public void tearDown() { 
		  driver.quit(); 
		  }
	 
}
