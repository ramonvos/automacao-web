package selenium;

import com.aventstack.extentreports.Status;

import base.TestBase;
import logger.Reporter;

public class SeleniumNavigation extends TestBase {

	private static String currentMethod;

	public static void navigateToUrl(String url) {

		currentMethod = Thread.currentThread().getStackTrace()[1].getMethodName();

		driver.navigate().to(url);

		Reporter.addLog(Status.INFO, currentMethod + " -> " + url);

	}
}
