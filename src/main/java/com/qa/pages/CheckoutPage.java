package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.TestBase;

public class CheckoutPage extends TestBase {
	Select select;
	
	@FindBy(xpath="//input[@id='customer-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='O6BQBN8']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='KUWH9XO']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='Y39MMUR']")
	WebElement streetAddress;
	
	@FindBy(xpath="//input[@id='X433GRP']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='IXWABAS']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@id='IGMMBVO']")
	WebElement phoneNumber;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void shippingAddressDetails() {
		
		email.sendKeys("tompeter@test.com");
		firstName.sendKeys("Tom");
		lastName.sendKeys("Peter");
		streetAddress.sendKeys("1 Francis Street, New South Wales, 2114");
		city.sendKeys("Sydney");
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='YWD1A3S']")));
		select.selectByVisibleText("//select[@id='YWD1A3S']//option[contains(text(),'United States')]");
		
		select=new Select(driver.findElement(By.xpath("select[@id='CAK9F0Q']")));
		select.selectByVisibleText("//select[@id='CAK9F0Q']//option[contains(text(),'Alaska')]");
		postalCode.sendKeys("2114");
		phoneNumber.sendKeys("+61403256771");
			
	}
	
	public void paymentMethodSelect() {
		
		driver.findElement(By.xpath("//input[@id='lpcheckout']")).click();
		driver.findElement(By.xpath("//span[@class='slider round']")).click();
		
	}
	
	public void billingAddress() {
		driver.findElement(By.xpath("//input[@id='lpcheckout']")).click();
	}
	
	public String verifyEmailPrepopulatedPrior() {
		
	String text=driver.findElement(By.xpath("//input[@name='email']")).getText();
		return text;
	}
	
	public String verifyOneTimePaymentAmount() {
    
	String element1=driver.findElement(By.xpath("//td[@class='amount']//span[@class='price'][contains(text(),'$22.00')]")).getText();
	  String element2=driver.findElement(By.xpath("//td[@class='amount']//span[@class='price'][contains(text(),'$5.00')]")).getText();
	  
	 String element3 =element1+element2;
	 return element3;
		
		
	}

}
