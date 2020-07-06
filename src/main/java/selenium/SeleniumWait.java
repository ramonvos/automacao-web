package selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import constants.Constants;

public class SeleniumWait {

	
	public static void waitElementClickable(WebElement element) {
		try {

			
			WebDriverWait wait = new WebDriverWait(TestBase.driver, Constants.defaultTimeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
}
