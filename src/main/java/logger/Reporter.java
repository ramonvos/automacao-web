package logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.DatetimeHelpers;
import utilities.ProjectHelpers;

public class Reporter {

	public static ExtentReports extent;
	public static ExtentTest test;

	//Cria um novo relatorio .html de log (Nova instância)
	public static void createNewReport() {

		String fileName = ProjectHelpers.getProjectPath() + "\\report\\Relatorio-tests_" + DatetimeHelpers.getCurrentDateToString() + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	//Cria um teste no relatorio com nome do teste, descrição e suite (Grupo de teste)
	public static void createTestNode(String testName, String description, String suiteName) {

		test = extent.createTest(testName, description).assignCategory(suiteName);

	}

	//Adiciona log no relatorio (Steps)
	public static void addLog(Status status, String logText) {
		test.log(status, logText);
	}

	//Adiciona marcações no relatorio
	public static void addMarkup(String text, ExtentColor color) {
		Markup markup = MarkupHelper.createLabel(text, color);

		if (color.equals(ExtentColor.RED)) {
			test.log(Status.FAIL, markup);
		} else {
			test.log(Status.PASS, markup);
		}

	}

	//Adiciona log de exceção no relatorio
	public static void addException(Throwable e) {
		test.fail(e);
	}

	//Adicionar screenshot no relatorio (Formato Str base64)
	public static void addScreeshotBase64(String screenshotPath) {
		test.log(Status.INFO, "Click the link 'base64-img' to open the screenshot").addScreenCaptureFromBase64String(screenshotPath);
	}

	//Gera o relatório	
	public static void generateReporter() {
		
		extent.flush();

	}

}
