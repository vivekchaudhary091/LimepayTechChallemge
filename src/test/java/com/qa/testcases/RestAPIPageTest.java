package com.qa.testcases;

import org.testng.Assert;
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
		restAPITest=new RestAPIPage();
	}
	
	@Test(priority = 1)
	public void generateTokenTest() {
		initialization();
		driver.get(prop.getProperty("urltoken"));
		restAPITest.generateToken(prop.getProperty("name"), prop.getProperty("email"));
	}
	
	@Test(priority = 2)
	public void getAccessTokenTest() {
		restAPITest.toGetAccessOfToken();
		
	}
	
	@Test(priority = 3)
	public void toGetLocationTest() {
		int code=restAPITest.toGetLocation();
		Assert.assertEquals(code, 200);
	}
	
	@Test(priority = 4)
	public void verifyStateTest(){
		String stateName=restAPITest.verifyState();
		System.out.println(stateName);
		Assert.assertEquals(stateName.toLowerCase().contains("Dadar and Nagar Haveli") /*Expected value*/, true /*Actual Value*/, "Response body does not contains Dadar and Nagar Haveli");
		
	}

}
