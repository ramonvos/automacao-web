package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class SeleniumJavascript {

	public static void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
		
	}
	
	
	public static String getReadyState() {
		
		return  ((JavascriptExecutor) TestBase.driver).executeScript("return document.readyState")
				.toString();
		
	}
	
}
