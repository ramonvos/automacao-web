package selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import logger.Reporter;

public class SeleniumButton {

	private static String currentMethod;
	private static String antecessor;
	public static void clickButton(WebElement element) {
		
		currentMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		antecessor = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			SeleniumWait.waitElementClickable(element);
			SeleniumJavascript.highlightElement(element);

			Reporter.addLog(Status.INFO, currentMethod + " -> " + element.getAttribute("id"));
			element.click();
		
			 
		} catch (Throwable e) {
			Assert.fail("Test '" + antecessor + "' ended with ERROR - Method '" + currentMethod
					+ "' Expected result message:  not present in element. \n<p>Stacktrace: "
					+ e.getMessage());
			e.printStackTrace();

		}
	}
}
