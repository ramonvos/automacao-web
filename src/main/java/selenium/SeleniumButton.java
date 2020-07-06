package selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeleniumButton {

	private static String currentMethod;
	private static String antecessor;
	public static void clickButton(WebElement element) {
		
		currentMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		antecessor = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {

			SeleniumWait.waitElementClickable(element);
			SeleniumJavascript.highlightElement(element);

			element.click();
			/*
			 * Reporter.addStepsToPassMarkup("(" + ExtensionMethods.endDateTime() +
			 * ") - TEST PASSED " + antecessor + currentMethod + "- Element <b>[" +
			 * ElementHelpers.getAttributeElement(element) +
			 * "]</b> is visible in page and contains text: <b> [" + text + "]</b>",
			 * ExtentColor.GREEN);
			 */
		} catch (Throwable e) {
			Assert.fail("Test '" + antecessor + "' ended with ERROR - Method '" + currentMethod
					+ "' Expected result message:  not present in element. \n<p>Stacktrace: "
					+ e.getMessage());
			e.printStackTrace();

		}
	}
}
