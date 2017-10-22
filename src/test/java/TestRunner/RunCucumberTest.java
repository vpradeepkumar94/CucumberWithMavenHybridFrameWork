package TestRunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;
import com.hybridframework.testbase.BrowserFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false, features = "src/test/resources/Features", glue = "classpath:", tags = { "@smokeTest" }, plugin = {
		"pretty", "html:target/site/cucumber-pretty", "rerun:target/rerun.txt",
		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
		"json:target/cucumber1.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public BrowserFactory browserFactory;

	public class CucumberRunner extends AbstractTestNGCucumberTests {

		@BeforeSuite
		public void setUp() throws Exception {
			openBrowser();
			maximizeWindow();
			implicitWait(30);
			deleteAllCookies();
		}
		@AfterClass
		public void finalOne() {
			  Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		        Reporter.setSystemInfo("user", System.getProperty("user.name"));
		        Reporter.setSystemInfo("os", "Mac OSX");
		        Reporter.setTestRunnerOutput("Sample test runner output message");
		}
		@AfterSuite
		public void quit() throws IOException, InterruptedException {
			browserFactory.captureScreenShot("SamplePic", driver);
			browserFactory.closeAllBrowsers();
		}

		private void openBrowser() {
			System.out.println("came");
			browserFactory = new BrowserFactory();
			browserFactory.initBrowser("chrome");
			try {
				driver = BrowserFactory.getDefaultDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void maximizeWindow() {
			driver.manage().window().maximize();
		}

		public void implicitWait(int time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}

		public void pageLoad(int time) {
			driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		}

		public void deleteAllCookies() {
			driver.manage().deleteAllCookies();
		}
	}
}
