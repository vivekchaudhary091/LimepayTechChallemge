package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qa.testbase.TestBase;



public class RestAPIPage extends TestBase{
	
	@FindBy(id="name")
	WebElement fullName;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement recaptcha;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement generateTokenButton;
	
	
	
	
	
	public RestAPIPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void generateToken(String name,String email) {
		
	fullName.sendKeys(name);
	emailAddress.sendKeys(email);
	
	//switch to frame to click recaptcha checkbox
	driver.switchTo().frame("");
	recaptcha.click();
	
	//switch to frame to click on generate button
	driver.switchTo().frame("");
	generateTokenButton.click();
	
	}
	
	//Get Token to move next step
	public void toGetAccessOfToken() throws UnirestException {
		
		 String url="https://www.universal-tutorial.com/api/getaccesstoken";
	     JsonNode body=Unirest.get(url)
		.header("Accept","application/json")
		.header("api-token", "yL2i_JyB5Mi8jToZCgGfA5r7pnUBdfIF-ilNqET70dN5jo1mkq83biCqIGofpikPP_k")
		.header("user-email", "test1234@test.com")
		.asJson()
		.getBody();
	    System.out.println(body);
	   
	
	}
	
	//To get states by using bearer token
	public void toGetLocation() throws UnirestException  {
		
		String url="https://www.universal-tutorial.com/api/states/India";
	    JsonNode body=Unirest.get(url)
		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJ0ZXN0MTIzNEB0ZXN0LmNvbSIsImFwaV90b2tlbiI6InlMMmlfSnlCNU1pOGpUb1pDZ0dmQTVyN3BuVUJkZklGLWlsTnFFVDcwZE41am8xbWtxODNiaUNxSUdvZnBpa1BQX2sifSwiZXhwIjoxNjM0NzIzNDc0fQ.q3i7iuvl_LP0XBYbOR1vzRdFUIXeG1A_uKmpPW5Qp1Y")
	    .header("Accept", "application/json")
	    .asJson()
	    .getBody();
	    System.out.println(body);
	}
	
	//Verify response contains state_name Dadar and Nagar Haveli
	public String verifyState() throws UnirestException {

		String body = Unirest.get("https://www.universal-tutorial.com/api/states/India")
				 .asString()
				 .getBody();
		System.out.println(body);
		return body;
		
		//{"state_name":"Dadra and Nagar Haveli"}
	}
	
	//verify Response 200
     public int verifyResponse() throws UnirestException {
		
		int code = Unirest.get("https://www.universal-tutorial.com/api/states/India")
				.asString()
				.getStatus();
		System.out.println(code);
		return code;
	
	}
	


}
