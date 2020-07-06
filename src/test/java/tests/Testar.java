package tests;

import org.testng.annotations.Test;

import base.TestBase;
import pages.americanas.AmericanasHomePage;
import selenium.SeleniumAssert;

public class Testar extends TestBase {

	
	@Test(description = "Realizar uma busca na página principal e verificar se foi retornado o produto informando.")
	public void TC001_() {
		
		String product = "MACBOOK AIR";
		
		new AmericanasHomePage(driver).setTextOnFindBar(product).clickOnButtonFind();
		
		
		
	}
}
