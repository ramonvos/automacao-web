package logger;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {

	public static ExtentReports extent;
	public static ExtentTest test;

	public static void createNewReport() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	public static void createTestNode(String testName) {
		test = extent.createTest(testName);
	}

	public static void addLog(Status status, String logText) {
		test.log(status, logText);
	}

	public static void addMarkup(String text, ExtentColor color) {
		Markup markup = MarkupHelper.createLabel(text, color);

		if (color.equals(ExtentColor.RED)) {
			test.log(Status.FAIL, markup);
		} else {
			test.log(Status.PASS, markup);
		}

	}

	public static void addException(Throwable e) {
		test.fail(e);
	}

	public static void addScreeshotBase64(String screenshotPath) {
		test.log(Status.INFO, "Screenshot:").addScreenCaptureFromBase64String(screenshotPath);
	}

	public static void addScreeshotImage(String screenshotPath) throws IOException {
		test.log(Status.INFO, "Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

}
