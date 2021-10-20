package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;

public class LumaPage extends TestBase {
	
	Actions action;

	@FindBy(xpath="//a[@title='Argus All-Weather Tank']/../../div[@class='swatch-opt-700']/div/div/div[@id='option-label-size-145-item-169']")
	WebElement largeSize;
	
	@FindBy(xpath="//a[@title='Argus All-Weather Tank']//..//..//..//div[@class='product-item-inner']//form/button[@title='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(id="option-label-color-93-item-52")
	WebElement color;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cart;
	
	@FindBy(id="top-cart-btn-checkout")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//a[@title='Argus All-Weather Tank']")
	WebElement imageElement;
	
	public LumaPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage addItemIntoCart(){
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30); WebElement
		 * element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//a[@title='Argus All-Weather Tank']")));
		 */
		
		
		//move to image
		action=new Actions(driver);
		action.moveToElement(imageElement).build().perform();
		
		//move to size of the item
		action.moveToElement(largeSize).build().perform();
		largeSize.click();
		
		//move to color of the item
		action.moveToElement(color).build().perform();
		color.click();
		
		//move to addToCart link
		action.moveToElement(addToCart).build().perform();
		addToCart.click();
		
		cart.click();
		
		//move to proceedToCheckout link
		action.moveToElement(proceedToCheckout).build().perform();
		proceedToCheckout.click();
		
		return new CheckoutPage();
	}
}
