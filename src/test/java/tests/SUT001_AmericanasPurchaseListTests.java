package tests;

import org.testng.annotations.Test;

import base.TestBase;
import pages.americanas.AmericanasHomePage;
import selenium.SeleniumAssert;

public class SUT001_AmericanasPurchaseListTests extends TestBase {

	@Test(description = "Realizar uma busca na página principal e verificar se foi exibido o produto informando.")
	public void TC001_FindProduct() {

		String product = "MACBOOK AIR";

		new AmericanasHomePage(driver).goToHomePage().setTextOnFindBar(product).clickOnButtonFind();
		
		SeleniumAssert.assertElementContainsText(new AmericanasHomePage(driver).productList, product);

	}
	@Test(description = "Realizar uma busca na página principal e adicionar o produto ao carrinho.")
	public void TC002_FindAndSelectProduct() {
		
		String product = "MACBOOK AIR";
		
		new AmericanasHomePage(driver).goToHomePage().setTextOnFindBar(product).clickOnButtonFind();
		
		SeleniumAssert.assertElementContainsText(new AmericanasHomePage(driver).productList, product);
		
	}
	@Test(description = "Realizar uma busca na página principal, adicionar no carrinho e clicar em comprar.")
	public void TC002_FindAndBuyProduct() {
		
		String product = "MACBOOK AIR";
		
		new AmericanasHomePage(driver).goToHomePage().setTextOnFindBar(product).clickOnButtonFind();
		
		SeleniumAssert.assertElementContainsText(new AmericanasHomePage(driver).productList, product);
		
	}
}
