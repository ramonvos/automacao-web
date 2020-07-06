package pages.americanas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObjectInitialize;
import selenium.SeleniumButton;
import selenium.SeleniumTextbox;

public class AmericanasHomePage extends PageObjectInitialize {

	// Ao extender a classe PageObjectInitialize, os elementos sao inicializados
	// sempre que acionados
	// Não precisa inicializar em toda classe Page (Vide implementação em
	// PageObjectInitialize.java)
	public AmericanasHomePage(WebDriver driver) {
		super(driver);
	}

	// Mapeamento dos elementos da página
	@FindBy(id = "h_search-input")
	private WebElement txtFind;

	@FindBy(id = "h_search-btn")
	private WebElement btnFind;

	// Metodos de iteração com a tela
	public AmericanasHomePage setTextOnFindBar(String product) {
		SeleniumTextbox.setText(txtFind, product);
		return this;
	}

	public AmericanasHomePage clickOnButtonFind() {
		SeleniumButton.clickButton(btnFind);
		return this;
	}

}
