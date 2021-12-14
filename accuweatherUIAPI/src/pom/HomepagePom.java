package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.SelUtils;

import testscrips.CompareTemparature;

public class HomepagePom {

	WebDriver driver;

	public static String DisplayWeather;

	public HomepagePom(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//input[@placeholder=\"Search\"]")
	private WebElement locationSearchBox;

	@FindBy(xpath="//span[@class=\"header-temp\"]")
	private WebElement displayTemperature;

	@FindBy(xpath="//a[@class=\"header-logo\"]")
	private WebElement mainPageHeaderLogo;


	public void setLocation(String desiredPlace){
		locationSearchBox.sendKeys(desiredPlace);
		locationSearchBox.sendKeys(Keys.ENTER);
	}

	public void clickOnHeaderLogo(){
		mainPageHeaderLogo.click();
	}


	public void getDisplayTemperatureSourceOne(){
		CompareTemparature.sourceOneWeather = displayTemperature.getText();
		System.out.println("First Location Weather: " +CompareTemparature.sourceOneWeather);
	}

	public void getDisplayTemperatureSourceTwo(){
		WebDriverWait waits = new WebDriverWait(driver,30);
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\\\"header-temp\\\"]")));
		CompareTemparature.sourceTwoWeather = displayTemperature.getText();
		System.out.println(CompareTemparature.sourceTwoWeather);
	}

}
