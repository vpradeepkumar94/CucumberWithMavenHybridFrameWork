package TestRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.hybridframework.pagegenerator.Page;
import com.hybridframework.testbase.BrowserFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
monochrome = false, 
features = "src/test/resources/Features",
glue = "classpath:",
tags = { "@smokeTest" },
plugin = {
"pretty", "html:target/site/cucumber-pretty", "rerun:target/rerun.txt",
"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
"json:target/cucumber1.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public static BrowserFactory browserFactory;

	public String browserName;

	@Parameters("browser")
	@BeforeTest
	public static void setUp(String browser) throws Exception {
		openBrowser(browser);
		initPageElements();
		maximizeWindow();
		implicitWait(30);
		deleteAllCookies();
	}

	private static void initPageElements() {
		Page.initialiseAllInstance();
	}

	@AfterClass
	public void finalOne() {
		// Reporter.loadXMLConfig(new
		// File("src/test/resources/extent-config.xml"));
		// Reporter.setSystemInfo("user", System.getProperty("user.name"));
		// Reporter.setSystemInfo("os", "Mac OSX");
		// Reporter.setTestRunnerOutput("Sample test runner output message");
	}

	@AfterSuite
	public void quit() throws IOException, InterruptedException {
		browserFactory.captureScreenShot("SamplePic", driver);
		try {
		browserFactory.closeAllBrowsers();
		} catch(Exception e) {
			System.out.println("error occured form here"+ e);
		}
	}

	private static void openBrowser(String browserName) {
		System.out.println("came");
		browserFactory = new BrowserFactory();
		browserFactory.initBrowser(browserName);
		try {
			driver = BrowserFactory.getDefaultDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
}
