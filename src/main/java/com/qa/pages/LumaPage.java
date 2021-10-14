package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

public class LumaPage extends TestBase {
	
	Actions action;

	@FindBy(xpath="//div[@class='swatch-opt-700']//div[@class='swatch-attribute size']//div[@class='swatch-attribute-options clearfix']//div[@id='option-label-size-145-item-169']")
	WebElement largeSize;
	
	@FindBy(xpath="//body[@class='cms-home cms-index-index page-layout-1column']/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@class='widget block block-static-block']/div[@class='block widget block-products-list grid']/div[@class='block-content']/div[@class='products-grid grid']/ol[@class='product-items widget-product-grid']/li[3]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@id='option-label-color-93-item-52']")
	WebElement color;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cart;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement proceedToCheckout;
	
	public LumaPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage addItemIntoCart(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='http://mage2-firecheckout-osc.tst.limep.net/pub/media/catalog/product/cache/2765542505660baab28ecd555e27366e/m/t/mt07-gray_main_1.jpg']")));
		
		//WebElement element=driver.findElement(By.xpath("//img[@src='http://mage2-firecheckout-osc.tst.limep.net/pub/media/catalog/product/cache/2765542505660baab28ecd555e27366e/m/t/mt07-gray_main_1.jpg']"));
		
		//move to image
		action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
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
