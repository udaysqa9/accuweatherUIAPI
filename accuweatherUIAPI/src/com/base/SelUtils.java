package com.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import testscrips.CompareTemparature;




public class SelUtils {

	public static String currentDate;
	
	public static String temp;
	

	/**
	 * 
	 * 
	 * @param ele
	 */
	
	public static void clickOnWebElement(WebElement ele){

		ele.click();	

	}
	
	/**
	 * This method fetches weather information from openweathermap api of two cities 
	 * @param placeOne
	 * @param placeTwo
	 * @param appIDKey
	 */
	public static String getWeatherData(String placeOne,String placeTwo,String appIDKey) {
	
		Response res=RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q="+placeOne+"&appid="+appIDKey+"");
		int statusCode=res.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		String responseBody=res.getBody().asString();
		return(responseBody.substring(56, 59));
//		Response responseCityTwo=RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q="+placeTwo+"&appid="+appIDKey+"");
//		String responseBodyTwo=responseCityTwo.getBody().asString();
//		CompareTemparature.sourceTwoWeather = responseBodyTwo.substring(56, 59);
//		System.out.println(sourceOneWeatherAPI);
//		System.out.println(sourceTwoWeatherAPI);
	}
/**
 * This method converts the standard date format to desired format.
 * @param dt
 * @return
 */

	public static String convertDateFormat(Date dt){
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM, yyyy");
		return dateFormat.format(dt);
	}
	
	/**
	 * 
	 * @param placeOne
	 * @param PlaceTwo
	 * @return difference of two number after converting from string to integer
	 */
	public static int compareTemperature(String placeOne,String PlaceTwo) {
		int valueOne=Integer.parseInt(placeOne.substring(0, 1));
		int valueTwo=Integer.parseInt(placeOne.substring(0, 1));
		if(valueOne==valueTwo) {
			return 0;
		}
		else if(valueOne>valueTwo) {
			return (valueOne-valueTwo);
		}
		else 
			return (valueTwo-valueOne);
		
	}
	/**
	 * This method adds desired number of days to the date value we pass.
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
	
	public static void selectItem(WebElement ele, String value) {
		
		Select listbox = new Select(ele);
		listbox.selectByVisibleText(value);
		
	}
	
	public static void populateInputBox(WebElement ele, String value) {
		if (!(ele.getAttribute("value").isEmpty())) {
			ele.clear();
		}
	

	}
}
