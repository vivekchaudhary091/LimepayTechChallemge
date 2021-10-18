package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.TestBase;

public class CheckoutPage extends TestBase {
	Select select;
	
	@FindBy(id="customer-email")
	WebElement email;
	
	@FindBy(id="O6BQBN8")
	WebElement firstName;
	
	@FindBy(id="KUWH9XO")
	WebElement lastName;
	
	@FindBy(id="Y39MMUR")
	WebElement streetAddress;
	
	@FindBy(id="X433GRP")
	WebElement city;
	
	@FindBy(id="IXWABAS")
	WebElement postalCode;
	
	@FindBy(id="IGMMBVO")
	WebElement phoneNumber;
	
	@FindBy(xpath="//button[@title='Place Order' and @type='button' and @class='action primary checkout']")
	WebElement placeOrder;
	
	@FindBy(id="lpcheckout")
	WebElement radioButtoncheck;
	
	
	@FindBy(xpath="//span[@class='slider round']")
	WebElement togglebutton;
	
	
	@FindBy(id="billing-address-same-as-shipping-shared")
	WebElement billingAddress;
	
	
	@FindBy(id="lpCustEmail")
	WebElement emailAddress;

	@FindBy(xpath="(//div[contains(text(),'Error: is required')])[1]")
	WebElement verifyError;
	
	@FindBy(xpath="//td[@class='amount']//span[@class='price'][contains(text(),'$22.00')]")
	WebElement cartSubTotal;
	
	
	@FindBy(xpath="//td[@class='amount']//span[@class='price'][contains(text(),'$5.00')]")
	WebElement shippingAmount;
	
	
	@FindBy(xpath="//select[@id='YWD1A3S']//option[contains(text(),'United States')]")
	WebElement selectUS;
			
	@FindBy(xpath="//select[@id='CAK9F0Q']//option[contains(text(),'Alaska')]")
	WebElement selectAlaska;	
	
	@FindBy(xpath="//span[contains(text(),'$27.00')]")
	WebElement orderTotalAmount;
	
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void shippingAddressDetails() {
		
		email.sendKeys("tompeter@test.com");
		firstName.sendKeys("Tom");
		lastName.sendKeys("Peter");
		streetAddress.sendKeys("1 Francis Street, New South Wales, 2114");
		city.sendKeys("Sydney");
		
		//select country from dropdown
		Select select=new Select(driver.findElement(By.xpath("//select[@id='YWD1A3S']")));
		select.selectByVisibleText("selectUS");
		
		//select region from dropdown
		select=new Select(driver.findElement(By.xpath("select[@id='CAK9F0Q']")));
		select.selectByVisibleText("selectAlaska");
		
		postalCode.sendKeys("2114");
		phoneNumber.sendKeys("+61403256771");
			
	}
	
	public void paymentMethodSelect() {
		
		radioButtoncheck.click();
		togglebutton.click();
		
	}
	
	public void toggleUnchecked()
	{
		togglebutton.click();
		
	}
	
	public void billingAddress() {
		billingAddress.click();
	}
	
	public String verifyEmailPrepopulatedPrior() {
		
	String text=emailAddress.getText();
		return text;
	}
	
	public String verifyOneTimePaymentAmount() {
	String element1=cartSubTotal.getText();
	  String element2=shippingAmount.getText();
	  
	 String element3 =element1+element2;
	 return element3;
	}
	
	public String verifyTotalAmount() {
		String totalAmount=orderTotalAmount.getText();
		return totalAmount;
	}
	
	public String errorVerify() {
		String errorMessage=verifyError.getText();
		return errorMessage;
	}
	
	public void placeOrder() {
		placeOrder.click();
	}

}
