package pages.americanas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;
import pages.PageObjectInitialize;
import selenium.SeleniumButton;
import selenium.SeleniumNavigation;
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

	@FindBy(id = "buy-button")
	private WebElement btnConfirm;
	
	@FindBy(id = "btn-buy")
	private WebElement btnBuy;

	@FindBy(xpath = "//div[@id='content-middle']/div[6]/div/div/div/div/div/div/div[2]/a/section/div[2]/div/h2")
	public WebElement productList;

	@FindBy(xpath = "//img[@alt='Ztw-30 mouse de computador sem fio bluetooth para macbook air macbook pro']")
	public WebElement imgProduct;

	@FindBy(id = "product-name-default")
	public WebElement productDetails;
	
	@FindBy(id = "fb-root")
	public WebElement btnLoginFacebook;

	// Metodos de iteração com a tela

	public AmericanasHomePage goToHomePage() {
		SeleniumNavigation.navigateToUrl(TestBase.urlBase);
		return this;
	}

	public AmericanasHomePage setTextOnFindBar(String product) {
		SeleniumTextbox.setText(txtFind, product);
		return this;
	}

	public AmericanasHomePage clickOnButtonFind() {

		SeleniumButton.clickButton(btnFind);
		return this;
	}

	public AmericanasHomePage selectProduct() {

		SeleniumButton.clickButton(imgProduct);
		return this;
	}

	public AmericanasHomePage clickOnButtonBuy() {
		SeleniumButton.clickButton(btnBuy);
		return this;
	}
	public AmericanasHomePage clickOnButtonConfirmBuy() {
		SeleniumButton.clickButton(btnConfirm);
		return this;
	}

}
