package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.CheckoutPage;
import com.qa.pages.LumaPage;
import com.qa.testbase.TestBase;

public class CheckoutPageTest extends TestBase {
	
	public LumaPage lumaPage;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		checkoutPage=new CheckoutPage();
		lumaPage=new LumaPage();
		checkoutPage=lumaPage.addItemIntoCart();
	}
	
	@Test(priority=1)
	public void fillShippingAddressDetails() {
		checkoutPage.shippingAddressDetails();
	}
	
	@Test(priority=2)
	public void paymentMethodSelectTest() {
		checkoutPage.paymentMethodSelect();
	}
	
	@Test(priority=3)
	public void verifyEmailTest() {
	String email=checkoutPage.verifyEmailPrepopulatedPrior();
	System.out.println(email);
	Assert.assertEquals(email, "tompeter@test.com");
	driver.findElement(By.xpath("//span[@class='slider round']")).click();
	}
	
	@Test(priority=4)
	public void billingAddressTest() {
		checkoutPage.billingAddress();
	}
	
	@Test(priority=5)
	public void verifyOneTimePaymentTest() {
	String amount=checkoutPage.verifyOneTimePaymentAmount();
	String totalAmount=driver.findElement(By.xpath("//span[contains(text(),'$27.00')]")).getText();
	Assert.assertEquals(amount, totalAmount);
	}
	
	@Test(priority=6)
	public void placeOrderTest() {
		checkoutPage.placeOrder();
		String errorText=driver.findElement(By.xpath("")).getText();
		Assert.assertEquals(errorText, "ERROR:IS REQUIRED");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
