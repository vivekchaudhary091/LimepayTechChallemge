package com.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public Properties prop;
	public WebDriver driver;
	
	public TestBase() {
		
		try {
		
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\eclipse\\eclipse_workspace\\LimepayTechChallenge\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
	}catch(IOException ex) {
		ex.printStackTrace();
	}	
	}
	
	
	public void initialization() {
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		
		}else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
			
		
		
		
	}

}
