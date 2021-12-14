package com.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Testbase {

	public static WebDriverWait wait;
	public static WebDriver driver;
	
	public static Actions action;
	@BeforeSuite
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.accuweather.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		wait= new WebDriverWait(driver,20);
		
		action = new Actions(driver);
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
	
}
