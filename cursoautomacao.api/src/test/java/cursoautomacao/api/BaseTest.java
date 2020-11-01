package cursoautomacao.api;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.response.Response;

public class BaseTest {
	
	protected Response resp;
	protected String corpo;
	protected int code;
	protected boolean verifyBoolean;
	protected List list;
	protected String nameController;
	protected String urlService;
	protected String statusTest;
	protected String typeRequest;
	protected ArrayList<String> descriptionTest = new ArrayList();

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "Resultado COSG-PRODUTOS.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.fail(MarkupHelper.createLabel(result.getName() + "Test Case Faile", ExtentColor.RED));
			test.fail(result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.pass(MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));

		}

		else {

			test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());

		}

	}

	@AfterSuite
	public void tearDown() {

		extent.flush();
	}

}
