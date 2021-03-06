package selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import logger.Reporter;

public class SeleniumTextbox {

	private static String currentMethod;
	private static String antecessor;

	public static void setText(WebElement element, String text) {

		// Metodos
		currentMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		antecessor = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			SeleniumWait.waitElementClickable(element);

			element.sendKeys(text);
			Reporter.addLog(Status.INFO,
					currentMethod + " -> " + text + " in element id -> " + element.getAttribute("id"));

		} catch (Throwable e) {
			Assert.fail("Test '" + antecessor + "' ended with ERROR - Method '" + currentMethod
					+ "' Expected result message: '" + text + "' not present in element. \n<p>Stacktrace: "
					+ e.getMessage());
			e.printStackTrace();

		}
	}
}
