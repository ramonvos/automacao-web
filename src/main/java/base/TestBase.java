package base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import constants.Constants;
import constants.LoadConfigurations;
import enums.Browser;
import enums.Environment;

public class TestBase {

	public static Properties propertiesContent;
	

	public static WebDriver driver;
	private String browser;
	private String urlBase;
	
	//Construtor responsavel por ler o arquivo de propriedades do projeto
	public TestBase() {

		if (propertiesContent == null) {
			propertiesContent = LoadConfigurations.getProperties();
			setEnvironment();
		}

	}

	// Executado uma vez antes de iniciar os testes (Anotação TestGN)
	@BeforeSuite
	private void initializeDriver() {

		browser = propertiesContent.getProperty("browserName");// Ler o browser setado no arquivo de propriedades

		//Verifica qual browser está setado no arquivo de propriedades (Cross browser testing)
		try {
			if (browser.equals(Browser.CHROME.toString())) {
				driver = getChromeDriver();
		
			} else if (browser.equals(Browser.FIREFOX.toString())) {
				driver = getFirefoxDriver();

			} else if (browser.equals(Browser.IE.toString())) {
				driver = getIEDriver();
			} else {
				new Exception("Invalid Browser in properties file");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.navigate().to(urlBase);

	}

	//// Executado uma vez após o ultimo teste (Anotação TestGN)
	@AfterSuite
	private void quitDriver() {
		driver.quit();
	}

	// Executado antes de cada teste apos iniciar a suite (Anotação TestGN)
	@BeforeMethod
	private void beforeMethod() {

	}

	// Executado apos cada teste apos iniciar a suite (Anotação TestGN)
	@AfterMethod(alwaysRun = true)
	private void afterMethod() {

	}

	//Retornar a instancia do chrome driver
	private WebDriver getChromeDriver() {

		System.setProperty("webdriver.chrome.driver",
				Constants.pathToChromedriver + propertiesContent.getProperty("driverVersion") + "\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Ler o arquivo de propriedades e verificar se o parametro headlessDriver está
		// true e seta para (Browser fantasma - Antes era usado o PhantomJS)
		if (propertiesContent.getProperty("headlessDriver").equals("TRUE")) {
			options.addArguments("--headless");
		}
		driver = new ChromeDriver(options);
		return driver;
	}

	//Retornar a instancia do firefox  driver
	private WebDriver getFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver",
				Constants.pathToFirefoxdriver + propertiesContent.getProperty("driverVersion") + "\\geckodriver.exe");

		driver = new FirefoxDriver();
		return driver;
	}
	//Retornar a instancia do Internet Explorer driver
	private WebDriver getIEDriver() {

		System.setProperty("webdriver.ie.driver",
				Constants.pathToIEdriver + propertiesContent.getProperty("driverVersion") + "\\IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		return driver;
	}

	//Retornar o caminho (String) do Screenshot Base64 
	private String takeScreenshot() {

		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		return screenshotBase64;

	}

	//Setar o ambiente que os testes serao executados 
	// OBS: Apenas um exemplo de parametrizacao, no projeto só existe PROD, nao existem outros ambientes
	private void setEnvironment() {

		String environment = propertiesContent.getProperty("environment");

		if (environment.equals(Environment.PROD.toString())) {
			urlBase = propertiesContent.getProperty("urlBaseProd");
		} else if (environment.equals(Environment.DEV.toString())) {
			urlBase = propertiesContent.getProperty("urlBaseDev");
		} else if (environment.equals(Environment.HOMOL.toString())) {
			urlBase = propertiesContent.getProperty("urlBaseHomol");
		} else if (environment.equals(Environment.LOCALHOST.toString())) {
			urlBase = propertiesContent.getProperty("urlBaseLocal");
		} else {
			new Exception("Invalid Enviroment in properties file");
		}

	}
}
