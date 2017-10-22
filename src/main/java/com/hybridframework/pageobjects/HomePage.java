package com.hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.testbase.BrowserFactory;


public class HomePage extends BrowserFactory {

   private final WebDriver driver = super.driver;
	
	@FindBy(how=How.ID ,using ="q")  private WebElement txtSearchBox;
	@FindBy(how=How.CSS,using="css") private WebElement sample;
	@FindBy(how=How.CSS,using="a[href='./basic-first-form-demo.html']") private WebElement simpleFormDemo;
	@FindBys(@FindBy(how=How.CSS,using="#treemenu  ul")) private List<WebElement> listMenus;
	@FindBy(how=How.LINK_TEXT,using="Input Forms") public WebElement inputForm;
	@FindBy(how=How.LINK_TEXT,using="Date pickers") private WebElement datePickers;
	@FindBy(how=How.LINK_TEXT,using="Table") private WebElement tables;
	@FindBy(how=How.LINK_TEXT,using="Progress Bars & Sliders") private WebElement progressBarsAndSliders;
	@FindBy(how=How.LINK_TEXT,using="Alerts & Modals") private WebElement alertsAndModels;
	@FindBy(how=How.LINK_TEXT,using="List Box") private WebElement listBox;
	@FindBy(how=How.LINK_TEXT,using="Others") private WebElement others; 
	
	
	public  void launchURL(String URL) {
		driver.get(URL);
 	}
	
	public void printMessage() {
		if(driver == null) System.out.println("driver is null in homePage");
		else System.out.println("driver is not null in home page");
	}
 
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public int getTotalItemsForPractise() {
		int totalSize = listMenus.size();
		listMenus.forEach(item -> System.out.println(item.getText()));
		return totalSize -1 ;
	}
	
	public void navigateToInputFormPage() {
		inputForm.click();
		simpleFormDemo.click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(inputForm));
	}
	 public void waitForInputFormPageToBeLoaded() {
	    	WebDriverWait wait = new WebDriverWait(driver,60);
	    	wait.until(ExpectedConditions.visibilityOf(others));
	    }
	
}
