package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


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
	
	recaptcha.click();
	
	generateTokenButton.click();
	
	}
	
	//Get Token to move next step
	public void toGetAccessOfToken(){
	    
	    RestAssured.baseURI = "https://www.universal-tutorial.com/api/getaccesstoken";
  		RequestSpecification httpRequest = RestAssured.given();
  		httpRequest.header("Accept","application/json");
  		httpRequest.header("api-token", "F2oBH_3_Sugw8-jZ7qPsXV_WwI4wJZQ2ztajdZVwjx2lx4D1N-X61SnrmsffjEKCAvY");
  		httpRequest.header("user-email", "test12345@test.com");
  		
  		Response response = httpRequest.request(Method.GET, RestAssured.baseURI);
		

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	   
	
	}
	
	//To get states by using bearer token
	public int toGetLocation() {
	    
	    RestAssured.baseURI = "https://www.universal-tutorial.com/api/states/India";
  		RequestSpecification httpRequest = RestAssured.given();
  		httpRequest.header("Accept","application/json");
  		httpRequest.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJ0ZXN0MTIzNDVAdGVzdC5jb20iLCJhcGlfdG9rZW4iOiJGMm9CSF8zX1N1Z3c4LWpaN3FQc1hWX1d3STR3SlpRMnp0YWpkWlZ3angybHg0RDFOLVg2MVNucm1zZmZqRUtDQXZZIn0sImV4cCI6MTYzNDgxNTE5OX0.axu6XOvMGjrdkjUpdn1GO6jA53DIDjQEerjXzbuxuOs");
  		
  		Response response = httpRequest.request(Method.GET, RestAssured.baseURI);
  		
  		
  		int code=response.statusCode();
		

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		return code;
	}
	
	//Verify response contains state_name Dadar and Nagar Haveli
	public String verifyState(){

		RestAssured.baseURI = "https://www.universal-tutorial.com/api/states/India";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, RestAssured.baseURI);
	
		ResponseBody body = response.getBody();


		String bodyAsString = body.asString();
		return bodyAsString;
	}

}
