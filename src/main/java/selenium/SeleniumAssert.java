package selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeleniumAssert {

	private static String currentMethod;
	private static String antecessor;
	
	public static void assertElementContainsText(WebElement element, String text) {

		// Metodos 
		currentMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		antecessor = Thread.currentThread().getStackTrace()[2].getMethodName();
		try {
			
			SeleniumWait.waitElementClickable(element);
			SeleniumJavascript.highlightElement(element);
		
			Assert.assertTrue(element.getText().contains(text));
			/*
			 * Reporter.addStepsToPassMarkup("(" + ExtensionMethods.endDateTime() +
			 * ") - TEST PASSED " + antecessor + currentMethod + "- Element <b>[" +
			 * ElementHelpers.getAttributeElement(element) +
			 * "]</b> is visible in page and contains text: <b> [" + text + "]</b>",
			 * ExtentColor.GREEN);
			 */
		} catch (Throwable e) {
			Assert.fail("Test '" + antecessor + "' ended with ERROR - Method '" + currentMethod
					+ "' Expected result message: '" + text + "' not present in element. \n<p>Stacktrace: "
					+ e.getMessage());
			e.printStackTrace();

		}
	}
	
}