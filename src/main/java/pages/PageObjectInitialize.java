package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PageObjectInitialize extends TestBase {

	protected WebDriver driver;

	// Construtor responsável por inicializar os elementos das paginas
	public PageObjectInitialize(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
