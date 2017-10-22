package Hooks;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hybridframework.testbase.Base;
import com.hybridframework.testbase.BrowserFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BrowserFactory {
	
    public static WebDriver driver;
	
	@Before
	public  void beforeScenario(Scenario scenario) throws IOException {
		System.out.println("before");   
		
    }

	@After
	public void afterScenario(Scenario scenario) throws IOException {
	System.out.println("close");      
	 
    }
}
