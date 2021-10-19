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
	
	public void setHeader(String head, String val) { 
		reqSpec.header(head, val);
		}

}
