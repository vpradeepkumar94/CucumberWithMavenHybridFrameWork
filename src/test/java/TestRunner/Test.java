package TestRunner;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Test {
	@RunWith(Cucumber.class)
	@CucumberOptions(monochrome = false, features = "src/test/resources/Features", glue = "classpath:", tags = { "@smokeTest" }, plugin = {
			"pretty", "html:target/site/cucumber-pretty", "rerun:target/rerun.txt",
			"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
			"json:target/cucumber1.json" })
	
	public class RunCucumberTest extends AbstractTestNGCucumberTests {
		
		@BeforeSuite
		public void setUp() throws Exception {
		System.out.println("");
		}
		    @AfterClass
		    public void teardown() {
		        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		        Reporter.setSystemInfo("user", System.getProperty("user.name"));
		        Reporter.setSystemInfo("os", "Mac OSX");
		        Reporter.setTestRunnerOutput("Sample test runner output message");
		    }
		}
	}

